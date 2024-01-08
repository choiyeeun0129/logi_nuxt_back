package kr.co.seoulit.erp.account.base.to;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
@EqualsAndHashCode(callSuper=false)
@Data
public class OpenApiBean2 extends BaseTO{
	private String dateName;
	private String locdate;
	
}
