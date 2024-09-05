package haui.store.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import haui.store.common.Constants;
import haui.store.entity.Product;
import haui.store.model.BestSellerModel;
import haui.store.model.CartModel;
import haui.store.model.ShowProduct;
import haui.store.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import haui.store.service.CategoryService;
import haui.store.service.CommentService;
import haui.store.service.OrderService;
import haui.store.service.ProductService;
import haui.store.service.SessionService;

@Controller
public class DetailProductController {
	@Autowired
    ProductService productService;

	@Autowired
    CategoryService categoryService;
	
	@Autowired
    SessionService sessionService;
	
	@Autowired
    CommentService commentService;

	@Autowired
    ShoppingCartServiceImpl cartService;
	
	@Autowired
    OrderService orderService;

	@GetMapping("/san-pham/{nameSearch}")
	public String index(@PathVariable("nameSearch") String nameSearch, Model model) {
		productService.updateView(nameSearch);
		model.addAttribute("infor", 3);
		sessionService.set("sessionProduct", cartService);
		return Constants.USER_DISPLAY_DETAIL_PRODUCT;
	}
	
	@SuppressWarnings("static-access")
	@PostMapping("/san-pham/{nameSearch}")
	public String orderProduct(@PathVariable("nameSearch") String nameSearch, Model model, HttpServletRequest req) {
		
		Product product = productService.getProductByNameSearch(nameSearch);
			
		Map<Integer, CartModel> map = cartService.map;
		CartModel cartModel = map.get(product.getId());
		
		if(cartModel == null) {
			cartModel = new CartModel();
			cartModel.setId(product.getId());
			cartModel.setProduct(product);
			cartModel.setQuality(1);
			cartService.add(product.getId(), cartModel);
		}
		
		else {
			if (product.getQuantity() <= cartModel.getQuality()){
				model.addAttribute("infor", 0);

				sessionService.set("sessionProduct", cartService);

				return Constants.USER_DISPLAY_DETAIL_PRODUCT;
			}
			cartService.update(cartModel.getId(), cartModel.getQuality() + 1);
		}
		
		model.addAttribute("infor", 1);
		
		sessionService.set("sessionProduct", cartService);
		
		return Constants.USER_DISPLAY_DETAIL_PRODUCT;
	}

	@ModelAttribute("inforProduct")
	public Product inforCategory(@PathVariable("nameSearch") String nameSearch) {
		Product product = productService.getProductByNameSearch(nameSearch);
		return product;
	}

	@ModelAttribute("listProductRelated")
	public List<ShowProduct> listProductRelated(@PathVariable("nameSearch") String nameSearch) {
		Product product = productService.getProductByNameSearch(nameSearch);
		List<Product> list = productService.getListProductRelated(product.getCategory().getId());

		List<ShowProduct> listProduct = new ArrayList<ShowProduct>();

		for (Product item : list) {
			ShowProduct showProduct = new ShowProduct();
			int totalStar = commentService.getAllStarCommentByProductNameSearch(item.getNamesearch());
			showProduct.setProduct(item);
			showProduct.setTotalStar(totalStar);
			listProduct.add(showProduct);
		}

		return listProduct;
	}

	@ModelAttribute("countComment")
	public int countComment(@PathVariable("nameSearch") String nameSearch) {
		int result = commentService.getCountCommentByProductNameSearch(nameSearch);
		return result;
	}

	@ModelAttribute("totalStar")
	public int totalStar(@PathVariable("nameSearch") String nameSearch) {
		int result = commentService.getAllStarCommentByProductNameSearch(nameSearch);
		return result;
	}
	
	@ModelAttribute("listBestSeller")
	public List<ShowProduct> getListBestSeller(Model model){
		Pageable topFour = PageRequest.of(0, 4);
		
		List<BestSellerModel> list = orderService.getListBestSellerProduct(topFour);
		
		List<ShowProduct> listProduct = new ArrayList<ShowProduct>();
		
		for(BestSellerModel bestSeller: list) {
			ShowProduct showProduct = new ShowProduct();
			int totalStar = commentService.getAllStarCommentByProductNameSearch(bestSeller.getProduct().getNamesearch());
			showProduct.setProduct(bestSeller.getProduct());
			showProduct.setTotalStar(totalStar);
			listProduct.add(showProduct);
		}		
		return listProduct;
	}
}
