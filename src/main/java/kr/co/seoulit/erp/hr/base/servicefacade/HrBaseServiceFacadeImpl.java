package kr.co.seoulit.erp.hr.base.servicefacade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.hr.base.applicationservice.BaseApplicationService;
import kr.co.seoulit.erp.hr.base.to.HrCodeTO;
import kr.co.seoulit.erp.hr.base.to.BaseWorkTimeTO;
import kr.co.seoulit.erp.hr.base.to.DeptTO;
import kr.co.seoulit.erp.hr.base.to.HrDetailCodeTO;
import kr.co.seoulit.erp.hr.base.to.HolidayTO;
import kr.co.seoulit.erp.hr.base.to.ReportTO;
import kr.co.seoulit.erp.hr.affair.applicationservice.EmpApplicationService;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;

@Service
public class HrBaseServiceFacadeImpl implements HrBaseServiceFacade {

	@Autowired
	private BaseApplicationService baseApplicationService ;
	@Autowired
	private EmpApplicationService empApplicationService ;
	

	@Override
	public ArrayList<HrDetailCodeTO> findDetailCodeList(String codetype) {
		// TODO Auto-generated method stub		
		ArrayList<HrDetailCodeTO> detailCodeto = baseApplicationService.findDetailCodeList(codetype);		
		return detailCodeto;
	}

	@Override
	public ArrayList<HrDetailCodeTO> findDetailCodeListRest(String code1, String code2, String code3) {
		// TODO Auto-generated method stub		
		ArrayList<HrDetailCodeTO> detailCodeto = baseApplicationService.findDetailCodeListRest(code1, code2, code3);
		return detailCodeto;
	}

	@Override
	public ArrayList<HolidayTO> findHolidayList() {
		// TODO Auto-generated method stub		
		try {
			ArrayList<HolidayTO> holidayList = baseApplicationService.findHolidayList();
			return holidayList;
		} catch (DataAccessException e) {
				
			throw e;
		} finally {
			
		}
	}

	@Override
	public String findWeekDayCount(String startDate, String endDate) {
		// TODO Auto-generated method stub
		try {
			String weekdayCount = baseApplicationService.findWeekDayCount(startDate, endDate);
			return weekdayCount;
		} catch (DataAccessException e) {
					
			throw e;
		} finally {
			
		}
	}

	@Override
	public void registEmpImg(String empCode, String imgExtend) {
		// TODO Auto-generated method stub
		try {
			baseApplicationService.registEmpImg(empCode, imgExtend);
			
		} catch (DataAccessException e) {
			
				throw e;
		} finally {
			
		}
	}

	@Override
	public void batchDeptProcess(ArrayList<DeptTO> deptto) {
		// TODO Auto-generated method stub
		try {
			baseApplicationService.batchDeptProcess(deptto);
			
		} catch (DataAccessException e) {
			
			throw e;
		} finally {
			
		}
	}

	@Override
	public ArrayList<BaseSalaryTO> findPositionList() {
		// TODO Auto-generated method stub
		ArrayList<BaseSalaryTO> positionList = empApplicationService.selectPositionList();

		return positionList;
	}

	@Override
	public void modifyPosition(ArrayList<BaseSalaryTO> positionList) {
		// TODO Auto-generated method stub
		try {
			baseApplicationService.modifyPosition(positionList);
		} catch (DataAccessException e) {
			throw e;
		} finally {
			
		}
	}

	@Override
	public ArrayList<HrCodeTO> findCodeList() {
		// TODO Auto-generated method stub
		ArrayList<HrCodeTO> codeto = baseApplicationService.findCodeList();
		return codeto;
	}

	@Override
	public void registCodeList(List<HolidayTO> holyday) {
		// TODO Auto-generated method stub
		try {
			baseApplicationService.registCodeList(holyday);
			
	
		} catch (DataAccessException e) {
				
			throw e;
		} finally {
			
		}
	}
	

	

	@Override
	   public ReportTO viewReport(String empCode) {             
	       ReportTO to=null;
	       try {
	            to=baseApplicationService.viewReport(empCode);
	         //   dataSourceTransactionManager.commitTransaction();
	         } catch (DataAccessException e) {
	           throw e;
	         } finally {
	            
	         }
	          return to;
	   }

	@Override
	public ArrayList<BaseWorkTimeTO> searchBaseWorkTimeList() {
		
		return baseApplicationService.searchBaseWorkTimeList();
	}

	@Override
	public void deleteBaseWorkTimeList(List<BaseWorkTimeTO> list) {

		baseApplicationService.deleteBaseWorkTime(list);
		
	}

	@Override
	public void batchBaseWorkTimeList(List<BaseWorkTimeTO> list) {
		baseApplicationService.batchBaseWorkTime(list);
		
	}



}