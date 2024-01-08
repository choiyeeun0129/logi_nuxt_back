package kr.co.seoulit.erp.logistic.base.dao;

import java.util.ArrayList;

import kr.co.seoulit.erp.logistic.base.to.LogiCodeDTO;
import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.base.to.LogiCodeTO;

@Mapper
public interface LogiCodeDAO {

	public ArrayList<LogiCodeTO> selectCodeList();

	public void insertCode(LogiCodeTO codeTO);

	public LogiCodeTO selectCode(String divisionCode);

	public void updateCode(LogiCodeTO logiCodeTO);

	public void deleteCode(LogiCodeTO logiCodeTO);
	public void deleteLogiCode(String divisionCodeNo);

	public String createDivisionCodeNo(String codeType);

}
