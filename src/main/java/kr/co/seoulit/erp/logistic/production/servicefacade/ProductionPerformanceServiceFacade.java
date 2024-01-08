package kr.co.seoulit.erp.logistic.production.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.erp.logistic.production.domain.ProductionPerformance;
import kr.co.seoulit.erp.logistic.production.domain.WorkOrderInfo;
import kr.co.seoulit.erp.logistic.production.to.*;

public interface ProductionPerformanceServiceFacade {

    public List<ProductionPerformance> getProductionPerformanceInfoList();


//    public List<ProductionPerformance> getItemClassifiction(String itemClassifiction);
}
