package kr.co.seoulit.erp.logistic.sales.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.seoulit.erp.logistic.sales.entity.ClientDelivery;
import kr.co.seoulit.erp.logistic.sales.entity.SalesPlane;
import kr.co.seoulit.erp.logistic.sales.to.*;
import org.springframework.ui.ModelMap;

public interface SalesServiceFacade {

	// EstimateApplicationServiceImpl
	public ArrayList<EstimateTO> getEstimateList(String dateSearchCondition, String startDate, String endDate);

	public ArrayList<EstimateDetailTO> getEstimateDetailList(String estimateNo);

	public ArrayList<logisticExelTO> getLogisticExel(String estimateNo);

	public HashMap<String, Object> addNewEstimate(String estimateDate, EstimateTO newEstimateTO);

	public HashMap<String, Object> batchEstimateDetailListProcess(ArrayList<EstimateDetailTO> estimateDetailTOList);

	// ContractApplicationServiceImpl
	public ArrayList<ContractInfoTO> getContractList(String startDate, String endDate);
	public ArrayList<ContractInfoTO> getContractOutputList(String startDate, String endDate);

	public ArrayList<ContractInfoTO> getContractListByCustomer(String customerCode);
	public ArrayList<ContractInfoTO> getContractOutputListByCustomer(String customerCode);

	public ArrayList<ContractInfoTO> getDeliverableContractList(String searchCondition, String[] paramArray);

	public ArrayList<ContractDetailTO> getContractDetailList(String estimateNo);

	// 출고를 위한 수주상세조회
	public ArrayList<ContractDetailTO> getContractOutputDetailList(String contractNo);

	public ArrayList<EstimateTO> getEstimateListInContractAvailable(String startDate, String endDate);

//	description:	파라미터 타입 & 이름 변경

	public HashMap<String, Object> addNewContract(String contractDate, String personCodeInCharge,
												  ContractTO workingContractTO, ArrayList<EstimateDetailTO> estimateDetailTO);

	public HashMap<String, Object> batchContractDetailListProcess(ArrayList<ContractDetailTO> contractDetailTOList);

	public void changeContractStatusInEstimate(String estimateNo, String contractStatus);

	// SalesPlanApplicationServiceImpl
	public ArrayList<SalesPlanTO> getSalesPlanList(String dateSearchCondition, String startDate, String endDate);

	public void batchSalesPlanListProcess(SalesPlanTO salesPlanTOList);

	public HashMap<String, Object> batchDeliveryListProcess(List<DeliveryInfoTO> deliveryTOList);

	public HashMap<String, Object> deliver(String contractDetailNo);

	public ArrayList<DeliveryInfoTO> getDeliveryInfoList();

	public Map<String, ArrayList<DeliveryInfoTO>> deliverUpdate(Map<String, ArrayList<DeliveryInfoTO>> deliverUpdate);

	public ArrayList<SalesPlanTO> getSalesPlan();

	public void UpdateSalesPlanListProcess(SalesPlanTO salesPlanTOList);

	public List<SalesPlane> findSalesPlan();

	public SalesPlane salesplansave(SalesPlane salesPlan);

	public void saelsplanupdate(SalesPlane salesPlan);

	public void  deletesalesplan(String sales);

	// 출고
	public ModelMap getOutputList();

	public ModelMap getOutputDetailList(String outputNumber);
//	public void insertOutput(OutputTO outputList);
	Map<String, Object> addNewOutput(Map<String, Object> params);
	public void deleteOutput(String outputNumber);

	//배송서비스
	public ModelMap getClientDeliveryList();
	Map<String, Object> addNewClientDelivery(Map<String, Object> params);

	public void updateClientDelivery(ClientDelivery clientDelivery);

	public void deleteClientDelivery(String deliveryNumber);

	//반품
	public HashMap<String, Object> getReturnList(String startDate, String endDate);

	public ModelMap returnListForStock();

    public void updateReturn(ReturnTO returnList);

    public void deleteReturn(String returnNo);

    Map<String, Object> addReturn(Map<String, Object> params);

	//반품재고입고
	public ArrayList<ReturnStockTO> searchReturnStockList(String itemCode);

	public void deleteReturnStock(String rtrnRecNo);

	Map<String, Object> addReturnStock(Map<String, Object> params);

}
