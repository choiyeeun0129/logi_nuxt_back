package kr.co.seoulit.erp.hr.affair.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CareerInfoTO extends BaseTO {
	private String empCode, careerCode, companyName, occupation, assignmentTask, exHiredate, exRetirementDate;

}
