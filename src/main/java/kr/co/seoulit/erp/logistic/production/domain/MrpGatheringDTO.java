package kr.co.seoulit.erp.logistic.production.domain;


import lombok.Data;
@Data
public class MrpGatheringDTO {

    private int mrpGatheringSeq;
    private String mrpGatheringNo;
    private String itemCode;
    private String itemName;
    private String claimDate;
    private String dueDate;
    private String orderOrProductionStatus;
    private int necessaryAmount;

}
