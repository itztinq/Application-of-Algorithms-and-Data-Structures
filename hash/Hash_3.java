import java.util.*;

class User1 {
    String name;
    String surname;
    int budget;
    String ipAddress;
    String time;
    String city;
    int price;

    public User1(String name, String surname, int budget, String ipAddress, String time, String city, int price) {
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
}

class CityInfo1 {
    int cnt;
    User1 earliest;

    public CityInfo1(User1 user) {
        this.cnt = 1;
        this.earliest = user;
    }
    public void update(User1 user) {
        cnt++;
        if(user.time.compareTo(earliest.time) < 0) {
            earliest = user;
        }
    }

    @Override
    public String toString() {
        return cnt + "\nThe user who logged on earliest after noon from that city is:\n" + earliest.toString();
    }
}

public class Hash_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, CityInfo1> table = new CBHT<>(2 * n - 1);

        for(int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String name = parts[0];
            String surname = parts[1];
            int budget = Integer.parseInt(parts[2]);
            String ipAddress = parts[3];
            String time = parts[4];
            String city = parts[5];
            int price = Integer.parseInt(parts[6]);

            if(time.compareTo("11:59") > 0) {
                User1 u = new User1(name, surname, budget, ipAddress, time, city, price);
                SLLNode<MapEntry<String, CityInfo1>> curr = table.search(city);
                if(curr == null) table.insert(city, new CityInfo1(u));
                else curr.element.value.update(u);
            }
        }

        sc.nextLine();
        int m = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String city = parts[5];
            SLLNode<MapEntry<String, CityInfo1>> curr = table.search(city);

            System.out.println("City: " + city + " has the following number of customers:");
            System.out.println(curr.element.value.cnt);
            System.out.println("The user who logged on earliest after noon from that city is:");
            System.out.println(curr.element.value.earliest.toString() + "\n");
        }
    }
}
