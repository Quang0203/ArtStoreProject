package haui.store.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import haui.store.model.CartModel;
import haui.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import haui.store.entity.Discount;
import haui.store.service.ShoppingCartService;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	public static Map<Integer, CartModel> map = new HashMap<>();

	public static Map<Integer, Discount> mapDiscount = new HashMap<>();

	private double amount = 0;

	@Autowired
	private ProductService productService;

	@Override
	public void add(Integer id, CartModel entity) {
		if (map.get(id) != null) {
			this.update(id, entity.getQuality() + 1);
		} else {
			map.put(id, entity);
		}

	}

	@Override
	public void addDiscount(Integer id, Discount entity) {
		mapDiscount.put(id, entity);
	}

	@Override
	public double getAmount() {
		double amount = 0;
		Set<Integer> set = map.keySet();
		for (Integer i : set) {
			amount += map.get(i).getQuality() * map.get(i).getProduct().getPrice();
			System.out.println(map.get(i).getQuality());
			System.out.println(map.get(i).getProduct().getPrice());


			System.out.println("amount-00: "+ amount);
		}

		if (this.getDiscount() != null) {
			try {
				amount = amount - this.getDiscount().getPrice();
			} catch (Exception e) {

			}
			System.out.println(amount);
		}

		System.out.println("amount-1111: "+ amount);
		this.amount = amount;
		return amount;
	}

	public double getCurAmount(){
		return this.amount;
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);
	}

	@Override
	public void update(Integer id, int qty) {
		map.get(id).setQuality(qty);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Collection<CartModel> getItems() {
		return map.values();
	}

	@Override
	public void add(Integer productId, int quantity) {
		CartModel cartItem = map.get(productId);
		if (cartItem == null) {
			// Tạo một CartModel mới nếu sản phẩm chưa có trong giỏ hàng
			cartItem = new CartModel();
//			cartItem.setProduct(productService.getOneProductById(productId));
			cartItem.setQuality(quantity);
			map.put(productId, cartItem);
		} else {
			// Cập nhật số lượng nếu sản phẩm đã có trong giỏ hàng
			cartItem.setQuality(cartItem.getQuality() + quantity);
		}
	}

	@Override
	public int getQuantityInCart(Integer productId) {
		CartModel cartItem = map.get(productId);
		return cartItem != null ? cartItem.getQuality() : 0;
	}

	@Override
	public int getCount() {
		int count = 0;
		Set<Integer> set = map.keySet();
		for (Integer i : set) {
			count++;
		}
		return count;
	}

	@Override
	public int getCountAllProduct() {
		int count = 0;
		Set<Integer> set = map.keySet();
		for (Integer i : set) {
			count += map.get(i).getQuality();
		}
		return count;
	}

	@Override
	public Discount getDiscount() {
		Discount discount = new Discount();
		Set<Integer> set = mapDiscount.keySet();
		for (Integer i : set) {
			discount = mapDiscount.get(i);
		}
		return discount;
	}

	@Override
	public void clearDiscount() {
		mapDiscount.clear();
	}

}
