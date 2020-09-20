class Solution {
    public int maximum(int a, int b) {
        int c = a / 2 - b / 2;
        int d = c >> 31;
        return (d + 1) * a - d * b;
    }
}

第一行求差，除以二可以避免超限int，得到正确的差值
直接粗暴右移位，这个差值如果是大于等于0，d=0，否则d=-1。
所以题目就等效成了 如果a > b ; d = 0 ; 返回 a
a < b ; d = -1;返回 b
这样是不是就很像一个X元X次方程组
所以直接推理出答案公式
