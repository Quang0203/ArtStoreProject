package haui.store.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import haui.store.entity.Blog;


public interface BlogDao extends JpaRepository<Blog, Integer> {
	@Query("SELECT c FROM Blog c WHERE c.Deleteday = null")
	List<Blog> getListBlog();
	
	@Query("SELECT c FROM Blog c WHERE c.Deleteday = null AND c.active = 1")
	Page<Blog> findAllBlogActive(Pageable pageable);
	
	@Query("SELECT c FROM Blog c WHERE c.Namesearch = ?1")
	Blog findBlogByNameSearch(String nameSearch);
	
	@Query(value="select * from Blogs Where Active = 1 AND DeleteDay is null order by UploadDay DESC LIMIT 6", nativeQuery = true)
	List<Blog> getSixBlogs();
}
