package io.github.laplacedemon.calc24;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class Calc24UtilTest {

    @Test
    public void testAllPermutation() {
        int[] arr = new int[]{1,2,3,4};
        List<Integer> list = new ArrayList<Integer>(4);
        Calc24Util.allPermutation(list, arr, new Consumer<List<Integer>>() {

            @Override
            public void accept(List<Integer> var) {
                System.out.println(var.toString());
            }
        });
    }

    @Test
    public void testCalcExpression() {
        Parser parser = new Parser("(10.0 * 10.0 - 4.0)/4.0");
        try {
            BaseExpression parse = parser.parse();
            Object eval = parse.eval();
            System.out.println(eval + ", " + eval.getClass());
        } catch (ParseExpressionException e) {
            e.printStackTrace();
        } catch (IncomputableException e) {
            e.printStackTrace();
        }
    }
}
