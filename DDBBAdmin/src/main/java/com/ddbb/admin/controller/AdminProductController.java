package com.ddbb.admin.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ddbb.admin.service.product.OrderListServiceImpl;
import com.ddbb.admin.service.product.OrderSimpleListServiceImpl;
import com.ddbb.admin.service.product.OrderSimpleModifyServiceImpl;
import com.ddbb.admin.service.product.ProductAddServiceImpl;
import com.ddbb.admin.service.product.ProductAllListServiceImpl;
import com.ddbb.admin.service.product.ProductDeleteServiceImpl;
import com.ddbb.admin.service.product.ProductModifyFnServiceImpl;
import com.ddbb.admin.service.product.ProductModifyServiceImpl;
import com.ddbb.admin.service.product.ProductQnaAllListServiceImpl;
import com.ddbb.admin.service.product.ProductQnaAnswerFnServiceImpl;
import com.ddbb.admin.service.product.ProductQnaAnswerServiceImpl;
import com.ddbb.admin.service.product.ProductQnaDeleteServiceImpl;
import com.ddbb.admin.service.product.ProductQnaNoAnswerServiceImpl;


@Controller
public class AdminProductController {

	// 상품
	@Autowired
	private ProductAllListServiceImpl productList;
	@Autowired
	private ProductAddServiceImpl productAdd;
	@Autowired
	private ProductModifyServiceImpl productModify;
	@Autowired
	private ProductModifyFnServiceImpl productModifyfn;
	@Autowired
	private ProductDeleteServiceImpl productDelete;
	// 상품 Q&A
	@Autowired
	private ProductQnaAllListServiceImpl productQnaAllList;
	@Autowired
	private ProductQnaAnswerServiceImpl productQnaAnswer;
	@Autowired
	private ProductQnaAnswerFnServiceImpl productQnaAnswerFn;
	@Autowired
	private ProductQnaNoAnswerServiceImpl productQnaNoAnswer;
	@Autowired
	private ProductQnaDeleteServiceImpl productQnaDelete;
	// 주문 / 배송
	@Autowired
	private OrderSimpleListServiceImpl orderSimpleList;
	@Autowired
	private OrderListServiceImpl orderList;
	@Autowired
	private OrderSimpleModifyServiceImpl orderSimpleModify;

	
	// ---------------------------------------
	// 					상품
	// ---------------------------------------
	// 상품 리스트 출력
	@RequestMapping(value="product")
	public String product(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		productList.execute(model);
		return "product/product";
	}
	
	
	// 상품 추가
	@RequestMapping(value="product_add")
	public String product_add(HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		return "product/product_add";
	}
	
	@RequestMapping(value="product_add_fn", method = RequestMethod.POST)
	public String product_add_fn(MultipartHttpServletRequest mtf, HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		String fileTag1 = "proImg";
		String fileTag2 = "proContentImg";
		String filePath1 = "C:\\Users\\USER\\Desktop\\Project\\DDBB\\src\\main\\webapp\\resources\\images\\product\\";
		String filePath2 = "C:\\Users\\USER\\Desktop\\Project\\DDBB\\src\\main\\webapp\\resources\\images\\product\\content\\";
		MultipartFile file1 = mtf.getFile(fileTag1); 
		MultipartFile file2 = mtf.getFile(fileTag2); 
		String fileName1 = file1.getOriginalFilename();
		String fileName2 = file2.getOriginalFilename();
		try {
			file1.transferTo(new File(filePath1 + fileName1));
			file2.transferTo(new File(filePath2 + fileName2));
		} catch (Exception e) {
			System.out.println("업로드 오류");
		}
		
		model.addAttribute("fileName1", fileName1);
		model.addAttribute("fileName2", fileName2);
		model.addAttribute("request", request);
		productAdd.execute(model);
		return "redirect:product";
	}
	
	
	// 상품 수정
	@RequestMapping(value="product_update")
	public String product_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		productModify.execute(model);
		return "product/product_update"; 
	}
	
	@RequestMapping(value="product_update_fn")
	public String product_update_fn(MultipartHttpServletRequest mtf, HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		String fileTag1 = "proImg";
		String fileTag2 = "proContentImg";
		String filePath1 = "C:\\Users\\USER\\Desktop\\Project\\DDBB\\src\\main\\webapp\\resources\\images\\product\\";
		String filePath2 = "C:\\Users\\USER\\Desktop\\Project\\DDBB\\src\\main\\webapp\\resources\\images\\product\\content\\";
		MultipartFile file1 = mtf.getFile(fileTag1); 
		MultipartFile file2 = mtf.getFile(fileTag2); 
		String fileName1 = file1.getOriginalFilename();
		String fileName2 = file2.getOriginalFilename();
		try {
			file1.transferTo(new File(filePath1 + fileName1));
			file2.transferTo(new File(filePath2 + fileName2));
		} catch (Exception e) {
			System.out.println("업로드 오류");
		}
		
		model.addAttribute("fileName1", fileName1);
		model.addAttribute("fileName2", fileName2);
		model.addAttribute("request", request);
		productModifyfn.execute(model);
		return "redirect:product";
	}
	
	
	// 상품 삭제
	@RequestMapping(value="product_delete", method = RequestMethod.POST)
	public String product_delete(HttpServletRequest request,@RequestParam(value="chBox") List<String> list, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("delete", list);
		productDelete.execute(model);
		return "redirect:product";
	}

	
	
	// ---------------------------------------
	// 				상품 Q&A
	// ---------------------------------------
	// 상품 Q&A 리스트 출력
	@RequestMapping(value="product_qna")
	public String product_qna(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		productQnaAllList.execute(model);
		return "product/product_qna";
	}
	
	// 상품 Q&A 상세 페이지 출력
	@RequestMapping(value="product_qna_answer")
	public String product_qna_answer(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		productQnaAnswer.execute(model);
		return "product/product_qna_answer";
	}
	
	// 상품 Q&A 답변달기
	@RequestMapping(value="product_qna_answer_fn")
	public String product_qna_answer_fn(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		productQnaAnswerFn.execute(model);
		return "redirect:product_qna";
	}

	// 상품 Q&A 삭제
	@RequestMapping(value="product_qna_delete", method = RequestMethod.POST)
	public String product_qna_delete(HttpServletRequest request,@RequestParam(value="chBox") List<String> list, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("delete", list);
		productQnaDelete.execute(model);
		return "redirect:product_qna";
	}
	

	
	// ---------------------------------------
	// 				   주문 / 배송
	// ---------------------------------------
	// 주문배송 페이지 출력
	@RequestMapping(value="order")
	public String order(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		orderSimpleList.execute(model);
		return "order/order";
	}
	
	// 주문배송 상세 페이지 출력
	@RequestMapping(value="order_con")
	public String order_con(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		orderList.execute(model);
		return "order/order_con";
	}
	
	// 주문배송 수정
	@RequestMapping(value="order_update")
	public String order_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		orderSimpleModify.execute(model);
		return "redirect:order";
	}
}
