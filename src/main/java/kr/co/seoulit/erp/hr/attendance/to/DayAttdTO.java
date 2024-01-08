package kr.co.seoulit.erp.hr.attendance.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DayAttdTO extends BaseTO{
	private String 
					empCode, 
					empName, 
					dayAttdCode, 
					applyDay,
					errorMsg,
					attdTypeCode,
					attdTypeName, 
					time;
}
	

