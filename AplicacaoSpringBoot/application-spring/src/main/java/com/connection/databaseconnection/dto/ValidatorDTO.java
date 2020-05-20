package com.connection.databaseconnection.dto;

public class ValidatorDTO {

    private Integer id, tipo;

    public ValidatorDTO(Integer id, Integer tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ValidatorDTO{" +
                "id=" + id +
                ", tipo=" + tipo +
                '}';
    }
}
