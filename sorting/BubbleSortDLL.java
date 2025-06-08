import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSortDLL {
    public static void bubbleSort(DLL<Integer> dll) {
        if(dll.getFirst() == null || dll.getFirst() == dll.getLast()) return;
        boolean flag = true;

        while(flag) {
            flag = false;
            DLLNode<Integer> curr = dll.getFirst();
            while(curr != null && curr.succ != null) {
                if(curr.element > curr.succ.element) {
                    int tmp = curr.element;
                    curr.element = curr.succ.element;
                    curr.succ.element = tmp;
                    flag = true;
                }
                curr = curr.succ;
            }
        }
    }

    public static void printList(DLL<Integer> dll) {
        DLLNode<Integer> curr = dll.getFirst();
        while(curr != null) {
            System.out.print(curr.element + " ");
            curr = curr.succ;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] values = br.readLine().split(" ");

        DLL<Integer> dll = new DLL<>();
        for(String value : values) {
            dll.insertLast(Integer.parseInt(value));
        }

        bubbleSort(dll);
        printList(dll);
    }
}
