import java.util.Scanner;

public class CeilAndFloor {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++)
            arr[i] = scn.nextInt();

        int tar = scn.nextInt();

        int res[] = ceilAndFloor(arr, tar);
        System.out.println(res[1] + "\n" + res[0]);
    }

    public static int[] ceilAndFloor(int[] arr, int tar) {
        // arr is sorted and idx=0 -> floor and idx=1 -> ceil
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int val = arr[mid];

            if (val == tar) {
                ceil = floor = val;
                break;
            } else if (val > tar) {
                high = mid - 1;
                ceil = val;
            } else {
                low = mid + 1;
                floor = val;
            }
        }

        return new int[] { floor, ceil };
    }
}
