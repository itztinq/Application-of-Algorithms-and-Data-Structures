package stack_book;
import java.sql.Array;
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
        String line = sc.nextLine();
        String[] balls = line.split(" ");

        ArrayStack<String> red = new ArrayStack<>(100);
        ArrayStack<String> green = new ArrayStack<>(100);
        ArrayStack<String> blue = new ArrayStack<>(100);

        for(int i = 0; i < balls.length; i++) {
            String ball = balls[i];
            if(ball.charAt(0) == 'R') {
                if(!red.isEmpty() && ball.charAt(1) != red.peek().charAt(1)) {
                    red.pop();
                } else red.push(ball);
            }
            else if(ball.charAt(0) == 'G') {
                if(!green.isEmpty() && ball.charAt(1) != green.peek().charAt(1)) {
                    green.pop();
                } else green.push(ball);
            }
            else if(ball.charAt(0) == 'B') {
                if(!blue.isEmpty() && ball.charAt(1) != blue.peek().charAt(1)) {
                    blue.pop();
                } else blue.push(ball);
            }
        }

        int cnt = 0;
        ArrayStack<String> stack = new ArrayStack<>(100);

        while(!blue.isEmpty()) {
            cnt++;
            String ball = blue.pop();
            if(ball.equals("B+")) stack.push("B-");
            else stack.push("B+");
        }
        while(!green.isEmpty()) {
            cnt++;
            String ball = green.pop();
            if(ball.equals("G+")) stack.push("G-");
            else stack.push("G+");
        }
        while(!red.isEmpty()) {
            cnt++;
            String ball = red.pop();
            if(ball.equals("R+")) stack.push("R-");
            else stack.push("R+");
        }

        System.out.println(cnt);
        while(!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }
}
