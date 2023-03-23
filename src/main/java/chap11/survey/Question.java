package chap11.survey;

import java.util.*;

public class Question {

	private String title;
	private List<String> options;
	
	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}
	
	public Question(String title) {
		this(title,Collections.<String>emptyList());	// this() 는 같은 클래스에 있는 생성자를 호출한다
	}													// 지금은 위에 매개변수 2개를 받는 생성자를 호출했다.

	public String getTitle() {
		return title;
	}

	public List<String> getOptions() {
		return options;
	}

	public boolean isChoice() {
		return this.options != null && !this.options.isEmpty();
	}

}
