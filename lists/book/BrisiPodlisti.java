package book;
import java.util.*;

/* Дадени се две двоjно поврзани листи чии што jазли содржат по една природен
броj. Од првата листа треба да се избришат сите поjавувања на втората листа
(поjавување на една листа во друга значи првата листа да е подлиста на втората).
Jазлите што ´ке останат во првата листа треба да се прикажат на излез. Ако не
остане ниту еден jазел се печати Prazna lista.
Пример.
Влез:
22
1 2 3 4 5 6 1 2 3 4 5 6 1 2 6 5 1 3 4 1 5 2
3
4 5 6
Излез:
1 2 3 1 2 3 1 2 6 5 1 3 4 1 5 2
*/

public class BrisiPodlisti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list1 = new DLL<>();
        for(int i = 0; i < n; i++) {
            list1.insertLast(sc.nextInt());
        }

        int m = sc.nextInt();
        DLL<Integer> list2 = new DLL<>();
        for(int i = 0; i < m; i++) {
            list2.insertLast(sc.nextInt());
        }

        DLLNode<Integer> curr = list1.getFirst();
        while(curr != null) {
            DLLNode<Integer> tmp1 = curr;
            DLLNode<Integer> tmp2 = list2.getFirst();
            while(tmp1 != null &&  tmp2 != null && tmp1.element.equals(tmp2.element)) {
                tmp1 = tmp1.succ;
                tmp2 = tmp2.succ;
            }
            if(tmp2 == null) {
                for(int i = 0; i < m; i++) {
                    DLLNode<Integer> next = curr.succ;
                    list1.delete(curr);
                    curr = next;
                }
            } else curr = curr.succ;
        }

        if(list1.getFirst() == null) System.out.println("Prazna lista");
        else System.out.println(list1);
    }
}
