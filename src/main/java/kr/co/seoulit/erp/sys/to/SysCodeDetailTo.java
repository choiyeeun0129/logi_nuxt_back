package kr.co.seoulit.erp.sys.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;

@Data
public class SysCodeDetailTo extends BaseTO {

	private String divisionCodeNo;
	private String detailCode;
	private String detailCodeName;
	private String codeUseCheck;
	private String description;


}
