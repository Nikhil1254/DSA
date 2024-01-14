public class l001_lecture1 {
    public static void main(String[] args) {

    }

    // 1. binary search
    public static int binarySearch(int[] arr,int tar){
        int n = arr.length, si =0 , ei = n-1;

        while(si<=ei){
            int mid = (si+ei)/2;  // si+(ei-si)/2 formula to handle overflow scenarios

            if(tar==arr[mid])
                return mid;
            else if(tar<arr[mid])
                ei = mid-1;
            else
                si = mid+1;
        }

        return -1;
    }

    // 2. first index of element in sorted array
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static int binarySearchFirstIndex(int[] arr, int tar) {
        int n = arr.length, si = 0, ei = n - 1;
        int ans = -1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (tar == arr[mid]) {
                ans = mid;
                ei = mid - 1;
            } else if (tar < arr[mid])
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return ans;
    }

    // 3. last index of element
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static int binarySearchLastIndex(int[] arr, int tar) {
        int n = arr.length, si = 0, ei = n - 1;
        int ans = -1;
        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (tar == arr[mid]) {
                ans = mid;
                si = mid + 1;
            } else if (tar < arr[mid])
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return ans;
    }

    // 4. Search insert position
    // https://leetcode.com/problems/search-insert-position/
    /**
     * 1. writing generic solution if duplicate elements also present
     * 2. In duplicate if data present will return lastIdx, otherwise insert
     * position
     */
    public int searchInsert(int[] nums, int target) {

        int n = nums.length, si = 0, ei = n - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (target >= nums[mid])
                si = mid + 1;
            else
                ei = mid - 1;
        }

        int insertPos = si;
        int lastIdx = si - 1; // for duplicate element scenarios if element present

        return (lastIdx >= 0 && nums[lastIdx] == target ? lastIdx : insertPos);
    }

    // 5. nearest element
    // https://www.geeksforgeeks.org/problems/find-the-closest-number5513/1
    /**
     * 1. if ele present return that only
     * 2. if not present return nearest element to it
     */
    public static int findClosest(int nums[], int n, int target) {
        int si = 0, ei = n - 1;

        if (target <= nums[0] || target >= nums[n - 1])
            return target <= nums[0] ? nums[0] : nums[n - 1];

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (target == nums[mid])
                return nums[mid]; // ele present
            else if (target > nums[mid])
                si = mid + 1;
            else
                ei = mid - 1;
        }

        int insertPos = si;

        return nums[insertPos] - target <= target - nums[insertPos - 1] ? nums[insertPos] : nums[insertPos - 1];
    }

    // 6. ceil and floor => floor <= data < ceil
    // https://www.codingninjas.com/studio/problems/ceiling-in-a-sorted-array_1825401?leftPanelTabValue=PROBLEM
    /*
     * 1. This is generic code which can be applied at multiple situations and it
     * will work if we have duplicate elements then also
     * 2. we just find insert position of element which will be equal to si, and
     * also see corner cases as well
     */
    public static int[] getFloorAndCeil(int[] arr, int data) {

        int si = 0, n = arr.length, ei = n - 1;

        if (data < arr[0] || data >= arr[n - 1])
            return data < arr[0] ? new int[] { -1, arr[0] } : new int[] { arr[n - 1], -1 };

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (data >= arr[mid])
                si = mid + 1;
            else
                ei = mid - 1;
        }

        // si will be the insert position after coming out of loop
        return new int[] { arr[si - 1], arr[si] };
    }

    // 7. quick sort -
    /**
     * 1. average time complexity if we assume array is equally getting divided in 2 parts --> nlogn
     * 2. worst case if array is already sorted ascending or descending --> n^2
     */
    public static void quickSort(int[] arr, int si, int ei){
        if(si<=ei)
            return;

        int pIdx = segregateData(arr, si, ei, ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }

    public static int segregateData(int[] arr, int si, int ei, int pivotIdx) {

        swap(arr, pivotIdx, ei);
        int p = si - 1, itr = si; // 0 to p => less than or equal to pivot , p+1 to itr-1-> greater than pivot,
                                  // itr to n-1 => unknown elements

        while (itr <= ei) {

            if (arr[itr] < arr[ei])
                swap(arr, ++p, itr);
            itr++;
        }

        return p; // correct position of pivot after segregation
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
