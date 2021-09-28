package com.ddbb.client.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ddbb.client.service.login.UserModifyServiceImpl;
import com.ddbb.client.service.login.UserdeleteServiceImpl;
import com.ddbb.client.service.product.ProductQnaDeleteServiceImpl;
import com.ddbb.client.service.product.ProductQnaDetailListServiceImpl;
import com.ddbb.client.service.product.ProductQnaModifyServiceImpl;
import com.ddbb.client.service.product.ProductQnaModifyfnServiceImpl;
import com.ddbb.client.service.product.ProductReviewDeleteServiceImpl;
import com.ddbb.client.service.product.ProductReviewModifyServiceImpl;
import com.ddbb.client.service.product.ProductReviewModifyfnServiceImpl;
import com.ddbb.client.service.product.UserQuestionproQnaServiceImpl;
import com.ddbb.client.service.product.UserReviewListServiceImpl;
import com.ddbb.client.service.customer.CustomerQuestionDeleteServiceImpl;
import com.ddbb.client.service.customer.CustomerQuestionDetailListServiceImpl;
import com.ddbb.client.service.customer.CustomerQuestionModifyServiceImpl;
import com.ddbb.client.service.customer.UserQuestionQnaServiceImpl;

@Controller
public class ClientMypageController {
	// 회원 정보 관리
	@Autowired
	private UserModifyServiceImpl UserModifyServiceImpl;
	@Autowired
	private UserdeleteServiceImpl UserdeleteServiceImpl;
	// 주문 조회
	// 나의 질문
	@Autowired
	private UserQuestionQnaServiceImpl UserQuestionQnaServiceImpl;
	@Autowired
	private UserQuestionproQnaServiceImpl UserQuestionproQnaServiceImpl;
	@Autowired
	private ProductQnaDetailListServiceImpl productQnaDetailList;
	@Autowired
	private CustomerQuestionDetailListServiceImpl questionDetailList;
	@Autowired
	private CustomerQuestionModifyServiceImpl questionModify;
	@Autowired
	private CustomerQuestionDeleteServiceImpl questionDel;
	@Autowired
	private ProductQnaModifyServiceImpl productQnaModify;
	@Autowired
	private ProductQnaModifyfnServiceImpl productQnaModifyfn;
	@Autowired
	private ProductQnaDeleteServiceImpl productQnaDelete;
	// 상품 리뷰
		@Autowired
		private UserReviewListServiceImpl userReviewList;
		@Autowired
		private ProductReviewModifyServiceImpl productReviewModify;
		@Autowired
		private ProductReviewModifyfnServiceImpl productReviewModifyfn;
		@Autowired
		private ProductReviewDeleteServiceImpl productReviewDelete;


	// 마이페이지
	@RequestMapping(value = "mypage")
	public String mypage(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
			
		return "mypage/mypage";
	}

	// ---------------------------------------
	// 회원 정보 관리
	// ---------------------------------------
	// 회원 정보 관리 페이지
	@RequestMapping(value = "user_info")
	public String user_info(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		return "mypage/user_info";
	}

	// 회원 정보 수정 페이지
	@RequestMapping(value = "user_modify_chk")
	public String user_modify_chk(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		return "mypage/user_modify_chk";
	}

	// 회원 정보 수정 페이지
	@RequestMapping(value = "user_modify")
	public String user_modify(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		return "mypage/user_modify";
	}

	// 회원 정보 결과 페이지
	@RequestMapping(value = "user_modify_result")
	public String user_modify_result(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		UserModifyServiceImpl.execute(model);
		return "mypage/user_info";
	}

	// 회원 정보 삭제 페이지
	@RequestMapping(value = "user_delete")
	public String user_delete(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		return "mypage/user_delete";
	}

	// 회원 정보 삭제 확인 페이지
	@RequestMapping(value = "user_delete_chk")
	public String user_delete_chk(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		return "mypage/user_delete_chk";
	}

//	// 회원 정보 삭제
//	@RequestMapping(value = "user_delete_result")
//	public String user_delete_result(HttpServletRequest request, Model model) {
//		if (request.getSession().getAttribute("user") == null)
//			return "redirect:login";
//		
//		model.addAttribute("request", request);
//		UserdeleteServiceImpl.execute(model);
//		return "index";
//	}
	// 회원 정보 삭제
	   @RequestMapping(value="user_delete_result")
	   public String user_delete_result(HttpServletRequest request, Model model) {
	      if (request.getSession().getAttribute("user") == null)
	         return "redirect:login";
	      
	      model.addAttribute("request", request);
	      UserdeleteServiceImpl.execute(model);
	      return "redirect:index";
	   }
	

	// ---------------------------------------
	// 장바구니
	// ---------------------------------------

	// ---------------------------------------
	// 찜목록
	// ---------------------------------------

	// --------------------------------
	// 주문 조회(결제 포함)
	// --------------------------------

	// ---------------------------------------
	// 나의 질문
	// ---------------------------------------
	// 나의 질문과 답변 페이지
	@RequestMapping(value = "user_question")
	public String user_question(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		UserQuestionQnaServiceImpl.execute(model); // 1:1 문의
		UserQuestionproQnaServiceImpl.execute(model); // 상품 문의
		return "mypage/user_question";
	}

	// 나의 1:1문의 상세 페이지
	@RequestMapping(value = "my_question_con")
	public String my_question_con(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		questionDetailList.execute(model);
		return "mypage/my_question_con";
	}

	// 1:1문의 수정 페이지
	@RequestMapping(value = "my_question_update")
	public String my_question_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		questionDetailList.execute(model);
		return "mypage/my_question_update";
	}

	// 1:1 문의 수정 체크
	@RequestMapping(value = "my_question_update_fin")
	public String my_question_update_fin(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		questionModify.execute(model);
		return "redirect:user_question";
	}

	// 1:1문의 삭제
	@RequestMapping(value = "my_question_del")
	public String my_question_del(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		questionDel.execute(model);
		return "redirect:user_question";
	}

	// 나의 상품 Q&A 컨텐츠 페이지
	@RequestMapping(value = "my_product_qna_con")
	public String my_product_qna_con(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		productQnaDetailList.execute(model);
		return "mypage/my_product_qna_con";
	}

	
	// 상품 Q&A 수정 페이지 ( 해당 게시글 정보 가져오기 )
		@RequestMapping(value = "my_product_qna_update")
		public String my_product_qna_update(HttpServletRequest request, Model model) {
			if (request.getSession().getAttribute("user") == null)
				return "redirect:login";
			model.addAttribute("request", request);
			productQnaModify.execute(model);
			return "mypage/my_product_qna_update";
		}

		// 상품 Q&A 수정 페이지 ( 새로 입력한 값으로 데이터 수정 )
		@RequestMapping(value = "my_product_qna_update_fn")
		public String my_product_qna_update_fn(HttpServletRequest request, Model model) {
			if (request.getSession().getAttribute("user") == null)
				return "redirect:login";
			model.addAttribute("request", request);
			productQnaModifyfn.execute(model);

			String proName = request.getParameter("proQnaProName");
			model.addAttribute("proName", proName);
			return "redirect:user_question";
		}

		// 상품 Q&A 삭제 페이지
		@RequestMapping(value = "my_product_qna_delete")
		public String my_product_qna_delete(HttpServletRequest request, Model model) {
			if (request.getSession().getAttribute("user") == null)
				return "redirect:login";
			model.addAttribute("request", request);
			productQnaDelete.execute(model);

			String proName = request.getParameter("proQnaProName");
			model.addAttribute("proName", proName);
			return "redirect:user_question";
		}
	// ---------------------------------------
	// 내가 쓴 상품평
	// ---------------------------------------
	@RequestMapping(value="user_review")
	public String user_review(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		userReviewList.execute(model);
		return "mypage/user_review";
	}
	  
	// 상품 리뷰 수정 페이지 ( 해당 게시글 정보 가져오기 )
	@RequestMapping(value = "my_review_update")
	public String my_review_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		productReviewModify.execute(model);
		return "mypage/my_review_update";
	}

	// 상품 리뷰 수정 페이지 ( 새로 입력한 값으로 데이터 수정 )
	@RequestMapping(value = "my_review_update_fn")
	public String my_review_update_fn(MultipartHttpServletRequest mtf, HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		String fileTag = "proReviewImg";
		String filePath = "C:\\Users\\USER\\Desktop\\Project\\DDBB\\src\\main\\webapp\\resources\\images\\product\\review\\";
		MultipartFile file = mtf.getFile(fileTag);
		String fileName = file.getOriginalFilename();
		try {
			file.transferTo(new File(filePath + fileName));
		} catch (Exception e) {
		}

		model.addAttribute("fileName", fileName);
		model.addAttribute("request", request);
		productReviewModifyfn.execute(model);
		return "redirect:user_review";
	}

	// 상품 리뷰 삭제 페이지
	@RequestMapping(value = "my_review_delete")
	public String my_review_delete(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		productReviewDelete.execute(model);
		return "redirect:user_review";
	}

}
