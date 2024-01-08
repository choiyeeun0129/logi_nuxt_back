package kr.co.seoulit.erp.logistic.production.servicefacade;


import kr.co.seoulit.erp.logistic.production.dao.MrpDAO;
import kr.co.seoulit.erp.logistic.production.to.MpsTO;

import kr.co.seoulit.erp.logistic.production.to.MrpTO;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class MrpServiceFacadeImpl implements MrpServiceFacade {

    private final MrpDAO mrpDAO;

    @Autowired
    public MrpServiceFacadeImpl(MrpDAO mrpDAO) {
        this.mrpDAO = mrpDAO;
    }


    /*****************************
            MPS 테이블 조회
     *****************************/

    @Override
    public Map<String, List<MpsTO>> getMpsList(String startDate, String endDate) {
        List<MpsTO> mpsList = mrpDAO.getMpsList(startDate, endDate);
        HashMap<String, List<MpsTO>> result = new HashMap<>();
        result.put("result", mpsList);
        return result;
    }

    /*****************************
                MPS 수정
     *****************************/

    @Override
    public void updateMps(MpsTO mpsTO) {
        mrpDAO.updateMps(mpsTO);
    }

    /*****************************
              MRP 모의전개
     *****************************/

    @Override
    public HashMap<String, Object> openMrp(String mpsNo) {

        HashMap<String, Object> param = new HashMap<>();
        param.put("mpsNo", mpsNo);
        mrpDAO.openMrp(param);
        HashMap<String, Object> map = new HashMap<>();

        try {
            map.put("result", param.get("RESULT"));
        } catch (Exception e2) {
            e2.printStackTrace();
            map.put("errorCode", -2);
            map.put("errorMsg", e2.getMessage());
        }
        return map;
    }


    /*****************************
                MRP 등록
     *****************************/
    @Override
    public HashMap<String, Object> registerMrp(String mrpRegisterDate, ArrayList<MrpTO> newMrpList) {

        List<MrpTO> mrpTOList = mrpDAO.selectMrpCount(mrpRegisterDate);

        /* custom 메서드 호출(getNewMrpNo,batchMrpListProcess) */
        HashSet<String> mpsNoList = getNewMrpNo(mrpRegisterDate, newMrpList, mrpTOList);
        HashMap<String, Object> resultMap = batchMrpListProcess(newMrpList);

        for (String mpsNo : mpsNoList) {
            HashMap<String, String> param = new HashMap<>();
            param.put("mpsNo", mpsNo);
            param.put("mrpStatus", "Y");
            mrpDAO.changeMrpApplyStatus(param);
        }

        try {
            resultMap.put("result", resultMap);
            resultMap.put("errorCode", 1);
            resultMap.put("errorMsg", "�꽦怨�");
        } catch (Exception e2) {
            e2.printStackTrace();
            resultMap.put("errorCode", -2);
            resultMap.put("errorMsg", e2.getMessage());
        }

        return resultMap;
    }

    private HashSet<String> getNewMrpNo(String mrpRegisterDate, ArrayList<MrpTO> newMrpList, List<MrpTO> mrpTOList) {
        TreeSet<Integer> intSet = new TreeSet<>();

        int i;

        for (MrpTO bean : mrpTOList) {
            String mrpNo = bean.getMrpNo();
            int no = Integer.parseInt(mrpNo.substring(mrpNo.length() - 3, mrpNo.length()));
            intSet.add(no);
        }

        if (intSet.isEmpty()) {
            i = 1;
        } else {
            i = intSet.pollLast() + 1;
        }

        StringBuffer newMrpNo = new StringBuffer();
        newMrpNo.append("RP");
        newMrpNo.append(mrpRegisterDate.replace("-", ""));
        newMrpNo.append("-");

        HashSet<String> mpsNoList = new HashSet<>();

        for (MrpTO bean : newMrpList) {
            bean.setMrpNo(newMrpNo + String.format("%03d", i++));
            bean.setStatus("INSERT");
            mpsNoList.add(bean.getMpsNo());
        }
        return mpsNoList;
    }

    public HashMap<String, Object> batchMrpListProcess(ArrayList<MrpTO> mrpTOList) {

        HashMap<String, Object> resultMap = new HashMap<>();
        ArrayList<String> insertList = new ArrayList<>();
        ArrayList<String> updateList = new ArrayList<>();
        ArrayList<String> deleteList = new ArrayList<>();

        for (MrpTO bean : mrpTOList) {
            String status = bean.getStatus();
            switch (status) {

                case "INSERT":
                    mrpDAO.insertMrp(bean);
                    insertList.add(bean.getMrpNo());
                    break;

                case "UPDATE":
                    mrpDAO.updateMrp(bean);
                    updateList.add(bean.getMrpNo());
                    break;

                case "DELETE":
                    mrpDAO.deleteMrp(bean);
                    deleteList.add(bean.getMrpNo());
                    break;
            }
        }

        resultMap.put("INSERT", insertList);
        resultMap.put("UPDATE", updateList);
        resultMap.put("DELETE", deleteList);

        return resultMap;
    }
}
