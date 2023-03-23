package chap11.survey;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")
public class SurveyController {

	/*
	@GetMapping
	public String form(Model model) {
		List<Question> questions = this.createQuestions();
		model.addAttribute("questions",questions);
		
		return "survey/surveyForm";
	}
	*/
	
	@GetMapping
	public ModelAndView form(Model model) {	// 위의 주석처리된 코드를 ModelAndView객체 형식으로 바꾼것
		List<Question> questions = this.createQuestions();
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions",questions);
		mav.setViewName("survey/surveyForm");
		
		return mav;
	}
	
	@PostMapping	//커맨드 객체인 AnsweredData에 surveyForm에서 나오는 파라미터 값이 자동으로 들어감
	public String submit(@ModelAttribute("ansData") AnsweredData data, Model model) {
		List<String> list = data.getResponses();
		Respondent res = data.getRes();
		model.addAttribute("list",list);
		model.addAttribute("res",res);
		return "survey/submitted";
	}
	
	private List<Question> createQuestions(){
		Question q1 = new Question("당신의 역할은?", 
				Arrays.asList("서버", "프론트" , "풀스택"));
		Question q2 = new Question("개발도구는?", 
				Arrays.asList("서버", "프론트" , "풀스택"));
		Question q3 = new Question("하고싶은 말을 적어주세요");		
		
		return Arrays.asList(q1,q2,q3);
	}
	
}
