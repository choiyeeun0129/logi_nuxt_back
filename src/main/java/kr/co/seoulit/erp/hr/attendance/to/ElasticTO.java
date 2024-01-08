package kr.co.seoulit.erp.hr.attendance.to;


import lombok.Data;

@Data
public class ElasticTO {
	private String
					empCode,
					applyDay,
					startTime,
					endTime;
}
