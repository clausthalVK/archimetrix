package org.archimetrix.architectureprognosis.ui.handler;


import org.archimetrix.architectureprognosis.ui.wizards.ArchitecturePrognosisWizard;
import org.archimetrix.relevanceanalysis.ui.views.RelevantBadSmellsView;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;


/**
 * Opens the wizard for starting the architecture prognosis from the relevant bad smells view per
 * context menu (see plugin.xml).
 * 
 * @author mcp
 * @author Last editor: $Author$
 * @version $Revision$ $Date$
 * 
 */
public class ArchitecturePrognosisStartingFromRelevantBadSmellsViewHandler extends AbstractHandler
{

   @Override
   public Object execute(final ExecutionEvent event) throws ExecutionException
   {
      ArchitecturePrognosisWizard wizard = new ArchitecturePrognosisWizard(
            RelevantBadSmellsView.getSelectedAnnotation());
      WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
      dialog.open();
      return null;
   }
}