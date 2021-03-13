package pub.pelatihan.penjualan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pub.pelatihan.penjualan.models.Users;
import pub.pelatihan.penjualan.repositories.UsersRepository;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Users> users = usersRepository.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("title", "Welcome to Spring Boot");
        return "home";
    }
}
