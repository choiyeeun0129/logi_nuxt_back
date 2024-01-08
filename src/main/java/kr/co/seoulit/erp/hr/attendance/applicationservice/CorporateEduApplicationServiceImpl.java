package kr.co.seoulit.erp.hr.attendance.applicationservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.hr.attendance.dao.CorporateEduDAO;
import kr.co.seoulit.erp.hr.attendance.to.CorporateEduTO;;

@Component
public class CorporateEduApplicationServiceImpl implements CorporateEduApplicationService{
	@Autowired
	private CorporateEduDAO corporateEduDAO;
	
	public List<CorporateEduTO> getClassList(){
		List<CorporateEduTO> list = corporateEduDAO.selectClassList();
		return list;
	}
	
	public CorporateEduTO getClass(String classCode){
		return corporateEduDAO.selectClass(classCode);
	}
	
	public void addClass(CorporateEduTO classData){
		System.out.println("as시작");
		corporateEduDAO.insertClass(classData);
		System.out.println("as끝");
	}
	
	public void removeClass(String classCode){
		corporateEduDAO.deleteClass(classCode);
	}
	
	public void modifyClass(CorporateEduTO classData){
		corporateEduDAO.updateClass(classData);
	}
}
