package org.storydriven.modeling.interpreter.adapter.storypattern.expressions;

import org.eclipse.emf.ecore.EcorePackage;
import org.storydriven.modeling.interpreter.adapter.SDMainAdapterFactory;
import org.storydriven.modeling.patterns.expressions.PrimitiveVariableExpression;

import de.mdelab.sdm.interpreter.common.SDMInterpreterConstants;
import de.mdelab.sdm.interpreter.common.SDMInterpreterException;
import de.mdelab.sdm.interpreter.common.adapters.m3.IClassifierAdapter;
import de.mdelab.sdm.interpreter.common.adapters.m3.IInstanceAdapter;
import de.mdelab.sdm.interpreter.common.variables.Variable;
import de.mdelab.sdm.interpreter.common.variables.VariableScope;

public class SDPrimitiveVariableExpressionAdapter extends SDPatternsExpressionAdapter<PrimitiveVariableExpression>
{

	public SDPrimitiveVariableExpressionAdapter(SDMainAdapterFactory mainAdapterFactory) 
	{
		super(mainAdapterFactory);
	}

	@Override
	public Variable evaluate(IClassifierAdapter contextClassifierAdapter, IInstanceAdapter contextInstanceAdapter, VariableScope variableScope)
			throws SDMInterpreterException 
	{

		try
		{
//			IClassifierAdapter classifierAdapter = variableScope.getInterpreterManager().getMainAdapterFactory().getM3AdapterFactory()
//					.getClassifierAdapter(EcorePackage.Literals.EDATA_TYPE);
			IClassifierAdapter classifierAdapter = variableScope.getInterpreterManager().getMainAdapterFactory().getM3AdapterFactory()
					.getClassifierAdapter(EcorePackage.Literals.EJAVA_OBJECT);
			
			IInstanceAdapter instanceAdapter = variableScope.getInterpreterManager().getMainAdapterFactory().getM3AdapterFactory()
					.getInstanceAdapter(getElement().getPrimitiveVariable(),classifierAdapter);
			
			return new Variable(SDMInterpreterConstants.INTERNAL_VAR_NAME, classifierAdapter, instanceAdapter);
		}
		catch (Exception e)
		{
			e.printStackTrace();

			throw new SDMInterpreterException("Could not evaluate AttributeValueExpression.", e);
		}
	}

	

}
