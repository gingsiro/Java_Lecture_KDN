package chapter06;

import java.util.Arrays;

public class ArrayTest3 {

	public static void main(String[] args) {
		int[] src = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] copy1 = new int[src.length + 10];
		int[] copy2 = new int[3];
		/*
		 * System.arraycopy(src, srcPos, dest, destPos, length);
		 * src : 복사할 원본
		 * srcPos : 원본을 복사할 위치(index)
		 * dest : 복사할 부분
		 * destPos :부분의 복사할 위치(index)
		 * length :  복사할 개수
		 */
		System.arraycopy(src, 0, copy1, 0, src.length);
		System.arraycopy(src, 4, copy2, 0, 3);
		print(src);
		print(copy1);
		print(copy2);
		
		int[] sort = {6, 3, 7, 9, 1, 4, 5};
		Arrays.sort(sort);
		print(sort);
	}
	
	public static void print(int[] array){
		if(array != null){
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}

}
