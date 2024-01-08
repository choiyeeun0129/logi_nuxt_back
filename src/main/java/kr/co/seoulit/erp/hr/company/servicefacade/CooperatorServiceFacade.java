package kr.co.seoulit.erp.hr.company.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.hr.company.to.CustomerTO;
import kr.co.seoulit.erp.hr.company.to.FinancialAccountAssociatesTO;

public interface CooperatorServiceFacade {

	public ArrayList<CustomerTO> getCustomerList(String searchCondition, String workplaceCode);

	public HashMap<String, Object> batchCustomerListProcess(ArrayList<CustomerTO> customerList);

	public ArrayList<FinancialAccountAssociatesTO> getFinancialAccountAssociatesList(String searchCondition,
			String workplaceCode);

	public HashMap<String, Object> batchFinancialAccountAssociatesListProcess(
			ArrayList<FinancialAccountAssociatesTO> financialAccountAssociatesList);

}
