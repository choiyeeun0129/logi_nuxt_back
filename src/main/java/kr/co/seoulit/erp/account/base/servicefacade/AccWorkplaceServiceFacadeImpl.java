package kr.co.seoulit.erp.account.base.servicefacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.account.base.applicationservice.AccWorkplaceApplicationService;
import kr.co.seoulit.erp.account.base.to.WorkplaceBean;


@Service
public class AccWorkplaceServiceFacadeImpl implements AccWorkplaceServiceFacade {
	
	@Autowired
	private AccWorkplaceApplicationService workplaceApplicationService;
	
	@Override
	public void workplaceAdd(WorkplaceBean workplaceBean) {
			WorkplaceBean workplaceCodeCheck = workplaceApplicationService.getWorkplace(workplaceBean.getWorkplaceCode());
			if(workplaceCodeCheck==null) {
			workplaceApplicationService.workPlaceAdd(workplaceBean);
			}
	}
	
	@Override
	public void eliminationWorkplace(ArrayList<String> getCodes) {
			workplaceApplicationService.eliminationWorkplace(getCodes);
	}
	
	@Override
	public void updateApprovalStatus(ArrayList<String> getCodes,String status) {
			workplaceApplicationService.updateApprovalStatus(getCodes, status);
	}
	
	@Override
	public WorkplaceBean getWorkplace(String workplaceCode) {
		return workplaceApplicationService.getWorkplace(workplaceCode);
	}
	
	
	@Override
	public ArrayList<WorkplaceBean> getAllWorkplaceList () {
		return workplaceApplicationService.getAllWorkplaceList();
	}
	
}