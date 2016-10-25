package part04_ajax_daum;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


//아이템값을 저장하기위한 클래스
@XmlRootElement(name="item")
public class BookDTO {
	private String title;
	private String link;
	private String image;
	private String author;
	private int price;
	
	public BookDTO() {
	}

	public String getTitle() {
		return title;
	}

    @XmlElement(name="title")
	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	@XmlElement(name="link")
	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	@XmlElement(name="cover_l_url")
	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement(name="author")
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	@XmlElement(name="sale_price")
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}//end class
