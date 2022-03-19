package scotts.spawn.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class TestSecurityController {

    @GetMapping("/admin/get")
    public String getAdmin() {
        return "Hi Admin";
    }

    @GetMapping("/user/get")
    public String getUser() {
        return "Hi User";
    }

    @GetMapping("/customers/get")
    public String getCustomer() {
        return "Hi Customer";
    }

}
