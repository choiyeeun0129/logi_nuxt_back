package kr.co.seoulit.erp.account.base.to;

import kr.co.seoulit.common.to.*;
import lombok.*;

@EqualsAndHashCode(callSuper=false)
@Data
public class AddressBean extends BaseTO{
	
    String zipNo;
    String zipcode;
    String sido;
    String sigungu;
    String dong;
    String ri;
    String bunji;
    String sidoname;
    String roadName;
    String buildingCode1;
    String buildingCode2;

}
