public class l002_lecture2 {

    // 1. search in sorted matrix 1
    // https://leetcode.com/problems/search-a-2d-matrix/
    public boolean searchMatrix1(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;
        int si = 0, ei = n * m - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;
            int r = mid / m;
            int c = mid % m;

            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] < target)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return false;
    }

    // 2. search in sorted matrix 2
    // https://leetcode.com/problems/search-a-2d-matrix-ii/
    public boolean searchMatrix2(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;
        int r = 0, c = m - 1;

        while (r < n && c >= 0) {

            if (matrix[r][c] == target)
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }

        return false;
    }
}