package kr.co.seoulit.erp.account.base.servicefacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.account.base.applicationservice.BusinessApplicationService;
import kr.co.seoulit.erp.account.base.to.BusinessBean;
import kr.co.seoulit.erp.account.base.to.DetailBusinessBean;

@Service
public class BusinessServiceFacadeImpl implements BusinessServiceFacade{
	@Autowired
	private BusinessApplicationService businessApplicationService;

	
	@Override
	public ArrayList<BusinessBean> getBusinessList() {
		return businessApplicationService.getBusinessList();
	}
	
	@Override
	public ArrayList<DetailBusinessBean> getDetailBusiness(String businessCode) {
		return businessApplicationService.getDetailBusiness(businessCode);
	}
}
