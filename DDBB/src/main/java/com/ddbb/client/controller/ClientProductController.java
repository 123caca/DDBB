package com.ddbb.client.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ddbb.client.DTO.UserDTO;
import com.ddbb.client.service.product.CartAddServiceImpl;
import com.ddbb.client.service.product.CartDeleteServiceImpl;
import com.ddbb.client.service.product.CartServiceImpl;
import com.ddbb.client.service.product.OrderAddServiceImpl;
import com.ddbb.client.service.product.OrderListServiceImpl;
import com.ddbb.client.service.product.OrderSimpleAddServiceImpl;
import com.ddbb.client.service.product.OrderSimpleListServiceImpl;
import com.ddbb.client.service.product.ProductDetailListServiceImpl;
import com.ddbb.client.service.product.ProductListServiceImpl;
import com.ddbb.client.service.product.ProductQnaAddServiceImpl;
import com.ddbb.client.service.product.ProductQnaDeleteServiceImpl;
import com.ddbb.client.service.product.ProductQnaDetailListServiceImpl;
import com.ddbb.client.service.product.ProductQnaListServiceImpl;
import com.ddbb.client.service.product.ProductQnaModifyServiceImpl;
import com.ddbb.client.service.product.ProductQnaModifyfnServiceImpl;
import com.ddbb.client.service.product.ProductReviewAddServiceImpl;
import com.ddbb.client.service.product.ProductReviewDeleteServiceImpl;
import com.ddbb.client.service.product.ProductReviewListServiceImpl;
import com.ddbb.client.service.product.ProductReviewModifyServiceImpl;
import com.ddbb.client.service.product.ProductReviewModifyfnServiceImpl;
import com.ddbb.client.service.product.WishListDeleteServiceImpl;
import com.ddbb.client.service.product.WishListAddServiceImpl;
import com.ddbb.client.service.product.WishListServiceImpl;
import com.ddbb.client.service.product.wishListDeleteChkBox;
import com.ddbb.client.service.product.wishListAllDelete;

@Controller
public class ClientProductController {

	// 상품
	@Autowired
	private ProductListServiceImpl productList;
	@Autowired
	private ProductDetailListServiceImpl productDetailList;
	// 상품 Q&A
	@Autowired
	private ProductQnaListServiceImpl productQnaList;
	@Autowired
	private ProductQnaDetailListServiceImpl productQnaDetailList;
	@Autowired
	private ProductQnaAddServiceImpl productQnaAdd;
	@Autowired
	private ProductQnaModifyServiceImpl productQnaModify;
	@Autowired
	private ProductQnaModifyfnServiceImpl productQnaModifyfn;
	@Autowired
	private ProductQnaDeleteServiceImpl productQnaDelete;
	// 상품 리뷰
	@Autowired
	private ProductReviewListServiceImpl productReviewList;
	@Autowired
	private ProductReviewAddServiceImpl productReviewAdd;
	@Autowired
	private ProductReviewModifyServiceImpl productReviewModify;
	@Autowired
	private ProductReviewModifyfnServiceImpl productReviewModifyfn;
	@Autowired
	private ProductReviewDeleteServiceImpl productReviewDelete;
	// 장바구니
	@Autowired
	private CartServiceImpl cart;
	@Autowired
	private CartAddServiceImpl cartAdd;
	@Autowired
	private CartDeleteServiceImpl cartDelete;
	// 찜목록
	@Autowired
	private WishListServiceImpl wishList;
	@Autowired
	private WishListAddServiceImpl wishListAdd;
	@Autowired
	private WishListDeleteServiceImpl wishListDelete;
	@Autowired
	private wishListDeleteChkBox wishListDeleteChkBox;
	@Autowired
	private wishListAllDelete wishListAllDelete;
	// 주문조회
	@Autowired
	private OrderSimpleListServiceImpl orderSimpleList;
	@Autowired
	private OrderSimpleAddServiceImpl orderSimpleAdd;
	@Autowired
	private OrderListServiceImpl orderList;
	@Autowired
	private OrderAddServiceImpl orderAdd;

	// ---------------------------------------
	// 상품
	// ---------------------------------------
	// 상품 전체 리스트 출력
	@RequestMapping(value = "product")
	public String product(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		productList.execute(model);
		return "product/product";
	}

	// 상품 상세 페이지 출력
	@RequestMapping(value = "product_con")
	public String product_con(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		productDetailList.execute(model); // 상품 데이터 출력
		productReviewList.execute(model); // 상품 리뷰 리스트 출력
		productQnaList.execute(model); // 상품 Q&A 리스트 출력
		return "product/product_con";
	}

	// ---------------------------------------
	// 상품 리뷰
	// ---------------------------------------
	// 상품 리뷰 작성 페이지 ( 해당 게시글 정보 가져오기 )
	@RequestMapping(value = "review_write")
	public String review_write(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		return "mypage/review_write";
	}

	// 상품 리뷰 작성 페이지 ( 새로 입력한 값으로 데이터 수정 )
	@RequestMapping(value = "review_write_fn", method = RequestMethod.POST)
	public String review_write_fn(MultipartHttpServletRequest mtf, HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		String fileTag = "proReviewImg";
		String filePath = "resources\\images\\product\\review";
		String uploadPath = request.getSession().getServletContext().getRealPath(filePath);
		MultipartFile file = mtf.getFile(fileTag);
		String fileName = file.getOriginalFilename();
		try {
			file.transferTo(new File(uploadPath + "\\" + fileName));
		} catch (Exception e) {
		}

		model.addAttribute("fileName", fileName);
		model.addAttribute("request", request);
		productReviewAdd.execute(model);
		orderList.execute(model);
		return "mypage/buy_list_con";
	}
  
	// 상품 리뷰 수정 페이지 ( 해당 게시글 정보 가져오기 )
	@RequestMapping(value = "review_update")
	public String review_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		productReviewModify.execute(model);
		return "mypage/review_update";
	}

	// 상품 리뷰 수정 페이지 ( 새로 입력한 값으로 데이터 수정 )
	@RequestMapping(value = "review_update_fn")
	public String review_update_fn(MultipartHttpServletRequest mtf, HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		String fileTag = "proReviewImg";
		String filePath = "resources\\images\\product\\review";
		String uploadPath = request.getSession().getServletContext().getRealPath(filePath);
		MultipartFile file = mtf.getFile(fileTag);
		String fileName = file.getOriginalFilename();
		try {
			file.transferTo(new File(uploadPath + "\\" + fileName));
		} catch (Exception e) {
		}

		model.addAttribute("fileName", fileName);
		model.addAttribute("request", request);
		productReviewModifyfn.execute(model);
		orderList.execute(model);
		return "mypage/buy_list_con";
	}

	// 상품 리뷰 삭제 페이지
	@RequestMapping(value = "review_delete")
	public String review_delete(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		productReviewDelete.execute(model);
		orderList.execute(model);
		return "mypage/buy_list_con";
	}

	// ---------------------------------------
	// 상품 Q&A
	// ---------------------------------------
	// 상품 Q&A 컨텐츠 페이지
	@RequestMapping(value = "product_qna_con")
	public String product_qna_con(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		productQnaDetailList.execute(model);
		return "product/product_qna_con";
	}

	// 상품 Q&A 작성 페이지 ( 해당 게시글 정보 가져오기 )
	@RequestMapping(value = "product_qna_write")
	public String product_qna_write(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		return "product/product_qna_write";
	}

	// 상품 Q&A 작성 페이지 ( 새로 입력한 값으로 데이터 수정 )
	@RequestMapping(value = "product_qna_write_fn")
	public String product_qna_write_fn(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		productQnaAdd.execute(model);

		String proName = request.getParameter("proQnaProName");
		model.addAttribute("proName", proName);
		return "redirect:product_con";
	}

	// 상품 Q&A 수정 페이지 ( 해당 게시글 정보 가져오기 )
	@RequestMapping(value = "product_qna_update")
	public String product_qna_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		productQnaModify.execute(model);
		return "product/product_qna_update";
	}

	// 상품 Q&A 수정 페이지 ( 새로 입력한 값으로 데이터 수정 )
	@RequestMapping(value = "product_qna_update_fn")
	public String product_qna_update_fn(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		productQnaModifyfn.execute(model);

		String proName = request.getParameter("proQnaProName");
		model.addAttribute("proName", proName);
		return "redirect:product_con";
	}

	// 상품 Q&A 삭제 페이지
	@RequestMapping(value = "product_qna_delete")
	public String product_qna_delete(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		productQnaDelete.execute(model);

		String proName = request.getParameter("proQnaProName");
		model.addAttribute("proName", proName);
		return "redirect:product_con";
	}

	// ---------------------------------------
	// 장바구니
	// ---------------------------------------
	// 장바구니 출력
	@RequestMapping(value = "cart")
	public String cart(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("user");

		if (userDTO == null) {
			return "login/login"; // 로그인이 안 되어 있을 때 로그인 화면으로
		} else {
			cart.execute(model);
			return "mypage/cart";
		}
	}

	// 장바구니 추가
	@RequestMapping(value = "cart_add")
	public String cart_add(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("user");

		if (userDTO == null) {
			return "login/login"; // 로그인이 안 되어 있을 때 로그인 화면으로
		} else {
			cartAdd.execute(model);
			if (request.getParameter("history").equals("1")) {
				return "redirect:cart"; // "예" 클릭 시 장바구니 화면으로
			} else {
				String proName = request.getParameter("proName"); // "아니오"클릭 시 파라미터값 넘겨주기 위해
				model.addAttribute("proName", proName); // 현재 상품 페이지의 상품명을 모델에 담는다.
				return "redirect:product_con"; // "아니오" 클릭 시 현재 있던 상품 페이지로
			}
		}
	}

	// 장바구니 삭제
	@RequestMapping(value = "cart_delete")
	public String cart_delete(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		cartDelete.execute(model);
		return "redirect:cart";
	}

	// ---------------------------------------
	// 찜목록
	// ---------------------------------------
	// 찜목록 출력
	@RequestMapping(value = "wish_list")
	public String wish_list(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("user");
		if (userDTO == null) {
			return "login/login";
		} else {
			wishList.execute(model);
			return "mypage/wish_list";
		}
	}

	// 찜목록 추가
	@RequestMapping(value = "wish_list_add")
	public String wish_list_add(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("user");
		if (userDTO == null) {
			return "login/login";
		} else {
			wishListAdd.execute(model);
			String proName = request.getParameter("proName");
			model.addAttribute("proName", proName);
			if (request.getParameter("history").equals("1"))
				return "redirect:wish_list";
			else
				return "redirect:product_con";
		}
	}

	// 찜목록 삭제
	@RequestMapping(value = "wish_list_delete")
	public String wish_list_delete(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		wishListDelete.execute(model);
		return "redirect:wish_list";
	}

	// 찜목록 다중 삭제
	@RequestMapping(value = "wish_list_delete_chkbox")
	public String wish_list_delete_chkbox(@RequestParam(value = "chBox") List<String> list, Model model,
			HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("wishList", list);
		model.addAttribute("request", request);
		wishListDeleteChkBox.execute(model);
		return "redirect:wish_list";
	}

	// 찜목록 모두 삭제
	@RequestMapping(value = "wish_list_alldelete")
	public String wish_list_alldelete(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		wishListAllDelete.execute(model);
		return "redirect:wish_list";
	}

	// ---------------------------------------
	// 주문조회 ( 결제 포함 )
	// ---------------------------------------
	// 상품 결제 ( 출력 )
	@RequestMapping(value = "buy")
	public String buy(@RequestParam(value = "chBox", required = false) List<String> list, HttpServletRequest request,
			Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("chBox", list);
		model.addAttribute("request", request);
		return "mypage/buy";
	}

	// 상품 결제 ( 기능 - 주문 테이블에 값 넣기 )
	@RequestMapping(value = "buy_fn")
	public String buy_fn(@RequestParam(value = "cartList", required = false) List<String> list,
			HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("cartList", list);
		model.addAttribute("request", request);
		orderSimpleAdd.execute(model); // 주문조회 테이블에 데이터 추가
		orderAdd.execute(model); // 주문조회 상세 테이블에 데이터 추가
		return "redirect:buy_list";
	}

	// 주문조회 출력 ( buyOrderSimple Table )
	@RequestMapping(value = "buy_list")
	public String buy_list(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		orderSimpleList.execute(model);
		return "mypage/buy_list";
	}

	// 주문조회 출력 ( buyOrder Table )
	@RequestMapping(value = "buy_list_con")
	public String buy_list_con(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		orderList.execute(model);
		return "mypage/buy_list_con";
	}

}
