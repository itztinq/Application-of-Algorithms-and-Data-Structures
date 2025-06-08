import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OddEvenSort {
    public static void oddEvenSort(int arr[], int n) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int num : arr) {
            if(num % 2 == 0) even.add(num);
            else odd.add(num);
        }
        Collections.sort(odd);
        even.sort(Collections.reverseOrder());
        int i = 0;
        for(int num : odd) arr[i++] = num;
        for(int num : even) arr[i++] = num;
    }

    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}
