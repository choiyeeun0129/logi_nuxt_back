package kr.co.seoulit.erp.account.base.servicefacade;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.base.to.BusinessBean;
import kr.co.seoulit.erp.account.base.to.DetailBusinessBean;

public interface BusinessServiceFacade {
	public ArrayList<BusinessBean> getBusinessList(); 
	
	public ArrayList<DetailBusinessBean> getDetailBusiness(String businessName); 
}
