package stack_book;
import java.util.*;

public class IspitnaSesija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] knigi = sc.nextLine().split(" ");
        String[] ispiti = sc.nextLine().split(" ");

        ArrayStack<String> stack = new ArrayStack<>(100);
        for(String kniga : knigi) {
            stack.push(kniga);
        }

        LinkedHashMap<String, Integer> cnt = new LinkedHashMap<>();
        for(String kniga : knigi) {
            cnt.put(kniga, 0);
        }

        for(String ispit : ispiti) {
            ArrayStack<String> tmp = new ArrayStack<>(100);
            while(!stack.isEmpty()) {
                String curr = stack.pop();
                tmp.push(curr);
                if(curr.equals(ispit)) break;
            }
            while(!tmp.isEmpty()) {
                String kniga = tmp.pop();
                cnt.put(kniga, cnt.get(kniga) + 1);
                stack.push(kniga);
            }

            ArrayStack<String> stackNew = new ArrayStack<>(100);
            while(!stack.isEmpty()) {
                String curr = stack.pop();
                if(curr.equals(ispit)) break;
                stackNew.push(curr);
            }
            while(!stackNew.isEmpty()) {
                stack.push(stackNew.pop());
            }
            stack.push(ispit);
        }
        for(String kniga : knigi) {
            System.out.println(kniga + " " + cnt.get(kniga));
        }
    }
}
