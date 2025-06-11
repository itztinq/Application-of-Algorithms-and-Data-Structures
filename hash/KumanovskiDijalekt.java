import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KumanovskiDijalekt {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        CBHT<String, String> dict = new CBHT<>(n);
        for(int i = 0; i < n; i++){
            String[] parts = br.readLine().split("\\s+");
            dict.insert(parts[0].toLowerCase(), parts[1]);
        }

        String text = br.readLine();
        String[] words = text.split("\\s+");
        StringBuilder res = new StringBuilder();

        if(n == 0) {
            System.out.println(text);
            return;
        }

        for(String word : words) {
            String punctation = "";
            String cleanWord = word;
            if(word.endsWith(".") || word.endsWith(",") || word.endsWith("!") || word.endsWith("?")) {
                punctation = word.substring(word.length() - 1);
                cleanWord = word.substring(0, word.length() - 1);
            }

            String lowerClean = cleanWord.toLowerCase();
            SLLNode<MapEntry<String, String>> node = dict.search(lowerClean);

            if(node != null) {
                String replacement = node.element.value;
                if(Character.isUpperCase(cleanWord.charAt(0))) {
                    replacement = replacement.substring(0, 1).toUpperCase() + replacement.substring(1);
                }
                res.append(replacement);
            }
            else res.append(cleanWord);

            res.append(punctation).append(" ");
        }
        System.out.println(res.toString().trim());
    }
}