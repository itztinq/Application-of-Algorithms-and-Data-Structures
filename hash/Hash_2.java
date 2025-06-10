import java.util.*;

class User {
    String name;
    String surname;
    int budget;
    String ipAddress;
    String time;
    String city;
    int price;

    public User(String name, String surname, int budget, String ipAddress, String time, String city, int price) {
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

class CityInfo {
    int cnt;
    User top;

    public CityInfo(User user) {
        this.cnt = 1;
        this.top = user;
    }
    public void update(User user) {
        cnt++;
        if(user.price > top.price) top = user;
    }

    @Override
    public String toString() {
        return cnt + "\nThe user who spent the most purchasing for that city is:\n" + top.toString();
    }
}

public class Hash_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, CityInfo> table = new CBHT<>(2 * n - 1);

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String name = parts[0];
            String surname = parts[1];
            int budget = Integer.parseInt(parts[2]);
            String ipAddress = parts[3];
            String time = parts[4];
            String city = parts[5];
            int price = Integer.parseInt(parts[6]);

            if(budget >= price) {
                User u = new User(name, surname, budget, ipAddress, time, city, price);
                SLLNode<MapEntry<String, CityInfo>> curr = table.search(city);
                if(curr == null) table.insert(city, new CityInfo(u));
                else curr.element.value.update(u);
            }
        }

        int m = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String city = parts[5];
            SLLNode<MapEntry<String, CityInfo>> curr = table.search(city);

            System.out.println("City: "+ city + " has the following number of customers:");
            System.out.println(curr.element.value.cnt);
            System.out.println("The user who spent the most purchasing for that city is:");
            System.out.println(curr.element.value.top.toString() + "\n");
        }
    }
}