package part04_ajax_daum;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="channel")
public class BookList {
	
	private List<BookDTO> bookItem;
	
	public BookList() {
	}

	public List<BookDTO> getBookItem() {
		return bookItem;
	}

	@XmlElement(name="item")
	public void setBookItem(List<BookDTO> bookItem) {
		this.bookItem = bookItem;
	}
	
	

}//end class
