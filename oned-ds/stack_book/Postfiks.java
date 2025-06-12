package stack_book;
import java.util.*;

/*
Пример:
Влез: 5 9 + 2 * 6 5 * +
Излез: Rezultatot e 58.0
*/

public class Postfiks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =  sc.nextLine();
        String[] znaci = str.split(" ");
        ArrayStack<Double> stack = new ArrayStack<>(100);

        for(int i = 0; i < znaci.length; i++) {
            String znak = znaci[i];
            if(znak.matches("\\d+")) {
                stack.push(Double.parseDouble(znak));
            }
            else {
                double b = stack.pop();
                double a = stack.pop();
                double res = 0;

                switch(znak) {
                    case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    case "/": res = a / b; break;
                }
                stack.push(res);
            }
        }

        System.out.println("Rezultatot e " + stack.peek());
    }
}
