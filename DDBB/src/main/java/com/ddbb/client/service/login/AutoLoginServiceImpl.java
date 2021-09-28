package com.ddbb.client.service.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.UserDAO;
import com.ddbb.client.DTO.UserDTO;
@Service
public class AutoLoginServiceImpl implements LoginService {

	@Autowired
	private UserDAO userdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		String userID = (String) map.get("userID");
		UserDTO userDTO= userdao.autologin(userID);
		
		if(userDTO!=null) {
			session.setAttribute("user", userDTO);
		} 
	}

}
