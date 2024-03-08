package jihun.algorithm.sort.shell;

import java.util.Scanner;

/**
 * 셸 정렬 (Shell Sort)
 * 1. 간격(gap)을 설정한다.
 * 2. 각 간격별로 분류 된 서브(부분) 리스트에 대해 삽입정렬을 한다.
 * 3. 각 서브(부분) 리스트의 정렬이 끝나면 간격을 줄인다.
 * 4. 간격이 1이 될 때 까지 2번 과정으로 되돌아가며 반복한다.
 *
 */
public class ShellSort {

	private static final int MAX_LENGTH = 10;
	
	private final static int[] gap =  
			{ 1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937, 	
			8858, 19930, 44842, 100894, 227011, 510774,
			1149241, 2585792, 5818032, 13090572, 29453787, 
			66271020, 149109795, 335497038, 754868335, 1698453753 };	
	
	// 맨 처음 gap을 참조 할 인덱스를 구하는 메소드
	private static int getGap(int[] a, int size) {
		int index = 0;
		
		int len = (int) (size / 2.25);
		
		while(gap[index] < len) {
			index++;
		}
		
		return index;
	}
	
	/**
	 * 셸 정렬 (오름차순)
	 * @param a
	 * @param size
	 */
	private static void shellSort(int[] a, int size) {
		int index = getGap(a, size);
		
		// gap[index] 값부터 gap[0] 까지 반복한다.
		for(int i = index; i >= 0; i--) {
			// 서브리스트들에 대해 삽입정렬 실행
			for(int j = 0; j < gap[i]; j++) {
				insertionSort(a, size, gap[i], j);
			}
		}
	}
	
	/**
	 * 삽입정렬 (오름차순)
	 * 두 번째 원소부터 앞에 있는 원소와 비교하여 작으면 앞에 있는 원소를 뒤로 이동한다.
	 * @param a 
	 * @param size
	 * @param gapVal gap 배열 값
	 * @param start 서브리스트 시작 인덱스
	 */
	private static void insertionSort(int[] a, int size, int gapVal, int start) {
		// 부분 배열의 두 번째 원소부터 size까지 반복한다. (gap 값씩 건너띔) 
		for (int i = start + gapVal; i < size; i += gapVal) {
			int target = a[i];
			int j = i - gapVal;
			
			// 타겟 원소가 이전의 원소보다 작을 때 까지 반복
			while(j >= start && target < a[j]) {
				a[j + gapVal] = a[j];
				j -= gapVal;
			}
			
			a[j + gapVal] = target;
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int[] a = new int[MAX_LENGTH];
		
		System.out.println("수 입력: ");
		int size = a.length;
		
		// 입력
		for(int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		
		// 셸 정렬
		shellSort(a, size);
		
		// 출력
		for(int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
