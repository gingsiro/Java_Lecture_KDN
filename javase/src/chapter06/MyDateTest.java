package chapter06;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate d1 = new MyDate();
//		d1.year = 2017;
//		d1.month = 13;
//		d1.day = 32;
		d1.setDate(1996, 13, 32);
		d1.setDate(2017, 5, 11);
		System.out.println(d1);
	}

}
