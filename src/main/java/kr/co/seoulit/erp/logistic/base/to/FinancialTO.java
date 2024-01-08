package kr.co.seoulit.erp.logistic.base.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class FinancialTO extends BaseTO {

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
