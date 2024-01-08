package kr.co.seoulit.erp.hr.attendance.servicefacade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.hr.attendance.applicationservice.EduAttendeeApplicationService;
import kr.co.seoulit.erp.hr.attendance.to.EduAttendeeTO;

@Service
public class EduAttendeeServiceFacadeImpl implements EduAttendeeServiceFacade {
	@Autowired
	public EduAttendeeApplicationService eduAttendeeApplicationService;
	
	public List<EduAttendeeTO> getAttendeeAll(){
		List<EduAttendeeTO> list=eduAttendeeApplicationService.getAttendeeAll(); 
		return list;
	}
	
	
	public List<EduAttendeeTO> getAttendeeList(String classCode){
		List<EduAttendeeTO> list=eduAttendeeApplicationService.getAttendeeList(classCode); 
		return list;
	}
	
	public EduAttendeeTO getAttendee(String empNo){
		EduAttendeeTO attendee=eduAttendeeApplicationService.getAttendee(empNo);
		return attendee;
	}
	
	public void addAttendee(EduAttendeeTO to){
		eduAttendeeApplicationService.addAttendee(to);
	}
	
	public void removeAttendee(String empNo, String classCode){
		eduAttendeeApplicationService.removeAttendee(empNo, classCode);
	}
	
	public void modifyAttendee(EduAttendeeTO to){
		eduAttendeeApplicationService.modifyAttendee(to);
	}
}
