import java.util.ArrayList;
import java.util.HashSet;

public class AppMSTMapa {

    public static void main(String[] args) {
        In arq = new In("dados.csv");
        ArrayList<Ponto> pontos = new ArrayList<>();
        while (arq.hasNextLine()) {
            String line = arq.readLine();
            String[] dados = line.split(";");
            double y = Double.parseDouble(dados[0]);
            double x = Double.parseDouble(dados[1]);
            pontos.add(new Ponto(x, y));
        }

        EdgeWeightedGraph g = new EdgeWeightedGraph();
        for (int pos = 0; pos < pontos.size(); pos++) {
            Ponto p = pontos.get(pos);
            double minDist = Double.POSITIVE_INFINITY;
            int minPos = 0;
            for (int pos2 = pos; pos2 < pontos.size(); pos2++) {
                if (pos == pos2)
                    continue;
                Ponto p2 = pontos.get(pos2);
                double dist = Math.sqrt(Math.pow(p.getX() - p2.getX(), 2) +
                        Math.pow(p.getY() - p2.getY(), 2));
                p2.setDist(dist);
                if (dist < minDist) {
                    minDist = dist;
                    minPos = pos2;
                }
            }
            g.addEdge(pos + "", minPos + "", minDist);
        }
        System.out.println(g.toDot());

        Kruskal k = new Kruskal(g);
        HashSet<Edge> conj = new HashSet<>(k.getEdges());
        for (Edge e : g.getEdges()) {
            int mst = 0;
            // Atualmente sempre vai ser true,
            // pois TODAS as arestas fazem
            // parte da MST
            if (conj.contains(e)) {
                mst = 1;
            }
            System.out.println(e.getV() + " " + e.getW() + " " + mst);
        }
    }

}
