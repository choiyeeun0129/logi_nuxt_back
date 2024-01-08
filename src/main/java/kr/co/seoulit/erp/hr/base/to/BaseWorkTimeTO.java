package kr.co.seoulit.erp.hr.base.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BaseWorkTimeTO extends BaseTO{
	String applyYear;
	String lunchEndTime;
	String dinnerEndTime;
	String attendTime;
	String overEndTime;
	String quitTime;
	String lunchStartTime;
	String nightEndTime;
	String dinnerStartTime;
}
