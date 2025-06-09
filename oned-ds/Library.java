import java.util.*;
import java.util.NoSuchElementException;

interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}

class LinkedQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue () {
        clear();
    }

    public boolean isEmpty () {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size () {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek () {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear () {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue (E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue () {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null)  rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}

class Student {
    String name;
    int science;
    int fiction;
    int history;
    public Student(String name, int science, int fiction, int history) {
        this.name = name;
        this.science = science;
        this.fiction = fiction;
        this.history = history;
    }
}

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinkedQueue<Student> scienceQ = new LinkedQueue<>();
        LinkedQueue<Student> fictionQ = new LinkedQueue<>();
        LinkedQueue<Student> historyQ = new LinkedQueue<>();

        for(int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int science = Integer.parseInt(sc.nextLine());
            int fiction = Integer.parseInt(sc.nextLine());
            int history = Integer.parseInt(sc.nextLine());
            Student s = new  Student(name, science, fiction, history);
            if(s.science == 1) scienceQ.enqueue(s);
            else if(s.fiction == 1) fictionQ.enqueue(s);
            else if(s.history == 1) historyQ.enqueue(s);
        }

        while(!scienceQ.isEmpty() || !fictionQ.isEmpty() || !historyQ.isEmpty()) {
            while(!scienceQ.isEmpty()) {
                Student s = scienceQ.dequeue();
                if(s.fiction == 1) fictionQ.enqueue(s);
                else if(s.history == 1) historyQ.enqueue(s);
                else System.out.println(s.name);
            }
            while(!fictionQ.isEmpty()) {
                Student s = fictionQ.dequeue();
                if(s.history == 1) historyQ.enqueue(s);
                else System.out.println(s.name);
            }
            if(!historyQ.isEmpty()) {
                Student s = historyQ.dequeue();
                System.out.println(s.name);
            }
        }
    }
}