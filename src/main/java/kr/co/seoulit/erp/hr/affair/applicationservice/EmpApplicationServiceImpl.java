package kr.co.seoulit.erp.hr.affair.applicationservice;

import kr.co.seoulit.erp.hr.affair.dao.*;
import kr.co.seoulit.erp.hr.affair.to.*;
import kr.co.seoulit.erp.hr.base.applicationservice.BaseApplicationService;
import kr.co.seoulit.erp.hr.base.dao.DeptDAO;
import kr.co.seoulit.erp.hr.base.to.DeptTO;
import kr.co.seoulit.erp.hr.salary.applicationservice.SalaryApplicationService;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmpApplicationServiceImpl implements EmpApplicationService {

	@Autowired
	SalaryApplicationService salaryApplicationService;
	@Autowired
	BaseApplicationService baseApplicationService;
	@Autowired
	private EmpDAO empDAO;
	@Autowired
	private DeptDAO deptDAO;
	@Autowired
	private EmployeeBasicDAO employeeBasicDAO;
	@Autowired
	private EmpAssignDAO empAssignDAO;
	@Autowired
	private BestEmpDAO bestEmpDAO;
	@Autowired
	private EmployeeDetailDAO employeeDetailDAO;

	@Override
	public ArrayList<EmployeeDetailTO> findEmpDetail(String empCode){
		return employeeDetailDAO.selectEmployeeDetail(empCode);
	}

	@Override
	public EmpTO selectEmp(String name) {
		EmpTO empto = empDAO.selectEmp(name);
		return empto;
	}

	@Override
	public void updateEmpInfo(EmpUpdateTO emp){
		empDAO.updateEmp(emp);
	}

	@Override
	public String findLastEmpCode() {
		String empCode = empDAO.selectLastEmpCode();
		return empCode;
	}

	@Override
	public void registEmployee(RegistEMPTO emp) {
		System.out.println("프로시저 호출 시작 " + emp);
		empDAO.registEmployee(emp);
		System.out.println("프로시저 호출 끝 ");
		// baseApplicationService.registEmpCode(emp);
	}

	@Override
	public ArrayList<EmpTO> findEmployeeListByDept(String deptName) {
		ArrayList<EmpTO> empList = null;
		// System.out.println("어플리케이션 호출");
		// System.out.println("짤린이름"+deptName.substring(deptName.length()-5));
		if (deptName.equals("전체부서")) {
			System.out.println("1");
			empList = empDAO.selectEmpList();
		} else if (deptName.substring(0, 3).equals("DPT")) {
			System.out.println("2");
			empList = empDAO.selectEmpListD(deptName);
		} else {
			System.out.println("3");
			empList = empDAO.selectEmpListN(deptName);
		}
		return empList;
	}

	@Override
	public ArrayList<EmpTO> findEmpMemberListByDept(String deptName) {
		ArrayList<EmpTO> empList = null;

//		/*
//		 * if (deptName.equals("전체부서")) { empList = empDAO.selectEmpList(); } else if
//		 * (deptName.substring(deptName.length()-1, deptName.length()).equals("팀")) {
//		 */
		empList = empDAO.selectEmpMemberListD(deptName);
		/*
		 * } else { empList = empDAO.selectEmpListN(deptName); }
		 */
		return empList;
	}

	/*
	 * @Override public void modifyEmployee(EmpTO emp) {
	 * 
	 * if (emp.getStatus().equals("update")) { empDAO.updateEmployee(emp); }
	 * 
	 * if (emp.getWorkInfoList() != null) { List<WorkInfoTO> workInfoList =
	 * emp.getWorkInfoList(); for (WorkInfoTO workInfo : workInfoList) { switch
	 * (workInfo.getStatus()) { case "insert": workInfoDAO.insertWorkInfo(workInfo);
	 * break; case "update": workInfoDAO.updateWorkInfo(workInfo); break; case
	 * "delete": workInfoDAO.deleteWorkInfo(workInfo); break; } } }
	 * 
	 * if (emp.getCareerInfoList() != null && emp.getCareerInfoList().size() > 0) {
	 * List<CareerInfoTO> careerInfoList = emp.getCareerInfoList(); for
	 * (CareerInfoTO careerInfo : careerInfoList) { switch (careerInfo.getStatus())
	 * { case "insert": careerInfoDAO.insertCareerInfo(careerInfo); break; case
	 * "update": careerInfoDAO.updateCareerInfo(careerInfo); break; case "delete":
	 * careerInfoDAO.deleteCareerInfo(careerInfo); break; } } }
	 * 
	 * if (emp.getEducationInfoList() != null && emp.getEducationInfoList().size() >
	 * 0) { List<EducationInfoTO> educationInfoList = emp.getEducationInfoList();
	 * for (EducationInfoTO educationInfo : educationInfoList) { switch
	 * (educationInfo.getStatus()) { case "insert":
	 * educationInfoDAO.insertEducationInfo(educationInfo); break; case "update":
	 * educationInfoDAO.updateEducationInfo(educationInfo); break; case "delete":
	 * educationInfoDAO.deleteEducationInfo(educationInfo); break; } } }
	 * 
	 * if (emp.getLicenseInfoList() != null && emp.getLicenseInfoList().size() > 0)
	 * { List<LicenseInfoTO> licenseInfoList = emp.getLicenseInfoList(); for
	 * (LicenseInfoTO licenseInfo : licenseInfoList) { switch
	 * (licenseInfo.getStatus()) { case "insert":
	 * licenseInfoDAO.insertLicenseInfo(licenseInfo); break; case "update":
	 * licenseInfoDAO.updateLicenseInfo(licenseInfo); break; case "delete":
	 * licenseInfoDAO.deleteLicenseInfo(licenseInfo); break; } } }
	 * 
	 * if (emp.getFamilyInfoList() != null && emp.getFamilyInfoList().size() > 0) {
	 * List<FamilyInfoTO> familyInfoList = emp.getFamilyInfoList(); for
	 * (FamilyInfoTO familyInfo : familyInfoList) { switch (familyInfo.getStatus())
	 * { case "insert": familyInfoDAO.insertFamilyInfo(familyInfo); break; case
	 * "update": familyInfoDAO.updateFamilyInfo(familyInfo); break; case "delete":
	 * familyInfoDAO.deleteFamilyInfo(familyInfo); break; } } } }
	 */

	@Override
	public void deleteEmpList(ArrayList<EmpTO> empList) {

		for (EmpTO emp : empList) {
			empDAO.deleteEmployee(emp);
			baseApplicationService.deleteEmpCode(emp);
		}
	}

	@Override
	public ArrayList<DeptTO> findDeptList() {
		ArrayList<DeptTO> deptList = deptDAO.selectDeptList();
		return deptList;
	}

	@Override
	public ArrayList<BaseSalaryTO> selectPositionList() {

		ArrayList<BaseSalaryTO> positionList = salaryApplicationService.findBaseSalaryList();

		return positionList;
	}

	@Override
	public ArrayList<EmpTO> findAllEmpInfo(HashMap<String, String> map) {

		return empDAO.selectEmployee(map);
	}

	@Override
	public void empInfoUpdate(Map<String, ArrayList<EmpTO>> empArray) {
		empDAO.updateEmployee(empArray);

	}

	@Override
	public ArrayList<EmployeeBasicTO> getEmpBasicInfo(String empCode) {

		return employeeBasicDAO.getEmpBasicInfo(empCode);
	}

	@Override
	public ArrayList<EmpTO> findEmpList() {
		// TODO Auto-generated method stub
		return empDAO.selectEmpAllList();
	}

	@Override
	public void insertAssign(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		empAssignDAO.insertAssign(map);
	}

	@Override
	public ArrayList<AssignEmpTO> getAssignList(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return empAssignDAO.selectAssignList(startDate, endDate);
	}

	@Override
	public void updateDeptCode(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		empAssignDAO.updateDeptCode(map);
	}

	@Override
	public ArrayList<BestEmpTO> getBestEmp() {

		System.out.println("applicationService");
		return bestEmpDAO.getBestEmp();
	}

}