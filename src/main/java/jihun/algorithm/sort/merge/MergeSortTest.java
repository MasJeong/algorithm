package jihun.algorithm.sort.merge;

/**
 * 병합 정렬
 * 1. 계수 정렬 (Counting Sort)
 * 2. 선택 정렬 (Selection Sort)
 * 3. 삽입 정렬 (Insertion Sort)
 * 4. 거품 정렬 (Bubble Sort)
 * 5. 셸 정렬 (Shell Sort)
 * 6. 힙 정렬 (Heap Sort)
 * 7. 합병(병합) 정렬 (Merge Sort)
 * 8. 퀵 정렬 (Quick Sort)
 * 9. 이진 삽입 정렬 (Binary Insertion Sort)
 * 10. 팀 정렬 (Tim Sort)
 *
 */
public class MergeSortTest {

	/** 합치는 과정에서 정렬하여 원소를 담을 임시 배열 */
	private static int[] sorted;

	/**
     * 병합정렬 시작 메서드
	 *
	 * @param a 배열
	 */
	public static void mergeSort(int[] a) {
		sorted = new int[a.length];
		mergeSort(a, 0, a.length - 1);
		sorted = null;
	}

	/**
	 * 배열 분할 후 작은 부분리스트들을 병합한다.
	 *
	 * @param a 배열
	 * @param left 왼쪽 인덱스
	 * @param right 오른쪽 인덱스
	 */
	private static void mergeSort(int[] a, int left, int right) {

		// 사이즈가 1인 것은 더이상 분할 할 수 없다.
		if (left == right) return;

		int mid = (left + right) / 2;

		mergeSort(a, left, mid);			// 좌측 부분리스트를 분할한다.
		mergeSort(a, mid + 1, right);	// 우측 부분리스트를 분할한다.

		merge(a, left, mid, right);
	}

	/**
	 * 작은 부분리스트들을 병합한다.
	 *
	 * @param a		정렬할 배열
	 * @param left	배열의 시작점
	 * @param mid	배열의 중간점
	 * @param right	배열의 끝 점
	 */
	private static void merge(int[] a, int left, int mid, int right) {
        int l = left;		// 왼쪽 블록 시작 인덱스
		int r = mid + 1;	// 오른쪽 블록 시작 인덱스
		int idx = left;		// sorted 배열의 삽입할 인덱스

		while (l <= mid && r <= right) {
			/*
			1. l = 0, r = 1, right = 1인 경우 |3| |7|
			2. l = 0, r = 1, right = 2인 경우 |3,7| |5|
			 */
			if (a[l] <= a[r]) {
				sorted[idx++] = a[l++];
			} else {
				sorted[idx++] = a[r++];
			}
		}

		// 왼쪽의 값을 다 넣어 오른쪽에 값이 남은 경우 오른쪽 값을 모두 추가
		if (l > mid) {
			while (r <= right) {
				sorted[idx++] = a[r++];
			}
		} else {
			while (l < r) {
				sorted[idx++] = a[l++];
			}
		}

		for (int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	}

	public static void main(String[] args) {
		int[] a = {3, 7, 5, 4, 2, 8};

		System.out.print(" 정렬 전 original 배열 : ");
		for(int val : a) {
			System.out.print(val + " ");
		}

		mergeSort(a);

		System.out.print("\n 정렬 후 배열 : ");
		for(int val : a) {
			System.out.print(val + " ");
		}
	}
}
