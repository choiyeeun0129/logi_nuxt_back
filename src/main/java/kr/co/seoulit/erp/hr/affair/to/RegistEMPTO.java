package kr.co.seoulit.erp.hr.affair.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
//******************************************************08-27 손유찬 **************************************************** */
@Data
@EqualsAndHashCode(callSuper=false)
public class RegistEMPTO extends BaseTO {
	
	private String companyCode;
	private String userPassword;
	private String updateDate;
	private String workplaceCode;
	private String deptCode;
	private String positionCode;
	private String userId;
	private String phoneNumber;
	private String email;
	private String zipCode;
	private String basicAddress;
	private String detailAddress;
	private String levelOfEducation;
	private String image;
	private String empName;
	private String empEngName;
	private String socialSecurityNumber;
	private String hireDate;
	private String retirementDate;
	private String userOrNot;
	private String birthDate;
	private String gender;
	private String authorityCode;
	private String accessCode;
	
	//******************************************************08-27 손유찬 **************************************************** */
	
}
