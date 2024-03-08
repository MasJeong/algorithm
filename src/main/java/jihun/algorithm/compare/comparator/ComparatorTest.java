package jihun.algorithm.compare.comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Comparator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComparatorTest {

	// 나이
	private int age;

	// 학급
	private int classNumber;

	// 익명 객체 구현
	static Comparator<ComparatorTest> comp = new Comparator<ComparatorTest>() {
		public int compare(ComparatorTest o1, ComparatorTest o2) {
			// 음수인 경우 교환 안하는 것을 이용, 내림차순
			if(o1.getAge() > o2.getAge())
				return -1;
			else if(o1.getAge() == o2.getAge())
				return 0;
			else
				return 1;
//			return o2.getAge() < o1.getAge();
		}
	};

	public static void main(String[] args) {
		ComparatorTest comparableTest = new ComparatorTest(20, 5);
		ComparatorTest comparableTest2 = new ComparatorTest(19, 2);

		int result = comp.compare(comparableTest, comparableTest2);

		System.out.println(result);

		// Arrays.sort() 메소드에 적용
		ComparatorTest[] arr = new ComparatorTest[10];

		// 객체 배열 초기화 (랜덤 값으로)
		System.out.println("정렬 전");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ComparatorTest((int) (Math.random() * 100), 1);
			System.out.print(arr[i].getAge() + " ");
		}
		System.out.println();

		Arrays.sort(arr, comp);

		System.out.println("정렬 후");
		for (int i = 0; i < 10; i++) {
			System.out.print(arr[i].getAge() + " ");
		}
	}
}
