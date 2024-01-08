package kr.co.seoulit.erp.logistic.sales.repository;

import kr.co.seoulit.erp.logistic.sales.to.EstimateDetailTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimateDetailRepository extends JpaRepository<EstimateDetailTO, String> {

}
