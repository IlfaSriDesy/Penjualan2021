package pub.pelatihan.penjualan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    Integer usersId;
    String username;
    String password;
    String email;
    String fullname;
    String address;
    Integer roleId;
    String rolename;
}
