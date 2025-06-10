import java.util.*;

class User3 {
    String name;
    String surname;
    int budget;
    String ipAddress;
    String time;
    String city;
    int price;

    public User3(String name, String surname, int budget, String ipAddress, String time, String city, int price) {
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.ipAddress = ipAddress;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + surname + " with salary " + budget + " from address " + ipAddress + " who spent " + price;
    }
}

public class Hash_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, List<User3>> table = new CBHT<>(2 * n -1);

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String name = parts[0];
            String surname = parts[1];
            int budget = Integer.parseInt(parts[2]);
            String ipAddress = parts[3];
            String time = parts[4];
            String city = parts[5];
            int price = Integer.parseInt(parts[6]);

            String network = getNetwork(ipAddress);
            User3 u = new User3(name, surname, budget, ipAddress, time, city, price);
            SLLNode<MapEntry<String, List<User3>>> curr = table.search(network);

            if(curr == null) {
                List<User3> list = new ArrayList<>();
                list.add(u);
                table.insert(network, list);
            } else curr.element.value.add(u);
        }

        int m = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String ipAddress = parts[3];
            String network = getNetwork(ipAddress);
            SLLNode<MapEntry<String, List<User3>>> curr = table.search(network);

            if(curr == null) continue;
            List<User3> users = curr.element.value;
            List<User3> valid = new ArrayList<>();
            for(User3 u : users) {
                if(u.budget >= u.price) valid.add(u);
            }

            if(valid.isEmpty()) continue;
            User3 top = valid.get(0);
            for(User3 u : valid) {
                if(u.price > top.price) top = u;
            }

            System.out.println("IP network: " + network + " has the following number of users:\n" + valid.size());
            System.out.println("The user who spent the most from that network is:");
            System.out.println(top.toString() + "\n");
        }
    }

    static String getNetwork(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        return parts[0] + "." + parts[1] + "." + parts[2];
    }
}
