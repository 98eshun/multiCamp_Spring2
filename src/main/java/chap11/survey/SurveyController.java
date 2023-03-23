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
	public ModelAndView form(Model model) {	// ���� �ּ�ó���� �ڵ带 ModelAndView��ü �������� �ٲ۰�
		List<Question> questions = this.createQuestions();
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions",questions);
		mav.setViewName("survey/surveyForm");
		
		return mav;
	}
	
	@PostMapping	//Ŀ�ǵ� ��ü�� AnsweredData�� surveyForm���� ������ �Ķ���� ���� �ڵ����� ��
	public String submit(@ModelAttribute("ansData") AnsweredData data, Model model) {
		List<String> list = data.getResponses();
		Respondent res = data.getRes();
		model.addAttribute("list",list);
		model.addAttribute("res",res);
		return "survey/submitted";
	}
	
	private List<Question> createQuestions(){
		Question q1 = new Question("����� ������?", 
				Arrays.asList("����", "����Ʈ" , "Ǯ����"));
		Question q2 = new Question("���ߵ�����?", 
				Arrays.asList("����", "����Ʈ" , "Ǯ����"));
		Question q3 = new Question("�ϰ���� ���� �����ּ���");		
		
		return Arrays.asList(q1,q2,q3);
	}
	
}
