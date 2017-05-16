package chapter06;

public class Customer {
	String name;
	String address;
	public int age;
	
	public Customer(){}
	public Customer(String name, String address, int age){
		this.name = name;
		this.address = address;
		this.age = age;
	}
	public String customerInfo(){
		return String.format("이름 : %s\n주소 : %s\n나이 : %s\n", name, address, age);
	}
}
