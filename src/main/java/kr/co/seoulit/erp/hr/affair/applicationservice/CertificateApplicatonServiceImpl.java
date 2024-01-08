package kr.co.seoulit.erp.hr.affair.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.hr.affair.dao.CertificateDAO;
import kr.co.seoulit.erp.hr.affair.to.CertificateTO;


@Component
public class CertificateApplicatonServiceImpl implements CertificateApplicationService {
	@Autowired
	private CertificateDAO certificateDAO;

	@Override
	public void registRequest(CertificateTO certificate) {
		certificateDAO.insertCertificateRequest(certificate);
	}

	@Override
	public ArrayList<CertificateTO> findCertificateList(String empCode, String startDate, String endDate) {

		HashMap<String, String> data = new HashMap<>();
		data.put("empCode", empCode);
		data.put("startDate", startDate);
		data.put("endDate", endDate);
		ArrayList<CertificateTO> certificateList = certificateDAO.selectCertificateList(data);
		return certificateList;
	}

	@Override
	public void removeCertificateRequest(ArrayList<CertificateTO> certificateList) {

		for (CertificateTO certificate : certificateList) {
			certificateDAO.deleteCertificate(certificate);
		}

	}

	@Override
	public ArrayList<CertificateTO> findCertificateListByDept(String deptName, String startDate, String endDate) {
		ArrayList<CertificateTO> certificateList = null;
		HashMap<String, String> data = new HashMap<>();
		if (deptName.equals("모든부서")) {
			certificateList = certificateDAO.selectCertificateListByAllDept(startDate);
		} else {
			data.put("deptName", deptName);
			data.put("startDate", startDate);
			data.put("endDate", endDate);
			certificateList = certificateDAO.selectCertificateListByDept(data);
		}
		return certificateList;
	}

	@Override
	public ArrayList<CertificateTO> modifyCertificateList(ArrayList<CertificateTO> certificateTO, String deptName,
			String startDate, String endDate) {
		System.out.println("재직증명업데이트 어플리케이션");
		HashMap<String, String> attdApplMap = new HashMap<>();
		HashMap<String, String> data = new HashMap<>();

		for (CertificateTO certificate : certificateTO) {
			System.out.println(certificate.getApprovalStatus());
			if (certificate.getApprovalStatus().equals("apploval")) {
				certificate.setApprovalStatus("승인");
			} else if (certificate.getApprovalStatus().equals("cancel")) {
				certificate.setApprovalStatus("승인취소");
			} else {
				certificate.setApprovalStatus("반려");
			}
			data.put("approvalStatus", certificate.getApprovalStatus());
			data.put("rejectCause", certificate.getRejectCause());
			data.put("empCode", certificate.getEmpCode());
			data.put("requestDate", certificate.getRequestDate());

			certificateDAO.updateCertificate(data);

		}

		ArrayList<CertificateTO> certificateList = findCertificateListByDept(deptName, startDate, endDate);
		return certificateList;
	}

}
