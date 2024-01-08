package kr.co.seoulit.erp.hr.salary.dao;

import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.erp.hr.salary.to.BonusTO;

@Mapper
public interface BonusDAO {
	public BonusTO selectBonus(BonusTO bonus);

	public void insertBonus(BonusTO bonus);

	public void deleteAllBonus();
}
