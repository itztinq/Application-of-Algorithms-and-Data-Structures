import java.util.*;

public class ListaOdListi {
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        long res = 1;
        DLLNode<DLL<Integer>> currList = list.getFirst();
        while(currList != null) {
            DLL<Integer> subList = currList.element;
            DLLNode<Integer> currElem = subList.getFirst();
            int sum = 0;
            while(currElem != null) {
                sum += currElem.element;
                currElem = currElem.succ;
            }
            res *= sum;
            currList = currList.succ;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }
}
