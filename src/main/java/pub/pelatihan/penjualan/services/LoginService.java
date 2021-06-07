package pub.pelatihan.penjualan.services;

import pub.pelatihan.penjualan.dto.LoginDTO;

import java.util.Map;

public interface LoginService {

    Map doLogin(LoginDTO loginDTO);

}
