package kr.co.seoulit.erp.hr.company.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.hr.company.applicationservice.CustomerApplicationService;
import kr.co.seoulit.erp.hr.company.applicationservice.FinancialAccountAssociatesApplicationService;
import kr.co.seoulit.erp.hr.company.to.CustomerTO;
import kr.co.seoulit.erp.hr.company.to.FinancialAccountAssociatesTO;

@Service
public class CooperatorServiceFacadeImpl implements CooperatorServiceFacade {
	
	@Autowired
	private CustomerApplicationService customerAS;
	@Autowired
	private FinancialAccountAssociatesApplicationService associatsAS;

	@Override
	public ArrayList<CustomerTO> getCustomerList(String searchCondition, String workplaceCode) {

		ArrayList<CustomerTO> customerList = null;

		try {

			customerList = customerAS.getCustomerList(searchCondition, workplaceCode);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}

		return customerList;
	}

	@Override
	public HashMap<String, Object> batchCustomerListProcess(ArrayList<CustomerTO> customerList) {

		HashMap<String, Object> resultMap = null;

		try {

			resultMap = customerAS.batchCustomerListProcess(customerList);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}

		return resultMap;

	}

	@Override
	public ArrayList<FinancialAccountAssociatesTO> getFinancialAccountAssociatesList(String searchCondition,
			String workplaceCode) {

		ArrayList<FinancialAccountAssociatesTO> financialAccountAssociatesList = null;

		try {

			financialAccountAssociatesList = associatsAS.getFinancialAccountAssociatesList(searchCondition,
					workplaceCode);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}

		return financialAccountAssociatesList;

	}

	@Override
	public HashMap<String, Object> batchFinancialAccountAssociatesListProcess(
			ArrayList<FinancialAccountAssociatesTO> financialAccountAssociatesList) {

		HashMap<String, Object> resultMap = null;

		try {

			resultMap = associatsAS.batchFinancialAccountAssociatesListProcess(financialAccountAssociatesList);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}

		return resultMap;
	}


}
