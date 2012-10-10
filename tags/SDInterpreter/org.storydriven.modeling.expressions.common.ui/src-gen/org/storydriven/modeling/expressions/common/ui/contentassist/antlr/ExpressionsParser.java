/*
* generated by Xtext
*/
package org.storydriven.modeling.expressions.common.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.storydriven.modeling.expressions.common.services.ExpressionsGrammarAccess;

public class ExpressionsParser extends AbstractContentAssistParser {
	
	@Inject
	private ExpressionsGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.storydriven.modeling.expressions.common.ui.contentassist.antlr.internal.InternalExpressionsParser createParser() {
		org.storydriven.modeling.expressions.common.ui.contentassist.antlr.internal.InternalExpressionsParser result = new org.storydriven.modeling.expressions.common.ui.contentassist.antlr.internal.InternalExpressionsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getDisjunctionAccess().getAlternatives_1_0(), "rule__Disjunction__Alternatives_1_0");
					put(grammarAccess.getNegationAccess().getAlternatives(), "rule__Negation__Alternatives");
					put(grammarAccess.getCExpressionAccess().getAlternatives(), "rule__CExpression__Alternatives");
					put(grammarAccess.getCompareAccess().getAlternatives_1(), "rule__Compare__Alternatives_1");
					put(grammarAccess.getOpenCompareAccess().getAlternatives_1(), "rule__OpenCompare__Alternatives_1");
					put(grammarAccess.getSomeValueAccess().getAlternatives(), "rule__SomeValue__Alternatives");
					put(grammarAccess.getAdditionAccess().getAlternatives_1_0(), "rule__Addition__Alternatives_1_0");
					put(grammarAccess.getMultiplicationAccess().getAlternatives_1_0(), "rule__Multiplication__Alternatives_1_0");
					put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
					put(grammarAccess.getVARIABLE_VALUEAccess().getAlternatives(), "rule__VARIABLE_VALUE__Alternatives");
					put(grammarAccess.getEquivalentAccess().getGroup(), "rule__Equivalent__Group__0");
					put(grammarAccess.getEquivalentAccess().getGroup_1(), "rule__Equivalent__Group_1__0");
					put(grammarAccess.getImplicationAccess().getGroup(), "rule__Implication__Group__0");
					put(grammarAccess.getImplicationAccess().getGroup_1(), "rule__Implication__Group_1__0");
					put(grammarAccess.getDisjunctionAccess().getGroup(), "rule__Disjunction__Group__0");
					put(grammarAccess.getDisjunctionAccess().getGroup_1(), "rule__Disjunction__Group_1__0");
					put(grammarAccess.getDisjunctionAccess().getGroup_1_0_0(), "rule__Disjunction__Group_1_0_0__0");
					put(grammarAccess.getDisjunctionAccess().getGroup_1_0_1(), "rule__Disjunction__Group_1_0_1__0");
					put(grammarAccess.getConjunctionAccess().getGroup(), "rule__Conjunction__Group__0");
					put(grammarAccess.getConjunctionAccess().getGroup_1(), "rule__Conjunction__Group_1__0");
					put(grammarAccess.getNegationAccess().getGroup_0(), "rule__Negation__Group_0__0");
					put(grammarAccess.getNegatedAccess().getGroup(), "rule__Negated__Group__0");
					put(grammarAccess.getCExpressionAccess().getGroup_0(), "rule__CExpression__Group_0__0");
					put(grammarAccess.getCompareAccess().getGroup(), "rule__Compare__Group__0");
					put(grammarAccess.getCompareAccess().getGroup_1_0(), "rule__Compare__Group_1_0__0");
					put(grammarAccess.getCompareAccess().getGroup_1_1(), "rule__Compare__Group_1_1__0");
					put(grammarAccess.getCompareAccess().getGroup_1_2(), "rule__Compare__Group_1_2__0");
					put(grammarAccess.getCompareAccess().getGroup_1_3(), "rule__Compare__Group_1_3__0");
					put(grammarAccess.getCompareAccess().getGroup_1_4(), "rule__Compare__Group_1_4__0");
					put(grammarAccess.getCompareAccess().getGroup_1_5(), "rule__Compare__Group_1_5__0");
					put(grammarAccess.getCompareAccess().getGroup_1_6(), "rule__Compare__Group_1_6__0");
					put(grammarAccess.getOpenCompareAccess().getGroup(), "rule__OpenCompare__Group__0");
					put(grammarAccess.getOpenCompareAccess().getGroup_1_0(), "rule__OpenCompare__Group_1_0__0");
					put(grammarAccess.getOpenCompareAccess().getGroup_1_1(), "rule__OpenCompare__Group_1_1__0");
					put(grammarAccess.getOpenCompareAccess().getGroup_1_2(), "rule__OpenCompare__Group_1_2__0");
					put(grammarAccess.getOpenCompareAccess().getGroup_1_3(), "rule__OpenCompare__Group_1_3__0");
					put(grammarAccess.getOpenCompareAccess().getGroup_1_4(), "rule__OpenCompare__Group_1_4__0");
					put(grammarAccess.getOpenCompareAccess().getGroup_1_5(), "rule__OpenCompare__Group_1_5__0");
					put(grammarAccess.getOpenCompareAccess().getGroup_1_6(), "rule__OpenCompare__Group_1_6__0");
					put(grammarAccess.getAdditionAccess().getGroup(), "rule__Addition__Group__0");
					put(grammarAccess.getAdditionAccess().getGroup_1(), "rule__Addition__Group_1__0");
					put(grammarAccess.getAdditionAccess().getGroup_1_0_0(), "rule__Addition__Group_1_0_0__0");
					put(grammarAccess.getAdditionAccess().getGroup_1_0_1(), "rule__Addition__Group_1_0_1__0");
					put(grammarAccess.getMultiplicationAccess().getGroup(), "rule__Multiplication__Group__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1(), "rule__Multiplication__Group_1__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1_0_0(), "rule__Multiplication__Group_1_0_0__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1_0_1(), "rule__Multiplication__Group_1_0_1__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1_0_2(), "rule__Multiplication__Group_1_0_2__0");
					put(grammarAccess.getPowerAccess().getGroup(), "rule__Power__Group__0");
					put(grammarAccess.getPowerAccess().getGroup_1(), "rule__Power__Group_1__0");
					put(grammarAccess.getPowerAccess().getGroup_1_0(), "rule__Power__Group_1_0__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_0(), "rule__PrimaryExpression__Group_0__0");
					put(grammarAccess.getNUMBERAccess().getGroup(), "rule__NUMBER__Group__0");
					put(grammarAccess.getNUMBERAccess().getGroup_1(), "rule__NUMBER__Group_1__0");
					put(grammarAccess.getVARIABLE_VALUEAccess().getGroup_1(), "rule__VARIABLE_VALUE__Group_1__0");
					put(grammarAccess.getEquivalentAccess().getRightAssignment_1_2(), "rule__Equivalent__RightAssignment_1_2");
					put(grammarAccess.getImplicationAccess().getRightAssignment_1_2(), "rule__Implication__RightAssignment_1_2");
					put(grammarAccess.getDisjunctionAccess().getRightAssignment_1_1(), "rule__Disjunction__RightAssignment_1_1");
					put(grammarAccess.getConjunctionAccess().getRightAssignment_1_2(), "rule__Conjunction__RightAssignment_1_2");
					put(grammarAccess.getNegatedAccess().getNotAssignment_1(), "rule__Negated__NotAssignment_1");
					put(grammarAccess.getCompareAccess().getRightAssignment_2(), "rule__Compare__RightAssignment_2");
					put(grammarAccess.getOpenCompareAccess().getRightAssignment_2(), "rule__OpenCompare__RightAssignment_2");
					put(grammarAccess.getAdditionAccess().getRightAssignment_1_1(), "rule__Addition__RightAssignment_1_1");
					put(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1(), "rule__Multiplication__RightAssignment_1_1");
					put(grammarAccess.getPowerAccess().getRightAssignment_1_1(), "rule__Power__RightAssignment_1_1");
					put(grammarAccess.getNumberValueAccess().getNumValueAssignment(), "rule__NumberValue__NumValueAssignment");
					put(grammarAccess.getBooleanValueAccess().getValueAssignment(), "rule__BooleanValue__ValueAssignment");
					put(grammarAccess.getStringValueAccess().getStrValueAssignment(), "rule__StringValue__StrValueAssignment");
					put(grammarAccess.getVariableAccess().getVarNameAssignment(), "rule__Variable__VarNameAssignment");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.storydriven.modeling.expressions.common.ui.contentassist.antlr.internal.InternalExpressionsParser typedParser = (org.storydriven.modeling.expressions.common.ui.contentassist.antlr.internal.InternalExpressionsParser) parser;
			typedParser.entryRuleLExpression();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ExpressionsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ExpressionsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
