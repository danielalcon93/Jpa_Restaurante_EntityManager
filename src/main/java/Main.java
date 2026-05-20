import modelo.Restaurante;
import repositorio.ClienteRepository;
import repositorio.MesaRepository;
import repositorio.ReservaRepository;
import repositorio.RestauranteRepository;
import servicio.ReservaServicio;

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

    }
}
