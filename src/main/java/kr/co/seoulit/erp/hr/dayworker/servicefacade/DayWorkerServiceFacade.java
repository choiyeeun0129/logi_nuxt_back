package kr.co.seoulit.erp.hr.dayworker.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerSalaryTO;
import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerTO;


public interface DayWorkerServiceFacade {
	public ArrayList<DayWorkerTO> findDayWorkerList(String empCode, String empName); 
	public void insertDayWorker(DayWorkerTO dayworker);
	public void deleteDayWorker(ArrayList<DayWorkerTO> elasticDelData);

	public ArrayList<DayWorkerSalaryTO> findDayWorkerSalaryList(String empCode, String empName);
	public void batchInsertDayWorkerSalary(HashMap<String, Object> map);
	public void batchInsertMonthWorkerSalary(HashMap<String, Object> map);
}
