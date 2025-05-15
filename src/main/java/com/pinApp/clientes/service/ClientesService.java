package com.pinApp.clientes.service;

import com.pinApp.clientes.common.ClienteConExpectativaDeVida;
import com.pinApp.clientes.common.ClienteDto;
import com.pinApp.clientes.common.EstadisticasEdadDto;
import com.pinApp.clientes.entity.Cliente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ClientesService {
    
    @Transactional
    Cliente save(ClienteDto cliente);
    
    EstadisticasEdadDto getEstadisticasEdad();
    
    List<ClienteConExpectativaDeVida> findAll();
}
