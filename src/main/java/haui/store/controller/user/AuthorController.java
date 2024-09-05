package haui.store.controller.user;

import haui.store.dao.ManufacturerDao;
import haui.store.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private ManufacturerDao manufacturerDao;

    @GetMapping("/author")
    public String listAuthors(Model model) {
        List<Manufacturer> authors = manufacturerDao.getListManufacturer();
        model.addAttribute("authors", authors);
        return "user/author/author"; // Tên của file HTML bạn muốn hiển thị (author.html)
    }
}