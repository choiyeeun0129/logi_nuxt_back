package kr.co.seoulit.erp.account.base.to;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
@EqualsAndHashCode(callSuper=false)
@Data
public class MenuBean extends BaseTO {
    String MenuCode;
    String MenuName;
    String ParentMenuCode;
    String Url;
    String PositionCode;

}
