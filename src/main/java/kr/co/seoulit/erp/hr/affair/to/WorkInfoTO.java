package kr.co.seoulit.erp.hr.affair.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class WorkInfoTO extends BaseTO{
	private String empCode, empName, workInfoDays, hiredate, retireDate, userOrNot,
	occupation, employmentType, hobong, position, deptName;

}
