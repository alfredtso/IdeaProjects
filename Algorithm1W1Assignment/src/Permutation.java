import edu.princeton.cs.algs4.StdIn;

import java.util.NoSuchElementException;

public class Permutation {
    public static void main(String[] args) {
//        int k = Integer.parseInt(args[2]);
        RandomizedQueue<String> testing = new RandomizedQueue<>();

        String result = StdIn.readString();
        testing.enqueue(result);
        while (result != null) {
            result = StdIn.readString();
            testing.enqueue(result);
        }

        for (String item: testing) {
            System.out.println(testing.dequeue());
        }
    }
}
