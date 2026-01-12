import java.util.*;

public class FunkcijaPovikuvaFunkcii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Stack<String> stack = new Stack<>() {
            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public String peek() {
                return "";
            }

            @Override
            public void clear() {

            }

            @Override
            public void push(String x) {

            }

            @Override
            public String pop() {
                return "";
            }
        };

        Map<String, Integer> cnt = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if(parts[0].equals("Call")) {
                String func = parts[1];
                if(!stack.isEmpty()) {
                    cnt.put(func, cnt.getOrDefault(func, 0) + 1);
                }
                stack.push(func);
            }
            else stack.pop();
        }

        String best = "";
        int max = -1;
        for(String k : cnt.keySet()) {
            int v = cnt.get(k);
            if(v > max) {
                max = v;
                best = k;
            }
        }

        System.out.println(best);
    }
}
