package Algorithm.kruskal;

import java.util.Arrays;

/**
 * @author ：hcy
 * @date ：Created in 2021/4/9
 * @description ：
 * @version: 1.0
 */
public class KruskalCase {
    private int edgeNum;
    private char[] vertexs;
    private int[][] matric;
    private static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
//        kruskalCase.print();
//        System.out.println(Arrays.toString(kruskalCase.getEdges()));
//        EData[] edges = kruskalCase.getEdges();
//        kruskalCase.sortEdges(edges);
//        System.out.println(Arrays.toString(edges));
        kruskalCase.kruskal();
    }

    public KruskalCase(char[] vertexs, int[][] matric) {
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        this.matric = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matric[i][j] = matric[i][j];
            }
        }

        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matric[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0;
        int[] ends = new int[edgeNum];
        EData[] rets = new EData[edgeNum];

        EData[] edges = getEdges();
        System.out.println("边集合=" + Arrays.toString(edges) + "边" + edgeNum + "条");
        sortEdges(edges);

        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            if (m != n) {
                ends[m] = n;
                rets[index++] = edges[i];
            }

        }
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
//        System.out.println("最小生成树为=" + Arrays.toString(rets));
    }

    public void print() {
        System.out.println("邻接矩阵为:\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d\t", matric[i][j]);
            }
            System.out.println();
        }
    }

    private void sortEdges(EData[] edges) {
        int max = 0;
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }

    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matric[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matric[i][j]);
                }
            }
        }
        return edges;
    }

    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

class EData {
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "<" + start +
                "," + end +
                ">=" + weight +
                '}';
    }
}
