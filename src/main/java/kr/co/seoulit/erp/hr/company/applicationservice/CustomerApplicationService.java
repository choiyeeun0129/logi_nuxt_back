package kr.co.seoulit.erp.hr.company.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.hr.company.to.CustomerTO;

public interface CustomerApplicationService {

	public ArrayList<CustomerTO> getCustomerList(String searchCondition,
			String workplaceCode);
	
	public String getNewCustomerCode(String workplaceCode);
	
	public HashMap<String, Object> batchCustomerListProcess(ArrayList<CustomerTO> customerList);
	
}
