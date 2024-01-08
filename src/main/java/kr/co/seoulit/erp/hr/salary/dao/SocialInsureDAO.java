package kr.co.seoulit.erp.hr.salary.dao;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.erp.hr.salary.to.SocialInsureTO;

@Mapper
public interface SocialInsureDAO {
	public ArrayList<SocialInsureTO> selectBaseInsureList(String searchYear);
}