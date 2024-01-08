package kr.co.seoulit.erp.account.base.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeBean extends BaseTO {
    private String divisionCodeNo;
    private String codeType;
    private String divisionCodeName;

}
