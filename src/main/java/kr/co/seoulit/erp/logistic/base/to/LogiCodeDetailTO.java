package kr.co.seoulit.erp.logistic.base.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LogiCodeDetailTO extends BaseTO {

	private String divisionCodeNo;
	private String detailCode;
	private String detailCodeName;
	private String codeUseCheck;
	private String description;

}