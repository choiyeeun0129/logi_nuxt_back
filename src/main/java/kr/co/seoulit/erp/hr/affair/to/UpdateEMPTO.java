package kr.co.seoulit.erp.hr.affair.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
//******************************************************08-27 손유찬 **************************************************** */
@Data
@EqualsAndHashCode(callSuper=false)
public class UpdateEMPTO extends BaseTO {
	
	private String empCode;
	private String email;
	private String zipCode;
	private String basicAddress;
	private String levelOfEducation;
	private String empName;
	private String birthDate;
	private String gender;
	
	//******************************************************08-27 손유찬 **************************************************** */
	
}
