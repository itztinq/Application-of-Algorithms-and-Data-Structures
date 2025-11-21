import java.io.*;
import java.util.*;


import java.util.NoSuchElementException;

class ArrayQueue<E> {
    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}

public class Printer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayQueue<String> waiting = new ArrayQueue<>(100);
        ArrayQueue<String> printed = new ArrayQueue<>(100);

        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if(parts[0].equals("ADD")) {
                int num = Integer.parseInt(parts[2]);
                for(int j = 0; j < num; j++) {
                    waiting.enqueue(parts[1]);
                }
            }

            else if(parts[0].equals("PRINT")) {
                int num = Integer.parseInt(parts[1]);
                for(int j = 0; j < num; j++) {
                    printed.enqueue(waiting.dequeue());
                }
            }

            else if(parts[0].equals("STATUS")) {
                System.out.println("Current status:");

                ArrayQueue<String> tempP = new ArrayQueue<>(100);
                ArrayQueue<String> tempW = new ArrayQueue<>(100);

                int sizeP = printed.size();
                int sizeW = waiting.size();

                for(int j = 0; j < sizeP; j++) {
                    String doc = printed.dequeue();
                    System.out.println(doc + " printed");
                    tempP.enqueue(doc);
                }
                while(!tempP.isEmpty()) printed.enqueue(tempP.dequeue());

                for(int j = 0; j < sizeW; j++) {
                    String doc = waiting.dequeue();
                    System.out.println(doc + " waiting");
                    tempW.enqueue(doc);
                }
                while(!tempW.isEmpty()) waiting.enqueue(tempW.dequeue());

                System.out.println();
            }
        }
    }
}
