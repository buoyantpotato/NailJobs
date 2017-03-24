
public class P074_Search2DMaxtrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || matrix[row - 1][col - 1] < target) {
            return false;
        }

        int start = 0;
        int end = row - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int targetRow = matrix[end][0] <= target ? end : start;

        start = 0;
        end = col - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return matrix[targetRow][start] == target || matrix[targetRow][end] == target;
    }
}
