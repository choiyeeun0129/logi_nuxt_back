package kr.co.seoulit.erp.hr.attendance.to;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CorporateEduTO {
	private String classCode;
	private String className;
	private String startDate;
	private String endDate;
	private String instructor;
	private String cost;
	private String classTime;

}
