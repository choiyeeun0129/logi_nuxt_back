package kr.co.seoulit.erp.logistic.production.to;

import lombok.Data;

@Data
public class WorkSiteLogTO {
	
	private String workOrderNo;
	private String itemCode;
	private String itemName;
	private String progress;
	private String workSiteName;
	private String workDate;
	private String productionProcessCode;
	private String productionProcessName;

}
