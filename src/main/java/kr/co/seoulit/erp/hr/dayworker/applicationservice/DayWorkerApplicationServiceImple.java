package kr.co.seoulit.erp.hr.dayworker.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.hr.dayworker.dao.DayWorkerDAO;
import kr.co.seoulit.erp.hr.dayworker.dao.DayWorkerSalaryDAO;
import kr.co.seoulit.erp.hr.dayworker.repository.DayWorkerRepository;
import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerSalaryTO;
import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerTO;
@Component
public class DayWorkerApplicationServiceImple implements DayWorkerApplicationService{
	@Autowired
	private DayWorkerDAO dayWorkerDAO;
	@Autowired
	private DayWorkerSalaryDAO dayWorkerSalaryDAO;
	@Autowired
	private DayWorkerRepository dayWorkerRepository;
	@Override
	public void insertDayWorker(DayWorkerTO dayworker) {
		// TODO Auto-generated method stub
		dayWorkerDAO.insertDayWorker(dayworker);
	}
	@Override
	public ArrayList<DayWorkerTO> findDayWorkerList(String empCode, String empName) {
		// TODO Auto-generated method stub
		List<DayWorkerTO> dayWorkerList = dayWorkerRepository.findByEmpCodeAndEmpName(empCode,empName);
		System.out.println("dayWorkerListdayWorkerListdayWorkerList"+dayWorkerList);
		return new ArrayList<>(dayWorkerList);
	}
	@Override
	public void deleteDayWorker(ArrayList<DayWorkerTO> dayworkerDelData) {
		// TODO Auto-generated method stub
		System.out.println("ApplicationService"+dayworkerDelData);
		
		for(DayWorkerTO dayworker : dayworkerDelData) {
			System.out.println(dayworker);
			dayWorkerDAO.deleteDayWorker(dayworker);
			}
	}
	
	////////////////////일/월급여 계산하기 및 조회하기//////////////////////////////////////////////
	
	@Override
	public ArrayList<DayWorkerSalaryTO> findDayWorkerSalaryList(String empCode, String empName) {
		// TODO Auto-generated method stub
		ArrayList<DayWorkerSalaryTO> dayWorkerSalaryList = dayWorkerSalaryDAO.selectDayWorkerSalaryList(empCode, empName);
		
		return dayWorkerSalaryList;
	}
	
	@Override
	public void batchInsertDayWorkerSalary(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		dayWorkerSalaryDAO.batchInsertDayWorkerSalary(map);
	}
	
	@Override
	public void batchInsertMonthWorkerSalary(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		dayWorkerSalaryDAO.batchInsertMonthWorkerSalary(map);
	}
	
}
