package kr.co.seoulit.erp.hr.affair.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TempAppointmentTO extends BaseTO{

	String appointmentNo, 
	empCode,
	appointmentHistory,
	currentInformation,
	preAppointmentInformation;
}
