package kr.co.seoulit.erp.hr.base.applicationservice;

import java.util.ArrayList;
import java.util.List;
import kr.co.seoulit.erp.hr.base.to.HrCodeTO;
import kr.co.seoulit.erp.hr.base.to.BaseWorkTimeTO;
import kr.co.seoulit.erp.hr.base.to.DeptTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;
import kr.co.seoulit.erp.hr.base.to.HolidayTO;
import kr.co.seoulit.erp.hr.base.to.ReportTO;
import kr.co.seoulit.erp.hr.affair.to.EmpTO;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;


public interface BaseApplicationService {

   public ArrayList<HrDetailCodeTO> findDetailCodeList(String codetype);
   public ArrayList<HrDetailCodeTO> findDetailCodeListRest(String code1, String code2, String code3);

   public ArrayList<HolidayTO> findHolidayList();
   public String findWeekDayCount(String startDate, String endDate);

   public void registEmpImg(String empCode, String imgExtend);

   public void batchDeptProcess(ArrayList<DeptTO> deptto);
   public void modifyPosition(ArrayList<BaseSalaryTO> positionList);
   
   public void registEmpCode(EmpTO emp);
   public void deleteEmpCode(EmpTO emp);

   public ArrayList<HrCodeTO> findCodeList();

   public void registCodeList(List<HolidayTO> holyday);

   public ReportTO viewReport(String empCode);
	public ArrayList<BaseWorkTimeTO> searchBaseWorkTimeList();
	public void deleteBaseWorkTime(List<BaseWorkTimeTO> list);
	public void batchBaseWorkTime(List<BaseWorkTimeTO> list);
	
	
}