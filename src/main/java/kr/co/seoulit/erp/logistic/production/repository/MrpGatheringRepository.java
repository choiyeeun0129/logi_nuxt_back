package kr.co.seoulit.erp.logistic.production.repository;


//import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.seoulit.erp.logistic.production.domain.MrpGathering;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@Transactional(rollbackFor = {Exception.class})
public class MrpGatheringRepository  {

    private final EntityManager em;

//    private final JPAQueryFactory queryFactory;
    public MrpGatheringRepository(EntityManager em) {
        this.em = em;
//        this.queryFactory = new JPAQueryFactory(em);
    }
    public List<MrpGathering> searchMrpGatheringList(String dateSearchCondition,
                                                     String startDate,
                                                     String endDate) {

        String query = "SELECT m FROM MrpGathering m " +
                "WHERE (CASE :dateSearchCondition " +
                "WHEN 'claimDate' THEN TO_DATE(m.claimDate, 'YYYY-MM-DD') " +
                "WHEN 'dueDate' THEN TO_DATE(m.dueDate, 'YYYY-MM-DD') " +
                "END) BETWEEN TO_DATE(:startDate, 'YYYY-MM-DD') AND TO_DATE(:endDate, 'YYYY-MM-DD')";

        return em.createQuery(query, MrpGathering.class)
                .setParameter("dateSearchCondition", dateSearchCondition)
                .setParameter("startDate", startDate.toString())
                .setParameter("endDate", endDate.toString())
                .getResultList();

//        QMrpGathering mrpGathering = new QMrpGathering("mrpGathering");

    }

    public List<MrpGathering> searchMrpGatheringCalendar(String month) {
        String query = "SELECT m FROM MrpGathering m " +
                "WHERE SUBSTR(m.mrpGatheringNo, 7, 2) = :month ";

        List<MrpGathering> MrpGathering = em.createQuery(query, MrpGathering.class)
                .setParameter("month", month)
                .getResultList();

        return MrpGathering;
    }

}
