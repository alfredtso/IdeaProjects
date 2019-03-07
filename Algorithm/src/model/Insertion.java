package model;

import java.util.Comparator;

public class Insertion {

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--){
                if (less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void sort(Object[] a, Comparator comparator)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(comparator, a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }

    private static boolean less(Comparator comparator, Object o, Object o1) {
        return comparator.compare(o,o1) < 0;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int min) {
        Object swap = a[i];
        a[i] = a[min];
        a[min] = swap;
    }
}
