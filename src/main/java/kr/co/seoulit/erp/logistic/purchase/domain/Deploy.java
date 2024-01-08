package kr.co.seoulit.erp.logistic.purchase.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Deploy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String itemCode;  // 품목코드
    private String bomNo;  // BOM NO
    private String parentItemCode;  // 상위품목코드
    private String itemName;  // 품목명
    private String unitOfStock;  // 단위
    private int netAmount;  // 정미수량
    private String lossRate;  // 손실율
    private String necessaryAmount;  // 필요수량
    private String leadTime;  // 소요일
    private String description;  // 설명

    @Transient
    private int bomLevel;  // BOM Level
    @Transient
    private String isLeaf;  // isLeaf
}
