package com.wxg.mysolution.algorithms.unionfind;

/**
 * uninon-find problem
 */
public class UnionFind {
    private int[] ids;
    /**
     * sz[i]表示i作为root的树的节点的总数
     */
    private int[] sz;

    /**
     * 联通分量的个数(component size)
     */
    private int cs;

    public UnionFind(int N) {
        cs = N;
        ids = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != ids[i])
            i = ids[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (sz[rootp] > sz[rootq]) {
            sz[rootp] += sz[rootq];
            ids[rootq] = rootp;
        } else {
            sz[rootq] += sz[rootp];
            ids[rootp] = rootq;
        }
    }
}
