package com.ddbb.admin.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.AdminUserDAO;

@Service
public class AdminUserListServiceImpl implements MemberManagementService{
	@Autowired
	private AdminUserDAO adminuserdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		String sort=re.getParameter("sort");
		String search=re.getParameter("search");
		String searchContent=re.getParameter("searchContent");
		String searchsql;
		String sortsql;
		String pagings = re.getParameter("paging");
		
		int paging;
		int pagingstart;
		int pagingend;
		if(pagings==null|| pagings=="") paging=0;
		else paging=Integer.parseInt(pagings);
		
		if(sort=="") sort=null;
		if(search=="") search=null;
		if(paging==0) {
			pagingstart=1;
			pagingend=10;
		} else {
			pagingstart=(paging-1)*10+1;
			pagingend=(paging)*10;
		}
		if(sort==null&&search==null) {
			sortsql=" ORDER BY adminUserNum ASC";
			searchsql="";
		} else if(sort!=null&&search==null) {
			if(sort.equals("adminUserBanner")||sort.equals("adminUserCustomer")||sort.equals("adminUserProduct")||sort.equals("adminUserOrder")) {
				sortsql=" ORDER BY "+sort+" DESC";
			}else {
				sortsql=" ORDER BY "+sort+" ASC";
			}
			searchsql="";
		} else if(search!=null&&sort==null) {
			sortsql="";
			searchsql=" WHERE " + search + " LIKE '%" + searchContent + "%'";
			
		}else {
			if(sort.equals("adminUserBanner")||sort.equals("adminUserCustomer")||sort.equals("adminUserProduct")||sort.equals("adminUserOrder")) {
				sortsql=" ORDER BY "+sort+" DESC";
			}else {
				sortsql=" ORDER BY "+sort+" ASC";
			}
			searchsql=" WHERE " + search + " LIKE '%" + searchContent + "%'";
		}
		model.addAttribute("adminUserList",adminuserdao.adminUserList(sortsql,searchsql,pagingstart,pagingend));
		model.addAttribute("adminUserListTotal",adminuserdao.adminUserListTotal(searchsql));
	}

}
