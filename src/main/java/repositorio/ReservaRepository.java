package repositorio;

import jakarta.persistence.EntityManager;
import modelo.EstadoReserva;
import modelo.Reserva;
import util.JpaUtil;

import java.util.List;

public class ReservaRepository extends JpaRepository<Reserva, Long> {

    public ReservaRepository() {
        super(Reserva.class);
    }

    // CONSULTAS PERSONALIZADAS (JPQL)

    /**
     * Busca reservas por estado
     * @param estado de la reserva
     * @return lista de reservas con ese estado
     */
    public List<Reserva> findByEstado(EstadoReserva estado) {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            return em.createQuery("FROM Reserva r WHERE r.estado = :estado", Reserva.class)
                    .setParameter("estado", estado)
                    .getResultList();

        } finally {
            em.close();
        }
    }


    /**
     * Busca reservas de un cliente
     * @param id id del cliente
     * @return lista de reservas del cliente
     */
    public List<Reserva> findByCliente(Long id) {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            return em.createQuery("FROM Reserva r WHERE r.cliente.id = :id", Reserva.class)
                    .setParameter("id", id)
                    .getResultList();

        } finally {
            em.close();
        }
    }


}
