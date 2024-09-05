/**
 * @(#)ProductService.java 2021/10/10.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/10/10.
 * Version 1.00.
 */
package haui.store.service;

import java.util.List;

import haui.store.model.ProductModel;
import haui.store.model.ShowProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import haui.store.entity.Product;

/**
 * Class cung cap cac dich vu thao tac voi table Products trong database
 * 
 * @author KHOA-PH
 * @version 1.00
 */
public interface ProductService {

	ProductModel createProduct(ProductModel productModel);

	List<Product> findAll();

	void delete(Integer id);

	ProductModel updateProduct(ProductModel productModel);

	ProductModel getOneProductById(Integer id);
//	Product getOneProductById(Integer id);

	List<Product> getListLatestProduct();

	List<Product> getListViewsProduct();

	Page<Product> getListProductByNameSearch(String nameSearch, Pageable pageable);

	List<Product> getDemo(String nameSearch);

	Page<Product> getListProductByPrice(String nameSearch, int minPrice, int maxPrice, Pageable pageable);

	Page<ShowProduct> getListProductByFilter(String nameSearch, String price, String manu, String sort, Pageable pageable, String status, String name, String category);

	Product getProductByNameSearch(String nameSearch);

	List<Product> getListProductRelated(int id);

	void updateView(String nameSearch);

	void updateQuality(Product product);

	List<Product> getListProductSales();

}
