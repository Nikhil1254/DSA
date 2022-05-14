public class PivotInSortedAndRotatedArray {
    // smallest value is the pivot we are assuming
    // and we have to find that
    public static int findPivot(int[] arr) {
        // write your code here
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] > arr[hi]) // if value is droping from mid to high - answer exits in right part i.e. mid+1
                                    // tohi part
                lo = mid + 1;
            else
                hi = mid; // value is increasing from mid to high - answer lies in left part i.e from lo
                          // to mid part

        }

        return arr[lo];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr);
        System.out.println(pivot);
    }
}
