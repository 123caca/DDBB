package com.ddbb.admin.service.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.MainBannerDAO;
import com.ddbb.admin.DTO.MainBannerDTO;

@Service
public class MainBannerDetailListServiceImpl implements MainService{

	@Autowired
	MainBannerDAO bannerDAO;
		
	   @Override
	   public void execute(Model model) {
	      Map<String, Object> map = model.asMap();
	      HttpServletRequest re = (HttpServletRequest) map.get("request");
	         
	      String mainBannerNum = re.getParameter("mainBannerNum");

	      model.addAttribute("mainBannerList", bannerDAO.detailList(mainBannerNum));
	      
	   }

}
