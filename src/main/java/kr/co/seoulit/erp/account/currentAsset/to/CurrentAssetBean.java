package kr.co.seoulit.erp.account.currentAsset.to;


import java.util.ArrayList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CurrentAssetBean {
  private String accountCode;
  private String accountName;
  private String assetCode;
  private String assetName;
  private String progress;
  private String finalizeStatus;
  private String checkStatus;
  private ArrayList<CurrentAssetDetailBean> currentAssetDetailBean;
  
}
