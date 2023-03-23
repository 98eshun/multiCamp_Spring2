package chap11.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import chap11.model.ChangePasswordService;
import chap11.model.LoginCommand;
import chap11.model.Member;
import chap11.model.MemberDaoSpring;
import chap11.model.MemberPrinter;
import chap11.model.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private ChangePasswordService changePasswordService;
	@Autowired
	private MemberDaoSpring memberDao;
	@Autowired
	private MemberPrinter printer;
	
	
	@PostMapping("/member/loginProcess")
	public String loginPost(LoginCommand login, HttpSession session) {
		String view ="";
		
		if(memberService.checkLoginAuth(login)) {
			Member member = memberService.findMember(login.getEmail());
			login.setName(member.getName());
			login.setPassword("");
			session.setAttribute("auth", login);	// 세션에 로그인 정보 삽입
			view = "redirect:/main";
		}
		else {
			view = "redirect:/member/login";		// 로그인 실패
			session.setAttribute("loginFailMsg", "로그인에 실패했습니다.");	// 세션에 메세지 저장
		}
		return view ;
	}
	
	@PostMapping("/member/findProcess")
	public String findPost(@RequestParam(value="email")String email, Model model) {
		Member member = memberService.findMember(email);
		
			if(member != null) {
				model.addAttribute("member", member);
			}
			else {
				model.addAttribute("memberFindMsg", "이메일을 다시 확인해주세요!");
			}
			
			return "member/findMember";		// get이라도 model이 같이 넘어감
	}
	
	@PostMapping("/member/changePwd")
	public String changePwd(@RequestParam(value="newpasswd")String newpasswd,@RequestParam(value="password")String oldpasswd, HttpSession session) {
		String view="";
		LoginCommand login = (LoginCommand)session.getAttribute("auth");
		if(login != null ) {
			changePasswordService.changePassword(login.getEmail(), oldpasswd, newpasswd);
			view = "redirect:/member/login";
			session.setAttribute("changeErrMsg", "");
		}
		else {
			session.setAttribute("changeErrMsg", "비밀번호를 다시 확인해주세요.");
			view = "/member/changePasswd";
		}
		return view;
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		String view = "";
		
		if(session.getAttribute("auth") != null) {
			session.invalidate();
			view = "redirect:/member/login";
		}
		else {
			view = "redirect:/main";
		}
		return view;
	}
	
	@GetMapping("/memeber/list")
	public String list(Model model) {
		Collection<Member> members = memberService.allMember();
		model.addAttribute("members", members);
		return "/memeber/list";
	}
}
