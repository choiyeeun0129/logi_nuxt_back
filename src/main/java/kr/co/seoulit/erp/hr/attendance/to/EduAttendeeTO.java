package kr.co.seoulit.erp.hr.attendance.to;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EduAttendeeTO {
	private String classCode;
	private String empNo;
	private String empName;
	private String startDate;
	private String endDate;
	private String totalHours;
	private String attendanceScore;
	private String testScore;
	private String totalScore;
	private String cost;
	private String actualCharge;
	private String status;

}