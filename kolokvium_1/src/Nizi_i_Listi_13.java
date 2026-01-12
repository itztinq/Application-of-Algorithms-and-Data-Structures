import java.util.*;

public class Nizi_i_Listi_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        int count = 0;
        DLLNode<Integer> curr = list.getFirst();
        while(curr != null) {
            int leftSum = 0, rightSum = 0;
            int leftNums = 0, rightNums = 0;

            DLLNode<Integer> before = curr.pred;
            while(before != null) {
                leftSum += before.element;
                leftNums++;
                before = before.pred;
            }

            DLLNode<Integer> after = curr.succ;
            while(after != null) {
                rightSum += after.element;
                rightNums++;
                after = after.succ;
            }

            if(leftNums > 0 && rightNums > 0) {
                double leftAvg = (double) leftSum / leftNums;
                double rightAvg = (double) rightSum / rightNums;
                if(leftAvg > rightAvg) count++;
            }

            curr = curr.succ;
        }
        System.out.println(count);
    }
}
