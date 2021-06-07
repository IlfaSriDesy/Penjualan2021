package pub.pelatihan.penjualan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private Integer roleId;
    private String rolename;
}
