package part04_ajax_daum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/*다음 book api키 : 08f3b6e376777934e056ecca8fbcdf89*/


@Controller
public class SearchDaumController {

		@RequestMapping("/daumForm.do")
		public String form(){
			return "part04_ajax_daum/daumForm";
		}//end form()
	
	
}//end class
