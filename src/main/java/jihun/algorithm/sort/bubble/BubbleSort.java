package jihun.algorithm.sort.bubble;

import java.util.Scanner;

/**
 * 버블 정렬
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
public class BubbleSort {

	private static final int MAX_LENGTH = 7;
	
	/**
	 * 버블정렬 (오름차순)
	 * 첫 번째 원소부터 뒤에 원소와 비교하며 위치를 변경한다.
	 * @param a 
	 * @param size
	 */
	private static void bubble(int[] a, int size) {
		// 반복 횟수 n - 1
		for(int i = 1; i < size; i++) {
			boolean bSwap = false;
			for(int j = 0; j < size - i; j++) {
				if(a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					bSwap = true;
				}
			}
			
			if(!bSwap) break;
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
		
		bubble(a, size);
		
		// 출력
		for(int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
