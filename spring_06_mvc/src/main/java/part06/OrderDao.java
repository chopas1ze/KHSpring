package part06;

import java.util.List;

public interface OrderDao {

	public void insertMethod(OrderDTO dto);
	
	public List<OrderDTO> selectMethod();
	
}//end interface
