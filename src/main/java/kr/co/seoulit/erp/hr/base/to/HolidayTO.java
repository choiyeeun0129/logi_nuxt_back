package kr.co.seoulit.erp.hr.base.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class HolidayTO extends BaseTO{
	private String applyDay, holidayName, note ,holidayCode ,status;
}
