import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        // Vasiot kod tuka

        String[] addition = expression.split("\\+");
        int res = 0;

        for(String part : addition) {
            if(part.contains("*")) {
                String[] multiplications = part.split("\\*");
                int product = 1;
                for(String num : multiplications) {
                    product *= Integer.parseInt(num);
                }
                res += product;
            } else {
                res += Integer.parseInt(part);
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}