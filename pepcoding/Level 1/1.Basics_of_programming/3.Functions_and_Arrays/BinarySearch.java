public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };
        int target = 20;

        System.out.println(binarySearch(arr, target));
    }

    public static int binarySearch(int[] arr, int tar) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == tar)
                return mid;
            else if (arr[mid] > tar)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}
