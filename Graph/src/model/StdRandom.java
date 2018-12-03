package model;

import java.util.Random;

public class StdRandom {
    private static Random random;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    private StdRandom(){ }

    // effects: the seed of the generator so that reproducible
    // modifies: the seed of this
    public static void setSeed(long s){
        seed = s;
        random = new Random(seed);
    }

    public static long  getSeed() { return seed; }

    public static double uniform() { return random.nextDouble(); }

    public static int uniform(int n){
        if (n <= 0) throw new IllegalArgumentException("arg must be +ve");
        return random.nextInt(n);
    }

    public static long uniform(long n) {
        if (n < 0L) throw new IllegalArgumentException("argument must be positive");

        long r = random.nextLong();
        long m = n - 1;

        if ((n & m) == 0L) {
            return r & m;
        }
        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L) {
            u = random.nextLong() >>> 1;
        }
        return r;
    }

    public static int uniform(int a, int b){
        if ((b <= a) ||( (long) b - a >= Integer.MAX_VALUE)){
            throw new IllegalArgumentException("invalid range");
        }
        return a + uniform(b-a);
    }

    public static double uniform(double a, double b) {
        if (!(a < b)) {
            throw new IllegalArgumentException("invalid range");
        }
        return a + uniform() * (b - a);
    }

    public static boolean bernoulli (double p) {
        if (!(p >= 0.0 && p <= 1.0)) throw new IllegalArgumentException();
        return uniform() < p;
    }

    public static boolean bernoulli() { return bernoulli(0.5);}

    public static double gaussian() {
        double r, x ,y;
        do {
            x = uniform(-1.0,1.0);
            y = uniform(-1.0,1.0);
            r = x*x + y*y;
        } while (r >= 1 || r == 0);
        return x * Math.sqrt(-2 * Math.log(r) / r);
    }

    public static double gaussian(double mu, double sigma) {
        return mu + sigma * gaussian();
    }

    public static void shuffle(Object[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(double[] a){
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n ; i++){
            int r = i + uniform(n - i );
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(int[] a){
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n ; i++){
            int r = i + uniform(n - i );
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(char[] a){
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n ; i++){
            int r = i + uniform(n - i );
            char temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(Object[] a, int lo, int hi){
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);
        int n = a.length;
        for (int i = lo; i < hi ; i++){
            int r = i + uniform(hi - i );
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(double[] a, int lo, int hi){
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);
        int n = a.length;
        for (int i = lo; i < hi ; i++){
            int r = i + uniform(hi - i );
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(int[] a, int lo, int hi){
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);
        int n = a.length;
        for (int i = lo; i < hi ; i++){
            int r = i + uniform(hi - i );
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static int[] permutation(int n){
        if (n < 0) {
            throw new IllegalArgumentException("invalid n");
        }
        int[] perm = new int[n];
        for (int i = 0; i < n; i++){ perm[i] = i; }
        shuffle(perm);
        return perm;
    }

    private static void validateSubarrayIndices(int lo, int hi, int length) {
    }

    private static void validateNotNull(Object[] a) {
    }


}
