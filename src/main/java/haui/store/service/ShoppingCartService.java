package haui.store.service;

import java.util.Collection;

import haui.store.model.CartModel;
import haui.store.entity.Discount;

public interface ShoppingCartService {
	void add(Integer id, CartModel entity);
	void remove(Integer id);
	void update(Integer id, int qty);
	void clear();
	Collection<CartModel> getItems();
	int getCount();
	int getCountAllProduct();
	double getAmount();
	void addDiscount(Integer id, Discount entity);
	Discount getDiscount();
	void clearDiscount();

	void add(Integer productId, int quantity);

	int getQuantityInCart(Integer productId);
}
