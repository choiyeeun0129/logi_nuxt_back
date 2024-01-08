package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.domain.WorkSiteLog;

import java.util.List;

public interface WorkSiteLogServiceFacade {

    //작업장/작업장 로그 = 작업장 로그 조회(JPA)
    public List<WorkSiteLog> getWorkSiteLog(String productionProcessCode, String workSiteName);
}
