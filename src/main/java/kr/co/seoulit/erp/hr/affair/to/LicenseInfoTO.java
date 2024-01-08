package kr.co.seoulit.erp.hr.affair.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LicenseInfoTO extends BaseTO{
	private String empCode, licenseCode,licenseName, getDate, expireDate, licenseLevel, licenseCenter, issueNumber;

	}
