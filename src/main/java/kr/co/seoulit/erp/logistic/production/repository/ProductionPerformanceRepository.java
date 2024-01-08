package kr.co.seoulit.erp.logistic.production.repository;

import kr.co.seoulit.erp.logistic.production.domain.ProductionPerformance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductionPerformanceRepository extends JpaRepository<ProductionPerformance, Long> {

//    List<ProductionPerformance> findByItemClassificationAndWorkSuccessRate(String itemClassification);
}
