package com.pinApp.clientes.service.impl;

import com.pinApp.clientes.common.ClienteConExpectativaDeVida;
import com.pinApp.clientes.common.ClienteDto;
import com.pinApp.clientes.common.EstadisticasEdadDto;
import com.pinApp.clientes.entity.Cliente;
import com.pinApp.clientes.repository.ClientesRepository;
import com.pinApp.clientes.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientesServiceImpl implements ClientesService {
    
    @Value("${cliente.expectativa-de-vida}")
    private int expectativaDeVida;
    
    private final ClientesRepository clientesRepo;
    
    @Autowired
    ClientesServiceImpl(ClientesRepository clientesRepository) {
        this.clientesRepo = clientesRepository;
    }
    
    @Override
    @Transactional
    public Cliente save(ClienteDto cliente) {
        Cliente newCliente = Cliente.builder()
        .nombre(cliente.getNombre())
        .apellido(cliente.getApellido())
        .fechaNacimiento(cliente.getFechaNacimiento())
        .edad(cliente.getEdad())
        .build();
        
        return this.clientesRepo.save(newCliente);
    }
    
    @Override
    public EstadisticasEdadDto getEstadisticasEdad() {
        return this.clientesRepo.getEstadisticasEdad();
    }
    
    @Override
    public List<ClienteConExpectativaDeVida> findAll() {
        return clientesRepo.findAll().stream()
        .map(this::getClienteExpVidaDto)
        .collect(Collectors.toList());
    }
    
    private ClienteConExpectativaDeVida getClienteExpVidaDto(Cliente cliente) {
        return ClienteConExpectativaDeVida.conExpectativaBuilder()
        .id(cliente.getId())
        .nombre(cliente.getNombre())
        .apellido(cliente.getApellido())
        .edad(cliente.getEdad())
        .fechaNacimiento(cliente.getFechaNacimiento())
        .expectativaDeVida(expectativaDeVida)
        .build();
    }
}
