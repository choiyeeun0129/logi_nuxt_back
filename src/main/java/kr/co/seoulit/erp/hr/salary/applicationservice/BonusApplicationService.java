package kr.co.seoulit.erp.hr.salary.applicationservice;

import kr.co.seoulit.erp.hr.salary.to.BonusTO;

public interface BonusApplicationService {
	public BonusTO findterBonus(BonusTO bonus);
	public void registerBonus(BonusTO bonus);
	public void removeAllBonus();
}