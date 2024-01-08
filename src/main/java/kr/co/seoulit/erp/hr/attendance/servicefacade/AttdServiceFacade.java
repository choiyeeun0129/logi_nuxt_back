package kr.co.seoulit.erp.hr.attendance.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.ui.ModelMap;

import kr.co.seoulit.erp.hr.attendance.to.DayAttdMgtTO;
import kr.co.seoulit.erp.hr.attendance.to.DayAttdTO;
import kr.co.seoulit.erp.hr.attendance.to.MonthAttdMgtTO;
import kr.co.seoulit.erp.hr.attendance.to.RestAttdTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;

public interface AttdServiceFacade {
	
	public void findAnnualVacationMgtList(ModelMap modelMap);

	public void modifyAnnualVacationMgtList(ModelMap modelMap);
	
	public ArrayList<DayAttdTO> findDayAttdList(String empCode, String applyDay);

	public HashMap<String, Object> registDayAttd(DayAttdTO dayAttd);

	public void insertDayAttd(DayAttdTO dayAttd); // test

	public ArrayList<RestAttdTO> findRestAttdList(String empCode, String startDate, String endDate, String code);

	public ArrayList<RestAttdTO> findRestAttdListByDept(HashMap<String, String> attdApplMap);

	public ArrayList<RestAttdTO> findRestAttdListByToday(String empCode, String toDay);

	public void registRestAttd(RestAttdTO restAttd);

	public ArrayList<DayAttdMgtTO> findDayAttdMgtList(String applyDay);

	public void modifyDayAttdMgtList(ArrayList<DayAttdMgtTO> dayAttdMgtList);

	public ArrayList<MonthAttdMgtTO> findMonthAttdMgtList(String applyYearMonth);

	public void modifyMonthAttdMgtList(ArrayList<MonthAttdMgtTO> monthAttdMgtList);

	public HashMap<String, Object> findDayAttdMgtList(HashMap<String, Object> map);// 占쎈쐻占쎈뼢�뇡�빘�굲

	public ArrayList<DayAttdMgtTO> findDayAttdMgtListAll(HashMap<String, Object> map);// 占쎈쐻占쎈뼢�뇡�빘�굲

	public ArrayList<DayAttdMgtTO> dayDeadlineRegister(HashMap<String, Object> map);// 占쎈쐻占쎈뼢�뇡�빘�굲

	public void dayDeadlineCancel(HashMap<String, Object> map);

	public ArrayList<HrDetailCodeTO> searchRestAttendanceType();

	public void deleteDayAttd(ArrayList<DayAttdTO> dayAttdData);

	public ArrayList<RestAttdTO> modifyRestAttdList(List<RestAttdTO> restAttdTo, String deptCode, String startDate,
			String endDate); // 2020-09-20 �뜝�럩�궨�뜝�럩寃� �뇦猿됲�ｏ옙�궨�뜝�럥諭잌뜝�럩逾ο옙苑닷뜝�뜾逾녑뜝占� �뜝�럥�빢�뜝�럩�젧

}
