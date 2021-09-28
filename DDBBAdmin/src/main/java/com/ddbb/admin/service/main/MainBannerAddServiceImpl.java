package com.ddbb.admin.service.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.MainBannerDAO;
import com.ddbb.admin.DTO.MainBannerDTO;

@Service
public class MainBannerAddServiceImpl implements MainService{

	@Autowired
	MainBannerDAO bannerDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest) map.get("request");
		
		String mainBannerTitle = re.getParameter("mainBannerTitle");
		String mainBannerLink = re.getParameter("mainBannerLink");
			if(mainBannerLink==null) { mainBannerLink="disable";}
		String mainBannerSort = re.getParameter("mainBannerSort");

	      // 이미지 출력
	      String mainBannerImg = (String) map.get("fileName");
	      mainBannerImg = "resources/images/main/banner/" + mainBannerImg;
	      
		MainBannerDTO dto = new MainBannerDTO();
		dto.setMainBannerTitle(mainBannerTitle);
		dto.setMainBannerImg(mainBannerImg);
		dto.setMainBannerLink(mainBannerLink);
		dto.setMainBannerSort(Integer.parseInt(mainBannerSort));
		
		bannerDAO.bannerAdd(dto);

	}
	
}
