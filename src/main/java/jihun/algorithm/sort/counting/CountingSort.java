package jihun.algorithm.sort.counting;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

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
public class CountingSort {
	private static final int MAX_LENGTH = 100;
	
	// TODO 중간과정이 생략되었으므로 다시 확인
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] input = new int[MAX_LENGTH];
		
		for(int i = 0; i < input.length; i++) {
			input[(int) (Math.random() * 100)]++;
		}
		
		for(int i = 0; i < input.length; i++) {
			while(input[i]-- > 0)
				bw.write(Integer.toString(i) + "\n");
		}

		bw.flush();
		bw.close();
	}
}
