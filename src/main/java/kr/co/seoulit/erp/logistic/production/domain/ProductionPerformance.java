package kr.co.seoulit.erp.logistic.production.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@Table(name = "PRODUCTION_PERFORMANCE")
public class ProductionPerformance {

    @Id
    private String workOrderCompletionDate;
    private String workOrderNo;
    private String contractDetailNo;
    private String itemClassification;
    private String itemCode;
    private String itemName;
    private String unit;
    private String workOrderAmount;
    private String actualCompletionAmount;
    private String workSuccessRate;

    @Transient
    private String mpsNo;

    public ProductionPerformance() {
    }
}
