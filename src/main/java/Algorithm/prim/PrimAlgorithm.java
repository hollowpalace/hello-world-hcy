package Algorithm.prim;

import java.util.Arrays;

/**
 * @author ：hcy
 * @date ：Created in 2021/4/6
 * @description ：
 * @version: 1.0
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};
        MGragh mGragh = new MGragh(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGragh, verxs, data, weight);
        minTree.showGraph(mGragh);
        minTree.prim(mGragh,0);
    }
}

class MinTree {
    public void createGraph(MGragh gragh, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            gragh.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                gragh.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGragh gragh) {
        for (int[] link : gragh.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGragh gragh, int v) {
        int visited[] = new int[gragh.verxs];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < gragh.verxs; k++) {
            for (int i = 0; i < gragh.verxs; i++) {
                for (int j = 0; j < gragh.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && gragh.weight[i][j] < minWeight) {
                        minWeight = gragh.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边" + gragh.data[h1] + "," + gragh.data[h2] + ">权值" + minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }
    }
}

class MGragh {
    int verxs;
    char[] data;
    int[][] weight;

    public MGragh(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
