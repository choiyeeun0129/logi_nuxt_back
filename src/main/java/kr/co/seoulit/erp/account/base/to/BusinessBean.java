package kr.co.seoulit.erp.account.base.to;

import kr.co.seoulit.common.to.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessBean  extends BaseTO {

    private String businessName;
    private String classificationCode;
    private String remarks;

}
