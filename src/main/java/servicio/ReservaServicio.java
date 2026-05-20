package servicio;

import jakarta.persistence.EntityManager;
import modelo.*;
import util.JpaUtil;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReservaServicio {

    /**
     * Consulta 1
     * Lista todas las reservas confirmadas ordenadas por fecha ascendente.
     */
    public void getReservasConfirmadas() {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            List<Reserva> reservas = em.createQuery("FROM Reserva r WHERE r.estado = :estado ORDER BY r.fechaReserva ASC", Reserva.class)
                    .setParameter("estado", EstadoReserva.CONFIRMADA)
                    .getResultList();

            System.out.println("Reservas Confirmadas");
            reservas.forEach(System.out::println);

        } finally {
            em.close();
        }
    }


    /**
     * Consulta 2
     * Mostrar todas las reservas asociadas a un restaurante dado.
     */
    public void getReservasPorRestaurante(Long restauranteId) {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            List<Reserva> reservas = em.createQuery("SELECT r FROM Reserva r " +
                    "JOIN r.mesa m " +
                    "JOIN m.restaurante res " +
                    "WHERE res.id = :id", Reserva.class)
                    .setParameter("id", restauranteId)
                    .getResultList();

            System.out.println("Reservas por restaurante");
            reservas.forEach(System.out::println);

        } finally {
            em.close();
        }
    }


    /**
     * Consulta 3
     * Obtener las reservas pendientes del día actual.
     */
    public void getReservasPendientesHoy() {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            List<Reserva> reservas = em.createQuery("FROM Reserva r WHERE r.estado = :estado AND r.fechaReserva = :hoy", Reserva.class)
                    .setParameter("estado", EstadoReserva.PENDIENTE)
                    .setParameter("hoy", LocalDate.now())
                    .getResultList();

            System.out.println("Reservas pendientes para hoy");
            reservas.forEach(System.out::println);

        } finally {
            em.close();
        }
    }


    /**
     * Consulta 4
     * Calcular la recaudación total estimada de cada restaurante, mostrando el nombre del
     * restaurante y el total, de mayor a menor.
     */
    public void getRecaudacionPorRestaurante() {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            List<Object[]> lista = em.createQuery("SELECT r.mesa.restaurante.nombre, SUM(r.importeEstimado) " +
                    "FROM Reserva r " +
                    "GROUP BY r.mesa.restaurante.nombre " +
                    "ORDER BY SUM(r.importeEstimado) DESC",
                    Object[].class)
                    .getResultList();

            System.out.println("Recaudacion por restaurante");

            lista.stream()
                    .map(obj -> obj[0] + " -> " + obj[1] + "€")
                    .forEach(System.out::println);

        } finally {
            em.close();
        }
    }


    /**
     * Consulta 5
     * Obtener el restaurante que tenga el mayor número de mesas registradas.
     */
    public void getRestauranteConMasMesas() {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            Restaurante restaurante = em.createQuery("FROM Restaurante ORDER BY SIZE(mesas) DESC",  Restaurante.class)
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);

            System.out.println("Restaurante con mas mesas");
            System.out.println(restaurante.getNombre() + " -> " + restaurante.getMesas().size() + " mesas");

        }  finally {
            em.close();
        }
    }


    /**
     * Consulta 6
     * Listar las reservas con estado  CANCELADA  o  NO_SHOW , ordenadas por fecha descendente
     */
    public void getReservasProblematicas() {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            List<Reserva> reservas = em.createQuery("FROM Reserva r WHERE r.estado in (:estados) " +
                    "ORDER BY r.fechaReserva DESC", Reserva.class)
                    .setParameter("estados", List.of(EstadoReserva.CANCELADA, EstadoReserva.NO_SHOW))
                    .getResultList();

            System.out.println("Reservas problematicas");
            reservas.forEach(System.out::println);

        } finally {
            em.close();
        }
    }


    /**
     * Consulta 7
     * Mostrar cuántas reservas existen agrupadas por ciudad del restaurante.
     */
    public void getReservasPorCiudad() {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            List<Object[]> lista = em.createQuery("SELECT r.mesa.restaurante.ciudad, COUNT(r) " +
                    "FROM Reserva r " +
                    "GROUP BY r.mesa.restaurante.ciudad", Object[].class)
                    .getResultList();

            System.out.println("Reservas por ciudad");

            lista.stream()
                    .map(obj -> obj[0] + " -> " + obj[1] + " reservas")
                    .forEach(System.out::println);

        } finally {
            em.close();
        }
    }


    /**
     * Consulta 8
     * Detectar las mesas con más reservas registradas.
     */
    public void getMesasMasSolicitadas() {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            Mesa mesa = em.createQuery("FROM Mesa", Mesa.class)
                    .getResultList()
                    .stream()
                    .max(Comparator.comparing(m -> m.getReservas().size()))
                    .orElse(null);

            System.out.println("Mesa mas solicitada");

            System.out.println(mesa);

        } finally {
            em.close();
        }
    }


    /**
     * Consulta 9
     * Calcular el importe medio estimado de las reservas en mesas de terraza y en mesas interiores.
     */
    public void getImporteMedioPorTerraza() {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            List<Object[]> lista = em.createQuery("SELECT m.terraza, AVG(r.importeEstimado) " +
                    "FROM Reserva r JOIN r.mesa m " +
                    "GROUP BY m.terraza", Object[].class)
                    .getResultList();

            System.out.println("Importe medio por terraza");

            lista.stream()
                    .map(obj -> obj[0] + " -> " + obj[1] + "€")
                    .forEach(System.out::println);


        } finally {
            em.close();
        }
    }


    /**
     * Consulta 10
     * Obtener los nombres de clientes con al menos minimoReservas reservas, sin repeticiones.
     */
    public void getClientesFrecuentes(int minimoReservas) {

        EntityManager em = JpaUtil.createEntityManager();

        try {
            List<Cliente> clientes = em.createQuery("SELECT r.cliente FROM Reserva r", Cliente.class)
                    .getResultList();

            List<String> clientesFrecuentes = clientes.stream()
                    .filter(c -> c.getReservas().size() >= minimoReservas)
                    .map(Cliente::getNombre)
                    .distinct()
                    .toList();

            System.out.println("Clientes frecuentes");

            clientesFrecuentes.forEach(System.out::println);

        } finally {
            em.close();
        }
    }



}
