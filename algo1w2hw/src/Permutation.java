import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.valueOf(args[0]);
        RandomizedQueue<String> testing = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            testing.enqueue(item);
        }

        while (k > 0) {
            StdOut.println(testing.dequeue());
            k--;
        }
    }
}
