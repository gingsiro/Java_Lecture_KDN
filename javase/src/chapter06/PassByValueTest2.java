package chapter06;

class PassByValue{
	public int primitive(int data){
		System.out.println("Primitive 메서드 data : " + data);
		data += 5;
		return data;
	}
	public void reference1(MyDate date){
		if(date != null){
			date.setDay(12);
		}
	}
}

public class PassByValueTest2 {
	public static void main(String[] args) {
		PassByValue pb = new PassByValue();
		int pdata = 10;
		System.out.println("함수 호출하기전 pData : " + pdata);
		pb.primitive(pdata);
		System.out.println("함수 호출한이후 pData : " + pdata);
		pdata = pb.primitive(pdata);
		System.out.println("함수 호출후리턴 pData : " + pdata);
		
		MyDate today = new MyDate(2017, 5, 11);
		System.out.println("함수 호출하기전 today : " + today);
		pb.reference1(today);
		System.out.println("함수 호출한이후 today : " + today);
	}
}
