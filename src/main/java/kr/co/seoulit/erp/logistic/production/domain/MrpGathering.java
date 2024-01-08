package kr.co.seoulit.erp.logistic.production.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class MrpGathering {

    @Id
    private String mrpGatheringNo;
    private String orderOrProductionStatus;
    private String itemCode;
    private String itemName;
    private String unitOfMrpGathering;
    private String claimDate;
    private String dueDate;
    private int necessaryAmount;
    private int mrpGatheringSeq;
    private String requestStatus;
    private String outsourcStatus;

//    @OneToMany
//    @JoinColumn(name = "mrpGatheringNo")
//    private List<OrderRequired> orderRequired = new ArrayList<>();
//
//    @OneToMany
//    @JoinColumn(name = "mrpGatheringNo")
//    private List<WorkOrderable> workOrderable = new ArrayList<>();
}
