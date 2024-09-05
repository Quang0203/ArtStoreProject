/**
 * @(#)IndexController.java 2021/09/07.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/22.
 * Version 1.00.
 */
package haui.store.controller.user;

import java.util.ArrayList;
import java.util.List;

import haui.store.common.Constants;
import haui.store.entity.Blog;
import haui.store.entity.Manufacturer;
import haui.store.entity.Product;
import haui.store.model.BestSellerModel;
import haui.store.model.ShowProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import haui.store.service.BlogService;
import haui.store.service.CommentService;
import haui.store.service.FavoriteService;
import haui.store.service.ManufacturerService;
import haui.store.service.OrderService;
import haui.store.service.ParamService;
import haui.store.service.ProductService;
import haui.store.service.UserRoleService;

/**
 * Class de hien thi trang chu nguoi dung
 * 
 * @author khoa-ph
 * @version 1.00
 */
@Controller
public class IndexController {
	@Autowired
    UserRoleService userRoleService;

	@Autowired
    ProductService productService;

	@Autowired
    ManufacturerService manufacturerService;

	@Autowired
    CommentService commentService;

	@Autowired
    BlogService blogService;

	@Autowired
	ParamService paramService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	FavoriteService favoriteService;

	/**
	 * Hien thi trang chu cua giao dien nguoi dung
	 * 
	 * @return trang index.html
	 */
	@GetMapping({ "/", "/index" })
	public String index(Model model) {
		return Constants.USER_DISPLAY_INDEX;
	}

	@ModelAttribute("manufacturer")
	public List<Manufacturer> manufacture(Model model) {
		List<Manufacturer> list = manufacturerService.findAll();
		return list;
	}

	@ModelAttribute("latestProduct")
	public List<List<ShowProduct>> getLatestProduct(Model model) {
		List<Product> list = productService.getListLatestProduct();

		List<ShowProduct> temp = new ArrayList<>();

		List<List<ShowProduct>> result = new ArrayList<List<ShowProduct>>();

		for (int i = 0; i < list.size(); i++) {
			int totalStar = commentService.getAllStarCommentByProductNameSearch(list.get(i).getNamesearch());

			ShowProduct showProduct = new ShowProduct();
			showProduct.setProduct(list.get(i));
			showProduct.setTotalStar(totalStar);
			temp.add(showProduct);
			if (i % 2 != 0) {
				result.add(temp);
				temp = new ArrayList<>();
			}
			if (i == (list.size() - 1)) {
				if (i % 2 == 0) {
					result.add(temp);
					temp = new ArrayList<>();
				}
			}
		}

		return result;
	}

	@ModelAttribute("viewsProduct")
	public List<ShowProduct> getViewsProduct(Model model) {
		List<Product> list = productService.getListViewsProduct();
		List<ShowProduct> listProduct = new ArrayList<ShowProduct>();

		for (Product product : list) {
			ShowProduct showProduct = new ShowProduct();
			int totalStar = commentService.getAllStarCommentByProductNameSearch(product.getNamesearch());
			showProduct.setProduct(product);
			showProduct.setTotalStar(totalStar);
			listProduct.add(showProduct);
		}

		return listProduct;
	}

	@ModelAttribute("listBlog")
	public List<Blog> getListBlog(Model model) {
		List<Blog> listBlog = blogService.getSixBlog();
		for (Blog blog : listBlog) {
			String uploadDay = paramService.convertDate(blog.getUploadday());
			blog.setUploadday(uploadDay);
		}
		return listBlog;
	}

	@ModelAttribute("listSale")
	public List<ShowProduct> getListProductSale(Model model) {
		List<Product> list = productService.getListProductSales();

		List<ShowProduct> listProduct = new ArrayList<ShowProduct>();

		for (Product product : list) {
			ShowProduct showProduct = new ShowProduct();
			int totalStar = commentService.getAllStarCommentByProductNameSearch(product.getNamesearch());
			showProduct.setProduct(product);
			showProduct.setTotalStar(totalStar);
			listProduct.add(showProduct);
		}

		return listProduct;
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
	
	@ModelAttribute("listFavorite")
	public List<ShowProduct> demo(Model model) {
		Pageable topFour = PageRequest.of(0, 4);
		List<BestSellerModel> list = favoriteService.getListBestSellerProduct(topFour);
		
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
