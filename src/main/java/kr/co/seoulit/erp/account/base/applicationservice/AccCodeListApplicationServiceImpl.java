package kr.co.seoulit.erp.account.base.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.erp.account.base.repository.AccountControllRepository;
import kr.co.seoulit.erp.account.base.to.AccountControlBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.account.base.dao.AccCodeDAO;
import kr.co.seoulit.erp.account.base.dao.AccDetailCodeDAO;
import kr.co.seoulit.erp.account.base.to.CodeBean;
import kr.co.seoulit.erp.account.base.to.DetailCodeBean;
import kr.co.seoulit.erp.account.base.applicationservice.AccCodeListApplicationService;
import kr.co.seoulit.erp.account.base.applicationservice.AccCodeListApplicationServiceImpl;

@Component
public class AccCodeListApplicationServiceImpl implements AccCodeListApplicationService {

	@Autowired
	private AccCodeDAO codeDAO;
	@Autowired
	private AccDetailCodeDAO detailCodeDAO;

	@Autowired
	private AccountControllRepository accountControllRepository;
	//민상

	@Override
	public ArrayList<AccountControlBean> getControllerCodeList() {
		ArrayList<AccountControlBean> codeList = ( ArrayList<AccountControlBean>)accountControllRepository.findAll();
		return codeList;
	}


	@Override
	public ArrayList<DetailCodeBean> getDetailCodeList(HashMap<String, Object> param) {

		return detailCodeDAO.selectDetailCodeList(param);
	}


	@Override
	public ArrayList<CodeBean> findCodeList() {
		return codeDAO.selectCodeList();
	}

	@Override
	public void batchCodeProcess(ArrayList<CodeBean> codeList, ArrayList<DetailCodeBean> codeList2) {

		for (CodeBean code : codeList) {
			switch (code.getStatus()) {
			case "insert":
				codeDAO.insertCode(code);
				break;
			case "update":
				codeDAO.updateCode(code);
				break;
			case "normal":
				break;
			case "delete":
				codeDAO.deleteCode(code.getDivisionCodeNo());
			}
		}
		ArrayList<DetailCodeBean> DetailcodeList = codeList2;
		for (DetailCodeBean codeDetailBean : DetailcodeList) {
			switch (codeDetailBean.getStatus()) {
			case "insert":
				detailCodeDAO.insertDetailCode(codeDetailBean);
				break;
			case "update":
				detailCodeDAO.updateDetailCode(codeDetailBean);
				break;
			case "delete":
				detailCodeDAO.deleteDetailCode(codeDetailBean.getDetailCode());
			}
		}

	}


}
