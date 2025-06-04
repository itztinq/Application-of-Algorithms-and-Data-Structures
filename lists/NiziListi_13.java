import java.util.Scanner;

public class NiziListi_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> dll = new DLL<>();
        for(int i = 0; i < n; i++) {
            dll.insertLast(sc.nextInt());
        }
        int res = 0;
        DLLNode<Integer> curr = dll.getFirst();
        while(curr != null) {
            int sumBefore = 0, numsBefore = 0;
            DLLNode<Integer> before = curr.pred;
            while(before != null) {
                sumBefore += before.element;
                numsBefore++;
                before = before.pred;
            }
            int sumAfter = 0, numsAfter = 0;
            DLLNode<Integer> after = curr.succ;
            while(after != null) {
                sumAfter += after.element;
                numsAfter++;
                after = after.succ;
            }
            if(numsBefore > 0 && numsAfter > 0) {
                double avgB = (double) sumBefore / numsBefore;
                double avgA = (double) sumAfter / numsAfter;
                if(avgB > avgA) res++;
            }
            curr = curr.succ;
        }
        System.out.println(res);
    }
}
