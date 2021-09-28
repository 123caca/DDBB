package com.ddbb.admin.service.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerNoticeDAO;

@Service
public class CustomerNoticeDeleteServiceImpl implements CustomerService {

	@Autowired
	private CustomerNoticeDAO noticeDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		List<String> noticeDelete = (List<String>) map.get("delete");
		for(int i = 0; i < noticeDelete.size(); i++) {
			noticeDAO.customerNoticeDelete(noticeDelete.get(i));;
		}

	}

}