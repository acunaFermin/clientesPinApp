package com.pinApp.clientes.controller;


import com.pinApp.clientes.common.ClienteConExpectativaDeVida;
import com.pinApp.clientes.common.ClienteDto;
import com.pinApp.clientes.common.EstadisticasEdadDto;
import com.pinApp.clientes.entity.Cliente;
import com.pinApp.clientes.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientesController {
    
    private final ClientesService clientesServ;
    
    @Autowired
    ClientesController(ClientesService clientesService) {
        this.clientesServ = clientesService;
    }
    
    @GetMapping("/listclientes")
    public List<ClienteConExpectativaDeVida> getClientes() {
        return this.clientesServ.findAll();
    }
    
    @GetMapping("/kpideclientes")
    public EstadisticasEdadDto getEstadisticasEdad() {
        return this.clientesServ.getEstadisticasEdad();
    }
    
    @PostMapping("/creacliente")
    public Cliente addCliente(@RequestBody ClienteDto cliente) {
        return this.clientesServ.save(cliente);
    }
    
    @GetMapping(value = {
    "/clientes",
    "/clientes/",
    "/clientes/{path:^(?!api).*$}",
    "/clientes/{path:^(?!api).*$}/**"
    })
    public String forwardAngularRoutes() {
        return "forward:/index.html";
    }

}
