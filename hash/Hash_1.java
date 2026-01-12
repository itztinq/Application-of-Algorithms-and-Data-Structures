import java.util.*;
import java.util.Objects;

class MapEntry<K extends Comparable<K>, E> {
    // Each MapEntry object is a pair consisting of a key (a Comparable object)
    // and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }
}

class CBHT<K extends Comparable<K>, E> {

    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    public SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is equal to targetKey.
        // Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(targetKey)) return currNode;
            else currNode = currNode.succ;
        }
        return null;
    }

    public void insert(K key, E val) {
        // Insert the entry <key, val> into this CBHT.
        // If entry with same key exists, overwrite it.
        MapEntry<K, E> newEntry = new MapEntry<>(key, val);
        int b = hash(key);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                // Make newEntry replace the existing entry ...
                currNode.element = newEntry;
                return;
            } else currNode = currNode.succ;
        }
        // Insert newEntry at the front of the SLL in bucket b ...
        buckets[b] = new SLLNode<>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        SLLNode<MapEntry<K, E>> predNode = null, currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                if (predNode == null) buckets[b] = currNode.succ;
                else predNode.succ = currNode.succ;
                return;
            } else {
                predNode = currNode;
                currNode = currNode.succ;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            SLLNode<MapEntry<K, E>> curr = buckets[i];
            while (curr != null) {
                temp += curr.element.toString() + " ";
                curr = curr.succ;
            }
            temp += "\n";
        }
        return temp;
    }
}

class Person implements Comparable<Person> {
    // поставете ги потребните полиња овде
    String name;
    int age;

    // имплементирајте соодветен конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        // имплементирајте го toString методот според барањето во текстот
        return "<" + name + ", " + age + ">";
    }

    // имплементирајте ги следните два методи за да работи табелата правилно
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return name.charAt(0) * age;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

class Project {
    int time;
    int rate;

    public Project(int time, int rate) {
        this.time = time;
        this.rate = rate;
    }

    int totalSalary() {
        return time * rate;
    }

    @Override
    public String toString() {
        return "<" + time + ", " + rate + ">";
    }
}

public class Hash_1 {
    public static void main(String[] args) {
        // Креирајте ја табелата според барањата
        CBHT<Person, Project> table = new CBHT<Person, Project>(10);

        // Прочитајте ги податоците од влезот и пополнете ја табелата
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            int time = sc.nextInt();
            int rate = sc.nextInt();

            Person person = new Person(name, age);
            Project newProject = new Project(time, rate);

            SLLNode<MapEntry<Person, Project>> curr = table.search(person);
            if(curr == null) table.insert(person, newProject);
            else {
                Project project = curr.element.value;
                if(project.totalSalary() >= newProject.totalSalary()) {
                    table.insert(person, project);
                } else table.insert(person, newProject);
            }
        }

        // отпечатете ја вашата табела
        System.out.println(table);
    }
}