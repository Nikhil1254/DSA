public class Sort012 {
    public static void sort012(int[] arr) {
        // write your code here
        int i = 0, j = 0, k = arr.length - 1;
        // 0 to j-1 is zeros area
        // j to i-1 is ones area
        // i to k unknown
        // k+1 to n-1 two's area

        while (i <= k) {
            if (arr[i] == 1)
                i++;
            else if (arr[i] == 0) {
                swap(arr, i++, j++);
            } else
                swap(arr, i, k--);
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        sort012(arr);
        print(arr);
    }
}
