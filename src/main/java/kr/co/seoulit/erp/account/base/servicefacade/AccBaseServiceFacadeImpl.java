package kr.co.seoulit.erp.account.base.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.base.to.AccountControlBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.account.base.applicationservice.AccCodeListApplicationService;
import kr.co.seoulit.erp.account.base.to.CodeBean;
import kr.co.seoulit.erp.account.base.to.DetailCodeBean;
import kr.co.seoulit.erp.account.base.to.SlipIreportBean;
import kr.co.seoulit.erp.account.base.servicefacade.AccBaseServiceFacade;
import kr.co.seoulit.erp.account.base.servicefacade.AccBaseServiceFacadeImpl;


@Service
public class AccBaseServiceFacadeImpl implements AccBaseServiceFacade {

	@Autowired
    private AccCodeListApplicationService codeListApplicationService;

    //민상

    @Override
    public ArrayList<AccountControlBean> getControllerCodeList() {
        return codeListApplicationService.getControllerCodeList();
    }
    


    @Override
    public ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, Object> param) {
        return codeListApplicationService.getDetailCodeList(param);
    }

    @Override
    public ArrayList<CodeBean> findCodeList() {
        return codeListApplicationService.findCodeList();
    }
    @Override
    public void batchCodeProcess(ArrayList<CodeBean> codeList, ArrayList<DetailCodeBean> codeList2) {

            codeListApplicationService.batchCodeProcess(codeList, codeList2);

    }


    @Override
	public ArrayList<SlipIreportBean> getSlipIreportData(String slipNo) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
