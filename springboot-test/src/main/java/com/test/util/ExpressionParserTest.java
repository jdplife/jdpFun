package com.test.util;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @ClassName ExpressionParserTest
 * @Description TODO
 * @Author jdp
 * @Date 14:34 2022/5/5
 * @Version 1.0
 **/
public class ExpressionParserTest {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        ParserContext parserContext = new ParserContext() {
            @Override
            public boolean isTemplate() {
                return true;
            }

            @Override
            public String getExpressionPrefix() {
                return "#|";
            }

            @Override
            public String getExpressionSuffix() {
                return "|";
            }
        };
        String template = "#|'Hello'|#|'World!'|";
        Expression expression = parser.parseExpression(template, parserContext);
        System.out.println(expression.getValue());
    }

}
