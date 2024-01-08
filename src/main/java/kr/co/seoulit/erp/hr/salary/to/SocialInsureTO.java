package kr.co.seoulit.erp.hr.salary.to;

import lombok.Data;

@Data

public class SocialInsureTO{
	private String attributionYear,
	healthinsureRates,
	longtermcareRate,
	nationpenisionRates,
	teachpenisionRates,
	empinsureRates,
	wrkinsureRates,
	jobstabilRates,
	vocacompetencyRates,
	industinsureRates,
	industinsurecharRates;
}