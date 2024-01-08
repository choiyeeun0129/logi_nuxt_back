package kr.co.seoulit.erp.account.base.to;

import kr.co.seoulit.common.to.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class DetailBusinessBean extends BaseTO{
	   private String detailBusinessName;
	    private String ChildClassificationCode;
	    private String remarks;

}
