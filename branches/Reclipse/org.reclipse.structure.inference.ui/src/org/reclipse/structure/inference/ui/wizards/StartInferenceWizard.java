package org.reclipse.structure.inference.ui.wizards;



import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.fujaba.commons.console.ReportLevel;
import org.reclipse.structure.InferenceUIPlugin;
import org.reclipse.structure.inference.DetectPatternsJob;
import org.reclipse.structure.inference.IAnnotationEvaluator;
import org.reclipse.structure.inference.notification.InferenceProgressListener;
import org.reclipse.structure.inference.ui.InferenceConstants;
import org.reclipse.structure.inference.ui.views.annotations.AnnotationView;


/**
 * This class creates the wizard which is used to configure and start a structural patterns
 * detection.
 * 
 * @version $Revision$ $Date$
 * @author Last editor: $Author$
 * @author harka
 */
public class StartInferenceWizard extends Wizard
{
   private static final String VID_MATCHED_PATTERNS = "org.reclipse.ui.views.structure.inference.matching.pattern"; //$NON-NLS-1$

   private static final String VID_MATCHED_OBJECTS = "org.reclipse.ui.views.structure.inference.matching.ast"; //$NON-NLS-1$

   protected StartInferenceWizardPage page;


   public StartInferenceWizard()
   {
      super();

      // configure
      setNeedsProgressMonitor(true);
      setHelpAvailable(false);
      setWindowTitle("Structural Patterns Detection");
      setDefaultPageImageDescriptor(InferenceUIPlugin.getInstance().getImageDescriptor(
            InferenceConstants.IMG_START_INFERENCE_WIZARD_BANNER));

      IDialogSettings settings = InferenceUIPlugin.getInstance().getDialogSettings();
      IDialogSettings section = settings.getSection(getClass().getCanonicalName());
      if (section == null)
      {
         section = settings.addNewSection(getClass().getCanonicalName());
      }
      setDialogSettings(section);
   }


   @Override
   public void addPages()
   {
      page = new StartInferenceWizardPage("Structural Patterns Detection");
      addPage(page);
   }


   @Override
   public boolean performFinish()
   {
      // let the user confirm annotation result overwriting
      if (abortStarting())
      {
         return false;
      }

      storePageSettings();

      final DetectPatternsJob job = createPatternDetectionJob();

      try
      {
         configureAnnotationsView(job);
      }
      catch (PartInitException e)
      {
         e.printStackTrace();
         return false;
      }
      configureMatchingViews();

      job.schedule();


      return true;
   }


   protected DetectPatternsJob createPatternDetectionJob()
   {
      return createPatternDetectionJob(page.getCatalogResource(), page.getHostGraphResource(), page.getEnginesResource(),
            page.getReportLevel(), false, page.isUseExistingEngines(), page.isSearchForAdditionals(),
            page.getEvaluator());
   }
  

   
   protected DetectPatternsJob createPatternDetectionJob(Resource catalogResource, Resource hostResource, Resource enginesResource,
         ReportLevel reportLevel, boolean createEnginesResource, boolean useExistingEngines,
         boolean searchForAdditionals, IAnnotationEvaluator evaluator)
   {

      final DetectPatternsJob job = new DetectPatternsJob(catalogResource, hostResource, enginesResource, reportLevel);

      job.setUseExistingEngines(useExistingEngines);
      job.setAnnotateAdditionalElements(searchForAdditionals);
      job.setEvaluator(evaluator);
      return job;
   }
   




   protected void configureAnnotationsView(final DetectPatternsJob job) throws PartInitException
   {
      IViewPart part = null;
      part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(AnnotationView.ID);

      // check for existing annotations view
      if (part == null || !(part instanceof AnnotationView))
      {
         throw new PartInitException("Annotations View can not be initialized correctly.");
      }

      final AnnotationView annotations = (AnnotationView) part;
      PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable()
      {
         @Override
         public void run()
         {
            if (annotations != null)
            {
               annotations.switchToInference(job.getEngine());
            }
         }
      });
   }


   protected void configureMatchingViews()
   {
      final InferenceProgressListener mPatternView = (InferenceProgressListener) getMatchingView(VID_MATCHED_PATTERNS);
      if (mPatternView != null)
      {
         mPatternView.init();
      }

      final InferenceProgressListener mObjectsView = (InferenceProgressListener) getMatchingView(VID_MATCHED_OBJECTS);
      if (mObjectsView != null)
      {
         mObjectsView.init();
      }
   }


   /**
    * Checks whether there are annotations to save and requests the user to confirm the overwrite of
    * those.
    * 
    * @return Returns whether to abort the start of the inference.
    */
   protected boolean abortStarting()
   {
      // check if there are annotations in the view
      AnnotationView annotations = (AnnotationView) getMatchingView(AnnotationView.ID);
      if (annotations != null && !annotations.isEmpty())
      {
         // configuration data
         Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
         String title = "Overwrite Results";
         String message = "There are already annotated results. Do you want to overwrite them?";
         String[] labels = new String[] { "Save", "Overwrite", "Abort" };

         // create the dialog
         MessageDialog dialog = new MessageDialog(shell, title, null, message, MessageDialog.WARNING, labels, 2);

         int result = dialog.open();

         switch (result)
         {
            case 0:
               // save
               IWizard wizard = new SaveAnnotationsWizard(annotations);
               if (new WizardDialog(shell, wizard).open() == Window.OK)
               {
                  return false;
               }
               else
               {
                  return abortStarting();
               }
            case 1:
               // start
               return false;
            default:
               // abort
               return true;
         }
      }

      return false;
   }


   protected void storePageSettings()
   {
      // save page settings
      page.saveSettings();
   }


   protected IViewPart getMatchingView(String id)
   {
      return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(id);
   }
}
