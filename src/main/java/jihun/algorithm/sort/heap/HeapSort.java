package jihun.algorithm.sort.heap;

/**
 * 힙 정렬 (오름차순)
 * 1. 계수 정렬 (Counting Sort)
 * 2. 선택 정렬 (Selection Sort)
 * 3. 삽입 정렬 (Insertion Sort)
 * 4. 거품 정렬 (Bubble Sort)
 * 5. 셸 정렬 (Shell Sort)
 * 6. 힙 정렬 (Heap Sort) - 최소힙 구현
 * 7. 합병(병합) 정렬 (Merge Sort)
 * 8. 퀵 정렬 (Quick Sort)
 * [구현 순서]
 * 1. 최대 힙으로 배열을 생성
 * 2. 루트 노드를 맨 뒤에 노드와 교환
 * 3. 방금 교환한 맨 뒤에 노드를 제외하고 최대 힙으로 다시 세팅
 * 4. 2~3 과정 반복
 *
 */
public class HeapSort {

	/**
	 * 부모 인덱스를 얻는 함수
	 * @param child 자식 노드 인덱스
	 * @return 부모 노드 인덱스
	 */
	private static int getParent(int child) {
		return (child - 1) / 2;
	}

	/**
	 * 두 인덱스의 원소를 교환하는 함수
	 * @param a 배열
	 * @param i 가장 큰 값 인덱스
	 * @param j 부모 인덱스
	 */
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


	/**
	 * 힙 생성
	 * @param a 배열
	 * @param parentIdx 부모 노드 인덱스
	 * @param lastIdx 배열의 마지막 인덱스
	 */
	private static void heapify(int[] a, int parentIdx, int lastIdx) {

		/*
		 * 현재 트리에서 부모 노드의 자식노드 인덱스를 각각 구해준다.
		 * 현재 부모 인덱스를 가장 큰 값을 갖고있다고 가정한다.
		 */
		int leftChildIdx = 2 * parentIdx + 1;
		int rightChildIdx = 2 * parentIdx + 2;
		int largestIdx = parentIdx;

		/*
		 *  left child node와 비교
		 *
		 *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
		 *  현재 가장 큰 인덱스보다 왼쪽 자식노드의 값이 더 클경우
		 *  가장 큰 인덱스를 가리키는 largestIdx를 왼쪽 자식노드인덱스로 바꿔준다.
		 *
		 */
		if(leftChildIdx <= lastIdx && a[largestIdx] < a[leftChildIdx]) {
			largestIdx = leftChildIdx;
		}

		/*
		 *  left right node와 비교
		 *
		 *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
		 *  현재 가장 큰 인덱스보다 오른쪽 자식노드의 값이 더 클경우
		 *  가장 큰 인덱스를 가리키는 largestIdx를 오른쪽 자식노드인덱스로 바꿔준다.
		 *
		 */
		if(rightChildIdx <= lastIdx && a[largestIdx] < a[rightChildIdx]) {
			largestIdx = rightChildIdx;
		}

		/*
		 * largestIdx 와 부모노드가 같지 않다는 것은
		 * 위 자식노드 비교 과정에서 현재 부모노드보다 큰 노드가 존재한다는 뜻이다.
		 * 그럴 경우 해당 자식 노드와 부모노드를 교환해주고,
		 * 교환 된 자식노드를 부모노드로 삼은 서브트리를 검사하도록 재귀 호출 한다.
		 */
		if(parentIdx != largestIdx) {
			swap(a, largestIdx, parentIdx);
			heapify(a, largestIdx, lastIdx);
		}
	}

	/**
	 * 힙 정렬
	 * @param a 입력 배열
	 */
	public static void heapsort(int[] a) {
		int size = a.length;

		/*
		 * 부모노드와 heapify 과정에서 음수가 발생하면 잘못 된 참조가 발생하기 때문에
		 * 원소가 1개이거나 0개일 경우는 정렬 할 필요가 없으므로 바로 함수를 종료한다.
		 */
		if(size < 2) {
			throw new IllegalArgumentException("Heap sort requires at least 2 elements");
		}

		// 가장 마지막 노드의 부모 노드 인덱스
		int parentIdx = getParent(size - 1);

		// max heap 만들기
		for(int i = parentIdx; i >= 0; i--) {
			int lastIdx = size - 1;
			// 부모노드(i값)을 1씩 줄이면서 heap 조건을 만족시키도록 재구성한다.
			heapify(a, i, lastIdx);
		}

		// 정렬 과정
		for(int i = size - 1; i > 0; i--) {

			/*
			 *  root인 0번째 인덱스와 i번째 인덱스의 값을 교환해준 뒤
			 *  0 ~ (i-1) 까지의 부분트리에 대해 max heap을 만족하도록
			 *  재구성한다.
			 */
			swap(a, 0, i);
			heapify(a, 0, i - 1);
		}

	}

	/**
	 * heap: 최솟값 또는 최댓값을 빠르게 찾아내기 위해 완전이진트리 형태로 만들어진 자료구조.
	 * [성질]
	 * 1. 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
	 * 2. 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 2
	 * 3. 부모 노드 인덱스 = (자식 노드 인덱스 - 1) / 2
	 */
	public static void main(String[] args) {
		int[] a = {3, 7, 5, 4, 2, 8};

		System.out.print(" 정렬 전 original 배열 : ");
		for(int val : a) {
			System.out.print(val + " ");
		}

		heapsort(a);

		System.out.print("\n 정렬 후 배열 : ");
		for(int val : a) {
			System.out.print(val + " ");
		}
	}
}
