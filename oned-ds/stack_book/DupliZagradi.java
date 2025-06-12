package stack_book;
import java.util.*;

/* Пример 1:
Влез:
(((a+(b)))+(c+d))
Излез:
Najdeni se dupli zagradi
Пример 2:
Влез:
((a)+(b))
Излез:
/
*/

public class DupliZagradi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayStack<Character> stack = new ArrayStack<>(100);
        boolean flag = false;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')') {
                if(stack.peek() == '(') {
                    flag = true;
                    break;
                } else {
                    while(stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();
                }
            } else stack.push(ch);
        }

        if(flag) System.out.println("Najdeni se dupli zagradi");
        else System.out.println("/");
    }
}
