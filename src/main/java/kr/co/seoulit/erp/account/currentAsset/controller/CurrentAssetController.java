package kr.co.seoulit.erp.account.currentAsset.controller;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.account.base.to.AccountCodeBean;
import kr.co.seoulit.erp.account.currentAsset.servicefacade.CurrentAssetFacedeService;
import kr.co.seoulit.erp.account.currentAsset.to.CurrentAssetBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/*")
public class CurrentAssetController {
	
	@Autowired
	private CurrentAssetFacedeService currentAssetFacedeService;
	
	@RequestMapping(value ="/CurrentAsset/CurrentAssetCode", method = RequestMethod.GET)
	public  ArrayList<AccountCodeBean> currentAssetCode(){
	 
			System.out.println("@@@@#@#@#");
		return currentAssetFacedeService.currentAssetCode();
	}
	@RequestMapping(value = "/CurrentAsset/findCurrentAssetList", method = RequestMethod.POST)
	public  ArrayList<CurrentAssetBean> findCurrentAssetList(@RequestBody  HashMap<String, Object> params){
	
			System.out.println("@@!!!!!!@@#@#@#"+params);  
		return currentAssetFacedeService.findCurrentAssetList(params);
	}
	@RequestMapping(value = "/CurrentAsset/insertCurrentAsset", method = RequestMethod.POST)
	public  void insertCurrentAsset(@RequestBody  HashMap<String, Object> params){
	
			System.out.println("@@!!!!!!@@#@#@#"+params);  
		 currentAssetFacedeService.insertCurrentAsset(params);
	}
	@RequestMapping(value = "/CurrentAsset/deleteCurrentAsset", method = RequestMethod.GET)
	public void deleteCurrentAsset(@RequestParam String assetCode){
		System.out.println(":##"+assetCode);
		currentAssetFacedeService.deleteCurrentAsset(assetCode);
	}
 
}
  