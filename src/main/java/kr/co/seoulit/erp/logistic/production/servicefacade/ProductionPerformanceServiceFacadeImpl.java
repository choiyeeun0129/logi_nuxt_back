package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.domain.ProductionPerformance;
import kr.co.seoulit.erp.logistic.production.domain.WorkOrderInfo;
import kr.co.seoulit.erp.logistic.production.repository.ProductionPerformanceRepository;
import kr.co.seoulit.erp.logistic.production.repository.WorkOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProductionPerformanceServiceFacadeImpl implements ProductionPerformanceServiceFacade {

    @Autowired
    private ProductionPerformanceRepository productionPerformanceRepository;


    @Override
    public List<ProductionPerformance> getProductionPerformanceInfoList() {
        System.out.println("여기 SF impl");
        List<ProductionPerformance> productionPerformanceList = productionPerformanceRepository.findAll();
        return productionPerformanceList;
    }

//    @Override
//    public List<ProductionPerformance> getItemClassifiction(String itemClassifiction) {
//        List<ProductionPerformance> byItemClassification = productionPerformanceRepository.findByItemClassification(itemClassifiction);
//
//        return byItemClassification;
//    }


}
