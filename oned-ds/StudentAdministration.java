import java.util.*;

class Students {
    String name;
    int submitDocs;
    int takeIndex;
    int takeDocs;
    public Students(String name, int submitDocs, int takeIndex, int takeDocs) {
        this.name = name;
        this.submitDocs = submitDocs;
        this.takeIndex = takeIndex;
        this.takeDocs = takeDocs;
    }
}

public class StudentAdministration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinkedQueue<Students> documents = new LinkedQueue<>();
        LinkedQueue<Students> index = new LinkedQueue<>();
        LinkedQueue<Students> highSchoolDocs = new LinkedQueue<>();

        for(int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int submitDocs = Integer.parseInt(sc.nextLine());
            int takeIndex = Integer.parseInt(sc.nextLine());
            int takeDocs = Integer.parseInt(sc.nextLine());
            Students s = new Students(name, submitDocs, takeIndex, takeDocs);
            if(s.submitDocs == 1) documents.enqueue(s);
            else if(s.takeIndex == 1) index.enqueue(s);
            else if(s.takeDocs == 1) highSchoolDocs.enqueue(s);
        }

        while(!documents.isEmpty() || !index.isEmpty() || !highSchoolDocs.isEmpty()) {
            if(!documents.isEmpty()) {
                Students s = documents.dequeue();
                s.submitDocs = 0;
                if(s.takeIndex == 1) index.enqueue(s);
                else if(s.takeDocs == 1) highSchoolDocs.enqueue(s);
                else System.out.println(s.name);
            }
            if(!index.isEmpty()) {
                Students s = index.dequeue();
                s.takeIndex = 0;
                if(s.takeDocs == 1) highSchoolDocs.enqueue(s);
                else System.out.println(s.name);
            }
            if(!highSchoolDocs.isEmpty()) {
                Students s = highSchoolDocs.dequeue();
                s.takeDocs = 0;
                if(s.submitDocs == 0 && s.takeIndex == 0) System.out.println(s.name);
            }
        }
    }
}