package kr.co.seoulit.erp.logistic.production.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@Table(name = "WORK_SITE_LOG")

public class WorkSiteLog {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private String workOrderNo;
    private String itemCode;
    private String itemName;
    private String productionProcessCode;
    private String productionProcessName;
    private String workSiteName;
    private String workDate;



//    @Transient
//    private String progress;

    @Column(name = "reaeson") // progress 필드를 데이터베이스 컬럼과 매핑
    private String progress;

    public WorkSiteLog(){}

}
