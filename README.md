# Sistema de Gestión de Restaurantes - JPA & Hibernate

Proyecto en Java que simula la gestión interna de una cadena de restaurantes, utilizando el persistence unit `restaurantesPU` para trabajar con clientes, mesas, reservas y consultas analíticas mediante ORM y Streams.

---

## Requisitos

* Java 21
* Maven
* MySQL Server

---

## Instalación

1. Crear la base de datos en tu MySQL local:

```sql
CREATE DATABASE restaurantesPU
```

2. Abrir el proyecto en IntelliJ IDEA:

---

## Ejecución
Ejecutar la clase Main o arrancar desde la terminal con Maven:
mvn clean compile exec:java

---

## Funcionalidades
- Inicialización y generación automática del esquema de tablas en MySQL a través de JPA

- Inserción automatizada de datos de prueba (Restaurantes, Mesas, Clientes y Reservas)

- Realizar consultas analíticas de la base de datos mediante JPQL y Streams

    - Obtener listados:

1. Reservas confirmadas ordenadas por fecha ascendente

2. Todas las reservas asociadas a un restaurante específico

3. Reservas con estado PENDIENTE registradas en el día de hoy

4. Recaudación total estimada por restaurante de mayor a menor

5. Identificación del restaurante con mayor número de mesas

6. Reservas problemáticas con estado CANCELADA o NO_SHOW

7. Número total de reservas agrupadas por ciudad del restaurante

8. Detección de la mesa con más reservas acumuladas

9. Importe medio estimado dividiendo mesas de terraza e interior

10. Clientes frecuentes con al menos X reservas (usando distinct y filter)

---

## Estructura

- App → Main

- modelo → Restaurante, Mesa, Cliente, Reserva, EstadoReserva

- repositorio → Repository, JpaRepository, RestauranteRepository, MesaRepository, ClienteRepository, ReservaRepository

- servicio → ReservaServicio

- util → JpaUtil

---

## AUTOR
Daniel Fernández Alcón

