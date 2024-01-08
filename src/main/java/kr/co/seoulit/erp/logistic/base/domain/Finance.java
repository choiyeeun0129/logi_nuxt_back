package kr.co.seoulit.erp.logistic.base.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "FINANCIAL_ACCOUNT_ASSOCIATES")
@Data
public class Finance {
    @Id
    @Column(name = "ACCOUNT_ASSOCIATES_CODE")
    private String accountAssociatesCode;
    private String workplaceCode;
    private String accountAssociatesName;
    private String accountAssociatesType;
    private String accountNumber;
    private String accountOpenPlace;
    private String cardNumber;
    private String cardType;
    private String cardMemberName;
    private String cardOpenPlace;
    private String businessLicenseNumber;
    private String financialInstituteCode;
    private String financialInstituteName;
    private String divisionCodeNo;
}
