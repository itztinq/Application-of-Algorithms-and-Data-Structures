import java.util.*;

public class DeleteSLL {
    public static void change(SLL<Integer> list, int br) {
        SLLNode<Integer> curr = list.getFirst();
        int cnt = 0;

        while(curr != null) {
            if(curr.element.equals(br)) {
                cnt++;
            }
            curr = curr.succ;
        }

        if(cnt % 2 != 0) {
            SLLNode<Integer> tmp = list.getFirst();
            while(tmp != null && !tmp.element.equals(br)) {
                tmp = tmp.succ;
            }
            if(tmp != null) {
                list.insertBefore(br, tmp);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n, broj;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list1.insertLast(scan.nextInt());
        }
        int br = scan.nextInt();
        change(list1,br);
        System.out.println(list1);
    }
}
