package kr.co.seoulit.erp.logistic.transport.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class CommercialVehicleInfoTO extends BaseTO {
	private String commercialVehicle;
	private String driver;
	private String transportStatus;
}
