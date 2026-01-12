import java.util.*;

public class Datoteki {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> contentMap = new HashMap<>();
        Map<String, String> fileMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String path = parts[0];
            String fileName = parts[1];
            String content = parts[2].substring(1, parts[2].length()-1);
            String fullPath = path + " " + fileName;

            fileMap.put(fullPath, content);

            contentMap.putIfAbsent(content, new ArrayList<>());
            contentMap.get(content).add(fullPath);
        }

        int m = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split(" ");
            String cmd = parts[0];
            String path = parts[1];
            String fileName = parts[2];
            String content = parts[3].substring(1, parts[3].length()-1);
            String fullPath = path + " " + fileName;

            switch (cmd) {
                case "add":
                    fileMap.put(fullPath, content);
                    contentMap.putIfAbsent(content, new ArrayList<>());
                    contentMap.get(content).add(fullPath);
                    break;
                case "delete":
                    if(fileMap.containsKey(fullPath)) {
                        String oldContent = fileMap.get(fullPath);
                        fileMap.remove(fullPath);
                        contentMap.get(oldContent).remove(fullPath);
                        if(contentMap.get(oldContent).isEmpty()) {
                            contentMap.remove(oldContent);
                        }
                    }
                    break;
                case "find":
                    System.out.println(fileMap.containsKey(fullPath));
                    break;
            }
        }

        String targetContent = sc.nextLine();
        if(contentMap.containsKey(targetContent)) {
            for(String s : contentMap.get(targetContent)) {
                System.out.print(s + " ");
            }
        }
    }
}
