package com.pinApp.clientes.repository;

import com.pinApp.clientes.common.EstadisticasEdadDto;
import com.pinApp.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends CrudRepository<Cliente, Integer> {
    
    List<Cliente> findAll();
    
    @Query(
        value = "SELECT AVG(edad) as promedio, STDDEV_POP(edad) as desvio FROM cliente",
        nativeQuery = true
    )
    EstadisticasEdadDto getEstadisticasEdad();
}
