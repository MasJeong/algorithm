package jihun.algorithm.sort.insertion;

import java.util.Scanner;

/**
 * 삽입 정렬
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
public class InsertionSortTest {

	private static final int MAX_LENGTH = 7;
	
	/**
	 * 삽입정렬 (오름차순)
	 * 두 번째 원소부터 앞에 있는 원소와 비교하여 작으면 앞에 있는 원소를 뒤로 이동한다.
	 * @param a 배열
	 * @param size 배열 크기
	 */
	private static void insertion(int[] a, int size) {
		for (int i = 1; i < size; i++) {
			int target = a[i];
			int ii = i - 1;

			/*
			3 7 5 4 1 6 2 i = 3, ii = 2
			3 7 5 5 1 6 2 i = 3, ii = 1
			3 7 7 5 1 6 2 i = 3, ii = 1
			3 4 7 5 1 6 2 i = 3, ii = 0
			 */
			while (ii >= 0 && target < a[ii]) {
				a[ii + 1] = a[ii];
				ii--;
			}

			a[ii + 1] = target;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[MAX_LENGTH];
		int size = a.length;
		
		System.out.println("수 입력: ");
		
		// 입력 (3 2 5 4 1 6 7)
		for(int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		
		insertion(a, size);
		
		// 출력
        for (int j : a) {
            System.out.print(j + " ");
        }
	}
}
