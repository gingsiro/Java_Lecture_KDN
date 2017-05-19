package com.kdn.model.domain;

/** 검색할 조건과 검색어 */
public class PageBean {
	/**검색 조건 : 이름,  급여 */
	private String key; 
	/**검색어 
	 * 이름 : 동일한 이름에 해당하는 사원을 모두 찾기 
	 * 급여이상 : 지정된 금액 이상의 사원들을 찾기 
	 * 급여이하 : 지정된 금액 이하의 사원들을 찾기
	 *  */
	private String word;
	
	private int pageNo;
	
	private int interval = 5;
	
	private int start = 1;
	
	private int end = interval;
	
	public PageBean(){}
	public PageBean(String key, String word) {
		this.key = key;
		this.word = word;
	}
	public PageBean(String key, String word, int pageNo) {
		this.key = key;
		this.word = word;
		this.pageNo = pageNo;
	}
	public PageBean(String key, String word, String pageNo) {
		this.key = key;
		this.word = word;
		try {
			this.pageNo = Integer.parseInt(pageNo);
		} catch (Exception e) {
			this.pageNo = 1;
		}
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	public int getStart() {
		if(pageNo>1){
			start = (pageNo -1) * interval + 1;
		}
		return start;
	}
	
	public void setStart(int start){
		this.start = start;
	}
	
	public int getEnd() {
		if(pageNo>1){
			end = start + interval - 1;
		}
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	public String toString() {
		return "PageBean [key=" + key + ", word=" + word + "]";
	}
	
}
