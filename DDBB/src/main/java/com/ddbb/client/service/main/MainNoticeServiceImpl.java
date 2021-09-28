package com.ddbb.client.service.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CustomerNoticeDAO;

@Service
public class MainNoticeServiceImpl implements MainService{

	@Autowired
	CustomerNoticeDAO noticeDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		model.addAttribute("noticeMainList",noticeDAO.customerNoticeMainList());
		
	}

}
