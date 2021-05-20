package Algorithm.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author ：hcy
 * @date ：Created in 2021/5/19
 * @description ：
 * @version: 1.0
 */
public class HorseChessboard {

    private static int X;
    private static int Y;
    private static boolean visited[];
    private static boolean finished;

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];
        long start = System.currentTimeMillis();
        traversalChessborad(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时" + (end - start) + "毫秒");
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    public static void traversalChessborad(int[][] chessboard, int row, int colum, int step) {
        chessboard[row][colum] = step;
        visited[row * X + colum] = true;
        ArrayList<Point> ps = next(new Point(colum, row));
        sort(ps);
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if (!visited[p.y * X + p.x]) {
                traversalChessborad(chessboard, p.y, p.x, step + 1);
            }
        }
        if (step < X * Y && !finished) {
            chessboard[row][colum] = 0;
            visited[row * X + colum] = false;
        } else {
            finished = true;
        }
    }

    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if (count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }

            }
        });
    }

    public static ArrayList<Point> next(Point curPoint) {

        ArrayList<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }


}
