package chapter06;

public class ArrayTest2 {

	public static void main(String[] args) {
		// 배열의 선언, 생성, 할당
		// DataType[] id = {값1, 값2, ...};
		
		int[] a = {0, 1, 2, 3, 4, 5};
		MyDate d1 = new MyDate(2017, a[5], 11);
		MyDate[] days = {d1, new MyDate()};
		System.out.println(days[0].toString());
		/**
		 * 다차원 배열 [], {} 차원
		 * 
		 * int[] a1, a2[], a3[][]; a1 : 1차원, a2 : 2차원, a3 : 3차원
		 * 
		 */
		
		int[][] a2={{0, 1, 2},{3, 4},{5, 6, 7}};
		for (int i = 0; i < a2.length; i++) {
			for (int j = 0; j < a2[i].length; j++) {
				System.out.printf("a2[%d][%d] : %d", i, j, a2[i][j]);
			}
			System.out.println();
		}
	}
}
