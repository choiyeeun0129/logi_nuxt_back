package kr.co.seoulit.erp.logistic.production.repository;

import kr.co.seoulit.erp.logistic.production.domain.WorkOrderInfo;
import kr.co.seoulit.erp.logistic.production.domain.WorkSite;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Repository
public interface WorkSiteRepository extends JpaRepository<WorkSite, String> {

    /**********************************
     작업장/작업장 로그 = 작업장 조회(JPA)
     **********************************/
//    @Query("select w.productionProcessCode, w.workSiteCode, w.workSiteName from WorkSite w")
//    public List<WorkSite> findList();
}


