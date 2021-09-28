package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.ProductQnaDAO;
import com.ddbb.client.DTO.UserDTO;
@Service
public class UserQuestionproQnaServiceImpl implements ProductService{

	@Autowired
	ProductQnaDAO qnaDAO;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		UserDTO user=(UserDTO)session.getAttribute("user");
		String searchSQL="where PROQNAUSERID='"+user.getUserId()+"'";
		// 페이징
				String pagingParam = re.getParameter("paging2");
				int paging, startNum, endNum;
				if (pagingParam == null || pagingParam == "")
					paging = 0;
				else 
					paging = Integer.parseInt(pagingParam);
				if (paging == 0) {
					startNum = 1;
					endNum = 5;
				} else {
					startNum = (paging - 1) * 5 + 1;
					endNum = paging * 5;
				}
				
				model.addAttribute("productQnaList", qnaDAO.UserQuestionProductQnaList(searchSQL, startNum, endNum));
				model.addAttribute("productQnaCount", qnaDAO.UserQuestionProductQnaCount(searchSQL));

		
	}

}
