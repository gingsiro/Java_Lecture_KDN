package chapter08.sub;

public interface Trans {
	int INIT = 0; // 컴파일 시 public static final로 선언됨
	
	void start(); // 컴파일 시 public abstract로 선언됨
	public void stop();
}
