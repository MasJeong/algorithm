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
public class ShellSortTest {

	private static final int MAX_LENGTH = 10;

	static int[] a;

	/** Ciura 시퀀스 (* 2.25 확장) */
	private static final int[] gap =
			{ 1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937, 	
			8858, 19930, 44842, 100894, 227011, 510774,
			1149241, 2585792, 5818032, 13090572, 29453787, 
			66271020, 149109795, 335497038, 754868335, 1698453753 };

	/**
	 * 맨 처음 gap을 참조 할 인덱스를 구하는 메소드
	 * @return gap index
	 */
	private static int getGap() {
		int index = 0;
		int len = (int) (a.length / 2.25);

		while (gap[index] < len) {
			index++;
		}

		return index;
	}
	
	/**
	 * 셸 정렬 (오름차순)
	 */
	private static void shellSort() {
		int gapIndex = getGap();

		/*
		3 2 5 1 9 8 4 7 6 0
		3       9       6
		  2       8       0
		    5       4
		      1       7
		 */
		for (int i = gapIndex; i >= 0; i--) {
			for(int ii = 0; ii < gap[i]; ii++) {
				insertionSort(gap[i], ii);
			}
		}
	}
	
	/**
	 * 삽입정렬 (오름차순)
	 * 두 번째 원소부터 앞에 있는 원소와 비교하여 작으면 앞에 있는 원소를 뒤로 이동한다.
	 * @param gapVal gap 배열 값
	 * @param start 서브리스트 시작 인덱스
	 */
	private static void insertionSort(int gapVal, int start) {
		for (int i = start + gapVal; i < a.length; i+= gapVal) {
			int target = a[i];
			int ii = i - gapVal;

			while (ii >= start && target < a[ii]) {
				a[ii + gapVal] = a[ii];
				ii -= gapVal;
			}

			a[ii + gapVal] = target;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = new int[MAX_LENGTH];
		
		System.out.println("수 입력: ");

		// 입력
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		// 셸 정렬
		shellSort();
		
		// 출력
        for (int i : a) {
            System.out.print(i + " ");
        }
	}
}
