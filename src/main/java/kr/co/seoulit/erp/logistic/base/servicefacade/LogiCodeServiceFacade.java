package kr.co.seoulit.erp.logistic.base.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.logistic.base.to.LogiCodeDetailTO;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeTO;
import org.springframework.ui.ModelMap;

public interface LogiCodeServiceFacade {
	public ModelMap getCodeList();
	public void batchCodeListProcess(LogiCodeTO codeData);
	public ModelMap getSelectCode(String divisionCode);
	public void updateCode(LogiCodeTO logiCodeTO);
	public void deleteLogiCode(String divisionCodeNo);
	public ModelMap getDetailCodeList(String divisionCode);

	public void batchDetailCodeListProcess(LogiCodeDetailTO detailCodeList);

//	public HashMap<String, Object> changeCodeUseCheckProcess(ArrayList<LogiCodeDetailTO> detailCodeList);

	/**
	 * 기초정보
	 *
	 */


}
