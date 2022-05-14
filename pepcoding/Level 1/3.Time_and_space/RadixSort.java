public class RadixSort {
    public static void radixSort(int[] arr) {
        // write code here
        int max = Integer.MIN_VALUE;
        for (int val : arr)
            if (val > max)
                max = val;

        int exp = 1;
        while (exp <= max) {
            countSort(arr, exp);
            exp *= 10;
        }
    }

    public static void countSort(int[] arr, int exp) {
        // write code here
        // creating frequency array
        int[] farr = new int[10];

        // filling freqncy array
        for (int idx = 0; idx < arr.length; idx++) {
            int val = arr[idx] / exp % 10;
            farr[val]++;
        }

        // making it presum array
        for (int idx = 1; idx < farr.length; idx++)
            farr[idx] += farr[idx - 1];

        // generating our answer
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i] / exp % 10;
            int pos = farr[val];
            int idx = pos - 1;

            ans[idx] = arr[i];
            farr[val]--;
        }

        for (int idx = 0; idx < ans.length; idx++)
            arr[idx] = ans[idx];

        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }
}
