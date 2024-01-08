package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.domain.WorkSiteLog;
import kr.co.seoulit.erp.logistic.production.repository.WorkSiteLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WorkSiteLogServiceFacadeImpl implements WorkSiteLogServiceFacade{

    @Autowired
    private WorkSiteLogRepository workSiteLogRepository;



    //작업장/작업장 로그 = 작업장 로그 조회(JPA)
    @Override
    public List<WorkSiteLog> getWorkSiteLog(String productionProcessCode, String workSiteName) {
        List<WorkSiteLog> workSiteCodeAndProductionProcessCode = workSiteLogRepository.findByWorkSiteNameAndProductionProcessCode(workSiteName, productionProcessCode);
        return workSiteCodeAndProductionProcessCode;
    }
}
