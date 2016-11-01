package dao;

import java.util.List;

import dto.PersonDTO;

public interface PersonDao {
	public List<PersonDTO> list();
	public PersonDTO list(int num);
	public PersonDTO list(PersonDTO dto);
	public void register(PersonDTO dto);
	public void  update(PersonDTO dto);
	public void delete(int num);
	
}// end interface
