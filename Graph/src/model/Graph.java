package model;

import java.util.LinkedList;

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

    public Graph(In in) {

    }

    public int V() {
        return V;
    }

    public int E() {
        for ()
    }

    public void addEdge(int v, int w) {
        adjLists[v].add(w);
        adjLists[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adjLists[v];
    }

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
