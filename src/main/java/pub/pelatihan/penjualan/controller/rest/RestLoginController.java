package pub.pelatihan.penjualan.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pub.pelatihan.penjualan.dto.LoginDTO;
import pub.pelatihan.penjualan.models.Users;
import pub.pelatihan.penjualan.repositories.UsersRepository;
import pub.pelatihan.penjualan.services.LoginService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest-login")
public class RestLoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/do-login")
    public Object doLogin(@RequestBody LoginDTO loginDTO) {

        Map result = loginService.doLogin(loginDTO);
        if (result.get("responseCode").equals("00")) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/users")
    public List<Users> users() {
        return usersRepository.getUsers();
    }
}
