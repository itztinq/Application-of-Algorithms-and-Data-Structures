import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Collections;


public class card_trick {
    public static int count(int N){
        // Vasiot kod tuka

        LinkedList<Integer> deck = new LinkedList<>();
        int shuffles = 0;

        for(int i = 1; i <= 51; i++) deck.add(i);

        while(deck.peek() != N) {
            shuffles++;

            LinkedList<Integer> seven = new LinkedList<>();
            for(int i = 0; i < 7; i++) seven.add(deck.poll());

            Collections.reverse(seven);

            while(!seven.isEmpty()) {
                deck.add(seven.poll());
                if(!deck.isEmpty()) deck.add(deck.poll());
            }
        }

        return shuffles;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}
