package uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

        private String brand;

        private String model;

        private Integer year;

        private String registerNumber;

        private Integer mileage;

        private String carType;

        @ManyToOne
        @JoinColumn (name = "user_id", nullable = false)
        private User user;
}
