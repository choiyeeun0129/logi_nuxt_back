package kr.co.seoulit.erp.hr.affair.applicationservice;

import java.util.ArrayList;

import kr.co.seoulit.erp.hr.affair.to.CertificateTO;

public interface CertificateApplicationService {
	public void registRequest(CertificateTO certificate);

	public ArrayList<CertificateTO> findCertificateList(String empCode, String startDate, String endDate);

	public void removeCertificateRequest(ArrayList<CertificateTO> certificateList);

	public ArrayList<CertificateTO> findCertificateListByDept(String deptName, String startDate, String endDate);

	public ArrayList<CertificateTO> modifyCertificateList(ArrayList<CertificateTO> certificateTO, String deptName,
			String startDate, String endDate);
}
