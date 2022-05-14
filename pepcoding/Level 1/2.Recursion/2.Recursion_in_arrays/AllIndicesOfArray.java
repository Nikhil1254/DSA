public class AllIndicesOfArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if (iarr.length == 0) {
            System.out.println();
            return;
        }

        for (int i = 0; i < iarr.length; i++) {
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int tar, int idx, int freq) {
        if (idx == arr.length)
            return new int[freq];

        int[] res ;
        if (tar == arr[idx]) {
            res = allIndices(arr, tar, idx + 1, freq + 1);
            res[freq] = idx;
        } else {
            res = allIndices(arr, tar, idx + 1, freq);
        }

        return res;
    }
}
