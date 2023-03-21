package chap11.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// 스프링의 mvc 설정
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();	// 정적인 자료들을 보여줌
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		// http://localhost:8080/mySpringWeb/main
		registry.addViewController("/main").setViewName("main");
		// http://localhost:8080/mySpringWeb/register/step1
		registry.addViewController("/register/step1").setViewName("/register/step1");
		// http://localhost:8080/mySpringWeb/member/login
		registry.addViewController("/member/login").setViewName("/member/login");
		// http://localhost:8080/mySpringWeb/member/findMember
		registry.addViewController("/member/findMember").setViewName("/member/findMember");
		// http://localhost:8080/mySpringWeb/member/findMember
		registry.addViewController("/member/changePasswd").setViewName("/member/changePasswd");
					
		
	}
}
