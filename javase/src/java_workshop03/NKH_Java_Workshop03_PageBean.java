package java_workshop03;

public class NKH_Java_Workshop03_PageBean {
	private String key;
	private String word;
	
	public String getKey() {
		return key;
	}
	
	public String getWord() {
		return word;
	}
	
	public NKH_Java_Workshop03_PageBean() {  }
	
	public NKH_Java_Workshop03_PageBean(String key, String word) { 
		setKey(key);
		setWord(word);
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String toString() {
		return String.format("%s, %s", key, word);
	}
	
}
