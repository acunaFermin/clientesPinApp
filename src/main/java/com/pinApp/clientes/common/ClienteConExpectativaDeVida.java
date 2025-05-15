package com.pinApp.clientes.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pinApp.clientes.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Date;

@Getter
public class ClienteConExpectativaDeVida extends ClienteDto {
    
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",timezone = "America/Argentina/Buenos_Aires")
    private Date fechaProbableMuerte;
    
    @Builder(builderMethodName = "conExpectativaBuilder")
    public ClienteConExpectativaDeVida(
        int id, String nombre, String apellido,
        int edad, Date fechaNacimiento, int expectativaDeVida) {
        super(id, nombre, apellido, edad, fechaNacimiento);
        this.fechaProbableMuerte = obtenerFechaProbableMuerte(expectativaDeVida);
    }
    
    private Date obtenerFechaProbableMuerte(int expectativaDeVida) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getFechaNacimiento());
        calendar.add(Calendar.YEAR, expectativaDeVida);
        return calendar.getTime();
    }
}
