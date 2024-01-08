package kr.co.seoulit.erp.hr.company.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logistic.base.dao.LogiCodeDetailDAO;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeDetailTO;
import kr.co.seoulit.erp.hr.company.dao.DepartmentDAO;
import kr.co.seoulit.erp.hr.company.to.DepartmentTO;

@Component
public class DepartmentApplicationServiceImpl implements DepartmentApplicationService {


	@Autowired
	private DepartmentDAO deptDAO;
	@Autowired
	private LogiCodeDetailDAO codeDetailDAO;

	public ArrayList<DepartmentTO> getDepartmentList(String searchCondition, String companyCode,
			String workplaceCode) {

		ArrayList<DepartmentTO> departmentList = null;

			switch (searchCondition) {

			case "ALL":

				departmentList = deptDAO.selectDepartmentListByCompany(companyCode);
				break;

			case "WORKPLACE":

				departmentList = deptDAO.selectDepartmentListByWorkplace(workplaceCode);
				break;
				
			}

		return departmentList;
	}

	public String getNewDepartmentCode(String companyCode) {

		ArrayList<DepartmentTO> departmentList = null;
		String newDepartmentCode = null;

			departmentList = deptDAO.selectDepartmentListByCompany(companyCode);

			TreeSet<Integer> departmentCodeNoSet = new TreeSet<>();

			for (DepartmentTO bean : departmentList) {

				if (bean.getDeptCode().startsWith("DPT-")) {

					try {

						Integer no = Integer.parseInt(bean.getDeptCode().split("DPT-")[1]);
						departmentCodeNoSet.add(no);

					} catch (NumberFormatException e) {

						// "DPT-" 다음 부분을 Integer 로 변환하지 못하는 경우 : 그냥 다음 반복문 실행

					}

				}

			}

			if (departmentCodeNoSet.isEmpty()) {
				newDepartmentCode = "DPT-" + String.format("%02d", 1);
			} else {
				newDepartmentCode = "DPT-" + String.format("%02d", departmentCodeNoSet.pollLast() + 1);
			}

		return newDepartmentCode;
	}


	public HashMap<String, Object> batchDepartmentListProcess(ArrayList<DepartmentTO> departmentList) {

		HashMap<String, Object> resultMap = new HashMap<>();

			ArrayList<String> insertList = new ArrayList<>();
			ArrayList<String> updateList = new ArrayList<>();
			ArrayList<String> deleteList = new ArrayList<>();

			LogiCodeDetailTO detailCodeBean = new LogiCodeDetailTO();

			for (DepartmentTO bean : departmentList) {

				String status = bean.getStatus();

				switch (status) {

				case "INSERT":

					// 새로운 부서번호 생성 후 bean 에 set
					String newDepartmentCode = getNewDepartmentCode(bean.getCompanyCode());
					bean.setDeptCode(newDepartmentCode);

					// 부서 테이블에 insert
					deptDAO.insertDepartment(bean);
					insertList.add(bean.getDeptCode());

					// CODE_DETAIL 테이블에 Insert
					detailCodeBean.setDivisionCodeNo("CO-03");
					detailCodeBean.setDetailCode(bean.getDeptCode());
					detailCodeBean.setDetailCodeName(bean.getDeptName());

					codeDetailDAO.insertDetailCode(detailCodeBean);

					break;

				case "UPDATE":

					deptDAO.updateDepartment(bean);
					updateList.add(bean.getDeptCode());

					// CODE_DETAIL 테이블에 Update
					detailCodeBean.setDivisionCodeNo("CO-03");
					detailCodeBean.setDetailCode(bean.getDeptCode());
					detailCodeBean.setDetailCodeName(bean.getDeptName());

					codeDetailDAO.updateDetailCode(detailCodeBean);

					break;

				case "DELETE":

					deptDAO.deleteDepartment(bean);
					deleteList.add(bean.getDeptCode());

					// CODE_DETAIL 테이블에 Delete
					detailCodeBean.setDivisionCodeNo("CO-03");
					detailCodeBean.setDetailCode(bean.getDeptCode());
					detailCodeBean.setDetailCodeName(bean.getDeptName());

					codeDetailDAO.deleteDetailCode(detailCodeBean);

					break;

				}

			}

			resultMap.put("INSERT", insertList);
			resultMap.put("UPDATE", updateList);
			resultMap.put("DELETE", deleteList);

		return resultMap;
	}
	
}
