package fc;

import java.util.ArrayList;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/14 下午3:29
 */
public class Que19 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int startRow = 0;
        int startLine = 0;
        int endLine = matrix[0].length - 1;
        int endRow = matrix.length - 1;

        while (startRow <= endRow && startLine <= endLine) {

            //如果就剩下一行
            if (startRow == endRow) {
                for (int i = startLine; i <= endLine; i++) {
                    res.add(matrix[startRow][i]);
                }
                return res;
            }
            //如果就剩下一列
            if (startLine == endLine) {
                for (int i = startRow; i <= endRow; i++) {
                    res.add(matrix[i][startLine]);
                }
                return res;
            }

            for (int i = startLine; i <= endLine; i++) {
                res.add(matrix[startRow][i]);
            }

            for (int i = startRow + 1; i <= endRow; i++) {
                res.add(matrix[i][endLine]);
            }
            for (int i = endLine - 1; i >= startLine; i--) {
                res.add(matrix[endRow][i]);
            }
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                res.add(matrix[i][startLine]);
            }

            startRow++;
            startLine++;
            endRow--;
            endLine--;
        }


        return res;
    }
}
