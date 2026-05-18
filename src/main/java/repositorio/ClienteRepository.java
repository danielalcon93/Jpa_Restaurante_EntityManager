package repositorio;

import jakarta.persistence.EntityManager;
import modelo.Cliente;
import util.JpaUtil;

import java.util.List;

public class ClienteRepository extends JpaRepository <Cliente, Long> {

    public ClienteRepository() {
        super(Cliente.class);
    }

    // CONSULTAS PERSONALIZADAS (JPQL)

    /**
     * Busca todos los clientes VIP
     * @return lista de clientes VIP
     */
    public List<Cliente> findVipClients() {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            return em.createQuery("FROM Cliente c WHERE c.vip = true", Cliente.class)
                    .getResultList();

        } finally {
            em.close();
        }
    }


}
