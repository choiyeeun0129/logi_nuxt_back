package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.dao.WorkSiteDAO;
import kr.co.seoulit.erp.logistic.production.domain.WorkSite;
import kr.co.seoulit.erp.logistic.production.repository.WorkSiteRepository;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteLogTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class WorkSiteServiceFacadeImpl implements kr.co.seoulit.erp.logistic.production.servicefacade.WorkSiteServiceFacade {

    @Autowired
    private WorkSiteRepository workSiteRepository;
//    @Autowired
//    private WorkSiteDAO workSiteDAO;

    /**********************************
     작업장/작업장 로그 = 작업장 조회(JPA)
     **********************************/
    @Override
    public List<WorkSite> getWorkSiteList() {
        List<WorkSite> workSiteList = workSiteRepository.findAll();
        return workSiteList;
    }

    //작업장/작업장 로그 = 작업장 조회(Spring)
    //    @Override
    //    public ArrayList<WorkSiteTO> getWorkSiteList() {
    //        return workSiteDAO.selectWorkSiteList();
    //    }


//    @Override
//    public ArrayList<WorkSiteLogTO> getProductionProcessCode(HashMap<String, String> map) {
//        return workSiteDAO.selectProductionProcessCode(map);
//    }
}
