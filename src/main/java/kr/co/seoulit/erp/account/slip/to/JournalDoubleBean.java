package kr.co.seoulit.erp.account.slip.to;

import lombok.Data;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class JournalDoubleBean {
	private String reportingDate;
	private String leftAccountName;
	private String leftDebtorPrice;
	private String rightAccountName;
	private String rightCreditsPrice;
	private String customerName;
	private String expenseReport;
}
