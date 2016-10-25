package dao;

import java.util.HashMap;
import java.util.List;

import dto.LibmapDTO;

public interface LibDAO {
   public List<LibmapDTO> lib_list(HashMap<String, Object> map);
   public int lib_countAll(String data);
}//end interface
