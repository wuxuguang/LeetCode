package com.wxg.mysolution.algorithms.unionfind;

public class UnionFindTest {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
        unionFind.union(0, 2);
        unionFind.union(3, 4);
        unionFind.union(5, 8);
        unionFind.union(2, 9);
        unionFind.union(1, 4);
        unionFind.union(6, 7);
        unionFind.union(0, 3);

        System.out.println("Test End");
    }
}
