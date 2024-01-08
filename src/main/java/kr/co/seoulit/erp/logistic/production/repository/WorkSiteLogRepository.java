package kr.co.seoulit.erp.logistic.production.repository;

import kr.co.seoulit.erp.logistic.production.domain.WorkSiteLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkSiteLogRepository extends JpaRepository<WorkSiteLog, Long> {

   //작업장/작업장 로그 = 작업장 로그 조회(JPA)
   List<WorkSiteLog> findByWorkSiteNameAndProductionProcessCode(String productionProcessCode, String workSiteName);
}
