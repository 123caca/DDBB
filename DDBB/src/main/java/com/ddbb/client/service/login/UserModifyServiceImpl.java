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
public class UserModifyServiceImpl implements LoginService{
	@Autowired
	private UserDAO userdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		String userId=(String)re.getParameter("id");
		String userPwd=(String)re.getParameter("pwd");
		String userName=(String)re.getParameter("name");
		String userEmail=(String)re.getParameter("email1")+"@"+(String)re.getParameter("email2");
		String userPhone=(String)re.getParameter("phone1")+"-"+(String)re.getParameter("phone2")
			+"-"+(String)re.getParameter("phone3");
		String userAddress=(String)re.getParameter("address1")+"-"+(String)re.getParameter("address3")+"-"+(String)re.getParameter("address4");
		userdao.userModify(userId,userPwd,userName,userEmail,userPhone,userAddress);
		HttpSession session = re.getSession();
		UserDTO userDTO=(UserDTO)session.getAttribute("user");
		userDTO.setUserAddress(userAddress);
		userDTO.setUserEmail(userEmail);
		userDTO.setUserName(userName);
		userDTO.setUserPhone(userPhone);
		userDTO.setUserPwd(userPwd);

	}

}
