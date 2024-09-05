/**
 * @(#)ManufacturerModel.java 2021/09/21.
 * 
 * Copyright(C) 2021 by PHOENIX TEAM.
 * 
 * Last_Update 2021/09/21.
 * Version 1.00.
 */
package haui.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class thong tin truy van cua bang Manufacturer
 * 
 * @author khoa-ph
 * @version 1.00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerModel {
	private int id;
	private String name;
	private String banner;
	private String logo;
	private String describe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
