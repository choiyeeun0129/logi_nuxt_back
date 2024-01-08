package kr.co.seoulit.erp.logistic.base.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.seoulit.erp.logistic.base.domain.Client;
import kr.co.seoulit.erp.logistic.base.domain.Finance;
import kr.co.seoulit.erp.logistic.base.servicefacade.ClientServiceFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Api(description = "거래처정보")
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/*")
public class ClientController {
    /* 75기 최영현 작성 및 수정 : 1. JPA CRUD를 이용한 단순화 및 단순화에 따른 applicationservice 삭제
     */
    @Autowired
    private ClientServiceFacade ClientSF;

    /*****************************
     일반거래처
     *****************************/
    @ApiOperation(value = "일반거래처 조회")
    @RequestMapping(value = "/base/searchClientList", method = RequestMethod.GET)
    public ModelMap searchClientList(){
        return ClientSF.searchClientList();
    }
    @ApiOperation(value = "일반거래처 상세조회")
    @RequestMapping(value = "/base/searchClientDetailList", method = RequestMethod.GET)
    public ModelMap searchClientDetailList(@RequestParam @ApiParam( value = "일반거래처코드") String customerCodes){
        return ClientSF.searchClientDetailList(customerCodes);
    }
    @ApiOperation(value = "일반거래처 등록")
    @PostMapping("/base/insertClient")
    public void insertClient(@RequestBody @ApiParam(value = "일반거래처JSON")Client clientdata){
        ClientSF.insertClient(clientdata);
    }
    @ApiOperation(value = "일반거래처 삭제")
    @DeleteMapping("/base/deleteClient/{customerCode}")
    public void deleteClient(@PathVariable @ApiParam(value = "일반거래처JSON")String customerCode){
        ClientSF.deleteClient(customerCode);
    }

    @ApiOperation(value = "일반거래처 수정")
    @PutMapping("/base/updateClient")
    public void updateClient(@RequestBody @ApiParam(value = "일반거래처JSON")Client clientdata){
        ClientSF.updateClient(clientdata);
    }

    /*****************************
     금융거래처
     *****************************/
    @ApiOperation(value = "금융거래처 조회")
    @RequestMapping(value = "/base/searchFinanceList", method = RequestMethod.GET)
    public ModelMap searchFinanceList(){
        return ClientSF.searchFinanceList();
    }
    @ApiOperation(value = "금융거래처 상세조회")
    @RequestMapping(value = "/base/searchFinanceDetailList", method = RequestMethod.GET)
    public ModelMap searchFinanceDetailList(@RequestParam @ApiParam(value = "금융거래처코드") String code){
        return ClientSF.searchFinanceDetailList(code);
    }
    @ApiOperation(value = "금융거래처 등록")
    @PostMapping("/base/insertFinance")
    public void insertFinance(@RequestBody @ApiParam(value = "금융거래처JSON")Finance clientdata){
        ClientSF.insertFinance(clientdata);
    }
    @ApiOperation(value = "금융거래처 삭제")
    @DeleteMapping("/base/deleteFinance/{accountAssociatesCode}")
    public void deleteFinance(@PathVariable @ApiParam(value = "금융거래처JSON")String accountAssociatesCode){
        ClientSF.deleteFinance(accountAssociatesCode);
    }
    @ApiOperation(value = "금융거래처 수정")
    @PutMapping("/base/updateFinance")
    public void updateFinance(@RequestBody @ApiParam(value = "금융거래처JSON")Finance clientdata){
        ClientSF.updateFinance(clientdata);
    }
}
