package com.ddbb.admin.service.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.MainBannerDAO;

@Service
public class MainBannerServiceAllListImpl implements MainService{

	@Autowired
	MainBannerDAO bannerDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest) map.get("request");

		model.addAttribute("bannerList", bannerDAO.allList());
		model.addAttribute("bannerCount", bannerDAO.bannerCount());

	}

}
