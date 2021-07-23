package leetcode.mid;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ：hcy
 * @date ：Created in 2021/7/14
 * @description ：[[".",".",".",".","5",".",".","1","."],[".","4",".","3",".",".",".",".","."],[".",".",".",".",".","3",".",".","1"],["8",".",".",".",".",".",".","2","."],[".",".","2",".","7",".",".",".","."],[".","1","5",".",".",".",".",".","."],[".",".",".",".",".","2",".",".","."],[".","2",".","9",".",".",".",".","."],[".",".","4",".",".",".",".",".","."]]
 * @version: 1.0
 */
public class ShuDu {
    public static void main(String[] args) {
        char[][] board ={{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
        HashMap<Integer, Integer> m = new HashMap<>();


    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                char d = board[j][i];
                if (c != '.') {
                    if (set1.contains(c)) {
                        return false;
                    } else {
                        set1.add(c);
                    }
                }

                if (d != '.') {
                    if (set2.contains(d)) {
                        return false;
                    } else {
                        set2.add(d);
                    }
                }
            }
            set1.clear();
            set2.clear();
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {

                for (int m = i; m <i+3 ; m++) {
                    for (int k = j; k < j+3; k++) {
                        char e = board[m][k];
                        if (e!='.'){
                            if (set3.contains(e)){
                                return false;
                            }else {
                                set3.add(e);
                            }
                        }
                    }

                }
                set3.clear();

            }

        }
        return true;


    }
}
