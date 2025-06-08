import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShakerSort {
    static void shakerSort(int arr[], int n) {
        if(n == 1) { print(arr, n); print(arr, n); }
        int l = 0, r = n - 1;
        boolean flag = true;

        while(l < r) {
            flag = false;
            for(int i = r; i > l; i--) {
                if(arr[i] < arr[i - 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    flag = true;
                }
            }
            print(arr, n);
            l++;

            for(int i = l; i < r; i++) {
                if(arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    flag = true;
                }
            }
            print(arr, n);
            r--;

            if(!flag) break;
        }
    }

    static void print(int arr[], int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
        shakerSort(a,n);
    }
}
