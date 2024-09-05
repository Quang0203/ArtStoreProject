package haui.store.service;

import java.util.List;

import haui.store.model.BestSellerModel;
import org.springframework.data.domain.Pageable;

import haui.store.entity.Favorite;

public interface FavoriteService {

	Favorite create(int id);

	List<Favorite> getListFavoriteByEmail();

	void delete(int id);

	Favorite getOneFavorite(int id);

	List<BestSellerModel> getListBestSellerProduct(Pageable topFour);

}
