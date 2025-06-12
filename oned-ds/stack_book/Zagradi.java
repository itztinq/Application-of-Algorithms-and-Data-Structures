package stack_book;
import java.util.*;

public class Zagradi {
    public static boolean korektni(char left, char right) {
        if(left == '(' && right == ')') return true;
        if(left == '[' && right == ']')  return true;
        if(left == '{' && right == '}') return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayStack<Character> stack = new ArrayStack<>(100);
        boolean flag = true;

        for(int i = 0; i < str.length(); i++) {
            char c =  str.charAt(i);
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else if(c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()) {
                    flag = false;
                    break;
                }
                char c1 = stack.peek();
                if(!korektni(c1, c)) {
                    flag = false;
                    break;
                }
                if(flag) stack.pop();
            }
        }

        if(!stack.isEmpty()) flag = false;
        System.out.println(flag ? str + " ima korektni zagradi" : str + " nema korektni zagradi");
    }
}
