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

	// ??????
	@Autowired
	private ProductListServiceImpl productList;
	@Autowired
	private ProductDetailListServiceImpl productDetailList;
	// ?????? Q&A
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
	// ?????? ??????
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
	// ????????????
	@Autowired
	private CartServiceImpl cart;
	@Autowired
	private CartAddServiceImpl cartAdd;
	@Autowired
	private CartDeleteServiceImpl cartDelete;
	// ?????????
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
	// ????????????
	@Autowired
	private OrderSimpleListServiceImpl orderSimpleList;
	@Autowired
	private OrderSimpleAddServiceImpl orderSimpleAdd;
	@Autowired
	private OrderListServiceImpl orderList;
	@Autowired
	private OrderAddServiceImpl orderAdd;

	// ---------------------------------------
	// ??????
	// ---------------------------------------
	// ?????? ?????? ????????? ??????
	@RequestMapping(value = "product")
	public String product(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		productList.execute(model);
		return "product/product";
	}

	// ?????? ?????? ????????? ??????
	@RequestMapping(value = "product_con")
	public String product_con(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		productDetailList.execute(model); // ?????? ????????? ??????
		productReviewList.execute(model); // ?????? ?????? ????????? ??????
		productQnaList.execute(model); // ?????? Q&A ????????? ??????
		return "product/product_con";
	}

	// ---------------------------------------
	// ?????? ??????
	// ---------------------------------------
	// ?????? ?????? ?????? ????????? ( ?????? ????????? ?????? ???????????? )
	@RequestMapping(value = "review_write")
	public String review_write(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		return "mypage/review_write";
	}

	// ?????? ?????? ?????? ????????? ( ?????? ????????? ????????? ????????? ?????? )
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
  
	// ?????? ?????? ?????? ????????? ( ?????? ????????? ?????? ???????????? )
	@RequestMapping(value = "review_update")
	public String review_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		productReviewModify.execute(model);
		return "mypage/review_update";
	}

	// ?????? ?????? ?????? ????????? ( ?????? ????????? ????????? ????????? ?????? )
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

	// ?????? ?????? ?????? ?????????
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
	// ?????? Q&A
	// ---------------------------------------
	// ?????? Q&A ????????? ?????????
	@RequestMapping(value = "product_qna_con")
	public String product_qna_con(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		productQnaDetailList.execute(model);
		return "product/product_qna_con";
	}

	// ?????? Q&A ?????? ????????? ( ?????? ????????? ?????? ???????????? )
	@RequestMapping(value = "product_qna_write")
	public String product_qna_write(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		return "product/product_qna_write";
	}

	// ?????? Q&A ?????? ????????? ( ?????? ????????? ????????? ????????? ?????? )
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

	// ?????? Q&A ?????? ????????? ( ?????? ????????? ?????? ???????????? )
	@RequestMapping(value = "product_qna_update")
	public String product_qna_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		productQnaModify.execute(model);
		return "product/product_qna_update";
	}

	// ?????? Q&A ?????? ????????? ( ?????? ????????? ????????? ????????? ?????? )
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

	// ?????? Q&A ?????? ?????????
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
	// ????????????
	// ---------------------------------------
	// ???????????? ??????
	@RequestMapping(value = "cart")
	public String cart(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("user");

		if (userDTO == null) {
			return "login/login"; // ???????????? ??? ?????? ?????? ??? ????????? ????????????
		} else {
			cart.execute(model);
			return "mypage/cart";
		}
	}

	// ???????????? ??????
	@RequestMapping(value = "cart_add")
	public String cart_add(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("user");

		if (userDTO == null) {
			return "login/login"; // ???????????? ??? ?????? ?????? ??? ????????? ????????????
		} else {
			cartAdd.execute(model);
			if (request.getParameter("history").equals("1")) {
				return "redirect:cart"; // "???" ?????? ??? ???????????? ????????????
			} else {
				String proName = request.getParameter("proName"); // "?????????"?????? ??? ??????????????? ???????????? ??????
				model.addAttribute("proName", proName); // ?????? ?????? ???????????? ???????????? ????????? ?????????.
				return "redirect:product_con"; // "?????????" ?????? ??? ?????? ?????? ?????? ????????????
			}
		}
	}

	// ???????????? ??????
	@RequestMapping(value = "cart_delete")
	public String cart_delete(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		cartDelete.execute(model);
		return "redirect:cart";
	}

	// ---------------------------------------
	// ?????????
	// ---------------------------------------
	// ????????? ??????
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

	// ????????? ??????
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

	// ????????? ??????
	@RequestMapping(value = "wish_list_delete")
	public String wish_list_delete(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		wishListDelete.execute(model);
		return "redirect:wish_list";
	}

	// ????????? ?????? ??????
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

	// ????????? ?????? ??????
	@RequestMapping(value = "wish_list_alldelete")
	public String wish_list_alldelete(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		wishListAllDelete.execute(model);
		return "redirect:wish_list";
	}

	// ---------------------------------------
	// ???????????? ( ?????? ?????? )
	// ---------------------------------------
	// ?????? ?????? ( ?????? )
	@RequestMapping(value = "buy")
	public String buy(@RequestParam(value = "chBox", required = false) List<String> list, HttpServletRequest request,
			Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("chBox", list);
		model.addAttribute("request", request);
		return "mypage/buy";
	}

	// ?????? ?????? ( ?????? - ?????? ???????????? ??? ?????? )
	@RequestMapping(value = "buy_fn")
	public String buy_fn(@RequestParam(value = "cartList", required = false) List<String> list,
			HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("cartList", list);
		model.addAttribute("request", request);
		orderSimpleAdd.execute(model); // ???????????? ???????????? ????????? ??????
		orderAdd.execute(model); // ???????????? ?????? ???????????? ????????? ??????
		return "redirect:buy_list";
	}

	// ???????????? ?????? ( buyOrderSimple Table )
	@RequestMapping(value = "buy_list")
	public String buy_list(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		orderSimpleList.execute(model);
		return "mypage/buy_list";
	}

	// ???????????? ?????? ( buyOrder Table )
	@RequestMapping(value = "buy_list_con")
	public String buy_list_con(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		orderList.execute(model);
		return "mypage/buy_list_con";
	}

}
