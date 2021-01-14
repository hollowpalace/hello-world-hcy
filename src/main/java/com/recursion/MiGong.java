package com.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hcy
 * @date ：Created in 2020/8/4
 * @description ：
 * @version: 1.0
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        System.out.println("地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        ArrayList<Object> list = new ArrayList<>();
        System.out.println(list.size());
        setWay(map,1,1,list);
        System.out.println("最短路径"+list.size());
        System.out.println("迷宫----");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] map, int i, int j, List list) {
        if (map[6][5] == 2) {

            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;

                if (setWay(map, i + 1, j,list)) {
                    list.add(map[i][j]);
                    return true;
                } else if (setWay(map, i, j + 1,list)) {
                    list.add(map[i][j]);
                    return true;
                } else if (setWay(map, i - 1, j,list)) {
                    list.add(map[i][j]);
                    return true;
                } else if (setWay(map, i, j - 1,list)) {
                    list.add(map[i][j]);
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }

    }
}
