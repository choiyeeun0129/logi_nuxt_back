package kr.co.seoulit.erp.account.currentAsset.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CurrentAssetDetailBean {
	private String assetCode;
	private String acquistionCost;
	private String depreciation;
	private String bookValue;
	private String amortizationWay;
	private String amortizationFinalYear;
	private String usefulLife;
	private String amortizationRate;
	private String month;
	private String normalAmortization;
	private String RAccumulatedAmortization;
	private String accumulatedAmortization;
	private String bookValueEnd;

}
