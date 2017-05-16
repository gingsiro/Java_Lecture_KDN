package chapter06;

import java.util.Calendar;

/**
 * abstract : 추상적인 성격 부여
 *   클래스 : 
 *     - 객체 생성 불가
 *     - 목적
 *       1. 상속 전용 클래스가 됨, 다형성
 *   	 2. 클래스 내에 추상 메서드가 한개 이상 있으면 반드시 추상 클래스로 선언.
 *   
 *   메서드 : 
 *     - 메서드의 body를 구현하지 않고 sub에게 재정의를 강제로 위임.
 *   	 => sub에서 추상 메서드를 재정의(Override)하지 않으면 compile오류 발생
 *     - 목적
 *       1. 모든 Sub에 해당 기능은 있지만 구현부가 달라서 공통 코드가 없는 경우
 *       2. 새로 변경될 부분을 예상 할 수 없는 경우
 *     - 효과
 *       1. 가볍게 상속
 *       2. 성능 저하를 조금 해결
 *       3. sub에 강제로 override하도록 설계시에 제어 가능
 */
	
abstract class Animal{
	String name;
	String kind;
	int age;
	/**
	 * 추상 클래스의 생성자는 객체 생성을 할 수 없지만
	 * 상속 시 호출될 수 있으므로 필요하다면 선언한다.
	 */
	public Animal(){}
	public Animal(String name, String kind, int age) {
		super();
		this.name = name;
		this.kind = kind;
		this.age = age;
	}

	public abstract void bark();
	public abstract void service();
}

class Dog extends Animal{
	public void bark() {
		System.out.println("멍멍");
	}
	
	public void keep(){
		Calendar today = Calendar.getInstance();
		int time = today.get(Calendar.HOUR_OF_DAY);
		if(time >= 9 && time <= 18){
			System.out.println("잘 지키고 있습니다.");
		}else{
			System.out.println("나도 좀 쉬어야죠!!!!");
		}
	}

	public void service() {
		keep();
	}
}

class Duck extends Animal{
	public Duck(){}
	public Duck(String name, String kind, int age){
		super(name, kind, age); //추상 클래스의 생성자를 재사용
	}
	
	public void bark() {
		System.out.println("꽥꽥!!!");
	}
	
	public void fly() {
		if(kind != null && !kind.equals("집오리")){
			System.out.println("날아올라 저하늘 날고 있어요....");
		}else{
			System.out.println("오리는 날 수 없다 엄마에게 혼났죠~~ ㅜ.ㅜ");
		}
	}
	
	public void service() {
		fly();
	}
}

public class AbstractTest {
	public static void main(String[] args) {
//		추상 클래스는 자신의 생성자로 객체 생성 불가
//		Animal animal = new Animal();
//		추상 클래스는 다형성에 의해 sub의 객체를 참조
		Animal ani1 = new Dog();
		ani1.bark();
		
//		추상클래스라도 배열 객체는 생성할 수 있다.
		Animal[] list = new Animal[2];
		list[0] = new Dog();
		list[1] = new Duck("체리필터", "집오리", 19);
		/*
		  for(Type 변수 : 배열 or Collection){ }
		  => 배열 or Collection을 처음부터 끝까지 반복 시켜서 데이터를 하나 추출해 변수에 저장
		  
		  for(int i=0 ; i<animal.length ; i++){
		      Animal animal = list[i];
		  }
		  
		  성능은 foreach가 더 좋다.
		  일반 for문은 조건, 수행을 반복하기 때문
		  foreach는 다음위치로 가서 불러오게 만들어짐 
		 */
		for (Animal animal : list) {
			animal.bark();
			animal.service();
//			공통코드로 추가된 기능이 아니라면 이를 반영하기 위해 아래와 같은 코드 필요
//			if (animal instanceof Dog) {
//				Dog dog = (Dog) animal;
//				dog.keep();
//			}else if (animal instanceof Duck) {
//				Duck duck = (Duck) animal;
//				duck.fly();
//			} 
		}
	}
}
