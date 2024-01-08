package kr.co.seoulit.erp.hr.salary.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseExtSalTO  extends BaseTO{
	private String extSalCode,
	extSalName,
	ratio,
	status;
}
