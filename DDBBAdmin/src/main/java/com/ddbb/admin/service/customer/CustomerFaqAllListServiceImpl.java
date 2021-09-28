package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerFaqDAO;

@Service
public class CustomerFaqAllListServiceImpl implements CustomerService {

	@Autowired
	CustomerFaqDAO faqDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest) map.get("request");
		String faqOption=re.getParameter("faqOption");
		String faqSearch=re.getParameter("faqSearch");

		String searchSQL = "";

		if (faqOption == "")
			faqOption = null;
		
		if (faqOption == null) {
			searchSQL = "";
		} else {
			if (faqOption.equals("1"))
				faqOption = "cusFaqTitle";
			else if (faqOption.equals("2"))
				faqOption = "cusQuestionContent";
			else if (faqOption.equals("3"))
				faqOption = "(cusFaqTitle||cusFaqContent)";
			searchSQL = " WHERE " + faqOption + " LIKE '%" + faqSearch + "%'";
		}

		model.addAttribute("faqAllList", faqDAO.customerFaqAllList(searchSQL));
		model.addAttribute("faqCount", faqDAO.faqCount());

	}

}
