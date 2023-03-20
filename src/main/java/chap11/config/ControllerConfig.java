package chap11.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 컨트롤러 설정

import chap11.controller.RegisterController;
import chap11.model.MemberRegisterService;
@Configuration


public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegisterService;
	
	@Bean
	public RegisterController registerController() {
		RegisterController rc = new RegisterController();
		rc.setMemberRegisterService(memberRegisterService);	//의존주입
		
		return rc;
	}
}
