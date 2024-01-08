package kr.co.seoulit.erp.hr.company.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.hr.company.to.WorkplaceTO;

public interface LogiWorkplaceApplicationService {
	
	public ArrayList<WorkplaceTO> getWorkplaceList(String companyCode);
	
	public String getNewWorkplaceCode(String companyCode);
	
	public HashMap<String, Object> batchWorkplaceListProcess(ArrayList<WorkplaceTO> workplaceList);
	
}
