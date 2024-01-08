package kr.co.seoulit.erp.logistic.base.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.base.to.LogiCodeDetailTO;

@Mapper
public interface LogiCodeDetailDAO {

	ArrayList<LogiCodeDetailTO> selectDetailCodeList(String divisionCode);

	void insertDetailCode(LogiCodeDetailTO TO);

	void updateDetailCode(LogiCodeDetailTO TO);

	public void deleteDetailCode(LogiCodeDetailTO TO);

	public void changeCodeUseCheck(String divisionCodeNo, String detailCode, String codeUseCheck);

}
