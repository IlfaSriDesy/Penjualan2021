package pub.pelatihan.penjualan.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pub.pelatihan.penjualan.dto.UsersDTO;
import pub.pelatihan.penjualan.models.Users;
import pub.pelatihan.penjualan.repositories.UsersRepository;
import pub.pelatihan.penjualan.services.UsersService;

import java.util.List;

@RestController
@RequestMapping("/rest-users")
public class RestUsersController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersService usersService;

    @GetMapping("/find-all")
    public List<UsersDTO> findAll() {
        return usersService.getUsers();
    }

    @PostMapping("/save")
    public Users save(@RequestParam("data") String data,
                      @RequestBody UsersDTO usersDTO) {
        return usersService.saveUser(usersDTO);
    }
}
