public class MaxOfAnArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int idx = 0; idx < arr.length; idx++)
            arr[idx] = scn.nextInt();

        System.out.println(maxOfArray(arr, 0));
    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length)
            return -1;

        int val = maxOfArray(arr, idx + 1);
        return val > arr[idx] ? val : arr[idx];
    }
}