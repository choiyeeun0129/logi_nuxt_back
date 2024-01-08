package kr.co.seoulit.erp.account.base.applicationservice;

import java.util.ArrayList;

import kr.co.seoulit.erp.account.base.to.BusinessBean;
import kr.co.seoulit.erp.account.base.to.DetailBusinessBean;

public interface BusinessApplicationService {

	public ArrayList<BusinessBean> getBusinessList();

	public ArrayList<DetailBusinessBean> getDetailBusiness(String businessName);
}
