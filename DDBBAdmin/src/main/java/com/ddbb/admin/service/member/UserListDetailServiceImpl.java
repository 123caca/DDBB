package com.ddbb.admin.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.UserDAO;
@Service
public class UserListDetailServiceImpl implements MemberManagementService{
	@Autowired
	private UserDAO userdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		
		String userId=re.getParameter("userId");
		
		model.addAttribute("userDTO",userdao.userDetailList(userId));
	}

}
