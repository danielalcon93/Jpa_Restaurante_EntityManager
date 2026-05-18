package modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name="hora_reserva", nullable = false)
    private LocalTime horaReserva;

    @Column(name="num_personas", nullable = false)
    private int numPersonas;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;


    @Column(name = "importe_estimado")
    private double importeEstimado;

    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    @ToString.Exclude
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @ToString.Exclude
    private Cliente cliente;
}
