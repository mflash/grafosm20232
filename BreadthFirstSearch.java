import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BreadthFirstSearch {
    private Set<String> marked;
    private Map<String, String> edgeTo;
    private Map<String, Integer> distTo;
    private String s;

    public BreadthFirstSearch(Graph g, String s) {
        this.s = s;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        bfs(g, s);
    }

    private void bfs(Graph g, String v) {
        List<String> fila = new LinkedList<>();
        fila.add(v);
        marked.add(v);
        distTo.put(v, 0);
        while (!fila.isEmpty()) {
            v = fila.remove(0);
            // System.out.println("estou em " + v);
            int dist = distTo.get(v);
            for (String w : g.getAdj(v)) {
                // Se w não foi visitado...
                if (!marked.contains(w)) {
                    marked.add(w);
                    // Armazena de onde estamos vindo
                    edgeTo.put(w, v);
                    distTo.put(w, dist + 1);
                    fila.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(String v) {
        return marked.contains(v);
    }

    public Iterable<String> pathTo(String v) {
        List<String> path = new LinkedList<>();
        while (!v.equals(s)) {
            path.add(0, v);
            v = edgeTo.get(v);
        }
        path.add(0, s);
        return path;
    }
}
