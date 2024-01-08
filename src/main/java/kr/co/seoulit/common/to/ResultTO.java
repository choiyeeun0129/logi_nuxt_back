package kr.co.seoulit.common.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultTO {
	private Date date;
    private String message;
    private String details;
	private String errorCode, errorMsg;
}
