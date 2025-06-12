package stack_book;
import java.util.NoSuchElementException;
import java.util.*;

interface Stack<E> {
    // Elementi na stekot se objekti od proizvolen tip.
    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:
    public void clear();
    // Go prazni stekot.

    public void push(E x);
    // Go dodava x na vrvot na stekot.

    public E pop();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems; //elems[0...depth-1] se negovite elementi.
    private int depth; //depth e dlabochinata na stekot

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }

    public int size() {
        // Ja vrakja dolzinata na stack-ot.
        return depth;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class PonishtuvanjeTopchinja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack<String> red = new ArrayStack<>(100);
        ArrayStack<String> green = new ArrayStack<>(100);
        ArrayStack<String> blue = new ArrayStack<>(100);

        for(String topce : sc.nextLine().split(" ")) {
            ArrayStack<String> stack = switch (topce.charAt(0)) {
                case 'R' -> red;
                case 'G' -> green;
                case 'B' -> blue;
                default -> null;
            };
            if(stack != null && !stack.isEmpty() && stack.peek().charAt(1) != topce.charAt(1)) {
                stack.pop();
            } else stack.push(topce);
        }

        ArrayStack<String> res = new ArrayStack<>(100);
        int cnt = 0;
        for(ArrayStack<String> s : List.of(blue, green, red)) {
            while(!s.isEmpty()) {
                String t =  s.pop();
                res.push(t.charAt(0) + (t.charAt(1) == '+' ? "-" : "+"));
                cnt++;
            }
        }

        System.out.println(cnt);
        while(!res.isEmpty()) System.out.print(res.pop() + " ");
    }
}
