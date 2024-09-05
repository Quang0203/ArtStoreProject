package haui.store.service;

import java.util.List;

import haui.store.model.Nav2Model;
import haui.store.entity.MenuTwo;

public interface MenuTwoService {

	Nav2Model createNav2(Nav2Model nav2Model);

	List<MenuTwo> findAll();

	void delete(Integer id);

	Nav2Model getOneNav2ById(Integer id);

	Nav2Model updateNav2(Nav2Model nav2Model);

}
