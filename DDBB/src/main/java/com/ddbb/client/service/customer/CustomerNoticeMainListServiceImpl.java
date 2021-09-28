package com.ddbb.client.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CustomerNoticeDAO;

@Service
public class CustomerNoticeMainListServiceImpl implements CustomerService{

	@Autowired
	CustomerNoticeDAO noticeDAO;
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
