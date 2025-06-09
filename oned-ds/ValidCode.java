import java.util.*;

public class ValidCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        while(true) {
            String str = sc.nextLine();
            if(str.equals("x")) break;
            if(!str.startsWith("end")) stack.push(str);
            else {
                if(stack.isEmpty() || !stack.peek().equals(str.substring(3))) {
                    System.out.println("Invalid");
                    return;
                }
                stack.pop();
            }
        }
        System.out.println(stack.isEmpty() ? "Valid" : "Invalid");
    }
}
