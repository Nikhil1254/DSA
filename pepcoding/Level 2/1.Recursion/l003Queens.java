import java.lang.reflect.Array;
import java.text.Bidi;
import java.util.Arrays;

public class l003Queens {
    public static void main(String[] args) {
        System.out.println(queenProblem(4, 3));
    }

    // ================================================================================
    // tnq : total no of queens
    // tnb : total no of boxes

    public static int queenProblem(int tnb, int tnq) {
        int[] arr = new int[tnb];
        int[][] boxes = new int[4][4];
        for (int[] a : boxes)
            Arrays.fill(a, 1);
        Arrays.fill(arr, 1);
        // return queenCombination_ss(arr, 0, tnq, 0, "");
        // return queenPermutation_ss(arr, 0, tnq, 0, "");
        // return queenCombination(arr, tnq, 0, 0, "");
        // return queenPermutation(arr, tnq, 0, 0, "");
        // return queenCombination_ss_2D(boxes, 0, 4, 0, ""); // 1820 answer
        // return queenPermutation_ss_2D(boxes, 0, 4, 0, ""); // 43680 answers
        // return queenCombination_2D(boxes, 4, 0, 0, "");
        return queenPermutation_2D(boxes, 4, 0, 0, "");
    }

    // for 1D - using subsequence method
    private static int queenCombination_ss(int[] arr, int bIdx, int tar, int qIdx, String ans) {
        if (tar == 0 || bIdx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (tar - arr[bIdx] >= 0)
            count += queenCombination_ss(arr, bIdx + 1, tar - arr[bIdx], qIdx + 1, ans + "b" + bIdx + "q" + qIdx + " ");
        count += queenCombination_ss(arr, bIdx + 1, tar, qIdx, ans);

        return count;
    }

    private static int queenPermutation_ss(int[] arr, int bIdx, int tar, int qIdx, String ans) {
        if (tar == 0 || bIdx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (arr[bIdx] != -1 && tar - arr[bIdx] >= 0) {
            int val = arr[bIdx];
            arr[bIdx] = -1;
            count += queenPermutation_ss(arr, 0, tar - val, qIdx + 1, ans + "b" + bIdx + "q" + qIdx + " ");
            arr[bIdx] = val;
        }
        count += queenPermutation_ss(arr, bIdx + 1, tar, qIdx, ans);

        return count;
    }

    // for 1D - using coin method -
    private static int queenCombination(int[] arr, int tar, int idx, int qIdx, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = idx; i < arr.length; i++)
            count += queenCombination(arr, tar - arr[idx], i + 1, qIdx + 1, ans + "b" + i + "q" + qIdx + " ");

        return count;
    }

    private static int queenPermutation(int[] arr, int tar, int idx, int qIdx, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = idx; i < arr.length; i++) {
            if (arr[i] != -1) {
                int val = arr[i];
                arr[i] = -1;
                count += queenPermutation(arr, tar - val, 0, qIdx + 1, ans + "b" + i + "q" + qIdx + " ");
                arr[i] = 1;
            }
        }

        return count;
    }

    // for 2D array - using subsequnce method
    private static int queenCombination_ss_2D(int[][] arr, int bIdx, int tar, int qIdx, String ans) {
        int n = arr.length, m = arr[0].length;
        if (tar == 0 || bIdx == n * m) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        int r = bIdx / m;
        int c = bIdx % m;
        if (tar - arr[r][c] >= 0) {
            count += queenCombination_ss_2D(arr, bIdx + 1, tar - arr[r][c], qIdx + 1,
                    ans + "(" + r + "," + c + ") ");
        }

        count += queenCombination_ss_2D(arr, bIdx + 1, tar, qIdx, ans);

        return count;
    }

    private static int queenPermutation_ss_2D(int[][] arr, int bIdx, int tar, int qIdx, String ans) {
        int n = arr.length, m = arr[0].length;
        if (tar == 0 || bIdx == n * m) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        int r = bIdx / m;
        int c = bIdx % m;
        if (arr[r][c] != -1 && tar - arr[r][c] >= 0) {
            arr[r][c] = -1;
            count += queenPermutation_ss_2D(arr, 0, tar - 1, qIdx + 1,
                    ans + "(" + r + "," + c + ") ");
            arr[r][c] = 1;
        }

        count += queenPermutation_ss_2D(arr, bIdx + 1, tar, qIdx, ans);

        return count;
    }

    // for 2D array - using oin method
    private static int queenCombination_2D(int[][] arr, int tar, int idx, int qIdx, String ans) {
        int n = arr.length, m = arr[0].length;

        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            count += queenCombination_2D(arr, tar - arr[r][c], i + 1, qIdx + 1, ans + "(" + r + "," + c + ") ");
        }

        return count;
    }

    private static int queenPermutation_2D(int[][] arr, int tar, int idx, int qIdx, String ans) {
        int n = arr.length, m = arr[0].length;

        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = idx; i < n*m; i++) {
            int r = i / m;
            int c = i % m;
            if(arr[r][c]!=-1){
                arr[r][c] = -1;
                count += queenPermutation_2D(arr, tar - 1, 0, qIdx + 1, ans +"("+r+","+c+") ");
                arr[r][c] = 1;
            }
        }

        return count;
    }
}
