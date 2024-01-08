package kr.co.seoulit.erp.sys.serviceFacade;

import kr.co.seoulit.erp.hr.affair.to.EmpInfoTO;
import kr.co.seoulit.erp.sys.exception.IdNotFoundException;
import kr.co.seoulit.erp.sys.exception.PwMissMatchException;
import kr.co.seoulit.erp.sys.to.*;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface BaseServiceFacade {

	List<MenuTo> findMenuList();
	
	//여기여기
	EmpInfoTO myLogin(LoginTo loginTo) throws DataAccessException, IdNotFoundException, PwMissMatchException;
	
	List<SysCodeTo> findCodeList();
	List<SysCodeDetailTo> findCodeDetailList();
	List<SysCodeDetailTo> findPayStepCodeDetailList(String itemClassificationCondition);
	
	List<AuthorityTo> findAuthorityList();
	
	List<AuthorityTo> findMenuAuthorityList(Map<String, Object> data);

	<T> void batchDetailCodeProcess(T bean, Map<String, Object> codeColumn);
	void batchDetailCodeProcess(List<SysCodeDetailTo> codeDetailList);
	// DetailCode 변경저장

}
