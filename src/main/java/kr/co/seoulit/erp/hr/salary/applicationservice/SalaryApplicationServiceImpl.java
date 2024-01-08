package kr.co.seoulit.erp.hr.salary.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.hr.salary.dao.BaseDeductionDAO;
import kr.co.seoulit.erp.hr.salary.dao.BaseExtSalDAO;
import kr.co.seoulit.erp.hr.salary.dao.BaseSalaryDAO;
import kr.co.seoulit.erp.hr.salary.dao.MonthDeductionDAO;
import kr.co.seoulit.erp.hr.salary.dao.MonthExtSalDAO;
import kr.co.seoulit.erp.hr.salary.dao.MonthSalaryDAO;
import kr.co.seoulit.erp.hr.salary.dao.SeverancePayDAO;
import kr.co.seoulit.erp.hr.salary.dao.SocialInsureDAO;
import kr.co.seoulit.erp.hr.salary.repository.MonthSalaryRepository;
import kr.co.seoulit.erp.hr.salary.to.BaseDeductionTO;
import kr.co.seoulit.erp.hr.salary.to.BaseExtSalTO;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;
import kr.co.seoulit.erp.hr.salary.to.MonthSalaryTO;
import kr.co.seoulit.erp.hr.salary.to.SeveranceTO;
import kr.co.seoulit.erp.hr.salary.to.SocialInsureTO;

@Component
public class SalaryApplicationServiceImpl implements SalaryApplicationService{
	
	@Autowired
	private MonthDeductionDAO monthDeductionDAO;
	@Autowired
	private MonthExtSalDAO monthExtSalDAO;
	@Autowired
	private MonthSalaryDAO monthSalaryDAO;
	@Autowired
	private BaseDeductionDAO baseDeductionDAO;
	@Autowired
	private BaseExtSalDAO baseExtSalDAO;
	@Autowired
	private BaseSalaryDAO baseSalaryDAO;
	@Autowired
	private MonthSalaryRepository monthSsalaryRepostiroy;
	@Autowired
	private SocialInsureDAO socialInsureDAO;
	@Autowired
	private SeverancePayDAO severancePayDAO;
	
	@Override
	public HashMap<String, Object> findMonthSalary(String applyYearMonth, String empCode) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("applyYearMonth", applyYearMonth);
		map.put("empCode", empCode);
		monthSalaryDAO.batchMonthSalaryProcess(map);
		System.out.println("MSG QWEEEEEEEEEEEEEEEEEEEEE "+map.get("errorMsg"));
		System.out.println("MSG QWEEEEEEEEEEEEEEEEEEEEE "+map.get("errorCode"));
		return map;
		
	}
	@Override
	public ArrayList<MonthSalaryTO> findYearSalary(String applyYear, String empCode) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("applyYear", applyYear);
		map.put("empCode", empCode);
		ArrayList<MonthSalaryTO> yearSalary = monthSalaryDAO.selectYearSalary(map);
		return yearSalary;	
	}
	@Override
	public void modifyMonthSalary(MonthSalaryTO monthSalary) {
		monthSalaryDAO.updateMonthSalary(monthSalary);
	}
	@Override
	public ArrayList<BaseDeductionTO> findBaseDeductionList() {
		ArrayList<BaseDeductionTO> baseDeductionList = baseDeductionDAO.selectBaseDeductionList();
		return baseDeductionList;
	}
	@Override
	public void batchBaseDeductionProcess(ArrayList<BaseDeductionTO> baseDeductionList) {

		for(BaseDeductionTO baseDeduction : baseDeductionList){
			switch(baseDeduction.getStatus()){
				case "insert" :
					baseDeductionDAO.insertBaseDeduction(baseDeduction);
					break;
				case "update" :
					baseDeductionDAO.updateBaseDeduction(baseDeduction);
					break;
				case "delete" :
					baseDeductionDAO.deleteBaseDeduction(baseDeduction);
					break;
			}
		}	
	}
	@Override
	public ArrayList<BaseSalaryTO> findBaseSalaryList() {
		ArrayList<BaseSalaryTO> baseSalaryList = baseSalaryDAO.selectBaseSalaryList();
		return baseSalaryList;
	}
//****************************************************2020-08-31 63疫뀐옙 占쎈�占쎌�筌∽옙 ********************************* **********************
	@Override
	public void modifyBaseSalaryList(ArrayList<BaseSalaryTO> baseSalaryList) {
		for(BaseSalaryTO baseSalary : baseSalaryList){
			if(baseSalary.getStatus().equals("update")) {
				baseSalaryDAO.updateBaseSalary(baseSalary);}
			
			if(baseSalary.getStatus().equals("insert")) {
				switch(baseSalary.getPositionName()) {
				case "占쎄텢占쎌삢" : baseSalary.setPositionCode("POS-01"); break;
				case "占쎌뵠占쎄텢" : baseSalary.setPositionCode("POS-02"); break;
				case "�겫占쏙옙�삢" : baseSalary.setPositionCode("POS-03"); break;
				case "筌△뫁�삢" : baseSalary.setPositionCode("POS-04"); break;
				case "�⑥눘�삢" : baseSalary.setPositionCode("POS-05"); break;
				case "占쏙옙�뵳占�" : baseSalary.setPositionCode("POS-06"); break;
				case "占쎄텢占쎌뜚" : baseSalary.setPositionCode("POS-07"); break;
				case "占쎌뵥占쎄쉘" : baseSalary.setPositionCode("POS-08"); break;
				case "�④쑴鍮잞쭪占�" : baseSalary.setPositionCode("POS-09"); break;
	            default: baseSalary.setPositionCode("X"); break;
	            }
				switch(baseSalary.getDeptName()) {
				case "�룯�빖龜�겫占�" : baseSalary.setDeptCode("DPT-01"); break;
				case "占쎌겫占쎈씜�겫占�" : baseSalary.setDeptCode("DPT-02"); break;
				case "占쎄문占쎄텦�겫占�" : baseSalary.setDeptCode("DPT-03"); break;
				case "�뤃�됤꼻�겫占�" : baseSalary.setDeptCode("DPT-04"); break;
				case "占쎌뵥占쎄텢�겫占�" : baseSalary.setDeptCode("DPT-05"); break;
				case "占쎌냹癰귣�占�" : baseSalary.setDeptCode("DPT-06"); break;
				case "揶쏆뮆而삯겫占�" : baseSalary.setDeptCode("DPT-07"); break;
	            default: baseSalary.setPositionCode("X"); break;
				}
				
					if(baseSalary.getPositionName()=="X" || baseSalary.getDeptName()=="X") {
						return;}
					else { baseSalaryDAO.insertPosition(baseSalary);}
			}
					
			if(baseSalary.getStatus().equals("delete"))
				baseSalaryDAO.deletePosition(baseSalary);
		}
	}
//****************************************************2020-08-31 63疫뀐옙 占쎈�占쎌�筌∽옙 ********************************* **********************
	@Override
	public ArrayList<BaseExtSalTO> findBaseExtSalList() {
		ArrayList<BaseExtSalTO> baseExtSalList = baseExtSalDAO.selectBaseExtSalList();
		return baseExtSalList;
	}
	@Override
	public void modifyBaseExtSalList(ArrayList<BaseExtSalTO> baseExtSalList) {
		for(BaseExtSalTO baseExtSal : baseExtSalList){
			if(baseExtSal.getStatus().equals("update"))
				baseExtSalDAO.updateBaseExtSal(baseExtSal);
		}		
	}
	@Override
	public HashMap<String, Object> findCloseSalary(String applyYearMonth, String deptCode) { //占쎌뜞疫뀀맩肉ц�곌퀬�돳
		HashMap<String, Object> map = new HashMap<>();
		map.put("applyYearMonth", applyYearMonth);
		map.put("deptCode", deptCode);
		monthSalaryDAO.findMonthSalaryProcess(map);
		return map;
	}
	@Override
	public void closeSalary(MonthSalaryTO empCodeList) { //筌띾뜃而� 占쎈맙占쎈땾
		
		
		monthSsalaryRepostiroy.save(empCodeList);
		
		
	}

	@Override
	public ArrayList<BaseSalaryTO> BaseSalaryList(String selectDeptTitle) {
		ArrayList<BaseSalaryTO> baseExtSalList = baseSalaryDAO.BaseSalaryList(selectDeptTitle);
		return baseExtSalList;
	}
	@Override
	public ArrayList<SocialInsureTO> findBaseInsureList(String searchYear) {

		ArrayList<SocialInsureTO> BaseInsureList = socialInsureDAO.selectBaseInsureList(searchYear);
		return BaseInsureList;
	}
	
	public ArrayList<SeveranceTO> findSeverancePayList(String empName){
		
		ArrayList<SeveranceTO> severancePayList = severancePayDAO.selectSeverancePayList(empName);
		return severancePayList;
	};
}