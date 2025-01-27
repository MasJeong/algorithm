package jihun.algorithm.sort.selection;

import java.util.Scanner;

/**
 * 선택 정렬
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
public class SelectionSort {

	private static final int MAX_LENGTH = 7;
	
	/**
	 * 선택정렬 (오름차순)
	 * 배열에서 가장 작은 수를 찾아 맨 앞과 교환한다.
	 * 첫 번째 인자를 가장 작은 값으로 생각한다.
	 * @param a 
	 * @param size
	 */
	private static void selection(int[] a, int size) {
		for(int i = 0; i < size - 1; i++) {
			int minIdx = i;
			
			for(int j = i + 1; j < size; j++) {
				if(a[minIdx] > a[j]) minIdx = j;
			}
			
			swap(a, minIdx, i);
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[MAX_LENGTH];
		
		System.out.println("수 입력: ");
		int size = a.length;
		
		// 입력
		for(int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		
		selection(a, size);
		
		// 출력
		for(int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
