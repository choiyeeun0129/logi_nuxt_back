package kr.co.seoulit.erp.hr.affair.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.hr.affair.to.CertificateTO;

@Mapper
public interface CertificateDAO {

	public void insertCertificateRequest(CertificateTO certificate);

	public ArrayList<CertificateTO> selectCertificateList(HashMap<String, String> data);

	public void deleteCertificate(CertificateTO certificate);

	public ArrayList<CertificateTO> selectCertificateListByAllDept(String requestDate);

	public ArrayList<CertificateTO> selectCertificateListByDept(HashMap<String, String> data);

	public void updateCertificate(HashMap<String, String> data);

}