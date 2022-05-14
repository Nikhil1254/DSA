public class CountSort {
    public static void countSort(int[] arr, int min, int max) {
        // creating frequency array
        int[] farr = new int[max - min + 1];

        // filling freqncy array
        for (int idx = 0; idx < arr.length; idx++) {
            int val = arr[idx];
            farr[val - min]++;
        }

        // making it presum array
        for (int idx = 1; idx < farr.length; idx++)
            farr[idx] += farr[idx - 1];

        // generating our answer
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = farr[val - min];
            int idx = pos - 1;

            ans[idx] = arr[i];
            farr[val - min]--;
        }

        for (int idx = 0; idx < ans.length; idx++)
            arr[idx] = ans[idx];
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
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }
}
