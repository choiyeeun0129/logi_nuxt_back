package kr.co.seoulit.erp.sys.to;

import java.util.List;

import lombok.Data;

@Data
public class SysCodeTo {

	private String code;
	private String codeName;
	private String editStatus;
	private String codeGroup;
	private List<SysCodeDetailTo> codeDetailList;

}
