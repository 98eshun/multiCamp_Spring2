package chap11.model;

public class MemberPrinter {

	public void print(Member member) {
		System.out.printf(" �쉶�썝 �젙蹂�: �븘�씠�뵒=%d\t�씠硫붿씪=%s\t�씠由�=%s\t�벑濡앹씪=%tF\n",
				member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
	}
	
	public String print(Member member, String result) {
		result += member.getId() + member.getEmail() + member.getName() + member.getRegisterDateTime();
		return result;
	}
}
