package com.ddbb.client.service.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.UserDAO;
@Service
public class IdCheckServiceImpl implements LoginService{
	@Autowired
	private UserDAO userdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		String userId=(String)re.getParameter("userId");
		model.addAttribute("userIdchk",userdao.idCheck(userId));
	}
}
