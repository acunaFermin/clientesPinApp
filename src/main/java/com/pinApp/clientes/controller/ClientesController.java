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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;

@RestController
@Tag(name = "Clientes", description = "Operaciones relacionadas con clientes")
public class ClientesController {
    
    private final ClientesService clientesServ;
    
    @Autowired
    ClientesController(ClientesService clientesService) {
        this.clientesServ = clientesService;
    }
    
    @Operation(summary = "Obtener lista de clientes con expectativa de vida")
    @GetMapping("/listclientes")
    public List<ClienteConExpectativaDeVida> getClientes() {
        return this.clientesServ.findAll();
    }
    
    @Operation(summary = "Obtener estadísticas de edad de los clientes")
    @GetMapping("/kpideclientes")
    public EstadisticasEdadDto getEstadisticasEdad() {
        return this.clientesServ.getEstadisticasEdad();
    }
    
    @Operation(summary = "Crear un nuevo cliente")
    @PostMapping("/creacliente")
    public Cliente addCliente(@RequestBody ClienteDto cliente) {
        return this.clientesServ.save(cliente);
    }
    
    @Operation(hidden = true)
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
