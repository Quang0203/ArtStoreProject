package haui.store.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Blogs")
public class Blog implements Serializable {
//	thong tin blogs id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// thong tin ten title	
	private String title;
	
	// thong tin noi dung content	
	private String content;
	
	// thong tin logo
	private String logo;
	
	// Thong tin trang thai
	private boolean active;
	
	// Thong tin ngay khoi tao blog
	private String Uploadday;
	
	// Thong tin banner
	private String Banner;
	
	// Thong tin ten tim kiem
	private String Namesearch;
	
	// Thong tin mo ta
	private String description;
	
	// Thong tin ngay tao
	private String Createday;

	// Thong tin ma nguoi tao
	private int Personcreate;

	// Thong tin ngay xoa
	private String Deleteday;

	// Thong tin nguoi xoa
	private int Persondelete;

	// Thong tin ngay cap nhat
	private String Updateday;

	// Thong tin ma nguoi cap nhat
	private int Personupdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUploadday() {
		return Uploadday;
	}

	public void setUploadday(String uploadday) {
		Uploadday = uploadday;
	}

	public String getBanner() {
		return Banner;
	}

	public void setBanner(String banner) {
		Banner = banner;
	}

	public String getNamesearch() {
		return Namesearch;
	}

	public void setNamesearch(String namesearch) {
		Namesearch = namesearch;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateday() {
		return Createday;
	}

	public void setCreateday(String createday) {
		Createday = createday;
	}

	public int getPersoncreate() {
		return Personcreate;
	}

	public void setPersoncreate(int personcreate) {
		Personcreate = personcreate;
	}

	public String getDeleteday() {
		return Deleteday;
	}

	public void setDeleteday(String deleteday) {
		Deleteday = deleteday;
	}

	public int getPersondelete() {
		return Persondelete;
	}

	public void setPersondelete(int persondelete) {
		Persondelete = persondelete;
	}

	public String getUpdateday() {
		return Updateday;
	}

	public void setUpdateday(String updateday) {
		Updateday = updateday;
	}

	public int getPersonupdate() {
		return Personupdate;
	}

	public void setPersonupdate(int personupdate) {
		Personupdate = personupdate;
	}
}
