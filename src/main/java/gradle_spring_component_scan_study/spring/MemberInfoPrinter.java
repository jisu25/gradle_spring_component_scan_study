package gradle_spring_component_scan_study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("infoPrinter")
public class MemberInfoPrinter {

	private MemberDao memDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if(member == null) {
			System.out.println("데이터 없음");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	// 이름이 다르면 타입을 보고 넣어준다
	@Autowired
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
}
