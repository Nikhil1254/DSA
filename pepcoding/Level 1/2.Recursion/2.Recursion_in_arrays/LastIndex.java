public class LastIndex {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int idx = 0; idx < arr.length; idx++)
            arr[idx] = scn.nextInt();

        int tar = scn.nextInt();

        System.out.println(lastIndex(arr, 0, tar));
    }

    public static int lastIndex(int[] arr, int idx, int tar) {
        if (idx == arr.length)
            return -1;

        int lastIdx = lastIndex(arr, idx + 1, tar);

        if (lastIdx == -1)
            lastIdx = arr[idx] == tar ? idx : -1;

        return lastIdx;
    }
}
