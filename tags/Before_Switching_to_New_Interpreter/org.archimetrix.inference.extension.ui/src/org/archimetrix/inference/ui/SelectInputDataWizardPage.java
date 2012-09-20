package org.archimetrix.inference.ui;


import org.reclipse.structure.inference.ui.wizards.StartInferenceWizardPage;


/**
 * @author Oleg
 * @author Last editor: $Author$
 * @version $Revision$ $Date$
 */
public class SelectInputDataWizardPage extends StartInferenceWizardPage
{
   protected SelectInputDataWizardPage(String name)
   {
      super(name);
      setTitle("Structural Pattern Detection on Architectures");
   }


   @Override
   protected String getHostGraphFileExt()
   {
      return "sourcecodedecorator";
   }
}