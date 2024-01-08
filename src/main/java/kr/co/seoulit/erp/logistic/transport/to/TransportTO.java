package kr.co.seoulit.erp.logistic.transport.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class TransportTO extends BaseTO {
	private String contractNo;
	private String reportingDate;
	private String customerBasicAddress;
	private String customerDetailAddress;
	private String transportStatus;
	private String commercialVehicle;
	private String driver;
	private String memo;
	private String dueDateOfContract;
}
