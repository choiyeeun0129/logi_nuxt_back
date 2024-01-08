package kr.co.seoulit.erp.hr.affair.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.affair.to.WorkInfoTO;

@Mapper
public interface WorkInfoDAO {
	public ArrayList<WorkInfoTO> selectWorkList(String empCode);

	public ArrayList<WorkInfoTO> selectWorkInfoList(String empCode);

	public void insertWorkInfo(WorkInfoTO workInfo);;

	public void updateWorkInfo(WorkInfoTO workInfo);

	public void deleteWorkInfo(WorkInfoTO workInfo);
}
