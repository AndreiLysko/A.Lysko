package by.tc.nb.bean;

import java.util.List;

import by.tc.nb.bean.entity.Question;

public class FindBookResponse extends Response {
	private List<Question> findBook;

	public List<Question> getFindBook() {
		return findBook;
	}

	public void setFindBook(List<Question> findBook) {
		this.findBook = findBook;
	}

	
}
