package kr.co.seoulit.erp.account.base.servicefacade;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.base.to.WorkplaceBean;



public interface AccWorkplaceServiceFacade {
	
	public WorkplaceBean getWorkplace(String workplaceCode);
	
	public void workplaceAdd(WorkplaceBean workplaceBean);
	
	public void eliminationWorkplace(ArrayList<String> getCodes); 

	public void updateApprovalStatus(ArrayList<String> getCodes,String status);
		
	public ArrayList<WorkplaceBean> getAllWorkplaceList();

}
