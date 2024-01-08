package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.to.MpsTO;
import kr.co.seoulit.erp.logistic.production.to.MrpTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MrpServiceFacade {

    public Map<String, List<MpsTO>> getMpsList(String startDate, String endDate);
    public void updateMps(MpsTO mpsTO);
    public HashMap<String, Object> openMrp(String mpsNo);
    public HashMap<String, Object> registerMrp(String mrpRegisterDate, ArrayList<MrpTO> newMrpList);

}
