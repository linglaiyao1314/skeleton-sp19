public class UnionFind {
    private int[] parents;
    private int[] childs;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parents = new int[n];
        childs = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = -1;
            childs[i] = 0;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if(vertex >= childs.length){
            throw new ArrayIndexOutOfBoundsException(vertex + "is not a valid index");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        return childs[v1];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        return parents[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);
        int v1root = find(v1);
        int v2root = find(v2);
        if(v1root == v2root){
            return;
        }
        int v1Size = sizeOf(v1root);
        int v2Size = sizeOf(v2root);
        if(v1Size <= v2Size){
            parents[v2root] = v1root;
            childs[v1root] += childs[v2root] + 1;
        }else{
            parents[v1root] = v2root;
            childs[v2root] += childs[v1root] + 1;
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        while (parent(vertex) != -1){
            vertex = parent(vertex);
        }
        return vertex;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(15);
        uf.union(1, 2);
        boolean a = uf.connected(1, 2);
        uf.union(6, 7);
        uf.union(1, 6);

    }
}
