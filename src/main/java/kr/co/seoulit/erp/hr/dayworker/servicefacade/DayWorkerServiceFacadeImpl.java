package kr.co.seoulit.erp.hr.dayworker.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.hr.dayworker.applicationservice.DayWorkerApplicationService;
import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerSalaryTO;
import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerTO;

@Service
public class DayWorkerServiceFacadeImpl implements DayWorkerServiceFacade{
	
	@Autowired   
	private DayWorkerApplicationService dayWorkerApplicationService;
	
	
	@Override
	public void insertDayWorker(DayWorkerTO dayworker) {
		// TODO Auto-generated method stub
		dayWorkerApplicationService.insertDayWorker(dayworker);
	}
	
	@Override
	public ArrayList<DayWorkerTO> findDayWorkerList(String empCode, String empName) {
		// TODO Auto-generated method stub
		dayWorkerApplicationService.findDayWorkerList(empCode, empName);
		return findDayWorkerList(empCode, empName);
	}
	
	@Override
	public void deleteDayWorker(ArrayList<DayWorkerTO> dayworkerDelData) {
		// TODO Auto-generated method stub
		dayWorkerApplicationService.deleteDayWorker(dayworkerDelData);
	}
	
	@Override
	public ArrayList<DayWorkerSalaryTO> findDayWorkerSalaryList(String empCode, String empName) {
		// TODO Auto-generated method stub
		dayWorkerApplicationService.findDayWorkerSalaryList(empCode, empName);
		return findDayWorkerSalaryList(empCode, empName);
	}
	
	@Override
	public void batchInsertDayWorkerSalary(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		dayWorkerApplicationService.batchInsertDayWorkerSalary(map);
	}
	
	@Override
	public void batchInsertMonthWorkerSalary(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		dayWorkerApplicationService.batchInsertMonthWorkerSalary(map);
	}
}

