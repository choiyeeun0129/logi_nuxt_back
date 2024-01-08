package kr.co.seoulit.erp.hr.affair.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class CertificateTO extends BaseTO {
	private String empCode, empName, deptName, requestDate, useDate, usageCode, 
	usageName, etc, approvalStatus, rejectCause;	
	}
