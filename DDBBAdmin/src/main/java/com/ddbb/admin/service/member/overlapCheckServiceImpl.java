package com.ddbb.admin.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.AdminUserDAO;

@Service
public class overlapCheckServiceImpl implements MemberManagementService{
	@Autowired
	private AdminUserDAO adminuserdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		String adminUserNum=(String)re.getParameter("adminUserNum");
		String adminUserId=(String)re.getParameter("adminUserId");
		
		if(adminUserNum!=null) {
			int result=adminuserdao.overlapCheck("adminUserNum",adminUserNum);
			model.addAttribute("overlapchk",result);
		}else if(adminUserId!=null) {
			int result=adminuserdao.overlapCheck("adminUserId",adminUserId);
			model.addAttribute("overlapchk",result);
		}

	}

}
