package kr.co.seoulit.erp.logistic.base.to;

import java.util.ArrayList;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LogiCodeTO extends BaseTO {

	private String divisionCodeNo;
	private String codeType;
	private String divisionCodeName;
	private String codeChangeAvailable;
	private String description;
	private ArrayList<LogiCodeDetailTO> codeDetailTOList;

}