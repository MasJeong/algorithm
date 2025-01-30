package jihun.algorithm.baekjoon.init;

public class etcTest {

    private static int binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (num == arr[mid]) {
                return mid;
            }

            if (num < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 7, 8};

        System.out.print("배열 : ");
        for(int val : arr) {
            System.out.print(val + " ");
        }

        int target = binarySearch(arr, 2);

        System.out.println();
        System.out.println("The target index is : " + target);
    }
}
