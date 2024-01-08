package kr.co.seoulit.erp.account.base.controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import kr.co.seoulit.erp.account.base.servicefacade.*;
import kr.co.seoulit.erp.account.base.to.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/*")
public class WorkPlaceController{
	
	@Autowired
    private AccWorkplaceServiceFacade workplaceServiceFacade;
    
    @RequestMapping(value="/company/workPlaceAdd", method=RequestMethod.POST)
    public Map<String, Object> workPlaceAdd(@RequestBody WorkplaceBean workplaceBean) {
    	
    	Map<String, Object> map = new HashMap<String, Object>();

            workplaceServiceFacade.workplaceAdd(workplaceBean);
            map.put("errorCode", 0);
            map.put("errorMsg", "회사등록완료");

        return map;
    }
    
    @RequestMapping(value="/company/eliminationWorkplace", method=RequestMethod.DELETE)
    public void eliminationWorkplace(@RequestParam("codes")String codes ) {
  //이부분 대체 어떻게 날아오는지 확인 json인지 그냥 requestparam 셀 코드 하나가 날아오는지 
    	//아니 이거 좀 이상하다 나중에 수정좀 
//    		ArrayList<String> getCodes = new ArrayList<>();
//			JSONArray jsonArray=JSONArray.fromObject(codes);
//			
//			for(Object obj :jsonArray) {
//				String code=(String)obj;
//				getCodes.add(code);
//			}
//            
//            workplaceServiceFacade.eliminationWorkplace(getCodes);
    		
    }
    
    @RequestMapping(value="/company/getWorkplace", method=RequestMethod.POST)
    public ModelAndView getWorkplace(HttpServletRequest request, HttpServletResponse response) {

			ModelAndView modelAndView = new ModelAndView("jsonView");

            String workplaceCode=request.getParameter("workplaceCode");
            WorkplaceBean workplaceBean = workplaceServiceFacade.getWorkplace(workplaceCode);
            WorkplaceBean emptyWorkplaceBean = new WorkplaceBean();
            
            modelAndView.addObject("workplaceBean", workplaceBean);
            modelAndView.addObject("emptyWorkplaceBean", emptyWorkplaceBean);

        return modelAndView;
    }
    
	public ModelAndView getAllWorkplaceList(HttpServletRequest request, HttpServletResponse response) {
			
			ModelAndView modelAndView = new ModelAndView("jsonView");
			
			ArrayList<WorkplaceBean> allWorkplaceList = workplaceServiceFacade.getAllWorkplaceList();
			modelAndView.addObject("allWorkplaceList",allWorkplaceList);
			modelAndView.addObject("errorCode", 0);

		return modelAndView;

	}
	

	public ModelAndView updateApprovalStatus(HttpServletRequest request, HttpServletResponse response) {

			ModelAndView modelAndView = new ModelAndView("jsonView");
			
			ArrayList<String> getCodes = new ArrayList<>();
			String status=request.getParameter("status");
//			String codes=request.getParameter("codes");
			
//			JSONArray jsonArray=JSONArray.fromObject(codes);
//			for(Object obj :jsonArray) {
//				String code=(String)obj;
//				getCodes.add(code);
//			}
	
			workplaceServiceFacade.updateApprovalStatus(getCodes,status);
			modelAndView.addObject("errorCode", 0);
			modelAndView.addObject("errorMsg", "거래처변경완료");
			
			return modelAndView;
	}
}
