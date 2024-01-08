package kr.co.seoulit.erp.account.slip.to;

import lombok.Data;

import lombok.EqualsAndHashCode;

import kr.co.seoulit.common.to.BaseTO;


@EqualsAndHashCode(callSuper=false)
@Data
public class GeneralAccountLedgerBean {
    private String reportingDate;
    private String accountName;
    private String leftDebtorPrice;
    private String rightCreditsPrice;
    private String customerName;
    private String expenseReport;

}
