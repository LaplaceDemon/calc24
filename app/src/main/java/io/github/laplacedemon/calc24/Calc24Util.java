package io.github.laplacedemon.calc24;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.Parser;

public class Calc24Util {

    /*
     * https://blog.csdn.net/hellojoy/article/details/82183153
     * */
    public static void allPermutation(final List<Integer> result, int[] arr, final Consumer<List<Integer>> consumer) {
        if (arr.length == 0) {
            consumer.accept(result);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int e = arr[i];
            int[] eArr = new int[arr.length - 1];
            int eArrIndex = 0;
            for (int n = 0; n < arr.length; n++) {
                if (n != i) {
                    eArr[eArrIndex] = arr[n];
                    eArrIndex++;
                }
            }

            final List<Integer> resultCopy = new ArrayList<>(result.size());
            for (Integer x : result) {
                resultCopy.add(x);
            }
            resultCopy.add(e);
            allPermutation(resultCopy, eArr, consumer);
        }
    }

    public static void calcAndShow(final TextView textView, int x0, int x1, int x2, int x3) {
        int[] arr = new int[]{x0, x1, x2, x3};
        List<Integer> list = new ArrayList<>(4);
        allPermutation(list, arr, new Consumer<List<Integer>>() {

            @Override
            public void accept(List<Integer> list) {
                int x0 = list.get(0);
                int x1 = list.get(1);
                int x2 = list.get(2);
                int x3 = list.get(3);

                for (int op1 = 0; op1 <= 3; op1++) {
                    for (int op2 = 0; op2 <= 3; op2++) {
                        for (int op3 = 0; op3 <= 3; op3++) {
                            final StringBuilder expressionStringBuilder = new StringBuilder();
                            appendNum(expressionStringBuilder, x0);
                            appendOp(expressionStringBuilder, op1);
                            appendNum(expressionStringBuilder, x1);
                            appendOp(expressionStringBuilder, op2);
                            appendNum(expressionStringBuilder, x2);
                            appendOp(expressionStringBuilder, op3);
                            appendNum(expressionStringBuilder, x3);
                            String expressionString = expressionStringBuilder.toString();
                            double v = opCalc(expressionString);
                            if (check24(v)) {
                                textView.append(expressionString.replaceAll(".0", "") + "\n");
                            }
                        }
                    }
                }

                // (x0 * x1) * x2 * x3
                for (int op1 = 0; op1 <= 3; op1++) {
                    for (int op2 = 0; op2 <= 3; op2++) {
                        for (int op3 = 0; op3 <= 3; op3++) {
                            final StringBuilder expressionStringBuilder = new StringBuilder();
                            expressionStringBuilder.append("(");
                            appendNum(expressionStringBuilder, x0);
                            appendOp(expressionStringBuilder, op1);
                            appendNum(expressionStringBuilder, x1);
                            expressionStringBuilder.append(")");
                            appendOp(expressionStringBuilder, op2);
                            appendNum(expressionStringBuilder, x2);
                            appendOp(expressionStringBuilder, op3);
                            appendNum(expressionStringBuilder, x3);
                            String expressionString = expressionStringBuilder.toString();
                            double v = opCalc(expressionString);
                            if (check24(v)) {
                                textView.append(expressionString.replaceAll(".0", "") + "\n");
                            }
                        }
                    }
                }

                // x0 * （x1 * x2） * x3
                for (int op1 = 0; op1 <= 3; op1++) {
                    for (int op2 = 0; op2 <= 3; op2++) {
                        for (int op3 = 0; op3 <= 3; op3++) {
                            final StringBuilder expressionStringBuilder = new StringBuilder();
                            appendNum(expressionStringBuilder, x0);
                            appendOp(expressionStringBuilder, op1);
                            expressionStringBuilder.append("(");
                            appendNum(expressionStringBuilder, x1);
                            appendOp(expressionStringBuilder, op2);
                            appendNum(expressionStringBuilder, x2);
                            expressionStringBuilder.append(")");
                            appendOp(expressionStringBuilder, op3);
                            appendNum(expressionStringBuilder, x3);
                            String expressionString = expressionStringBuilder.toString();
                            double v = opCalc(expressionString);
                            if (check24(v)) {
                                textView.append(expressionString.replaceAll(".0", "") + "\n");
                            }
                        }
                    }
                }

                // x0 * x1 * (x2 * x3)
                for (int op1 = 0; op1 <= 3; op1++) {
                    for (int op2 = 0; op2 <= 3; op2++) {
                        for (int op3 = 0; op3 <= 3; op3++) {
                            final StringBuilder expressionStringBuilder = new StringBuilder();
                            appendNum(expressionStringBuilder, x0);
                            appendOp(expressionStringBuilder, op1);
                            appendNum(expressionStringBuilder, x1);
                            appendOp(expressionStringBuilder, op2);
                            expressionStringBuilder.append("(");
                            appendNum(expressionStringBuilder, x2);
                            appendOp(expressionStringBuilder, op3);
                            appendNum(expressionStringBuilder, x3);
                            expressionStringBuilder.append(")");
                            String expressionString = expressionStringBuilder.toString();
                            double v = opCalc(expressionString);
                            if (check24(v)) {
                                textView.append(expressionString.replaceAll(".0", "") + "\n");
                            }
                        }
                    }
                }

                // （x0 * x1 * x2） * x3
                for (int op1 = 0; op1 <= 3; op1++) {
                    for (int op2 = 0; op2 <= 3; op2++) {
                        for (int op3 = 0; op3 <= 3; op3++) {
                            final StringBuilder expressionStringBuilder = new StringBuilder();
                            expressionStringBuilder.append("(");
                            appendNum(expressionStringBuilder, x0);
                            appendOp(expressionStringBuilder, op1);
                            appendNum(expressionStringBuilder, x1);
                            appendOp(expressionStringBuilder, op2);
                            appendNum(expressionStringBuilder, x2);
                            expressionStringBuilder.append(")");
                            appendOp(expressionStringBuilder, op3);
                            appendNum(expressionStringBuilder, x3);
                            String expressionString = expressionStringBuilder.toString();
                            double v = opCalc(expressionString);

                            if (check24(v)) {
                                textView.append(expressionString.replaceAll(".0", "") + "\n");
                            }
                        }
                    }
                }

                // x0 * （x1 * x2 * x3）
                for (int op1 = 0; op1 <= 3; op1++) {
                    for (int op2 = 0; op2 <= 3; op2++) {
                        for (int op3 = 0; op3 <= 3; op3++) {
                            final StringBuilder expressionStringBuilder = new StringBuilder();
                            appendNum(expressionStringBuilder, x0);
                            appendOp(expressionStringBuilder, op1);
                            expressionStringBuilder.append("(");
                            appendNum(expressionStringBuilder, x1);
                            appendOp(expressionStringBuilder, op2);
                            appendNum(expressionStringBuilder, x2);
                            appendOp(expressionStringBuilder, op3);
                            appendNum(expressionStringBuilder, x3);
                            expressionStringBuilder.append(")");
                            String expressionString = expressionStringBuilder.toString();
                            double v = opCalc(expressionString);
                            if (check24(v)) {
                                textView.append(expressionString.replaceAll(".0", "") + "\n");
                            }
                        }
                    }
                }

                // （x0 * x1) * (x2 * x3)
                for (int op1 = 0; op1 <= 3; op1++) {
                    for (int op2 = 0; op2 <= 3; op2++) {
                        for (int op3 = 0; op3 <= 3; op3++) {
                            final StringBuilder expressionStringBuilder = new StringBuilder();
                            expressionStringBuilder.append("(");
                            appendNum(expressionStringBuilder, x0);
                            appendOp(expressionStringBuilder, op1);
                            appendNum(expressionStringBuilder, x1);
                            expressionStringBuilder.append(")");
                            appendOp(expressionStringBuilder, op2);
                            expressionStringBuilder.append("(");
                            appendNum(expressionStringBuilder, x2);
                            appendOp(expressionStringBuilder, op3);
                            appendNum(expressionStringBuilder, x3);
                            expressionStringBuilder.append(")");
                            String expressionString = expressionStringBuilder.toString();
                            double v = opCalc(expressionString);
                            if (check24(v)) {
                                textView.append(expressionString.replaceAll(".0", "") + "\n");
                            }
                        }
                    }
                }

                // (x0 * (x1 * x2)) * x3
                for (int op1 = 0; op1 <= 3; op1++) {
                    for (int op2 = 0; op2 <= 3; op2++) {
                        for (int op3 = 0; op3 <= 3; op3++) {
                            final StringBuilder expressionStringBuilder = new StringBuilder();
                            expressionStringBuilder.append("(");
                            appendNum(expressionStringBuilder, x0);
                            appendOp(expressionStringBuilder, op1);
                            expressionStringBuilder.append("(");
                            appendNum(expressionStringBuilder, x1);
                            appendOp(expressionStringBuilder, op2);
                            appendNum(expressionStringBuilder, x2);
                            expressionStringBuilder.append(")");
                            expressionStringBuilder.append(")");
                            appendOp(expressionStringBuilder, op3);
                            appendNum(expressionStringBuilder, x3);
                            String expressionString = expressionStringBuilder.toString();
                            double v = opCalc(expressionString);
                            if (check24(v)) {
                                textView.append(expressionString.replaceAll(".0", "") + "\n");
                            }
                        }
                    }
                }

                // x0 * ((x1 * x2) * x3)
                for (int op1 = 0; op1 <= 3; op1++) {
                    for (int op2 = 0; op2 <= 3; op2++) {
                        for (int op3 = 0; op3 <= 3; op3++) {
                            final StringBuilder expressionStringBuilder = new StringBuilder();
                            appendNum(expressionStringBuilder, x0);
                            appendOp(expressionStringBuilder, op1);
                            expressionStringBuilder.append("(");
                            expressionStringBuilder.append("(");
                            appendNum(expressionStringBuilder, x1);
                            appendOp(expressionStringBuilder, op2);
                            appendNum(expressionStringBuilder, x2);
                            expressionStringBuilder.append(")");
                            appendOp(expressionStringBuilder, op3);
                            appendNum(expressionStringBuilder, x3);
                            expressionStringBuilder.append(")");
                            String expressionString = expressionStringBuilder.toString();
                            double v = opCalc(expressionString);
                            if (check24(v)) {
                                textView.append(expressionString.replaceAll(".0", "") + "\n");
                            }
                        }
                    }
                }

            }
        });
        textView.append("计算完成！");
    }

    public static boolean check24(Number num) {
        double v = num.doubleValue();
        if (v >= 23.99 && v <= 24.01) {
            return true;
        }
        return false;
    }

    public static double opCalc(final String expressionString) {
        Parser parser = new Parser(expressionString);
        try {
            BaseExpression parse = parser.parse();
            Double result = (Double) parse.eval();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(expressionString, e);
        }
    }

    private static void appendNum(final StringBuilder sb,  final int num) {
        sb.append(num);
        sb.append(".0");
    }

    private static void appendOp(final StringBuilder sb, final int op) {
        if (op == 0) {
            sb.append("+");
        } else if (op == 1) {
            sb.append("-");
        } else if (op == 2) {
            sb.append("*");
        } else if (op == 3) {
            sb.append("/");
        } else {
            throw new RuntimeException();
        }
    }
}
