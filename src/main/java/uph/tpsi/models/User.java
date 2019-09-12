package uph.tpsi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table (name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User
{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Column (name = "username")
        @NotEmpty
        @Length (min = 2, max = 100)
        private String username;

        @Column (name = "password")
        @NotEmpty
        @Length (min = 2, max = 100)
        private String password;

        @OneToMany(mappedBy = "user")
        @JsonIgnore
        private Set<Car> cars;
}
