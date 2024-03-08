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
public class InsertionSort {

	private static final int MAX_LENGTH = 7;
	
	/**
	 * 삽입정렬 (오름차순)
	 * 두 번째 원소부터 앞에 있는 원소와 비교하여 작으면 앞에 있는 원소를 뒤로 이동한다.
	 * @param a 
	 * @param size
	 */
	private static void insertion(int[] a, int size) {
		for(int i = 1; i < size; i++) {
			int target = a[i];
			int j = i - 1;
			
			while(j >= 0 && a[j] > target) {
				a[j + 1] = a[j];
				j--;
			}
			
			a[j + 1] = target;
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int[] a = new int[MAX_LENGTH];
		int size = a.length;
		
		System.out.println("수 입력: ");
		
		// 입력
		for(int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		
		insertion(a, size);
		
		// 출력
		for(int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
