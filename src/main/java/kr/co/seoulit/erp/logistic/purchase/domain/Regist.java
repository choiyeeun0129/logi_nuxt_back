package kr.co.seoulit.erp.logistic.purchase.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Regist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String itemCode;
    private String parentItemCode;
    private int no;
    private int netAmount;
    private String description;

    @Transient
    private String status;
}
