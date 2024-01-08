package kr.co.seoulit.erp.hr.attendance.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.ui.ModelMap;

import kr.co.seoulit.erp.hr.attendance.to.DayAttdMgtTO;
import kr.co.seoulit.erp.hr.attendance.to.DayAttdTO;
import kr.co.seoulit.erp.hr.attendance.to.MonthAttdMgtTO;
import kr.co.seoulit.erp.hr.attendance.to.RestAttdTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;

public interface AttdApplicationService {
	
	public ArrayList<DayAttdTO> findDayAttdList(String empCode, String applyDay);
	public HashMap<String,Object> registDayAttd(DayAttdTO dayAttd);
//	public void removeDayAttdList(HashMap<String, String> params);  
	public void insertDayAttd(DayAttdTO dayAttd); //test
	public ArrayList<DayAttdMgtTO> findDayAttdMgtList(String applyDay);
	public void modifyDayAttdMgtList(ArrayList<DayAttdMgtTO> dayAttdMgtList);
	public ArrayList<MonthAttdMgtTO> findMonthAttdMgtList(String applyYearMonth);
	public void modifyMonthAttdMgtList(ArrayList<MonthAttdMgtTO> monthAttdMgtList);
	
	public ArrayList<RestAttdTO> findRestAttdList(String empCode, String startDate, String endDate, String code);
	public ArrayList<RestAttdTO> findRestAttdListByDept(HashMap<String,String> attdApplMap);
	public ArrayList<RestAttdTO> findRestAttdListByToday(String empCode, String toDay);
	public void registRestAttd(RestAttdTO restAttd); 
//   public void removeRestAttdList(ArrayList<RestAttdTO> restAttdList);
	   public ArrayList<DayAttdMgtTO> findDayAttdMgtListAll(HashMap<String, Object> map);//�뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥堉�占쎈눀占쎈튂占쎄뎡
	   public ArrayList<DayAttdMgtTO> dayDeadlineRegister(HashMap<String, Object> map);//�뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥堉�占쎈눀占쎈튂占쎄뎡
	   public HashMap<String, Object> findDayAttdMgtList(HashMap<String, Object> map); //�뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥堉�占쎈눀占쎈튂占쎄뎡
	public void dayDeadlineCancel(HashMap<String, Object> map);//�뜝�럥�맶�뜝�럥堉�占쎈눀占쎈튂占쎄뎡
	public ArrayList<HrDetailCodeTO> searchRestAttendanceType();//�뜝�럥�맶�뜝�럥堉�占쎈눀占쎈튂占쎄뎡
	public void deleteDayAttd(ArrayList<DayAttdTO> dayAttdData); 
	
	public ArrayList<RestAttdTO> modifyRestAttdList(List<RestAttdTO> restAttdTo, String deptCode, String startDate, String endDate); //�뇦猿됲�ｏ옙�젷�뜝�럥諭잌뜝�럩逾ο옙苑닷뜝�뜾逾녑뜝占� 2020-09-20 �뜝�럩�궨�뜝�럩寃�

	//
	 public void findAnnualVacationMgtList(ModelMap modelMap);
	 public void modifyAnnualVacationMgtList(ModelMap modelMap);
	 
}
