package kr.co.seoulit.erp.hr.attendance.applicationservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.hr.attendance.dao.EduAttendeeDAO;
import kr.co.seoulit.erp.hr.attendance.to.EduAttendeeTO;

@Component
public class EduAttendeeApplicationServiceImpl implements EduAttendeeApplicationService{
	@Autowired
	private EduAttendeeDAO eduAttendeeDAO;
	
	public List<EduAttendeeTO> getAttendeeAll(){
		List<EduAttendeeTO> list=eduAttendeeDAO.selectAttendeeAll();
		return list;
	}
	
	public List<EduAttendeeTO> getAttendeeList(String classCode){
		List<EduAttendeeTO> list=eduAttendeeDAO.selectAttendeeList(classCode);
		return list;
	}
	
	public EduAttendeeTO getAttendee(String empNo) {
		EduAttendeeTO attendee=eduAttendeeDAO.selectAttendee(empNo);
		return attendee;
	}
	
	public void addAttendee(EduAttendeeTO to) {
		eduAttendeeDAO.insertAttendee(to);
	}
	
	public void removeAttendee(String empNo, String classCode) {
		eduAttendeeDAO.deleteAttendee(empNo, classCode);
	}
	
	public void modifyAttendee(EduAttendeeTO to) {
		eduAttendeeDAO.updateAttendee(to);
	}
}
