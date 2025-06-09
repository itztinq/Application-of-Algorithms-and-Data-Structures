import java.util.*;

public class Library1 {
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
            Student s = new Student(name, science, fiction, history);
            if(s.science == 1) scienceQ.enqueue(s);
            else if(s.fiction == 1) fictionQ.enqueue(s);
            else if(s.history == 1) historyQ.enqueue(s);
        }

        while(!scienceQ.isEmpty() || !fictionQ.isEmpty() || !historyQ.isEmpty()) {
            for(int i = 0; i < 2 && !scienceQ.isEmpty(); i++) {
                Student s = scienceQ.dequeue();
                s.science = 0;
                if(s.fiction == 1) fictionQ.enqueue(s);
                else if(s.history == 1) historyQ.enqueue(s);
                else System.out.println(s.name);
            }
            if(!fictionQ.isEmpty()) {
                Student s = fictionQ.dequeue();
                s.fiction = 0;
                if(s.science == 1) scienceQ.enqueue(s);
                else if(s.history == 1) historyQ.enqueue(s);
                else System.out.println(s.name);
            }
            for(int i = 0; i < 2 && !historyQ.isEmpty(); i++) {
                Student s = historyQ.dequeue();
                s.history = 0;
                if(s.science == 1) scienceQ.enqueue(s);
                else if(s.fiction == 1) fictionQ.enqueue(s);
                else System.out.println(s.name);
            }
        }
    }
}
