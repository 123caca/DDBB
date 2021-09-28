package com.ddbb.admin.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.AdminUserDAO;

@Service
public class AdminUserAddServiceImpl implements MemberManagementService{
	@Autowired
	private AdminUserDAO adminuserdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		String adminUserNums=(String)re.getParameter("adminUserNum");
		int adminUserNum=Integer.parseInt(adminUserNums);
		String adminUserName=(String)re.getParameter("adminUserName");
		String adminUserId=(String)re.getParameter("adminUserId");
		String adminUserPwd=(String)re.getParameter("adminUserPwd");
		
		int adminUserBanner;
		int adminUserCustomer;
		int adminUserProduct;
		int adminUserOrder;

		if(re.getParameterValues("adminUserBanner")!=null) adminUserBanner=1;
		else adminUserBanner=0;
		if(re.getParameterValues("adminUserCustomer")!=null) adminUserCustomer=1;
		else adminUserCustomer=0;
		if(re.getParameterValues("adminUserProduct")!=null) adminUserProduct=1;
		else adminUserProduct=0;
		if(re.getParameterValues("adminUserOrder")!=null) adminUserOrder=1;
		else adminUserOrder=0;
		
		adminuserdao.adminUserAdd(adminUserNum,adminUserName,adminUserId,adminUserPwd,adminUserBanner,adminUserCustomer,adminUserProduct,adminUserOrder);
	
	}

}
