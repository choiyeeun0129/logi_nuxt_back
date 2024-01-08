package kr.co.seoulit.erp.hr.attendance.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class annualVacationMgtTO extends BaseTO implements Serializable {
	@Id
	private String empCode;
	@Id
	private String applyYearMonth;

	@Column(nullable = false)
	private String empName, afternoonOff, monthlyLeave, remainingHoliday, finalizeStatus;

}