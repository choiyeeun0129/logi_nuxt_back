package kr.co.seoulit.erp.account.statement.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;

@EqualsAndHashCode(callSuper=false)
@Data
public class CashJournalBean extends BaseTO{
	private String monthReportingDate;
	private String reportingDate;
	private String expenseReport;
	private String customerCode;
	private String customerName;
	private int deposit;
	private int withdrawal;
	private String balance;

}
