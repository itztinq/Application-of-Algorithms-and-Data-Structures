import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MostFrequentSubstring {
    public static void main (String[] args) throws IOException {
        CBHT<String,Integer> table = new CBHT<String,Integer>(300);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();

        for(int i = 0; i < word.length(); i++) {
            for(int j = i + 1; j <= word.length(); j++) {
                String sub = word.substring(i, j);
                SLLNode<MapEntry<String, Integer>> node = table.search(sub);
                if(node != null) node.element.value++;
                else table.insert(sub,1);
            }
        }

        String best = "";
        int mxFreq = 0;
        for(int i = 0; i < 300; i++) {
            SLLNode<MapEntry<String, Integer>> curr = table.buckets[i];
            while(curr != null) {
                String sub = curr.element.key;
                int freq = curr.element.value;
                if(freq > mxFreq || (freq == mxFreq && sub.length() > best.length()) ||
                        (freq == mxFreq && sub.length() == best.length() && sub.compareTo(best) < 0)) {
                    mxFreq = freq;
                    best = sub;
                }
                curr = curr.succ;
            }
        }
        System.out.println(best);
    }
}