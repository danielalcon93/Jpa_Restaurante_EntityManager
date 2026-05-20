import modelo.*;
import repositorio.ClienteRepository;
import repositorio.MesaRepository;
import repositorio.ReservaRepository;
import repositorio.RestauranteRepository;
import servicio.ReservaServicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        IO.println("Arrancando aplicación restaurantes");

        RestauranteRepository restauranteRepo = new RestauranteRepository();
        MesaRepository mesaRepo = new MesaRepository();
        ClienteRepository clienteRepo = new ClienteRepository();
        ReservaRepository reservaRepo = new ReservaRepository();

        ReservaServicio reservaServicio = new ReservaServicio();


        //Restaurantes
        Restaurante r1 = new Restaurante(null, "La Esquina", "Madrid", "Calle Mayor 12", "950123846", new ArrayList<>());

        Restaurante r2 = new Restaurante(null, "Sabor Mediterraneo", "Valencia", "Calle Federico Garcia Lorca 1", "666792016", new ArrayList<>());

        restauranteRepo.save(r1);
        restauranteRepo.save(r2);


        //Mesas
        Mesa m1 = new Mesa(null, 1, 4, true, r1, new ArrayList<>());
        Mesa m2 = new Mesa(null, 2, 2, false, r1, new ArrayList<>());
        Mesa m3 = new Mesa(null, 3, 6, true, r1, new ArrayList<>());
        Mesa m4 = new Mesa(null, 4, 4, false, r1, new ArrayList<>());
        Mesa m5 = new Mesa(null, 5, 8, true, r1, new ArrayList<>());
        Mesa m6 = new Mesa(null, 6, 2, false, r1, new ArrayList<>());
        Mesa m7 = new Mesa(null, 7, 4, true, r2, new ArrayList<>());
        Mesa m8 = new Mesa(null, 8, 2, false, r2, new ArrayList<>());
        Mesa m9 = new Mesa(null, 9, 6, true, r2, new ArrayList<>());
        Mesa m10 = new Mesa(null, 10, 4, false, r2, new ArrayList<>());
        Mesa m11 = new Mesa(null, 11, 8, true, r2, new ArrayList<>());
        Mesa m12 = new Mesa(null, 12, 2, false, r2, new ArrayList<>());

        mesaRepo.save(m1);
        mesaRepo.save(m2);
        mesaRepo.save(m3);
        mesaRepo.save(m4);
        mesaRepo.save(m5);
        mesaRepo.save(m6);
        mesaRepo.save(m7);
        mesaRepo.save(m8);
        mesaRepo.save(m9);
        mesaRepo.save(m10);
        mesaRepo.save(m11);
        mesaRepo.save(m12);


        //Clientes
        Cliente c1 = new Cliente(null, "Daniel", "daniel@gmail.com",
                "9686211034", true, new ArrayList<>());

        Cliente c2 = new Cliente(null, "Marta", "marta@gmail.com",
                "659872034", false, new ArrayList<>());

        Cliente c3 = new Cliente(null, "Ana", "ana@gmail.com",
                "645698030", true, new ArrayList<>());

        Cliente c4 = new Cliente(null, "Luis", "luis@gmail.com",
                "634513014", false, new ArrayList<>());

        Cliente c5 = new Cliente(null, "Pedro", "pedro@gmail.com",
                "697820146", false, new ArrayList<>());

        Cliente c6 = new Cliente(null, "Lucia", "lucia@gmail.com",
                "635444400", true, new ArrayList<>());

        Cliente c7 = new Cliente(null, "Carlos", "carlos@gmail.com",
                "698799642", false, new ArrayList<>());

        Cliente c8 = new Cliente(null, "Elena", "elena@gmail.com",
                "600239980", true, new ArrayList<>());

        Cliente c9 = new Cliente(null, "Sergio", "sergio@gmail.com",
                "777666230", false, new ArrayList<>());

        Cliente c10 = new Cliente(null, "Paula", "paula@gmail.com",
                "656957041", true, new ArrayList<>());

        clienteRepo.save(c1);
        clienteRepo.save(c2);
        clienteRepo.save(c3);
        clienteRepo.save(c4);
        clienteRepo.save(c5);
        clienteRepo.save(c6);
        clienteRepo.save(c7);
        clienteRepo.save(c8);
        clienteRepo.save(c9);
        clienteRepo.save(c10);


        //Reservas
        Reserva rs1 = new Reserva(
                null,
                LocalDate.now(),
                LocalTime.of(14, 0),
                4,
                EstadoReserva.CONFIRMADA,
                80.0,
                m1,
                c1
        );

        Reserva rs2 = new Reserva(
                null,
                LocalDate.now(),
                LocalTime.of(15, 0),
                2,
                EstadoReserva.PENDIENTE,
                40.0,
                m2,
                c2
        );

        Reserva rs3 = new Reserva(
                null,
                LocalDate.now().plusDays(1),
                LocalTime.of(21, 0),
                6,
                EstadoReserva.CANCELADA,
                120.0,
                m3,
                c3
        );

        Reserva rs4 = new Reserva(
                null,
                LocalDate.now().plusDays(2),
                LocalTime.of(22, 0),
                3,
                EstadoReserva.NO_SHOW,
                65.0,
                m4,
                c4
        );

        Reserva rs5 = new Reserva(
                null,
                LocalDate.now(),
                LocalTime.of(20, 30),
                5,
                EstadoReserva.CONFIRMADA,
                95.0,
                m5,
                c5
        );

        Reserva rs6 = new Reserva(
                null,
                LocalDate.now(),
                LocalTime.of(13, 30),
                2,
                EstadoReserva.CONFIRMADA,
                35.0,
                m6,
                c6
        );

        Reserva rs7 = new Reserva(
                null,
                LocalDate.now().plusDays(1),
                LocalTime.of(14, 30),
                4,
                EstadoReserva.PENDIENTE,
                75.0,
                m7,
                c7
        );

        Reserva rs8 = new Reserva(
                null,
                LocalDate.now().plusDays(2),
                LocalTime.of(15, 30),
                2,
                EstadoReserva.CONFIRMADA,
                45.0,
                m8,
                c8
        );

        Reserva rs9 = new Reserva(
                null,
                LocalDate.now(),
                LocalTime.of(21, 30),
                8,
                EstadoReserva.CONFIRMADA,
                150.0,
                m9,
                c9
        );

        Reserva rs10 = new Reserva(
                null,
                LocalDate.now().plusDays(3),
                LocalTime.of(22, 30),
                2,
                EstadoReserva.CANCELADA,
                50.0,
                m10,
                c10
        );

        Reserva rs11 = new Reserva(
                null,
                LocalDate.now().plusDays(1),
                LocalTime.of(13, 0),
                3,
                EstadoReserva.CONFIRMADA,
                60.0,
                m11,
                c1
        );

        Reserva rs12 = new Reserva(
                null,
                LocalDate.now().plusDays(2),
                LocalTime.of(14, 15),
                2,
                EstadoReserva.PENDIENTE,
                45.0,
                m12,
                c2
        );

        Reserva rs13 = new Reserva(
                null,
                LocalDate.now().plusDays(3),
                LocalTime.of(15, 45),
                5,
                EstadoReserva.CONFIRMADA,
                110.0,
                m1,
                c3
        );

        Reserva rs14 = new Reserva(
                null,
                LocalDate.now().plusDays(4),
                LocalTime.of(20, 0),
                6,
                EstadoReserva.NO_SHOW,
                130.0,
                m2,
                c4
        );

        Reserva rs15 = new Reserva(
                null,
                LocalDate.now().plusDays(5),
                LocalTime.of(21, 15),
                4,
                EstadoReserva.CONFIRMADA,
                90.0,
                m3,
                c5
        );

        Reserva rs16 = new Reserva(
                null,
                LocalDate.now().plusDays(1),
                LocalTime.of(22, 0),
                2,
                EstadoReserva.CANCELADA,
                40.0,
                m4,
                c6
        );

        Reserva rs17 = new Reserva(
                null,
                LocalDate.now().plusDays(2),
                LocalTime.of(13, 30),
                8,
                EstadoReserva.CONFIRMADA,
                170.0,
                m5,
                c7
        );

        Reserva rs18 = new Reserva(
                null,
                LocalDate.now().plusDays(3),
                LocalTime.of(14, 0),
                3,
                EstadoReserva.PENDIENTE,
                55.0,
                m6,
                c8
        );

        Reserva rs19 = new Reserva(
                null,
                LocalDate.now().plusDays(4),
                LocalTime.of(15, 0),
                5,
                EstadoReserva.CONFIRMADA,
                115.0,
                m7,
                c9
        );

        Reserva rs20 = new Reserva(
                null,
                LocalDate.now().plusDays(5),
                LocalTime.of(20, 30),
                2,
                EstadoReserva.NO_SHOW,
                35.0,
                m8,
                c10
        );

        Reserva rs21 = new Reserva(
                null,
                LocalDate.now().plusDays(1),
                LocalTime.of(16, 0),
                4,
                EstadoReserva.CONFIRMADA,
                85.0,
                m9,
                c1
        );

        Reserva rs22 = new Reserva(
                null,
                LocalDate.now().plusDays(2),
                LocalTime.of(17, 15),
                2,
                EstadoReserva.PENDIENTE,
                42.0,
                m10,
                c2
        );

        Reserva rs23 = new Reserva(
                null,
                LocalDate.now().plusDays(3),
                LocalTime.of(18, 30),
                6,
                EstadoReserva.CONFIRMADA,
                125.0,
                m11,
                c3
        );

        Reserva rs24 = new Reserva(
                null,
                LocalDate.now().plusDays(4),
                LocalTime.of(19, 45),
                3,
                EstadoReserva.CANCELADA,
                58.0,
                m12,
                c4
        );

        Reserva rs25 = new Reserva(
                null,
                LocalDate.now().plusDays(5),
                LocalTime.of(20, 15),
                5,
                EstadoReserva.CONFIRMADA,
                105.0,
                m1,
                c5
        );

        Reserva rs26 = new Reserva(
                null,
                LocalDate.now().plusDays(1),
                LocalTime.of(21, 0),
                2,
                EstadoReserva.NO_SHOW,
                38.0,
                m2,
                c6
        );

        Reserva rs27 = new Reserva(
                null,
                LocalDate.now().plusDays(2),
                LocalTime.of(13, 45),
                7,
                EstadoReserva.CONFIRMADA,
                160.0,
                m3,
                c7
        );

        Reserva rs28 = new Reserva(
                null,
                LocalDate.now().plusDays(3),
                LocalTime.of(14, 20),
                4,
                EstadoReserva.PENDIENTE,
                72.0,
                m4,
                c8
        );

        Reserva rs29 = new Reserva(
                null,
                LocalDate.now().plusDays(4),
                LocalTime.of(15, 10),
                6,
                EstadoReserva.CONFIRMADA,
                135.0,
                m5,
                c9
        );

        Reserva rs30 = new Reserva(
                null,
                LocalDate.now().plusDays(5),
                LocalTime.of(22, 0),
                2,
                EstadoReserva.CANCELADA,
                48.0,
                m6,
                c10
        );


        reservaRepo.save(rs1);
        reservaRepo.save(rs2);
        reservaRepo.save(rs3);
        reservaRepo.save(rs4);
        reservaRepo.save(rs5);
        reservaRepo.save(rs6);
        reservaRepo.save(rs7);
        reservaRepo.save(rs8);
        reservaRepo.save(rs9);
        reservaRepo.save(rs10);
        reservaRepo.save(rs11);
        reservaRepo.save(rs12);
        reservaRepo.save(rs13);
        reservaRepo.save(rs14);
        reservaRepo.save(rs15);
        reservaRepo.save(rs16);
        reservaRepo.save(rs17);
        reservaRepo.save(rs18);
        reservaRepo.save(rs19);
        reservaRepo.save(rs20);
        reservaRepo.save(rs21);
        reservaRepo.save(rs22);
        reservaRepo.save(rs23);
        reservaRepo.save(rs24);
        reservaRepo.save(rs25);
        reservaRepo.save(rs26);
        reservaRepo.save(rs27);
        reservaRepo.save(rs28);
        reservaRepo.save(rs29);
        reservaRepo.save(rs30);


        //Consultas
        IO.println("--------- Consulta 1 -----------");
        reservaServicio.getReservasConfirmadas();

        IO.println("--------- Consulta 2 -----------");
        reservaServicio.getReservasPorRestaurante(r1.getId());

        IO.println("--------- Consulta 3 -----------");
        reservaServicio.getReservasPendientesHoy();

        IO.println("--------- Consulta 4 -----------");
        reservaServicio.getRecaudacionPorRestaurante();

        IO.println("--------- Consulta 5 -----------");
        reservaServicio.getRestauranteConMasMesas();

        IO.println("--------- Consulta 6 -----------");
        reservaServicio.getReservasProblematicas();

        IO.println("--------- Consulta 7 -----------");
        reservaServicio.getReservasPorCiudad();

        IO.println("--------- Consulta 8 -----------");
        reservaServicio.getMesasMasSolicitadas();

        IO.println("--------- Consulta 9 -----------");
        reservaServicio.getImporteMedioPorTerraza();

        IO.println("--------- Consulta 10 -----------");
        reservaServicio.getClientesFrecuentes(2);

    }
}
