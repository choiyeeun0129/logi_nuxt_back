package kr.co.seoulit.erp.hr.company.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logistic.base.dao.LogiCodeDetailDAO;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeDetailTO;
import kr.co.seoulit.erp.hr.company.dao.FinancialAccountAssociatesDAO;
import kr.co.seoulit.erp.hr.company.to.FinancialAccountAssociatesTO;

@Component
public class FinancialAccountAssociatesApplicationServiceImpl implements FinancialAccountAssociatesApplicationService {

	@Autowired
	private FinancialAccountAssociatesDAO associatesDAO;
	@Autowired
	private LogiCodeDetailDAO codeDetailDAO;

	public ArrayList<FinancialAccountAssociatesTO> getFinancialAccountAssociatesList(String searchCondition,
			String workplaceCode) {

		ArrayList<FinancialAccountAssociatesTO> financialAccountAssociatesList = null;

			switch (searchCondition) {

			case "ALL":

				financialAccountAssociatesList = associatesDAO.selectFinancialAccountAssociatesListByCompany();
				break;

			case "WORKPLACE":

				financialAccountAssociatesList = associatesDAO
						.selectFinancialAccountAssociatesListByWorkplace(workplaceCode);
				break;

			}

		return financialAccountAssociatesList;
	}

	public String getNewFinancialAccountAssociatesCode() {

		ArrayList<FinancialAccountAssociatesTO> financialAccountAssociatesList = null;
		String newFinancialAccountAssociatesCode = null;

			financialAccountAssociatesList = associatesDAO
					.selectFinancialAccountAssociatesListByCompany();

			TreeSet<Integer> financialAccountAssociatesCodeNoSet = new TreeSet<>();

			for (FinancialAccountAssociatesTO bean : financialAccountAssociatesList) {

				if (bean.getAccountAssociatesCode().startsWith("FPT-")) {

					try {

						Integer no = Integer.parseInt(bean.getAccountAssociatesCode().split("FPT-")[1]);
						financialAccountAssociatesCodeNoSet.add(no);

					} catch (NumberFormatException e) {

						// "FPT-" 다음 부분을 Integer 로 변환하지 못하는 경우 : 그냥 다음 반복문 실행

					}

				}

			}

			if (financialAccountAssociatesCodeNoSet.isEmpty()) {
				newFinancialAccountAssociatesCode = "FPT-" + String.format("%02d", 1);
			} else {
				newFinancialAccountAssociatesCode = "FPT-"
						+ String.format("%02d", financialAccountAssociatesCodeNoSet.pollLast() + 1);
			}

		return newFinancialAccountAssociatesCode;
	}

	public HashMap<String, Object> batchFinancialAccountAssociatesListProcess(
			ArrayList<FinancialAccountAssociatesTO> financialAccountAssociatesList) {

		HashMap<String, Object> resultMap = new HashMap<>();

			ArrayList<String> insertList = new ArrayList<>();
			ArrayList<String> updateList = new ArrayList<>();
			ArrayList<String> deleteList = new ArrayList<>();

			LogiCodeDetailTO detailCodeBean = new LogiCodeDetailTO();

			for (FinancialAccountAssociatesTO bean : financialAccountAssociatesList) {

				String status = bean.getStatus();

				switch (status) {

				case "INSERT":

					// 새로운 금융거래처번호 생성 후 bean 에 set
					String newFinancialAccountAssociatesCode = getNewFinancialAccountAssociatesCode();
					bean.setAccountAssociatesCode(newFinancialAccountAssociatesCode);

					// 금융거래처 테이블에 insert
					associatesDAO.insertFinancialAccountAssociates(bean);
					insertList.add(bean.getAccountAssociatesCode());

					// CODE_DETAIL 테이블에 Insert
					detailCodeBean.setDivisionCodeNo("CL-02");
					detailCodeBean.setDetailCode(bean.getAccountAssociatesCode());
					detailCodeBean.setDetailCodeName(bean.getAccountAssociatesName());

					codeDetailDAO.insertDetailCode(detailCodeBean);

					break;

				case "UPDATE":

					associatesDAO.updateFinancialAccountAssociates(bean);
					updateList.add(bean.getAccountAssociatesCode());

					// CODE_DETAIL 테이블에 Update
					detailCodeBean.setDivisionCodeNo("CL-02");
					detailCodeBean.setDetailCode(bean.getAccountAssociatesCode());
					detailCodeBean.setDetailCodeName(bean.getAccountAssociatesName());

					codeDetailDAO.updateDetailCode(detailCodeBean);

					break;

				case "DELETE":

					associatesDAO.deleteFinancialAccountAssociates(bean);
					deleteList.add(bean.getAccountAssociatesCode());

					// CODE_DETAIL 테이블에 Delete
					detailCodeBean.setDivisionCodeNo("CL-02");
					detailCodeBean.setDetailCode(bean.getAccountAssociatesCode());
					detailCodeBean.setDetailCodeName(bean.getAccountAssociatesName());

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
