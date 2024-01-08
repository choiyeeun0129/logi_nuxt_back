package kr.co.seoulit.erp.hr.salary.applicationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.hr.salary.dao.BonusDAO;
import kr.co.seoulit.erp.hr.salary.to.BonusTO;

@Component
public class BonusApplicationServiceImpl implements BonusApplicationService{

	
	
	@Autowired
	private BonusDAO bonusDAO;
	
	@Override
	public BonusTO findterBonus(BonusTO bonus) {
		// TODO Auto-generated method stub
		return bonusDAO.selectBonus(bonus);
	}

	@Override
	public void registerBonus(BonusTO bonus) {
		// TODO Auto-generated method stub
		bonusDAO.insertBonus(bonus);
	}

	@Override
	public void removeAllBonus() {
		// TODO Auto-generated method stub
		bonusDAO.deleteAllBonus();
	}
	
}