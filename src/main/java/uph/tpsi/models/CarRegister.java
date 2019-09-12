package uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table (name = "registers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarRegister
{
        private Long id;

        private Instant registerDate;

        private String registerNumber;

        private boolean paid;

        @OneToOne (mappedBy = "carRegister")
        private Car car;
}
