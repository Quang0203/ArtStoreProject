package haui.store.controller.user;

import haui.store.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangePasswordController {
	@GetMapping("/account/change-password")
	public String index() {
		return Constants.USER_DISPLAY_ACCOUNT_CHANGE_PASSWORD;
	}
}
