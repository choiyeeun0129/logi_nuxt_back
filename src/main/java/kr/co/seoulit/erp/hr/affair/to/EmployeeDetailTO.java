package kr.co.seoulit.erp.hr.affair.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EmployeeDetailTO extends BaseTO {
	 private String companyCode;
	 private String empCode;
	 private int seq;
	 private String updateHistory;
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

}