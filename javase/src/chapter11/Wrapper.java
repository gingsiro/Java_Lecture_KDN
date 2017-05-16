package chapter11;

public class Wrapper {
	public static void main(String[] args) {
		// 1.4 버전 까지
		Integer iNum = new Integer(256);
		Double dPi = new Double(3.14);
		int num = iNum.intValue();
		double pi = dPi.doubleValue();
		
		//1.5 버전 부터
		int iPrice = 5000;
		double dPrice = 5000.0;
		int price = iPrice;
		double d = dPrice;
		
		//문자열의 해당 타입으로 변환
		int size = Integer.parseInt("256");
		double rate = Double.parseDouble("0.035");
		
		System.out.println(num + pi + price + d + size + rate);
	}
}
