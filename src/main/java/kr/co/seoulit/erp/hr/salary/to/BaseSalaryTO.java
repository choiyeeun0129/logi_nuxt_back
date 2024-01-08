package kr.co.seoulit.erp.hr.salary.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
//****************************************************2020-08-28 63기 손유찬 ********************************* **********************
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseSalaryTO extends BaseTO {
	private String positionCode, 
	positionName, 
	baseSalary,	
	hobongRatio,
	deptName,
	deptCode,
	workPlaceCode,
	status;
	
}
//****************************************************2020-08-28 63기 손유찬 ********************************* **********************