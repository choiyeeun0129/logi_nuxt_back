package kr.co.seoulit.erp.account.base.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;

@EqualsAndHashCode(callSuper=false)
@Data
public class PeriodBean extends BaseTO{
	
	private String accountPeriodNo;
	private String fiscalYear;
	private String workplaceCode;
	private String periodStartDate;
	private String periodEndDate;

}
