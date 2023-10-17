import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepthFirstSearch {
    private Set<String> marked;
    private Map<String, String> edgeTo;
    private String s;

    public DepthFirstSearch(Graph g, String s) {
        this.s = s;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        dfs(g, s);
    }

    private void dfs(Graph g, String v) {
        System.out.println("Estou em " + v);
        marked.add(v); // marca v como visitado
        for (String w : g.getAdj(v)) {
            // Se w não foi visitado...
            if (!marked.contains(w)) {
                // Armazena de onde estamos vindo
                edgeTo.put(w, v);
                // Recursivamente visita w
                dfs(g, w);
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
