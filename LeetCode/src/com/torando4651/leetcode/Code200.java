package com.torando4651.leetcode;


/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */

public class Code200 {
    public static void main(String[] args) {
        char[][] test = {
                            {'1', '1', '1', '1', '0'},
                            {'1', '1', '0', '1', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '0', '0', '1'}
                        };
        System.out.println(Solution.numIslands(test));
    }
}

class Solution {
    public static int numIslands(char[][] grid) {
        int num = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    killIslands(grid, row, col);
                    num++;
                }
            }
        }
        return num;
    }

    private static void killIslands(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        } else {
            grid[row][col] = '0';
            killIslands(grid, row + 1, col);
            killIslands(grid, row - 1, col);
            killIslands(grid, row, col + 1);
            killIslands(grid, row, col - 1);
            return;
        }
    }
}
