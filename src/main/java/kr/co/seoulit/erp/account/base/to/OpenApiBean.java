package kr.co.seoulit.erp.account.base.to;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
@EqualsAndHashCode(callSuper=false)
@Data
public class OpenApiBean extends BaseTO{
	private String sidonm;
	private String co;
	private String no;
	private String so;
	private String tsp;
	private String pm;
	private String voc;
	private String pm2;
	private String nh3;

}
