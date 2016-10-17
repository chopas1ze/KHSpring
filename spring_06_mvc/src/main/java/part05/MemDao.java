package part05;

import java.util.List;

public interface MemDao {

	public List<MemDTO> listMethod();
	public void insertMethod(MemDTO dto);
	
}//end interface
