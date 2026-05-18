package repositorio;

import jakarta.persistence.EntityManager;
import modelo.Mesa;
import util.JpaUtil;

import java.util.List;

public class MesaRepository extends JpaRepository<Mesa, Long> {


    public MesaRepository() {
        super(Mesa.class);
    }

    // CONSULTAS PERSONALIZADAS (JPQL)

    /**
     * Busca todas las mesas pertenecientes a un restaurante.
     * @param id id del restaurante
     * @return lista de mesas del restaurante
     */
    public List<Mesa> findByRestaurante(Long id) {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            return em.createQuery("SELECT m FROM Mesa m WHERE m.restaurante.id = :id", Mesa.class)
                    .setParameter("id", id)
                    .getResultList();

        } finally {
            em.close();
        }
    }



}
