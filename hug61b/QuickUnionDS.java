public class QuickUnionDS implements DisjointSets {
    private int[] parent;

    public QuickUnionDS(int num) {
        parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = -1;
        }
    }

    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        if(i < j){
            parent[j] = i;
        }else{
            parent[i] = j;
        }

    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        while (parent[p] >= 0) {
            p = parent[p];
        }
        return p;
    }

    public static void main(String[] args) {
        QuickUnionDS quds = new QuickUnionDS(7);
        quds.connect(0, 1);
        quds.connect(1, 2);
        quds.connect(0, 4);
        quds.connect(3, 5);
        quds.connect(5, 2);
    }
}
