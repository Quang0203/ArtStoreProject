package haui.store.service;

import java.util.List;

import haui.store.model.Nav1Model;
import haui.store.entity.MenuOne;

public interface MenuOneService {

	Nav1Model createNav1(Nav1Model nav1Model);

	List<MenuOne> findAll();

	void delete(Integer id);

	Nav1Model getOneNav1ById(Integer id);

	Nav1Model updateNav1(Nav1Model nav1Model);

}
