package haui.store.service;

import java.util.List;

import haui.store.model.CategoryModel;
import haui.store.entity.Category;

public interface CategoryService {

	CategoryModel createCategory(CategoryModel categoryModel);

	List<Category> findAll();

	void delete(Integer id);

	CategoryModel getOneCategoryById(Integer id);

	CategoryModel updateCategory(CategoryModel categoryModel);

	Category getCategoryByNameSearch(String nameSearch);

}
