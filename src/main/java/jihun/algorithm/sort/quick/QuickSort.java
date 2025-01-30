package jihun.algorithm.sort.quick;

/**
 * 퀵 정렬
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
 * [ 구현 ]
 * 1. 피벗을 하나 선택한다.
 * 2. 피벗을 기준으로 양쪽에서 피벗보다 큰 값, 혹은 작은 값을 찾는다.
 * 	왼쪽에서부터는 피벗보다 큰 값을 찾고, 오른쪽에서부터는 피벗보다 작은 값을 찾는다.
 * 3. 양 방향에서 찾은 두 원소를 교환한다.
 * 4. 왼쪽에서 탐색하는 위치와 오른쪽에서 탐색하는 위치가 엇갈리지 않을 때 까지 2번으로 돌아가 위 과정을 반복한다.
 * 5. 엇갈린 기점을 기준으로 두 개의 부분리스트로 나누어 1번으로 돌아가
 * 	해당 부분리스트의 길이가 1이 아닐 때 까지 1번 과정을 반복한다. (Divide : 분할)
 * 6. 인접한 부분리스트끼리 합친다. (Conqure : 정복)
 */
public class QuickSort {

	/**
	 * 싱글 피벗 정렬 (왼쪽 피벗 방식)
	 * @param a		정렬할 배열
	 * @param lo	현재 부분배열의 왼쪽
	 * @param hi	현재 부분배열의 오른쪽
	 */
	private static void singlePivotSort(int[] a, int lo, int hi) {

		/*
		 *  lo가 hi보다 크거나 같다면 정렬 할 원소가
		 *  1개 이하이므로 정렬하지 않고 return한다.
		 */
		if(lo >= hi) return;

		int pivotIdx = partition(a, lo, hi);

		singlePivotSort(a, lo, pivotIdx - 1);	// 피벗을 기준으로 좌측 분할
		singlePivotSort(a, pivotIdx + 1, hi);	// 피벗을 기준으로 우측 분할
	}

	/**
	 * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
	 *
	 * @param a		정렬 할 배열
	 * @param left	현재 배열의 가장 왼쪽 부분
	 * @param right	현재 배열의 가장 오른쪽 부분
	 * @return		최종적으로 위치한 피벗의 위치(lo)를 반환
	 */
	private static int partition(int[] a, int left, int right) {

		int lo = left;
		int hi = right;
		int pivotVal = a[left];		// 부분리스트의 왼쪽 요소를 피벗으로 설정

		// lo가 hi보다 작을 때 까지만 반복한다.
		while(lo < hi) {

			/*
			 * hi가 lo보다 크면서, hi의 요소가 pivot보다 작거나 같은 원소를
			 * 찾을 떄 까지 hi를 감소시킨다.
			 */
			while(lo < hi && a[hi] > pivotVal) {
				hi--;
			}

			/*
			 * hi가 lo보다 크면서, lo의 요소가 pivot보다 큰 원소를
			 * 찾을 떄 까지 lo를 증가시킨다.
			 */
			while(lo < hi && a[lo] <= pivotVal) {
				lo++;
			}

			// 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
			swap(a, lo, hi);
		}

		/*
		마지막으로 맨 처음 pivot으로 설정했던 위치(a[left])의 원소와
		lo가 가리키는 원소를 바꾼다.
		 */
		swap(a, left, lo);

		// 두 요소가 교환되었다면 피벗이었던 요소는 lo에 위치하므로 lo를 반환한다.
		return lo;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = {5, 3, 8, 9, 2, 4};

		System.out.print(" 정렬 전 original 배열 : ");
		for(int val : a) {
			System.out.print(val + " ");
		}

		singlePivotSort(a, 0, a.length - 1);

		System.out.print("\n 정렬 후 배열 : ");
		for(int val : a) {
			System.out.print(val + " ");
		}
	}
}
