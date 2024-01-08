package kr.co.seoulit.erp.hr.affair.servicefacade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.hr.affair.applicationservice.CertificateApplicationService;
import kr.co.seoulit.erp.hr.affair.to.CertificateTO;
import kr.co.seoulit.erp.hr.affair.servicefacade.CertificateServiceFacade;

@Service
public class CertificateServiceFacadeImpl implements CertificateServiceFacade {
	
	@Autowired
	private CertificateApplicationService certificateApplicationService;

	public void registRequest(CertificateTO certificate) {
		certificateApplicationService.registRequest(certificate);
	}

	@Override
	public ArrayList<CertificateTO> findCertificateList(String empCode, String startDate, String endDate) {
		ArrayList<CertificateTO> certificateList = certificateApplicationService.findCertificateList(empCode, startDate,
				endDate);
		return certificateList;
	}

	@Override
	public ArrayList<CertificateTO> findCertificateListByDept(String deptName, String startDate, String endDate) {
		ArrayList<CertificateTO> certificateList = certificateApplicationService.findCertificateListByDept(deptName,
				startDate, endDate);
		return certificateList;
	}

	@Override
	public void removeCertificateRequest(ArrayList<CertificateTO> certificateList) {
		certificateApplicationService.removeCertificateRequest(certificateList);
	}

	@Override
	public ArrayList<CertificateTO> modifyCertificateList(ArrayList<CertificateTO> certificateTO, String deptName,
			String startDate, String endDate) {
		ArrayList<CertificateTO> certificateList = certificateApplicationService.modifyCertificateList(certificateTO,
				deptName, startDate, endDate);
		return certificateList;
	}
}
