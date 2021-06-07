package pub.pelatihan.penjualan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @Column(name = "role_id", nullable = false, unique = true)
    private Integer roleId;

    @Column(name = "rolename")
    private String rolename;
}
