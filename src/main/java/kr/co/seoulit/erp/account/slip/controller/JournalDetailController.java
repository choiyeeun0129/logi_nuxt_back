package kr.co.seoulit.erp.account.slip.controller;


import kr.co.seoulit.erp.account.slip.servicefacade.SlipServiceFacade;
import kr.co.seoulit.erp.account.slip.to.JournalDetailBean;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/*")
public class JournalDetailController {
    @Autowired
    private SlipServiceFacade slipServiceFacade;
	 
	//=====================================  일반전표 분개상세조회  2020-09-14 조편백    ==================================== 
	@RequestMapping(value="/account/getJournalDetailList", method=RequestMethod.GET)
    public HashMap<String, Object> getJournalDetailList(@RequestParam("journalNo")String journalNo) {

		System.out.println("분개상세 들어간다아~ ");
        HashMap<String, Object> map=new HashMap<>();
        try {
        ArrayList<JournalDetailBean> journalDetailList=slipServiceFacade.getJournalDetailList(journalNo);
        map.put("journalDetailList",journalDetailList);
        map.put("errorCode",0);
        map.put("errorMsg","등록완료");
 }
        catch(Exception e2){
     	 	map.put("errorCode", -1);
         	map.put("errorMsg", e2.getMessage());
        }
        return map;
        }
    
	 
	//=====================================  일반전표 분개상세저장  2020-09-14 조편백   시작 ==================================== 
	@RequestMapping(value="/account/SaveJournalDetailList", method=RequestMethod.POST)
    public void SaveJournalDetailList(@RequestBody Map<String,ArrayList<JournalDetailBean>> SaveJournalDetailList) {
		   
			JournalDetailBean journalDetailBeans=new JournalDetailBean();
            ArrayList<JournalDetailBean>  journalDetailBeanList = SaveJournalDetailList.get("SaveJournalDetailList");
            System.out.println("11111111"+journalDetailBeanList); 
            for(JournalDetailBean journalDetailBean : journalDetailBeanList ) {

            	journalDetailBeans.setJournalDetailNo(journalDetailBean.getJournalDetailNo());
            	journalDetailBeans.setJournalDescription(journalDetailBean.getJournalDescription());
            	
            	System.out.println("분개상세저장"+journalDetailBeans); //ApplicationServiceImpl 에서 하기귀찮아서 여기서 함 

                slipServiceFacade.editJournalDetail(journalDetailBeans);
            }
            
            
           
           

    }
}