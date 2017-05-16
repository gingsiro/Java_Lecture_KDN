package chapter06;

public class EmployeeManager {
	private Employee[] empList;
	private Manager[] mgrList;
	private Engineer[] engList;

	/** 일반직원이 등록된 수, 다음 저장될 위치 */
	private int empIndex = 0;
	/** 매니저가 등록된 수, 다음 저장될 위치 */
	private int mgrIndex = 0;
	/** 엔지니어가 등록된 수, 다음 저장될 위치 */
	private int engIndex = 0;

	public EmployeeManager() {
		empList = new Employee[15];
		mgrList = new Manager[3];
		engList = new Engineer[5];
	}

	/**
	 * 사원 번호에 해당하는 사원을 찾아 해당 사원의 정보를 반환하는 기능
	 * 
	 * @param empno
	 *            찾을 사원의 사원번호
	 * @return 찾은 경우 해당 사원의 사원 정보 반환, 못 찾은 경우 error 메시지
	 */
	public String findEmployee(String empno) {
		if (empno != null) {
			// 사원 번호에 해당하는 사원을 찾기
			int i;

			for (i = 0; i < empIndex; i++) {
				if (empno.equals(empList[i].getEmpno())) {
					return empList[i].toString();
				}
			}

			for (i = 0; i < mgrIndex; i++) {
				if (empno.equals(mgrList[i].getEmpno())) {
					return mgrList[i].toString();
				}
			}

			for (i = 0; i < engIndex; i++) {
				if (empno.equals(engList[i].getEmpno())) {
					return engList[i].toString();
				}
			}
			return "찾는 사원이 존재하지 않습니다.";
		} else {
			return "찾을 사원 정보를 입력하세요.";
		}
	}

	/**
	 * 사원 번호에 해당하는 매니저를 찾아 해당 매니저의 정보를 반환하는 기능
	 * 
	 * @param empno
	 *            찾을 매니저의 사원번호
	 * @return 찾은 경우 해당 매니저의 사원 정보 반환, 못 찾은 경우 error 메시지
	 */
	public String findManager(String empno) {
		int i;
		String result = null;

		for (i = 0; i < empIndex; i++) {
			if (empno.equals(mgrList[i].getEmpno())) {
				result = empList[i].toString();
			}
		}
		if (i == empIndex) {
			result = String.format("%s번 사원을 찾을 수 없습니다.\n", empno);
		}

		return result;
	}

	/**
	 * 사원 번호에 해당하는 엔지니어를 찾아 해당 사원의 정보를 반환하는 기능
	 * 
	 * @param empno
	 *            찾을 엔지니어의 사원번호
	 * @return 찾은 경우 해당 엔지니어의 사원 정보 반환, 못 찾은 경우 error 메시지
	 */
	public String findEngineer(String empno) {
		int i;
		String result = null;

		for (i = 0; i < engIndex; i++) {
			if (empno.equals(engList[i].getEmpno())) {
				result = engList[i].toString();
			}
		}
		if (i == engIndex) {
			result = String.format("%s번 사원을 찾을 수 없습니다.\n", empno);
		}

		return result;
	}

	/**
	 * 일반 직원을 등록하는 기능
	 * 
	 * @param emp
	 *            등록할 사원 정보
	 */
	public void addEmployee(Employee emp) {
		if (emp != null) {
			// 동일한 사원번호가 있는 경우 등록되지 않음
			// 배열이 가득 찬 경우 늘리기
			int i;

			// for로 여러번 접근할 땐 함수접근이 빈번한 코드보다 변수로 선언해주는 것이 좋음
			// for (i = 0; i < empIndex; i++) {
			// if (empList[i].getEmpno().equals(emp.getEmpno())) {
			// System.out.println("동일 사원번호로는 등록되지 않습니다.");
			// break;
			// }
			// }
			String empno = emp.getEmpno();
			for (i = 0; i < empIndex; i++) {
				if (empList[i].getEmpno().equals(empno)) {
					System.out.printf("%s번은 이미 등록된 사원번호입니다.\n", empno);
					return;
				}
			}

			int size = empList.length;
			if (empIndex == size) {
				Employee[] emptemp = new Employee[size + 10];
				System.arraycopy(empList, 0, emptemp, 0, size);
				empList = emptemp;
			}
			empList[empIndex++] = emp;
		}
	}

	/**
	 * 매니저 직원을 등록하는 기능
	 * 
	 * @param mgr
	 *            등록할 사원 정보
	 */
	public void addEmployee(Manager mgr) {
		if (mgr != null) {
			int i;
			String empno = mgr.getEmpno();
			for (i = 0; i < mgrIndex; i++) {
				if (mgrList[i].getEmpno().equals(empno)) {
					System.out.printf("%s번은 이미 등록된 사원번호입니다.\n", empno);
					return;
				}
			}

			int size = mgrList.length;
			if (mgrIndex == size) {
				Manager[] mgrTemp = new Manager[size + 10];
				System.arraycopy(mgrList, 0, mgrTemp, 0, size);
				mgrList = mgrTemp;
			}
			mgrList[mgrIndex++] = mgr;
		}
	}

	/**
	 * 엔지니어 직원을 등록하는 기능
	 * 
	 * @param eng
	 *            등록할 사원 정보
	 */
	public void addEmployee(Engineer eng) {
		if (eng != null) {
			int i;
			String empno = eng.getEmpno();
			for (i = 0; i < engIndex; i++) {
				if (engList[i].getEmpno().equals(empno)) {
					System.out.printf("%s번은 이미 등록된 사원번호입니다.\n", empno);
					return;
				}
			}
			int size = engList.length;
			if (engIndex == size) {
				Engineer[] engTemp = new Engineer[size + 10];
				System.arraycopy(engList, 0, engTemp, 0, size);
				engList = engTemp;
			}
			engList[engIndex++] = eng;
		}
	}
}
