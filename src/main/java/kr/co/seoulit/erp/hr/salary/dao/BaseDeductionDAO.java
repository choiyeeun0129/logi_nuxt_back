package kr.co.seoulit.erp.hr.salary.dao;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.erp.hr.salary.to.BaseDeductionTO;

@Mapper
public interface BaseDeductionDAO {
	public ArrayList<BaseDeductionTO> selectBaseDeductionList();

	public void updateBaseDeduction(BaseDeductionTO baseDeduction);

	public void insertBaseDeduction(BaseDeductionTO baseDeduction);

	public void deleteBaseDeduction(BaseDeductionTO baseDeduction);

}
