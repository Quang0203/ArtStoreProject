package haui.store.service;

import java.util.List;

import haui.store.model.ManufacturerModel;
import haui.store.entity.Manufacturer;

public interface ManufacturerService{

	ManufacturerModel createManufacturer(ManufacturerModel manufacturerModel);

	List<Manufacturer> findAll();

	ManufacturerModel getOneManufacturerById(Integer id);

	void delete(Integer id);

	ManufacturerModel updateManufacturer(ManufacturerModel manufacturerModel);

}
