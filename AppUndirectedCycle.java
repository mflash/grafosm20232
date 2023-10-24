public class AppUndirectedCycle {

    public static void main(String[] args) {
        Graph g = new Graph("ciclonaodirigido.txt");

        System.out.println(g.toDot());

        UndirectedCycle uc = new UndirectedCycle(g);
        System.out.println(uc.containsCycle());
    }
}
