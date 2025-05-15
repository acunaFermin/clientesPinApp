package com.pinApp.clientes.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    protected int id;
    protected String nombre;
    protected String apellido;
    protected int edad;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",timezone = "America/Argentina/Buenos_Aires")
    protected Date fechaNacimiento;
}
