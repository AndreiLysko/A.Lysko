package by.tc.nb.bean;

import java.util.List;

import by.tc.nb.bean.entity.Note;

public class FindBookResponse extends Response {
	private List<Note> findBook;

	public List<Note> getFindBook() {
		return findBook;
	}

	public void setFindBook(List<Note> findBook) {
		this.findBook = findBook;
	}

	
}
