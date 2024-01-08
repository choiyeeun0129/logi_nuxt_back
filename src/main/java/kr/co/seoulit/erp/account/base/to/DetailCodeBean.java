package kr.co.seoulit.erp.account.base.to;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DetailCodeBean extends BaseTO {
    private String divisionCodeNo;
    private String detailCode;
    private String detailCodeName;
    private String description;

}
