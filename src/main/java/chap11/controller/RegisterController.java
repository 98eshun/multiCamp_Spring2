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
	public String handleStep2(@RequestParam(value="agree", defaultValue="false") boolean agree, Model model) {	//agree�� String���� �Ѿ������ �ڵ� ����ȯ�� �ȴ�
		String view = "";
		
		if(agree) {
			view = "register/step2";
			model.addAttribute("formData",new RegisterRequest());	//Ŀ�ǵ� ��ü�� ����ϱ� ���� model�� �־���
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
	public String handleMain() {	//�� �̸��� ��ȯ�ϴ� ��Ʈ�ѷ� = �� ��Ʈ�ѷ�
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
	
	@PostMapping("/register/step3")	//�Ű������� ���� Ÿ�� �� ������� �׳� ���� ���� 
	public String handleStep3(@ModelAttribute("formData") RegisterRequest regReq, Model model) {	//model�� ��Ī ����
		String view = "register/step3";
		
		try {
			memberRegisterService.regist(regReq);
		}
		catch(DuplicateMemberException e) {
			model.addAttribute("msg","�ߺ��� �̸��� �ּҰ� �߰ߵǾ����ϴ�.");
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
		model.addAttribute("changeMsg","��й�ȣ�� ����Ǿ����ϴ�.");
		return "register/change";
	}
}
