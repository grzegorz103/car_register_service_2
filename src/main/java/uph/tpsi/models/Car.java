package uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table (name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car
{
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Long id;

        @OneToOne (mappedBy = "car")
        private CarRegister carRegister;

        @Column (name = "brand")
        @NotEmpty
        @Length (min = 2, max = 100)
        private String brand;

        @Column (name = "model")
        @NotEmpty
        @Length (min = 2, max = 100)
        private String model;

        @Column (name = "year")
        @Min(1900)
        @Max (2020)
        private Integer year;

        @Column (name = "mileage")
        @Min (1)
        private Integer mileage;

        @NotEmpty
        @Length (min = 2, max = 100)
        private String carType;

        @ManyToOne
        @JoinColumn (name = "user_id", nullable = false)
        private User user;
}
