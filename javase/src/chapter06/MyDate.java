package chapter06;

/**
 * 날짜를 위한 클래스
 * ex) 2017년 5월 11일
 */
public class MyDate {
	private int year, month, day;
	
	public void setYear(int year){
		if(year >= 1997)
			this.year = year;
		else
			System.out.println("1997년 이후로 설정하세요.");
	}
	
	public void setMonth(int month){
		if(month >= 1 && month <= 12)
			this.month = month;
		else
			System.out.println("1월부터 12월 사이로 설정하세요.");
	}
	
	public void setDay(int day){
		if(day < 1 || day > 31)
			System.out.println("1일부터 31일 사이로 설정하세요.");
		else{
			if(isValid(day))
				this.day = day;
			else
				System.out.printf("%d월에 %d일을 설정할 수 없습니다.\n", month, day);
		}
	}
	/** 작은달 큰달 검사	*/
	private boolean isValid(int day) {
		if((month==2 && day>28) || (month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
			return false;
		else
			return true;
	}
	
	public void setDate(int year, int month, int day){
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	public MyDate(){
		setDate(1998, 01, 23);
	}
	
	public MyDate(int year, int month, int day){		
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}
	/**
	 * 객체의 정보를 문자열로 표현하는 메서드
	 *  - System.out 으로 출력시 toString()이 호출됨
	 *  - 문자열에 + 연산자로 객체를 연결하면 toString()이 호출됨.  
	 */
	public String toString(){
		if(year == 0 || month == 0 || day == 0)
			return "잘못된 날짜 형식입니다. 다시 설정하세요.";
		else
			return String.format("%d년 %2d월 %d일", year, month, day);
	}
}
