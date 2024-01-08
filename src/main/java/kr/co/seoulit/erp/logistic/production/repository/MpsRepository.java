package kr.co.seoulit.erp.logistic.production.repository;

import kr.co.seoulit.erp.logistic.production.to.MpsTO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MpsRepository extends JpaRepository<MpsTO, Long> {

}
