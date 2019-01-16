package model;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Graph {
    private final int V;
    private int E;
    private LinkedList<Integer> adjLists[];

    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must >= 0");
        this.E = 0;
        this.V = V;
        this.adjLists = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjLists[i] = new LinkedList<Integer>();
        }
    }

/*    public Graph(In in) {
        try{
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("V must be non-neg");
            adj = (Bag<Integer>) new Bag[V];
            for (int v = 0; v < V; v++){
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("E must be non-neg");
            for (int i = 0; i < E; i++){
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(V);
                validateVertex(E);
                addEdge(v,w);
            }
        }
        catch (NoSuchElementException e){
            throw new IllegalArgumentException("invalid input");
        }
    }

    private void validateVertex(int e) {
        if (e <- 0 || e >= V){
            throw new IllegalArgumentException("invalid vertex");
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adjLists[v].add(w);
        adjLists[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adjLists[v];
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size;
    }*/

//    public static void main(String[] args) {
//
//    }

//    public Graph consGraphfromtxt (String file){
//        Scanner s = null;
//
//        try {
//            s = new Scanner(new FileReader(file));
//            s.useLocale(Locale.US);
//
//            while (s.hasNext()) {
//                s.
//            }
//        }
//    }
}
