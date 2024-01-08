package kr.co.seoulit.erp.hr.affair.servicefacade;

import kr.co.seoulit.erp.hr.affair.applicationservice.EmpApplicationService;
import kr.co.seoulit.erp.hr.affair.to.*;
import kr.co.seoulit.erp.hr.base.to.DeptTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmpServiceFacadeImpl implements EmpServiceFacade {
	@Autowired
	private EmpApplicationService empApplicationService;

	@Override
	public ArrayList<EmployeeDetailTO> findEmpDetail(String empCode){
		return empApplicationService.findEmpDetail(empCode);
	}

	@Override
	public EmpTO getEmp(String name) {
		// TODO Auto-generated method stub
		EmpTO empto = null;
		empto = empApplicationService.selectEmp(name);
		return empto;
	}

	@Override
	public String findLastEmpCode() { //
		String empCode = empApplicationService.findLastEmpCode();
		return empCode;
	}

	@Override
	public void registEmployee(RegistEMPTO emp) {
		empApplicationService.registEmployee(emp);
	}

	@Override
	public List<EmpTO> findEmpList(String dept) {
		ArrayList<EmpTO> empList = empApplicationService.findEmployeeListByDept(dept);
		return empList;
	}

	public List<EmpTO> findEmpMemberList(String dept) {
		ArrayList<EmpTO> empList = empApplicationService.findEmpMemberListByDept(dept);
		return empList;
	}

	@Override
	public ArrayList<EmpTO> findAllEmpInfo(HashMap<String, String> map) {

		ArrayList<EmpTO> empDetailedList = null;
		try {
			System.out.println("=============================EmpServiceFacadeImpl===================================");

			empDetailedList = empApplicationService.findAllEmpInfo(map);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}

		return empDetailedList;

	}

	/*
	 * @Override public void modifyEmployee(EmpTO emp) {
	 * empApplicationService.modifyEmployee(emp); }
	 */
	@Override
	public void deleteEmpList(ArrayList<EmpTO> empList) {
		empApplicationService.deleteEmpList(empList);
	}

	@Override
	public ArrayList<DeptTO> findDeptList() {
		ArrayList<DeptTO> deptList = empApplicationService.findDeptList();
		return deptList;
	}

	@Override
	public void empInfoUpdate(Map<String, ArrayList<EmpTO>> empArray) {

		System.out.println("=============================EmpServiceFacadeImpl===================================");
		empApplicationService.empInfoUpdate(empArray);

	}

	@Override
	public void updateEmpInfo(EmpUpdateTO emp){
		empApplicationService.updateEmpInfo(emp);
	}

	// 은비 사원 기본정보 조회
	@Override
	public ArrayList<EmployeeBasicTO> getEmpBasicInfo(String empCode) {

		ArrayList<EmployeeBasicTO> basicInfoList = null;

		try {

			basicInfoList = empApplicationService.getEmpBasicInfo(empCode);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}

		return basicInfoList;
	}

	@Override
	public List<EmpTO> findEmpList() {
		// TODO Auto-generated method stub
		ArrayList<EmpTO> empList = empApplicationService.findEmpList();
		return empList;
	}

	@Override
	public void addAssignInfo(HashMap<String, String> map) {
		empApplicationService.insertAssign(map);

	}

	@Override
	public ArrayList<AssignEmpTO> findAssignList(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return empApplicationService.getAssignList(startDate, endDate);

	}

	@Override
	public void updateDeptCode(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		empApplicationService.updateDeptCode(map);

	}

	// 범석 best 사원 뽑기
	@Override
	public ArrayList<BestEmpTO> bestEmp() {

		System.out.println("facade");
		ArrayList<BestEmpTO> bastEmp = null;
		bastEmp = empApplicationService.getBestEmp();

		return bastEmp;

	}

}