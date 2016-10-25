package part04_ajax_daum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



/*다음 book api키 : 08f3b6e376777934e056ecca8fbcdf89*/


@Controller
public class SearchDaumController {

		@RequestMapping("/daumForm.do")
		public String form(){
			return "part04_ajax_daum/daumForm";
		}//end form()
	
		/*@RequestMapping("/searchOpen.do")
		public ModelAndView process(String search) throws MalformedURLException, IOException{
			ModelAndView mav = new ModelAndView();
																									//한글처리
			String url="https://apis.daum.net/search/book?apikey=08f3b6e376777934e056ecca8fbcdf89&q="+URLEncoder.encode(search,"UTF-8") +"&output=xml";
		//	https://apis.daum.net/search/book?apikey=08f3b6e376777934e056ecca8fbcdf89&q=카카오톡&output=xml  주소창에서는 그냥 UTF-8상관없이  테스트 가능.
			
			//URL을 연결
			HttpURLConnection con=(HttpURLConnection)new URL(url).openConnection();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			
			String input=null;
			String total="";
			//파일의 끝 : .read()는 -1 리턴   readLine()은 null리턴
			//readLine은 한줄한줄 읽어들임
			while((input=reader.readLine())!=null){
				total+=input;
			}
			
			mav.addObject("total",total);
			mav.setViewName("part04_ajax_daum/daumResult");
			return mav;
		}//end process()
*/	
		@RequestMapping("/searchOpen.do")
		//ResponseBody는 json뿐만이 아니라 json.xml에서도 사용가능.데이터값을 바로 리턴하여 사용
		public @ResponseBody BookList process(String search) throws MalformedURLException, IOException, JAXBException{
		
			//이방법은 <br>태그를 알아서 고쳐준다.
			
			
			String url="https://apis.daum.net/search/book?apikey=08f3b6e376777934e056ecca8fbcdf89&q="+URLEncoder.encode(search,"UTF-8") +"&output=xml";
			HttpURLConnection con=(HttpURLConnection)new URL(url).openConnection();
			
			JAXBContext jaxbContext=null;
			BookList booklist=null;
			
			jaxbContext=JAXBContext.newInstance(BookList.class);
			
			booklist=(BookList)jaxbContext.createUnmarshaller().unmarshal(con.getInputStream());
			//System.out.println("data:"+booklist.getBookItem().get(0).getTitle());
			return booklist;
		
		
		}
		
		
}//end class
