package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.domain.MrpGathering;
import kr.co.seoulit.erp.logistic.production.domain.MrpGatheringDTO;
import kr.co.seoulit.erp.logistic.production.to.MrpGatheringTO;
import kr.co.seoulit.erp.logistic.production.to.MrpTO;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface MrpGatheringServiceFacade {


    public HashMap<String, Object> searchMrpList(String mrpGatheringStatusCondition);

    public HashMap<String, Object> searchMrpList(String dateSearchCondtion, String startDate, String endDate);

    public HashMap<String, Object> searchMrpListAsMrpGatheringNo(String mrpGatheringNo);


    public HashMap<String, Object> batchMrpListProcess(ArrayList<MrpTO> mrpTOList);

    public HashMap<String, Object> getMrpGathering(String mrpNoArr);

    public HashMap<String, Object> registerMrpGathering(String mrpGatheringRegisterDate,
                                                        ArrayList<MrpGatheringTO> newMrpGatheringList, HashMap<String, String> mrpNoAndItemCodeMap);

    public List<MrpGathering> searchMrpGatheringList(String dateSearchCondition, String startDate,
                                                     String endDate);

    public List<MrpGatheringDTO> searchMrpGatheringCalendar(String month);

}
