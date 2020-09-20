package leetcode.editor.cn;

//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 368 👎 0


/**
 * 思路：
 * 首先，遍历矩阵的最外圈，将最外圈上的'O'以及其上下左右相邻的'O'填充成'#'，区别于'X'
 * 这样，就能将矩阵内部被围住的'O'单独显示出来
 * 然后，将剩余的，也就是被围住的'O'全部换成X
 * 最后，将第一步独立区分的边界'#'变回成'O'即可
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        // 首先取得矩阵的行m和列n
        int n = board.length;// 行
        if(n<1)
            return;
        int m = board[0].length;// 列
        // 开始对上下边的'O'转换成'#'
        for (int i = 0; i < m; i++) {
            fill(0,i,board,n,m);
            fill(n-1,i,board,n,m);
        }
        // 对左右两列的边界'O'及其相邻转换填充
        for (int i = 1; i < n; i++) {
            fill(i,0,board,n,m);
            fill(i,m-1,board,n,m);
        }
        //最终遍历一遍矩阵，将孤立的'O'换成'X'，将'#'变回'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    /*
        自定义填充方法，使用循环对其上下左右依次填充，直到没有O。
        注意：不需要写出当前位置为'#'的情况，因为这表明仍需继续递归遍历周围的位置
     */
    public void fill(int x, int y, char[][] ch, int n ,int m){
        // 越界情况
        if(x<0 || x>=n || y<0 || y>=m)
            return;
        // 不需要继续的情况
        if(ch[x][y]=='#' || ch[x][y]=='X')
            return;
        if(ch[x][y]=='O')
            ch[x][y] = '#';
        // 递归判断相邻位
        fill(x-1,y,ch,n,m);
        fill(x,y-1,ch,n,m);
        fill(x+1,y,ch,n,m);
        fill(x,y+1,ch,n,m);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
