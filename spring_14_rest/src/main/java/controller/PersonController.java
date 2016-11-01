package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.PersonDao;
import dto.PersonDTO;

/*
GET(/rest/person/list)     		자료의 조회용
GET(/rest/person/list/3)   		자료의 조회용
DELETE(/rest/person/3)     		자료의 삭제
POST(/rest/person/)+데이터    		자료의 등록
PUT(/rest/person/update)+데이터 	자료의 수정  

@PathVariable-URI의 경로에서 원하는 데이터를 추출하는 용도로 사용
@RequestBody - 전송된 JSON데이터를 객체로 변환해 주는 어노테이션으로 
@ModeAndView와 유사한 역할을 하지만 JSON에서 사용된다는 점이 차이
*/



@Controller
public class PersonController {
	private PersonDao dao;
	
	public PersonController() {
	}
	
	public void setDao(PersonDao dao) {
		this.dao = dao;
	}
	
	//http://127.0.0.1:8090/rest/person/list
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody List<PersonDTO> listMethod(){
		return dao.list();
	}//end listMethod()
	
	
	//http://127.0.0.1:8090/rest/person/list/2
	@RequestMapping(value="/list/{ss}", method = RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(@PathVariable("ss") int num){
											//json으로 매개변수 받을때는 @requsetbody
		return dao.list(num);
	}//end listMethod()
	
	//http://127.0.0.1:8090/rest/person/list/2/이영희
/*	@RequestMapping(value="/list/{num}/{name}", method = RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(@PathVariable("num") int num,@PathVariable("name") String name){
		PersonDTO dto = new PersonDTO();
		dto.setName(name);
		dto.setNum(num);
		return dao.list(dto);
		
	}//end listMethod()
*/	
	
	/*@RequestMapping(value="/list/{num}/{name}", method = RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(PersonDTO dto){
	return dao.list(dto);
	}//end listMethod()
*/	
	
	@RequestMapping(value="/list/{num}/{name}", method = RequestMethod.GET)
	public ResponseEntity<PersonDTO> listMethod(PersonDTO dto){
		ResponseEntity<PersonDTO> entity = new ResponseEntity<PersonDTO>(dao.list(dto),HttpStatus.OK);
	return entity;
	}//end listMethod()
	
	

	/* 뷰단(jsp)에서 json으로 데이터값을 보낼때
	 * $.ajax({
	 * dataType:'text',
	 * type:'POST',
	 * 컨트롤러에서JSON데이터를 문자열로 받을때
	 * data:JSON.stringify({"id":"user","pass":"4253","name":"야옹이"}),
	 * 
	 * 
	 * 문자열을 제이손으로 받을때는 JSON.parse
	 */
	
	
	//http://127.0.0.1:8090/rest/person/
	//postman 에서 테스트할떄 header부분에서 content-Type  application/json 설정후 raw에서 배열형태로 데이터 삽입한다. 
	//json형태로 데이터를 받을때 사용 responebody 로 받아도 되고 reponseeintity로도 받을수 있다. 
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<String> insertMethod(@RequestBody PersonDTO dto){
		
		ResponseEntity<String> entity = null;
		
		try{
			dao.register(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//end insertMethod()
	

	//http://127.0.0.1:8090/rest/person/update
	//매개변수를 JSON형태로넘길때 사용법이고, URI에서 매개변수를 넘길때는  listmethod 1,2번 처럼 넘김
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateMethod(@RequestBody PersonDTO dto){
		ResponseEntity<String> entity = null;
		try{
			dao.update(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//end updateMethod()
	
	@RequestMapping(value="/{num}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteMethod(@PathVariable("num") int num){
		ResponseEntity<String> entity = null;
		try{
			dao.delete(num);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}//end deleteMethod()
	
	@RequestMapping(value="/file", method=RequestMethod.POST)
	public @ResponseBody void fileMethod(PersonDTO dto,HttpServletRequest req){
		/*multipart/form-data*/
		MultipartFile file = dto.getFilename();
		if(!file.isEmpty()){
			String fileName=file.getOriginalFilename();
			
			UUID random=UUID.randomUUID();
			String root=req.getSession().getServletContext().getRealPath("/");
			//root+"temp/"
			
			/*C:\study\workspace_spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\spring_07_board\temp */
			String saveDirectory = root+"temp"+File.separator;  //File.separator 는 "/" 이다.
			
			//디렉토리 생성 용도
			File fe = new File(saveDirectory);
			if(!fe.exists())
				fe.mkdir();
			
			File ff = new File(saveDirectory,random+"_"+fileName);
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			};
			
			};
		
			
	}//end fileMethod()
	
	
	
}//end class
