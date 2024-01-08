package kr.co.seoulit.erp.hr.attendance.servicefacade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.hr.attendance.applicationservice.CorporateEduApplicationService;
import kr.co.seoulit.erp.hr.attendance.to.CorporateEduTO;

@Service
public class CorporateEduServiceFacadeImpl implements CorporateEduServiceFacade {
	@Autowired
	private CorporateEduApplicationService corporateEduApplicationService;
	
	public CorporateEduTO getClass(String classCode) {
		return corporateEduApplicationService.getClass(classCode);
	}

	public List<CorporateEduTO> getClassList(){
		return corporateEduApplicationService.getClassList();
	}
	
	public void modifyClass(CorporateEduTO classData) {
		corporateEduApplicationService.modifyClass(classData);
	}
	
	public void removeClass(String classCode) {
		corporateEduApplicationService.removeClass(classCode);
	}

	public void addClass(CorporateEduTO classData) {
		System.out.println("sf시작");
		corporateEduApplicationService.addClass(classData);
		System.out.println("sf끝");
	}
	
}

