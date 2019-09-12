package uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table (name = "registers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarRegister
{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name="register_date")
        private Instant registerDate;

        @Column(name="register_number")
        private String registerNumber;

        private boolean paid;

        @OneToOne (cascade = CascadeType.ALL)
        @JoinColumn (name = "car_id", referencedColumnName = "id")
        private Car car;
}
