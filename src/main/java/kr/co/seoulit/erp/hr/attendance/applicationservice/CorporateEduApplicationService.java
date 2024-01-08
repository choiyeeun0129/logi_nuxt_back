package kr.co.seoulit.erp.hr.attendance.applicationservice;

import java.util.List;

import kr.co.seoulit.erp.hr.attendance.to.CorporateEduTO;

public interface CorporateEduApplicationService {
	public List<CorporateEduTO> getClassList();
	
	public CorporateEduTO getClass(String classCode); 
		
	public void addClass(CorporateEduTO classData);
	
	public void removeClass(String classCode);
	
	public void modifyClass(CorporateEduTO classData);
}
