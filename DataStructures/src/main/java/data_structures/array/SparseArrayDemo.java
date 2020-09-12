package data_structures.array;


public class SparseArrayDemo {
    public static void main(String[] args) {
        SparseArray sa = new SparseArray();
        // 创建数组并打印
        int[][] originArray = sa.initArry();
        sa.printArray(originArray);
        // 转化为稀疏数组并打印稀疏数组
        int[][] sparseArray = sa.convertToSparseArray(originArray);
        sa.printArray(sparseArray);
        // 转化回原始数组并打印
        int[][] originArray2 = sa.convertToOriginArray(sparseArray);
        sa.printArray(originArray2);
    }
}


/**
 * 稀疏数组：节省空间的存储数据较少的二维数组
 * 所包含的成员函数（功能）：
 *  初始化二维数组
 *  将二维数组转化为稀疏数组
 *  将稀疏数组转化为二维数组
 *  打印函数
 */
class SparseArray{
    /**
     * 初始化一个原始数组
     * @return
     */
    public int[][] initArry(){
        int[][] originArry = new int[10][10];
        originArry[1][2] = 7;
        originArry[2][3] = 4;
        originArry[3][4] = 8;
        return originArry;
    }


    /**
     * 将二维数组转化为稀疏数组
     * @param array 要转化的原始二维数组
     * @return sparseArry 转化后的稀疏数组
     */
    public int[][] convertToSparseArray(int[][] array){
        // 统计原始数组的行列以及非零数
        int sum = 0;
        int row = 0;
        int column = 0;
        for (row = 0; row < array.length; row++) {
            for (column = 0; column < array[row].length; column++) {
                if (array[row][column] != 0)
                        sum++;
            }
        }
        // 初始化稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = row;
        sparseArray[0][1] = column;
        sparseArray[0][2] = sum;
        // 再次遍历原始数组，将非零元素存入
        int count = 0;
        for (row = 0; row < array.length; row++) {
            for (column = 0; column < array[row].length; column++) {
                if (array[row][column] != 0){
                    count++;
                    sparseArray[count][0] = row;
                    sparseArray[count][1] = column;
                    sparseArray[count][2] = array[row][column];
                }
            }
        }
        return  sparseArray;
    }


    /**
     * 将稀疏数组转化为二维数组
     * @param array 稀疏数组
     * @return originArray 转化后的原本数组
     */
    public int[][] convertToOriginArray(int[][] array){
        int[][] originArray= new int[ array[0][0] ][ array[0][1] ];
        for (int i = 1; i < array.length; i++) {
            originArray[ array[i][0] ][ array[i][1] ] = array[i][2];
        }
        return originArray;
    }


    /**
     * 打印数组
     */
    public void printArray(int[][] array){
        System.out.println("=========开始打印=========");
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++)
                System.out.printf("%d\t",array[i][j]);
            System.out.println();
        }
        System.out.println("=========打印完成=========\n");
    }
}
