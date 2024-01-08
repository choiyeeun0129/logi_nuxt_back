package kr.co.seoulit.erp.logistic.sales.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.co.seoulit.erp.logistic.sales.dao.*;
import kr.co.seoulit.erp.logistic.sales.repository.EstimateDetailRepository;
import kr.co.seoulit.erp.logistic.sales.to.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class ContractApplicationServiceImpl implements ContractApplicationService {

	@Autowired
	private ContractDAO contractDAO;
	@Autowired
	private ContractDetailDAO contractDetailDAO;
	@Autowired
	private EstimateDAO estimateDAO;
	@Autowired
	private EstimateDetailDAO estimateDetailDAO;
	@Autowired
	private EstimateDetailRepository estimateDetailRepository;

	@Autowired
	private OutputDAO outputDAO;



	public ArrayList<ContractInfoTO> getContractList(String startDate, String endDate) {

		ArrayList<ContractInfoTO> contractInfoTOList = null;
		HashMap<String, String> param = new HashMap<>();

		param.put("startDate", startDate);
		param.put("endDate", endDate);

		contractInfoTOList = contractDAO.selectContractListByDate(param);

		// 수주번호 들고와야함
		// bean.setContractDetailTOList(contractDetailDAO.selectContractDetailList(bean.getContractNo()));

		return contractInfoTOList;

	}

	// 출고를 위한 수주조회
	public ArrayList<ContractInfoTO> getContractOutputList(String startDate, String endDate) {

		ArrayList<ContractInfoTO> contractOutputInfoTOList = null;
		HashMap<String, String> param = new HashMap<>();

		param.put("startDate", startDate);
		param.put("endDate", endDate);

		contractOutputInfoTOList = contractDAO.selectContractOutputListByDate(param);

		// 수주번호 들고와야함
		// bean.setContractDetailTOList(contractDetailDAO.selectContractDetailList(bean.getContractNo()));

		return contractOutputInfoTOList;

	}

	public ArrayList<ContractInfoTO> getContractListByCustomer(String customerCode) {

		ArrayList<ContractInfoTO> contractInfoTOList = null;

		contractInfoTOList = contractDAO.selectContractListByCustomer(customerCode);

		return contractInfoTOList;

		//출고를 위한 수주조회
	}	public ArrayList<ContractInfoTO> getContractOutputListByCustomer(String customerCode) {

		ArrayList<ContractInfoTO> contractOutputInfoTOList = null;

		contractOutputInfoTOList = contractDAO.selectContractOutputListByCustomer(customerCode);

		return contractOutputInfoTOList;

	}




	public ArrayList<ContractInfoTO> getDeliverableContractList(String searchCondition, String[] paramArray) {

		ArrayList<ContractInfoTO> contractInfoTOList = null;
		HashMap<String, String> param = new HashMap<>();

		switch (searchCondition) {

		case "searchByDate":

			String startDate = paramArray[0];
			String endDate = paramArray[1];

			param.put("startDate", startDate);
			param.put("endDate", endDate);

			contractInfoTOList = contractDAO.selectDeliverableContractListByDate(param);

			break;

		case "searchByCustomer":

			String customerCode = paramArray[0];

			contractInfoTOList = contractDAO.selectDeliverableContractListByCustomer(customerCode);

			break;

		}

		for (ContractInfoTO bean : contractInfoTOList) {

			bean.setContractDetailTOList(contractDetailDAO.selectDeliverableContractDetailList(bean.getContractNo()));

		}

		return contractInfoTOList;

	}

	@Override
	public ArrayList<ContractDetailTO> getContractDetailList(String contractNo) {

		return contractDetailDAO.selectContractDetailList(contractNo);
	}

	@Override
	public ArrayList<ContractDetailTO> getContractOutputDetailList(String contractNo) {

		System.out.println("와랏");
		return contractDetailDAO.getContractOutputDetailList(contractNo);
	}

	@Override
	public ArrayList<EstimateTO> getEstimateListInContractAvailable(String startDate, String endDate) {

		HashMap<String, String> param = new HashMap<>();
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		ArrayList<EstimateTO> estimateListInContractAvailable = contractDAO.selectEstimateListInContractAvailable(param);
		for (EstimateTO bean : estimateListInContractAvailable) {
			bean.setEstimateDetailTOList(estimateDetailDAO.selectEstimateDetailList(bean.getEstimateNo()));

		}
		return estimateListInContractAvailable;
	}

	@Override
	public String getNewContractNo(String contractDate) {

		StringBuffer newContractNo = null;

		int i = contractDAO.selectContractCount(contractDate) + 1;
		newContractNo = new StringBuffer();
		newContractNo.append("CO");
		newContractNo.append(contractDate.replace("-", ""));
		newContractNo.append(String.format("%02d", i)); // CO + contractDate + 01
		System.out.println("newContractNo = "+newContractNo);

		return newContractNo.toString();
	}

	//************************* 2020.09.04 63기 양지훈 수정 시작 *************************
//	description:	파라미터 변경
//					주석 변경
//
	@Override
	public HashMap<String, Object> addNewContract(String contractDate, String personCodeInCharge,
			ContractTO workingContractBean, ArrayList<EstimateDetailTO> estimateDetailArray) {
		System.out.println("ContractApplicationServiceImpl.addNewContract");
		//69기 VUE프로젝트에서 추가
		System.out.println("estimateDetailArray.size() = " + estimateDetailArray.size());
		for (EstimateDetailTO estimateDetailTO : estimateDetailArray) {
			if(estimateDetailTO.getStatus().equals("update")) {
				System.out.println("update돔");
				estimateDetailDAO.updateDueDateOfEstimate(estimateDetailTO);
			}
		}

		String newContractNo = getNewContractNo(contractDate);
		System.out.println("		@ newContractNo: " + newContractNo);
		System.out.println("		@ contractDate: " + contractDate);
		System.out.println("		@ personCodeInCharge: " + personCodeInCharge);
		System.out.println("		@ workingContractTOList: " + workingContractBean);

		// 새로운 수주일련번호 생성
		// CO + contractDate + 01 <= 01은 첫번째라는 뜻 2번째이며 02 로 부여가 됨

		HashMap<String, Object> param = new HashMap<>();

		// 새로운 수주일련번호 세팅
		workingContractBean.setContractNo(newContractNo);
		// 뷰에서 전달한 수주일자 세팅
		workingContractBean.setContractDate(contractDate);
		// 뷰에서 전달한 수주담당자코드 세팅
		workingContractBean.setPersonCodeInCharge(personCodeInCharge);

		contractDAO.insertContract(workingContractBean);

		// 견적 테이블에 수주여부 "Y" 로 수정
		changeContractStatusInEstimate(workingContractBean.getEstimateNo(), "Y");

		param.put("estimateNo", workingContractBean.getEstimateNo());
		param.put("contractNo", newContractNo);

		// ES ... 견적일련번호 , CO ... 수주일련번호
		contractDetailDAO.procedureInsertContractDetail(param);
		System.out.println("???");
		/**/
		return param;
	}
//************************* 2020.09.04 63기 양지훈 수정 종료 *************************

	@Override
	public HashMap<String, Object> batchContractDetailListProcess(ArrayList<ContractDetailTO> contractDetailTOList) {

		HashMap<String, Object> resultMap = new HashMap<>();

		ArrayList<String> insertList = new ArrayList<>();
		ArrayList<String> updateList = new ArrayList<>();
		ArrayList<String> deleteList = new ArrayList<>();

		for (ContractDetailTO bean : contractDetailTOList) {

			String status = bean.getStatus();

			switch (status) {

			case "INSERT":

				/* contractDetailDAO.insertContractDetail(bean); */
				insertList.add(bean.getContractDetailNo());

				break;

			case "UPDATE":

				/* contractDetailDAO.updateContractDetail(bean); */
				updateList.add(bean.getContractDetailNo());

				break;

			case "DELETE":

				contractDetailDAO.deleteContractDetail(bean);
				deleteList.add(bean.getContractDetailNo());

				break;

			}

		}

		resultMap.put("INSERT", insertList);
		resultMap.put("UPDATE", updateList);
		resultMap.put("DELETE", deleteList);

		return resultMap;
	}

	public void changeContractStatusInEstimate(String estimateNo, String contractStatus) {

		HashMap<String, String> param = new HashMap<>();
		param.put("estimateNo", estimateNo);
		param.put("contractStatus", contractStatus);

		estimateDAO.changeContractStatusOfEstimate(param);

	}

}
