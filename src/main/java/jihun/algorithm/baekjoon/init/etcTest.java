package jihun.algorithm.baekjoon.init;

public class etcTest {

    /**
     * 이진 탐색 테스트
     * @param arr 배열
     * @param target 찾고자 하는 숫자
     * @return 찾고자 하는 숫자의 배열 인덱스
     */
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (target == arr[mid]) {
                return mid;
            }

            if (target < arr[mid]) {
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
