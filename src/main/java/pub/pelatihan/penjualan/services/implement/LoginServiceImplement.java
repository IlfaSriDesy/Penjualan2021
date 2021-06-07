package pub.pelatihan.penjualan.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.pelatihan.penjualan.dto.LoginDTO;
import pub.pelatihan.penjualan.models.Users;
import pub.pelatihan.penjualan.repositories.UsersRepository;
import pub.pelatihan.penjualan.services.LoginService;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImplement implements LoginService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Map doLogin(LoginDTO loginDTO) {
        Map result = new HashMap();
        try {
            Users user = usersRepository.getUserByUsername(loginDTO.getUsername());
            if (user != null) {
                if (user.getPassword().equals(loginDTO.getPassword())) {
                    result.put("responseCode", "00");
                    result.put("message", "Login berhasil!");
                } else {
                    result.put("responseCode", "99");
                    result.put("message", "Password salah!");
                }
            } else {
                result.put("responseCode", "99");
                result.put("message", "User belum terdaftar!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("responseCode", "99");
            result.put("message", "Terjadi kesalahan!");
        }
        return result;
    }
}
