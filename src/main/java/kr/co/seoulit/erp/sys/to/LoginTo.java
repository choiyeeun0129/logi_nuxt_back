package kr.co.seoulit.erp.sys.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginTo extends BaseTO {
	
    private String empCode;
    private String password;
    private String companyCode;
    private String workplaceCode;
    
}
