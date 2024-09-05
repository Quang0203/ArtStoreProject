package haui.store.service;

import java.util.List;

import haui.store.model.BlogModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import haui.store.entity.Blog;

public interface BlogService {

	BlogModel createBlog(BlogModel blogModel);
	
	List<Blog> findAll();

	void delete(Integer id);

	BlogModel getOneBlogById(Integer id);

	BlogModel updateCategory(BlogModel blogModel);

	Blog findById(Integer id);

	Page<Blog> findAllBlogActive(Pageable pageable);

	Blog findBlogByNameSearch(String nameSearch);

	List<Blog> getSixBlog();

}
