package com.ddbb.admin.service.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.AdminUserDAO;

@Service
public class AdminUserdeleteServiceImpl implements MemberManagementService{
	@Autowired
	private AdminUserDAO adminuserdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		List<String> adminuserDelete = (List<String>) map.get("delete");
		for(int i = 0; i < adminuserDelete.size(); i++) {
			adminuserdao.adminUserDelete(adminuserDelete.get(i));
		}
	}
	
}
