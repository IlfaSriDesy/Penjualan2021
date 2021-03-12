package pub.pelatihan.penjualan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pub.pelatihan.penjualan.dto.SearchDTO;
import pub.pelatihan.penjualan.dto.UsersDTO;
import pub.pelatihan.penjualan.models.Users;
import pub.pelatihan.penjualan.repositories.UsersRepository;
import pub.pelatihan.penjualan.services.UsersService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersService usersService;

    @RequestMapping("/home")
    public String home(Model model) {
        List<Users> users = usersRepository.getUsers();
        SearchDTO search = new SearchDTO();
        model.addAttribute("users", users);
        model.addAttribute("title", "Welcome to Spring Boot");
        model.addAttribute("search", search);
        return "home";
    }

    @RequestMapping("/getUsers")
    public String getUsersNative() {
        List<Users> users = usersService.getUsersNative();
        System.out.printf("==================NATIVE"+users.get(0).getFullname());
        return "redirect:home";
    }

    @GetMapping("/deleteDataUser")
    public String hapusData(int usersId, ModelMap model) throws Exception{
        boolean result = usersService.deleteUser(usersId);
        if(result){
            return "redirect:home";
        }else{
            return "redirect:error";
        }

    }

    @RequestMapping(value = "/doInsertUser", method = RequestMethod.GET)
    public String doInsertData(ModelMap model) throws Exception{
        UsersDTO dto = new UsersDTO();
        List<Map> listAddress = new ArrayList<>();
        try {

            model.addAttribute("userDto", dto);
            Map address1 = new HashMap();
            address1.put("id","cianjur");
            address1.put("nm","Cianjur");
            listAddress.add(address1);
            Map address2 = new HashMap();
            address2.put("id","bandung");
            address2.put("nm","Bandung");
            listAddress.add(address2);
            model.addAttribute("listAddress", listAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertUser";

    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveData(@RequestBody UsersDTO userDto, ModelMap model) throws Exception{
        Users result = usersService.saveUser(userDto);
        System.out.println("=================="+result.getUsersId());
        return "redirect:home";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(SearchDTO search, ModelMap model) throws Exception{
        System.out.println("**************"+search.getCari());
        List<Users> users = usersService.searchByUsername(search);
        SearchDTO cari = new SearchDTO();
        model.addAttribute("users", users);
        model.addAttribute("title", "Welcome to Spring Boot");
        model.addAttribute("search", cari);
        return "home";
    }

    @RequestMapping(value = "/doUpdateDataUser", method = RequestMethod.GET)
    public String doUpdateDataUser(ModelMap model, int usersId) throws Exception{
        UsersDTO dto = usersService.getUserById(usersId);
        List<Map> listAddress = new ArrayList<>();
        try {

            model.addAttribute("userDto", dto);
            Map address1 = new HashMap();
            address1.put("id","cianjur");
            address1.put("nm","Cianjur");
            listAddress.add(address1);
            Map address2 = new HashMap();
            address2.put("id","bandung");
            address2.put("nm","Bandung");
            listAddress.add(address2);
            model.addAttribute("listAddress", listAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "updateUser";

    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(UsersDTO userDto) throws Exception{
        Users result = usersService.updateUser(userDto);
        System.out.println("UPDATE =================="+result.getUsersId());
        return "redirect:home";
    }
}
