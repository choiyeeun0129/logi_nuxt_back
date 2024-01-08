package kr.co.seoulit.erp.account.slip.to;

//박미노 추가 2020-11-24

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class JournalSeparatorBean {
		
	    private String slipNo;
	    private String deliveryNo;
	    private String empCode;
	    private String applyYearMonth;
	    private String seqNo;
}
