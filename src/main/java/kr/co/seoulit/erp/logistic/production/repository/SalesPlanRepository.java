package kr.co.seoulit.erp.logistic.production.repository;

import kr.co.seoulit.erp.logistic.production.domain.SalesPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



import java.util.List;

public interface SalesPlanRepository extends JpaRepository<SalesPlan, Long> {
    @Query(" select s " +
            "from SalesPlane s " +
            "where s.salesPlanDate between :startDate and :endDate")
    public List<SalesPlan> findByDate(@Param("salesPlanDate") String startDate,
                                      @Param("dueDateOfSales") String endDate);

    @Modifying
    @Query("UPDATE SalesPlane s SET s.mpsApplyStatus = 'Y' " +
            "WHERE s.salesPlanNo = :salesPlanNo")
    public void changeMpsApplyStatus(@Param("salesPlanNo") String salesPlanNo);

}
