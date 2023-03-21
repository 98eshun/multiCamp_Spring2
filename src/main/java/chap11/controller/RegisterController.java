package chap11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import chap11.exception.DuplicateMemberException;
import chap11.model.*;

@Controller
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	/*
	@RequestMapping("/register/step1")	//http://localhost:8080/mySpringWeb/register/step1
	public String handleStep1() {
		return "register/step1";
	}
	*/
	
	@PostMapping("/register/step2")
	public String handleStep2(@RequestParam(value="agree", defaultValue="false") boolean agree, Model model) {	//agree가 String으로 넘어오지만 자동 형변환이 된다
		String view = "";
		
		if(agree) {
			view = "register/step2";
			model.addAttribute("formData",new RegisterRequest());	//커맨드 객체를 사용하기 위해 model을 넣어줌
		}
		else {
			view = "redirect:/register/step1";
		}
		return view;	
	}
	
	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}
	/*
	@GetMapping("/main")
	public String handleMain() {	//뷰 이름만 반환하는 컨트롤러 = 뷰 컨트롤러
		return "/main";				
	}
	*/
/*	
	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq) {
		String view = "register/step3";
		if(regReq.getName().length() >=2 && regReq.getPassword().length() >=4 &&
				regReq.getPassword().equals(regReq.getConfirmPassword())) {
			try {
				memberRegisterService.regist(regReq);
			}
			catch(DuplicateMemberException e) {
				view = "/register/step2";
			}
		}
		else {
			view = "/register/step2";
		}

		return view;
	}*/
	
	@PostMapping("/register/step3")	//매개변수의 갯수 타입 은 상관없이 그냥 삽입 가능 
	public String handleStep3(@ModelAttribute("formData") RegisterRequest regReq, Model model) {	//model의 명칭 변경
		String view = "register/step3";
		
		try {
			memberRegisterService.regist(regReq);
		}
		catch(DuplicateMemberException e) {
			model.addAttribute("msg","중복된 이메일 주소가 발견되었습니다.");
			view = "/register/step2";
		}
			
		return view;
	}
	
	@RequestMapping("/register/change")	//http://localhost:8080/mySpringWeb/register/step1
	public String handleChange(Model model) {
		model.addAttribute("formData",new RegisterRequest());
		return "register/changeResult";
	}
	
	@RequestMapping("/register/changeResult")	//http://localhost:8080/mySpringWeb/register/step1
	public String handleChangeResult(@ModelAttribute("formData") RegisterRequest regReq, Model model) {
		changePasswordService.changePassword(regReq.getEmail(),regReq.getPassword(),regReq.getConfirmPassword());
		model.addAttribute("changeMsg","비밀번호가 변경되었습니다.");
		return "register/change";
	}
}
