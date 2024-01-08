package kr.co.seoulit.erp.hr.affair.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EmployeeSecretTO extends BaseTO {
	
	 private String companyCode;
	 private String empCode;
	 private int seq;
	 private String userPassword;

}