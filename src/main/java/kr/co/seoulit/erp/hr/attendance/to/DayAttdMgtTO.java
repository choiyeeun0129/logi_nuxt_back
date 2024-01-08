package kr.co.seoulit.erp.hr.attendance.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DayAttdMgtTO extends BaseTO{
	
   private String empCode, empName, applyDays ,dayAttdCode
   ,dayAttdName ,attendTime,HalfHolidayStatus
   ,quitTime ,lateWhether ,leaveHour ,workHour,earlyLeaveHour
   ,overWorkHour ,nightWorkHour ,finalizeStatus, privateleaveHour, publicleaveHour, status ;
   
   
}