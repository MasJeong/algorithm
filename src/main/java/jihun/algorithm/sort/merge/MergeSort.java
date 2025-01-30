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
public class MergeSort {

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
	 * 배열을 분할하는 메서드
	 *
	 * @param a 배열
	 * @param left 왼쪽 인덱스
	 * @param right 오른쪽 인덱스
	 */
	private static void mergeSort(int[] a, int left, int right) {

		// left==right 즉, 부분리스트가 1개의 원소만 갖고있는경우 더이상 쪼갤 수 없으므로 return
		if(left == right) return;

		int mid = (left + right) / 2;		// 절반 위치

		mergeSort(a, left, mid);			// 절반 중 왼쪽 부분리스트(left ~ mid)
		mergeSort(a, mid + 1, right);	// 절반 중 오른쪽 부분리스트(mid+1 ~ right)

		merge(a, left, mid, right);			// 병합 작업
	}

	/**
	 * 합칠 부분리스트는 a배열의 left ~ right 까지이다.
	 *
	 * @param a		정렬할 배열
	 * @param left	배열의 시작점
	 * @param mid	배열의 중간점
	 * @param right	배열의 끝 점
	 */
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left;		// 왼쪽 부분리스트 시작점
		int r = mid + 1;	// 오른쪽 부분리스트의 시작점
		int idx = left;		// 채워넣을 배열의 인덱스

		while(l <= mid && r <= right) {
			/*
			 *  왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
			 *  왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
			 */
			if(a[l] <= a[r]) {
				sorted[idx++] = a[l++];
			}
			/*
			 *  오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
			 *  오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
			 */
			else {
				sorted[idx++] = a[r++];
			}
		}

		/*
		 * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
		 * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
		 * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
		 */
		if(l > mid) {
			while(r <= right) {
				sorted[idx++] = a[r++];
			}
		}

		/*
		 * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
		 * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
		 * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
		 */
		else {
			while(l <= mid) {
				sorted[idx++] = a[l++];
			}
		}

		// 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
		for(int i = left; i <= right; i++) {
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
