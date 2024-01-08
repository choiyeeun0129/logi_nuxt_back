package kr.co.seoulit.erp.hr.base.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.hr.base.dao.HrCodeDAO;
import kr.co.seoulit.erp.hr.base.dao.BaseWorkTimeDAO;
import kr.co.seoulit.erp.hr.base.dao.DeptDAO;
import kr.co.seoulit.erp.hr.base.dao.HrDetailCodeDAO;
import kr.co.seoulit.erp.hr.base.dao.HolidayDAO;
import kr.co.seoulit.erp.hr.base.dao.ReportDAO;
import kr.co.seoulit.erp.hr.base.to.HrCodeTO;
import kr.co.seoulit.erp.hr.base.to.BaseWorkTimeTO;
import kr.co.seoulit.erp.hr.base.to.DeptTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;
import kr.co.seoulit.erp.hr.base.to.HolidayTO;
import kr.co.seoulit.erp.hr.base.to.ReportTO;
import kr.co.seoulit.erp.hr.affair.applicationservice.EmpApplicationService;
import kr.co.seoulit.erp.hr.affair.to.EmpTO;
import kr.co.seoulit.erp.hr.salary.dao.BaseSalaryDAO;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;

@Component
public class BaseApplicationServiceImpl implements BaseApplicationService {
      
      
   @Autowired
      EmpApplicationService empApplicationService ;   
      @Autowired
      private HrDetailCodeDAO detailCodeDAO ;
      @Autowired
      private HolidayDAO holidayDAO ;
      @Autowired
      private DeptDAO deptDAO ;
      @Autowired
      private BaseSalaryDAO baseSalaryDAO ;
      @Autowired
      private HrCodeDAO codeDAO ;
      @Autowired
      private ReportDAO reportDAO ;
      @Autowired
      private BaseWorkTimeDAO baseWorkTimeDAO;
   

      @Override
      public ArrayList<HrDetailCodeTO> findDetailCodeList(String codetype) {
         // TODO Auto-generated method stub
         
         ArrayList<HrDetailCodeTO> detailCodeList = null;
         detailCodeList = detailCodeDAO.selectDetailCodeList(codetype);
         
         return detailCodeList;
      }
      
      @Override
      public void registEmpCode(EmpTO emp) {
         // TODO Auto-generated method stub      
         HrDetailCodeTO detailCodeto = new HrDetailCodeTO();
         detailCodeto.setDetailCodeNumber(emp.getEmpCode());
         detailCodeto.setDetailCodeName(emp.getEmpName());
         detailCodeto.setCodeNumber("CO-17");
         detailCodeto.setDetailCodeNameusing("N");
         detailCodeDAO.registDetailCode(detailCodeto);   
      }

      @Override
      public void deleteEmpCode(EmpTO emp) {
         // TODO Auto-generated method stub      
         HrDetailCodeTO detailCodeto = new HrDetailCodeTO();
         detailCodeto.setDetailCodeNumber(emp.getEmpCode());
         detailCodeto.setDetailCodeName(emp.getEmpName());
         detailCodeDAO.deleteDetailCode(detailCodeto);
      }

      @Override
      public ArrayList<HrDetailCodeTO> findDetailCodeListRest(String code1, String code2, String code3) {
         // TODO Auto-generated method stub
         
         ArrayList<HrDetailCodeTO> detailCodeList = null;
         detailCodeList = detailCodeDAO.selectDetailCodeListRest(code1, code2, code3);
         
         return detailCodeList;
      }

      @Override
      public ArrayList<HolidayTO> findHolidayList() {
         // TODO Auto-generated method stub
         ArrayList<HolidayTO> holidayList = holidayDAO.selectHolidayList();
         
         return holidayList;
      }

      @Override
      public void batchDeptProcess(ArrayList<DeptTO> deptto) {
         // TODO Auto-generated method stub      
         HrDetailCodeTO detailCodeto = new HrDetailCodeTO();

         for (DeptTO dept : deptto) {
            switch (dept.getStatus()) {

            case "update":
               deptDAO.updateDept(dept);
               detailCodeto.setDetailCodeNumber(dept.getDeptCode());
               detailCodeto.setDetailCodeName(dept.getDeptName());
               detailCodeto.setCodeNumber("CO-07");
               detailCodeto.setDetailCodeNameusing("Y");
               detailCodeDAO.updateDetailCode(detailCodeto);
               break;

            case "insert":
               deptDAO.registDept(dept);
               detailCodeto.setDetailCodeNumber(dept.getDeptCode());
               detailCodeto.setDetailCodeName(dept.getDeptName());
               detailCodeto.setCodeNumber("CO-07");
               detailCodeto.setDetailCodeNameusing("Y");
               detailCodeDAO.registDetailCode(detailCodeto);
               break;

            case "delete":
               deptDAO.deleteDept(dept);
               detailCodeto.setDetailCodeNumber(dept.getDeptCode());
               detailCodeto.setDetailCodeName(dept.getDeptName());
               detailCodeDAO.deleteDetailCode(detailCodeto);
               break;

            case "normal":
               break;
            }
         }
      }

      @Override
      public void modifyPosition(ArrayList<BaseSalaryTO> positionList) {
         // TODO Auto-generated method stub
    	//****************************************************2020-08-28 63湲� �넀�쑀李� ********************************* **********************
         if (positionList != null && positionList.size() > 0) {
            for (BaseSalaryTO position : positionList) {
               HrDetailCodeTO detailCodeto = new HrDetailCodeTO();
               switch (position.getStatus()) {

               case "update":
                  baseSalaryDAO.updatePosition(position);
                  detailCodeto.setDetailCodeNumber(position.getPositionCode());
                  detailCodeto.setDetailCodeName(position.getPositionName());
                  detailCodeto.setCodeNumber("CO-04");
                  detailCodeto.setDetailCodeNameusing("Y");
                  detailCodeDAO.updateDetailCode(detailCodeto);
                  break;

               case "insert":
                  baseSalaryDAO.insertPosition(position);
                  detailCodeto.setDetailCodeNumber(position.getPositionCode());
                  detailCodeto.setDetailCodeName(position.getPositionName());
                  detailCodeto.setCodeNumber("CO-04");
                  detailCodeto.setDetailCodeNameusing("Y");
                  detailCodeDAO.registDetailCode(detailCodeto);
                  break;

               case "delete":
                  baseSalaryDAO.deletePosition(position);
                  detailCodeto.setDetailCodeNumber(position.getPositionCode());
                  detailCodeto.setDetailCodeName(position.getPositionName());
                  detailCodeDAO.deleteDetailCode(detailCodeto);
                  break;
               }
            }
         }      //****************************************************2020-08-28 63湲� �넀�쑀李� ********************************* **********************
      }

      @Override
      public String findWeekDayCount(String startDate, String endDate) {
         // TODO Auto-generated method stub
         String weekdayCount = holidayDAO.selectWeekDayCount(startDate, endDate);

         return weekdayCount;
      }
   /*
    * @Override public void registEmpImg(String empCode, String company, String
    * workPlace, String position, String empName, String imgExtend) { // TODO
    * Auto-generated method stub EmpTO emp =
    * empApplicationService.findAllEmployeeInfo(
    * company,workPlace,position,empName); if (emp == null) { emp = new EmpTO();
    * emp.setEmpCode(empCode); emp.setStatus("insert"); } else {
    * emp.setStatus("update"); } emp.setImgExtend(imgExtend);
    * empApplicationService.modifyEmployee(emp); }
    */

      @Override
      public ArrayList<HrCodeTO> findCodeList() {
         // TODO Auto-generated method stub
         // TODO Auto-generated method stub
         ArrayList<HrCodeTO> codeList = codeDAO.selectCode();

         return codeList;
      }

      @Override
      public void registCodeList(List<HolidayTO> holyday) {
         // TODO Auto-generated method stub

         for (HolidayTO holiday : holyday) {
            switch (holiday.getStatus()) {

            case "update":
               holidayDAO.updateCodeList(holiday);
               break;
            
            case "insert":
               holidayDAO.insertCodeList(holiday);
               break;

            case "delete":
               holidayDAO.deleteCodeList(holiday);
               break;

            }
         }
      }
      @Override
      public ReportTO viewReport(String empCode) {
               
          ReportTO to=null;

       to=reportDAO.selectReport(empCode);
      
         return to;
      }

	@Override
	public void registEmpImg(String empCode, String imgExtend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BaseWorkTimeTO> searchBaseWorkTimeList() {
		return baseWorkTimeDAO.selectBaseWorkTimeList();
	}

	@Override
	public void deleteBaseWorkTime(List<BaseWorkTimeTO> list) {
		
		HashMap<String,Object> map = new HashMap<>();
		map.put("list", list);
		
		baseWorkTimeDAO.deleteBaseWorkTime(map);
	}

	@Override
	public void batchBaseWorkTime(List<BaseWorkTimeTO> list) {
		
		baseWorkTimeDAO.mergeBaseWorkTime(list);
	}



   }