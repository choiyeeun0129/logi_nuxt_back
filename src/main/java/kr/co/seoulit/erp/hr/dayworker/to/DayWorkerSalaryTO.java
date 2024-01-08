package kr.co.seoulit.erp.hr.dayworker.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DayWorkerSalaryTO extends BaseTO{
	private String
				empCode,
				empName, 
				lastWorkDate,
				daySalary,
				monthSalary;
			
}
