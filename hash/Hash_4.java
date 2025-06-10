import java.util.*;

class User2 {
    String name;
    String surname;
    int budget;
    String ipAddress;
    String time;
    String city;
    int price;

    public User2(String name, String surname, int budget, String ipAddress, String time, String city, int price) {
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
        return name + " " + surname + " with salary " + budget + " from address " + ipAddress + " who logged in at " + time;
    }

    public boolean isAfterNoon() {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        return h > 11 || (h == 11 && Integer.parseInt(parts[1]) > 59);
    }

    public int timeInMinutes() {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

public class Hash_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, List<User2>> table = new CBHT<>(2 * n - 1);
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
            User2 u = new User2(name, surname, budget, ipAddress, time, city, price);
            SLLNode<MapEntry<String, List<User2>>> curr = table.search(network);
            if(curr == null) {
                List<User2> list = new ArrayList<>();
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
            SLLNode<MapEntry<String, List<User2>>> curr = table.search(network);

            if(curr == null) continue;
            List<User2> users = curr.element.value;
            List<User2> filtered = new ArrayList<>();
            for(User2 u : users) {
                if(u.isAfterNoon()) filtered.add(u);
            }

            if(filtered.isEmpty()) continue;
            User2 earliest = filtered.get(0);
            for(User2 u : filtered) {
                if(u.timeInMinutes() < earliest.timeInMinutes())
                    earliest = u;
            }

            System.out.println("IP network: " + network + " has the following number of users:\n" + filtered.size());
            System.out.println("The user who logged on earliest after noon from that network is:");
            System.out.println(earliest.toString() + "\n");

        }
    }

    static String getNetwork(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        return parts[0] + "." + parts[1] + "." + parts[2];
    }
}
