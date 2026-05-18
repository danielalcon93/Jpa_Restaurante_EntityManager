package modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "mesa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private int capacidad;

    @Column(nullable = false)
    private boolean terraza;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    @ToString.Exclude
    private Restaurante restaurante;

    @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL,  orphanRemoval = true)
    @ToString.Exclude
    private List<Reserva> reservas;
}
