package jihun.algorithm.sort.quick;

/**
 * 퀵 정렬
 * 1. 피벗을 하나 선택한다.
 * 2. 피벗을 기준으로 양쪽에서 피벗보다 큰 값, 혹은 작은 값을 찾는다.
 * 	왼쪽에서부터는 피벗보다 큰 값을 찾고, 오른쪽에서부터는 피벗보다 작은 값을 찾는다.
 * 3. 양 방향에서 찾은 두 원소를 교환한다.
 * 4. 왼쪽에서 탐색하는 위치와 오른쪽에서 탐색하는 위치가 엇갈리지 않을 때 까지 2번으로 돌아가 위 과정을 반복한다.
 * 5. 엇갈린 기점을 기준으로 두 개의 부분리스트로 나누어 1번으로 돌아가
 * 	해당 부분리스트의 길이가 1이 아닐 때 까지 1번 과정을 반복한다. (Divide : 분할)
 * 6. 인접한 부분리스트끼리 합친다. (Conqure : 정복)
 */
public class QuickSortTest {

	private static void singlePivotSort(int[] a, int left, int right) {

		if(left >= right) return;

		int pivotIdx = partition(a, left, right);

		singlePivotSort(a, left, pivotIdx - 1);
		singlePivotSort(a, pivotIdx + 1, right);
	}

	private static int partition(int[] a, int left, int right) {

		int pivotVal = a[left];
		int lo = left;
		int hi = right;

		while (lo < hi) {
			while (lo < hi && a[hi] > pivotVal) {
				hi--;
			}

			while(lo < hi && a[lo] < pivotVal) {
				lo++;
			}

			swap(a, lo, hi);
		}

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
