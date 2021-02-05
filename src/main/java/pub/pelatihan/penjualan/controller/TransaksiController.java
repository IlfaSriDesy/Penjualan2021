package pub.pelatihan.penjualan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransaksiController {

    @RequestMapping(path = "isAlive", method = RequestMethod.GET)
    public String isAlive(){
        return "Pelatihan Java 2021 OK";
    }
}
