package jihun.algorithm.compare.comparable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComparableTest implements Comparable<ComparableTest>{
	
	// 나이
	private int age;
	
	// 학급
	private int classNumber;
	
	public int compareTo(ComparableTest o) {
		// 자기자신의 age가 o의 age보다 크다면 양수
		if(this.age > o.age) {
			return 1;
		}
		// 자기 자신의 age와 o의 age가 같다면 0
		else if(this.age == o.age) {
			return 0;
		}
		// 자기 자신의 age가 o의 age보다 작다면 음수
		else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		ComparableTest comparableTest1 = new ComparableTest(20, 1);
		ComparableTest comparableTest2 = new ComparableTest(19, 1);
		
		int result = comparableTest1.compareTo(comparableTest2);
		
		System.out.println(result);
	}
}
