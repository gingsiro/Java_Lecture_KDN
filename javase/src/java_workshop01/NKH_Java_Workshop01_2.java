package java_workshop01;

import java.util.Scanner;

public class NKH_Java_Workshop01_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input1 = s.nextInt(), input2 = s.nextInt();
		s.close();
		for(int i=1 ; i<=input1 ; i++){
			for(int j=0 ; j<input2 ; j++){
				System.out.printf("%2d ",i+i*j);
			}
			System.out.println();
		}
	}

}
