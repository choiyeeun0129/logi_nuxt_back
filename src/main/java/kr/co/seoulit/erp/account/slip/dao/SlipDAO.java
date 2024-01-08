package kr.co.seoulit.erp.account.slip.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.account.slip.to.SlipBean;

@Mapper
public interface SlipDAO {

    public ArrayList<SlipBean> selectSlipDataList(String slipDate);

    public void deleteSlip(String slipNo);

    public void updateSlip(SlipBean slipBean);

    public void insertSlip(SlipBean slipBean);

    void approveSlip(SlipBean slipBean);

    public ArrayList<SlipBean> selectRangedSlipList(HashMap<String,Object> map);

    public ArrayList<SlipBean> selectDisApprovalSlipList();

    public int selectSlipCount(String today);
}
