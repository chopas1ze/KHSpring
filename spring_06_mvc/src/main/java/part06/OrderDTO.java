package part06;

import java.util.List;

public class OrderDTO {

	private List<OrderItem> list;
	private String address;
	
	public OrderDTO() {
	}

	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}//end class
