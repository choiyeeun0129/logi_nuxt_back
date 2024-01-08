package kr.co.seoulit.erp.hr.affair.controller;

import kr.co.seoulit.erp.hr.affair.Exception.UserNotFoundException;
import kr.co.seoulit.erp.hr.affair.servicefacade.EmpServiceFacade;
import kr.co.seoulit.erp.hr.affair.to.EmpTO;
import kr.co.seoulit.erp.hr.affair.to.EmpUpdateTO;
import kr.co.seoulit.erp.hr.affair.to.EmployeeDetailTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/affair/*")
public class EmpController {

    @Autowired
    private EmpServiceFacade empServiceFacade;

    /**
     * <h2>RESTFUL API</h2>
     * 해당컨트롤러는 뷰에서 구현한 인사관리의 용도에 맞게 재설정되었습니다.<br/>
     * EmpAssign , EmpDetail, EmpRegist Controller를 사용하지 않는쪽으로 설정<br/>
     * Success 에러코드,에러메세지 AOP 설정은 시간관계상 하지않았습니다.<br/>
     * 직접구현하시면 도움이 되실듯합니다.
//     **/

    @GetMapping("/empList")
    public ResponseEntity<Map<String,Object>> empList() {

        Map<String, Object> map = new HashMap<String, Object>();
        List<EmpTO> list = empServiceFacade.findEmpList();

        if(list.isEmpty())
            throw new UserNotFoundException("사용자 정보가 없습니다.");


        map.put("empList", list);
        map.put("errorMsg", "success");
        map.put("errorCode", 0);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/empList/{empCode}")
    public ResponseEntity<Map<String, Object>> findEmp(@PathVariable String empCode) {
        ArrayList<EmployeeDetailTO> empDetail = null;
        Map<String, Object> map = new HashMap<String, Object>();

            empDetail = empServiceFacade.findEmpDetail(empCode);

            if(empDetail.isEmpty())
                throw new UserNotFoundException("검색된 사용자 정보가 없습니다.");

            map.put("empDetailInfo", empDetail);
            map.put("errorCode", 1);
            map.put("errorMsg", "success");

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @PutMapping("/empList")
    public ResponseEntity<EmpUpdateTO> updateEmp (@RequestBody EmpUpdateTO emp){

        empServiceFacade.updateEmpInfo(emp);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp)
                .toUri();

        return ResponseEntity.created(location).build();
    }
//

    @RequestMapping("/list")
    public Map<String, Object> emplist(@RequestParam String dept, HttpServletResponse response) {
        System.out.println("부서명호출");
        System.out.println(dept);
        Map<String, Object> map = new HashMap<String, Object>();

        List<EmpTO> list = empServiceFacade.findEmpList(dept);
        map.put("list", list);

        return map;
    }

    @RequestMapping(value = "/memberList", method = RequestMethod.GET)
    public Map<String, Object> emplist(@RequestParam String value) {
        System.out.println("리스트");
        System.out.println(value);
        Map<String, Object> map = new HashMap<String, Object>();
        if (value == null)
            value = "전체부서";

        List<EmpTO> list = empServiceFacade.findEmpMemberList(value);
        System.out.println("list:" + list);
        map.put("list", list);
        map.put("errorMsg", "success");
        map.put("errorCode", 0);

        return map;
    }

    /*
     * public ModelAndView workInfoList(HttpServletRequest request,
     * HttpServletResponse response) {
     * response.setContentType("application/json; charset=UTF-8"); // TODO
     * Auto-generated method stub HashMap<String, Object> map = new HashMap<String,
     * Object>(); String viewName = null; try { String code =
     * request.getParameter("code");
     *
     * EmpServiceFacadeImpl sf = EmpServiceFacadeImpl.getInstance();
     *
     * ListForm listForm = new ListForm();
     *
     *
     * ArrayList<EmpTO> list = sf.workInfoList(code); map.put("list", list);
     *
     * JSONObject jsonobject = JSONObject.fromObject(map); PrintWriter out =
     * response.getWriter(); out.println(jsonobject);
     * System.out.println(jsonobject); } catch (Exception e) { viewName = "error";
     * map.put("errorCode", -1); map.put("errorMsg", e.getMessage()); JSONObject
     * jsonobject = JSONObject.fromObject(map); try { PrintWriter out =
     * response.getWriter(); out.println(jsonobject); } catch (IOException e1) { //
     * TODO Auto-generated catch block e1.printStackTrace(); } } ModelAndView
     * modelAndView = null; return null; }
     */

}