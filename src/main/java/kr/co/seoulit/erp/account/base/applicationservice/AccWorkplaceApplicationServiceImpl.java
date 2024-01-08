package kr.co.seoulit.erp.account.base.applicationservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.account.base.dao.AccWorkplaceDAO;
import kr.co.seoulit.erp.account.base.to.WorkplaceBean;

@Component
public class AccWorkplaceApplicationServiceImpl implements AccWorkplaceApplicationService {
	@Autowired
	private AccWorkplaceDAO workplaceDAO;

	@Override
	public WorkplaceBean getWorkplace(String workplaceCode) {
		return workplaceDAO.selectWorkplace(workplaceCode);
	}

	@Override
	public void updateApprovalStatus(ArrayList<String> getCodes, String status) {
		for (String code : getCodes) {
			workplaceDAO.updateWorkplaceAccount(code, status);
		}
	}

	@Override
	public void workPlaceAdd(WorkplaceBean workplaceBean) {
		workplaceDAO.insertWorkplace(workplaceBean);
	}

	@Override
	public void eliminationWorkplace(ArrayList<String> getCodes) {
		for (String code : getCodes) {
			workplaceDAO.deleteWorkplace(code);
		}
	}

	@Override
	public ArrayList<WorkplaceBean> getAllWorkplaceList() {
		return workplaceDAO.selectAllWorkplaceList();
	}
}
