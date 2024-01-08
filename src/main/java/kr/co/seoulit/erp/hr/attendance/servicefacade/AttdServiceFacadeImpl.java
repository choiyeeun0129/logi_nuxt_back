package kr.co.seoulit.erp.hr.attendance.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import kr.co.seoulit.erp.hr.attendance.applicationservice.AttdApplicationService;
import kr.co.seoulit.erp.hr.attendance.to.DayAttdMgtTO;
import kr.co.seoulit.erp.hr.attendance.to.DayAttdTO;
import kr.co.seoulit.erp.hr.attendance.to.MonthAttdMgtTO;
import kr.co.seoulit.erp.hr.attendance.to.RestAttdTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;

@Service
public class AttdServiceFacadeImpl implements AttdServiceFacade{
@Autowired   
private AttdApplicationService attdApplicationService;

@Override
public void findAnnualVacationMgtList(ModelMap modelMap) {
	attdApplicationService.findAnnualVacationMgtList(modelMap);
}

@Override
public void modifyAnnualVacationMgtList(ModelMap modelMap) {
	// TODO Auto-generated method stub
	attdApplicationService.modifyAnnualVacationMgtList(modelMap);
}
	@Override
	public ArrayList<DayAttdTO> findDayAttdList(String empCode, String applyDay) {
		ArrayList<DayAttdTO> dayAttdList=attdApplicationService.findDayAttdList(empCode, applyDay);
			return dayAttdList;
		}
	
	@Override  
	public HashMap<String,Object> registDayAttd(DayAttdTO dayAttd) {
			return attdApplicationService.registDayAttd(dayAttd);
			
		}
	@Override
	public ArrayList<RestAttdTO> findRestAttdList(String empCode, String startDate, String endDate, String code) {
			ArrayList<RestAttdTO> restAttdList = attdApplicationService.findRestAttdList(empCode, startDate, endDate, code);
			return restAttdList;	
		}
	@Override
	public ArrayList<RestAttdTO> findRestAttdListByDept(HashMap<String,String> attdApplMap) {
			ArrayList<RestAttdTO> restAttdList = attdApplicationService.findRestAttdListByDept(attdApplMap);
			return restAttdList;
		}

	@Override
	public ArrayList<RestAttdTO> findRestAttdListByToday(String empCode, String toDay) {
			ArrayList<RestAttdTO> restAttdList = attdApplicationService.findRestAttdListByToday(empCode,toDay);
			return restAttdList;
		}

	@Override
	public void registRestAttd(RestAttdTO restAttd) {
			
		attdApplicationService.registRestAttd(restAttd);
		}
 
	@Override
	public ArrayList<DayAttdMgtTO> findDayAttdMgtList(String applyDay) {
			ArrayList<DayAttdMgtTO> dayAttdMgtList = attdApplicationService.findDayAttdMgtList(applyDay);
			return dayAttdMgtList;
		}
	@Override
	public void modifyDayAttdMgtList(ArrayList<DayAttdMgtTO> dayAttdMgtList) {
			attdApplicationService.modifyDayAttdMgtList(dayAttdMgtList);
		}
	@Override
	public ArrayList<MonthAttdMgtTO> findMonthAttdMgtList(String applyYearMonth) {
		
			return attdApplicationService.findMonthAttdMgtList(applyYearMonth);
		}
	@Override
	public void modifyMonthAttdMgtList(ArrayList<MonthAttdMgtTO> monthAttdMgtList) {
			attdApplicationService.modifyMonthAttdMgtList(monthAttdMgtList);
		}
	@Override
	public void insertDayAttd(DayAttdTO dayAttd) {
			attdApplicationService.insertDayAttd(dayAttd);
	
		}
	
	   @Override  ///占쎈쐻占쎈뼢�뇡�빘�굲
	   public ArrayList<DayAttdMgtTO> findDayAttdMgtListAll(HashMap<String, Object> map) {
	      // TODO Auto-generated method stub
	      return attdApplicationService.findDayAttdMgtListAll(map);
	   }

	   @Override   ///占쎈쐻占쎈뼢�뇡�빘�굲
	   public ArrayList<DayAttdMgtTO> dayDeadlineRegister(HashMap<String, Object> map) {
	      // TODO Auto-generated method stub
	      
	      return attdApplicationService.dayDeadlineRegister(map);
	   }

	@Override
	  public HashMap<String, Object> findDayAttdMgtList(HashMap<String,Object> map) {
		
		HashMap<String, Object> result = attdApplicationService.findDayAttdMgtList(map);
		return result;
	      }

	@Override
	public void dayDeadlineCancel(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		attdApplicationService.dayDeadlineCancel(map);
	}

	@Override
	public ArrayList<HrDetailCodeTO> searchRestAttendanceType() {
		// TODO Auto-generated method stub
		return attdApplicationService.searchRestAttendanceType();
	}
	
	//�뜝�럩�궨�뜝�럩寃� �뜝�럩逾у윜諭��닗繹먲옙 �뼨轅명�▽빳�맠占쎄퀗�э옙�뤂 �뜝�럡�뀭�뜝�럩�젷
	@Override
	public void deleteDayAttd(ArrayList<DayAttdTO> dayAttdData) {
			attdApplicationService.deleteDayAttd(dayAttdData);
	}
	//********************* �뇦猿됲�ｏ옙�젷�뜝�럥諭잌뜝�럩逾ο옙苑닷뜝�뜾逾녑뜝占� �뜝�럩�꼪�뜝�럩�젧 2020-09-20  �뜝�럩�궨�뜝�럩寃� *********************
	@Override
	public ArrayList<RestAttdTO> modifyRestAttdList(List<RestAttdTO> restAttdTo, String deptCode, String startDate, String endDate) { 
		ArrayList<RestAttdTO> restAttdList  = attdApplicationService.modifyRestAttdList(restAttdTo,deptCode,startDate,endDate);
		
		return restAttdList;
	}
	
}
