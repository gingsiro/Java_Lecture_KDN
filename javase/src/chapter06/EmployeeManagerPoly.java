package chapter06;

public class EmployeeManagerPoly {
	/**
	 * Heterogeneous Collection
	 * 배열에 다형성 적용
	 * 다형성에 의해서 모든 sub 타입은 super 타입으로 자동 형변환이 되므로
	 * 배열을 super 타입으로 선언하면 됨.
	 */
	private Employee[] empList;
	private int empIndex;

	public EmployeeManagerPoly() {
		empList = new Employee[15];
	}
	
	/**
	 * 사원번호에 해당하는 사원이 저장된 배열의 index를 반환하는 기능
	 * @param empno 찾을 사원의 사원번호
	 * @return 찾은경우 해당 index를, 못 찾은 경우 -1을 반환
	 */
	private int findEmployeeIndex(String empno){
		if(empno != null){
			for (int i = 0; i < empIndex; i++) {
				if(empno.equals(empList[i].getEmpno())){
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * 사원 번호에 해당하는 사원을 찾아 해당 사원의 정보를 반환하는 기능
	 * @param empno 찾을 사원의 사원번호
	 * @return 찾은 경우 해당 사원의 사원 정보 반환, 못 찾은 경우 error 메시지
	 */
	public Employee findEmployee(String empno) {
		/* 다형성을 메서드 리턴타입에 적용
		 * 다형성에 의해서 모든 sub 타입은 super 타입으로 자동 형변환이 되므로
		 * 리턴 타입을 super로 선언하면 sub들도 리턴된다.
		 * */
		int index = findEmployeeIndex(empno);
		if(index > -1){
			return empList[index];
		}else{
			return null;
		}
	}

	/**
	 * 직원을 등록하는 기능
	 * @param emp 등록할 사원 정보
	 */
	public void addEmployee(Employee emp) {
		/* 다형성을 메서드 인자에 적용
		 *   - 다형성에 의해서 모든 sub 타입은 super 타입으로 자동 형변환이 되므로
		 *     메서드 인자를 super로 선언하면 sub타입도 인자로 받을 수 있다.
		 */
		if (emp != null) {
			// 동일한 사원번호가 있는 경우 등록되지 않음
			String empno = emp.getEmpno();
			int index = findEmployeeIndex(empno);
			
			if (index < 0) { //동일한 사원번호를 못찾은 경우 이므로 등록
				int size = empList.length;	
			
				if(empIndex == size){ //배열이 꽉 찼는지 검사
					//배열이 꽉 찬 경우 늘리기
					Employee[] copy = new Employee[size+10];
					System.arraycopy(empList, 0, copy, 0, size);
					empList = copy;
				}
				
				empList[empIndex++] = emp;
			}else{
				System.out.printf("%s번은 이미 등록된 사원번호입니다.\n", empno);
			}
		}
	}
	
	/**
	 * 사원번호에 해당하는 사원의 정보를 수정하는 기능
	 * @param emp 수정할 사원의 정보
	 */
	public void updateEmployee(Employee emp){
		if(emp != null){
			String empno = emp.getEmpno();
			int index = findEmployeeIndex(empno);
			if (index > -1) {
				empList[index] = emp;
			}else{
				System.out.println("수정할 사원을 찾을 수 없습니다.");
			}
		}
	}
	
	public void removeEmployee(String empno){
		int index = findEmployeeIndex(empno);
		if(index > -1){
			empList[index] = empList[empIndex - 1];
			empList[empIndex-- - 1] = null;
			
		}else{
			System.out.println("해당 사원을 찾을 수 없습니다.");
		}
	}
	
	public void printAll(){
		for (int i = 0; i < empIndex; i++) {
			System.out.println(empList[i]);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
