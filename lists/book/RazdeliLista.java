package book;
import java.util.*;

/* Дадена е еднострано поврзана листа со природни броеви. Да се креираат две
резултантни еднострано поврзани листи т.ш. во првата листа ´ке се земаат само
jазлите што содржат парни броj, при што доколку во првичната листа има пове´ке
соседни jазли со парни броеви се зема само последниот jазел. Слична процедура
се применува и за втората резултантна листа, при што овде се земаат само jазлите
што содржат непарни броеви, при што ако има пове´ке соседни jазли со непарни
броеви се зема само последниот jазел.
Влез: Во првата линиjа е даден броjот на елементи n. Во втората линиjа се
даваат броевите во листата одделени со празно место.
Излез: Прво се печати резултантната листа со прости броеви, а потоа во нов
ред таа со непрости. Доколку некоjа од листите е празна се печати: Prazna lista.
Пример.
Влез:
8
1 3 2 4 5 7 6 8
Излез:
4->8
3->7 */

public class RazdeliLista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        SLL<Integer> parni = new SLL<>();
        SLL<Integer> neparni = new SLL<>();
        for(int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }
        SLLNode<Integer> curr = lista.getFirst();
        while(curr != null) {
            while(curr.succ != null && curr.element%2==0 && curr.succ.element%2==0) {
                curr = curr.succ;
            }
            while(curr.succ != null && !(curr.element%2==0) && !(curr.succ.element%2==0)) {
                curr = curr.succ;
            }
            if(curr.element%2==0) parni.insertLast(curr.element);
            else neparni.insertLast(curr.element);
            curr = curr.succ;
        }

        System.out.println(parni);
        System.out.println(neparni);
    }
}
