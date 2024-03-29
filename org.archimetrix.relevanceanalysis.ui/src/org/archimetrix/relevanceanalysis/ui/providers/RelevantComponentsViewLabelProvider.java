package org.archimetrix.relevanceanalysis.ui.providers;


import org.archimetrix.relevanceanalysis.ui.RelevanceAnalysisUIPlugin;
import org.archimetrix.relevanceanalysis.ui.views.RelevantComponentsView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import eu.qimpress.sourcecodedecorator.ComponentImplementingClassesLink;


/**
 * The label provider for the table in the Relevant Components View.
 * 
 * @author mcp
 * @author Last editor: $Author$
 * @version $Revision$ $Date$
 * 
 */
public class RelevantComponentsViewLabelProvider extends AbstractRelevanceAnalysisViewLabelProvider
{

   private final RelevantComponentsView relevantComponentsView;


   public RelevantComponentsViewLabelProvider(final RelevantComponentsView relevantComponentsView)
   {
      this.relevantComponentsView = relevantComponentsView;
   }


   @Override
   public String getColumnText(final Object element, final int columnIndex)
   {
      String text;
      switch (columnIndex)
      {
         case 0:
            text = ((ComponentImplementingClassesLink) element).getComponent().getName();
            break;
         default:
            int lastColumn = this.relevantComponentsView.getRelevanceResults().getNumberOfRelevanceStrategies();
            if (columnIndex == lastColumn)
            {
               text = getParetoRelevanceValueString(columnIndex - 1, (ComponentImplementingClassesLink) element);
            }
            else
            {
               text = getRelevanceValueString(columnIndex - 1, (ComponentImplementingClassesLink) element);
            }
      }
      if (text.equals(INVALID_STRATEGY_VALUE))
      {
         text = "";
      }
      return text;
   }


   private String getParetoRelevanceValueString(final int index, final ComponentImplementingClassesLink link)
   {
      Double value = getRelevanceValueFromMap(index, link);
      if (value == 1.0)
      {
         return PARETO_OPTIMAL_TRUE;
      }
      return PARETO_OPTIMAL_FALSE;
   }


   public String getRelevanceValueString(final int index, final ComponentImplementingClassesLink element)
   {
      Double value = getRelevanceValueFromMap(index, element);
      return value.toString();
   }


   public Double getRelevanceValueFromMap(final int index, final ComponentImplementingClassesLink link)
   {
      if (this.relevantComponentsView.getRelevanceResults().getRelevanceValues(link).length > 0)
      {
         return this.relevantComponentsView.getRelevanceResults().getRelevanceValues(link)[index];
      }
      return 0d;
   }


   @Override
   public Color getBackground(final Object element, final int columnIndex)
   {
      if (getRelevanceValueFromMap(
            this.relevantComponentsView.getRelevanceResults().getNumberOfRelevanceStrategies() - 1,
            ((ComponentImplementingClassesLink) element)) == 1.0)
      {
         return Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW);
      }
      if (isHighestRelevanceValue(
            getRelevanceValueFromMap(
                  this.relevantComponentsView.getRelevanceResults().getNumberOfRelevanceStrategies() - 2,
                  ((ComponentImplementingClassesLink) element)), ((ComponentImplementingClassesLink) element)))
      {
         return Display.getCurrent().getSystemColor(SWT.COLOR_CYAN);
      }
      return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
   }


   private boolean isHighestRelevanceValue(final Double relevanceValue,
         final ComponentImplementingClassesLink currentLink)
   {
      return relevanceValue.equals(getMaxRelevanceValue(currentLink));
   }


   private Double getMaxRelevanceValue(final ComponentImplementingClassesLink currentLink)
   {
      Double max = -1.0;
      for (Double value : this.relevantComponentsView.getRelevanceResults().getRelevanceValuesForStrategy(
            this.relevantComponentsView.getRelevanceResults().getNumberOfRelevanceStrategies()-2))
      {
         if (value >= max)
         {
            max = value;
         }
      }
      return max;
   }


   @Override
   public Image getColumnImage(final Object element, final int columnIndex)
   {
      if (columnIndex == 0)
      {
         return RelevanceAnalysisUIPlugin.getImageDescriptor(COMPONENTS_ICON_PATH).createImage();
      }
      return null;
   }
}
