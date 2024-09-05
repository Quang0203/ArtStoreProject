package haui.store.controller.user;

import haui.store.common.Constants;
import haui.store.service.ContactService;
import haui.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	@Autowired
    ContactService contactService;
	@Autowired
    UserService userService;
	@GetMapping("/contact")
	public String index(Model model) {
		return Constants.USER_DISPLAY_CONTACT;
	}
}
