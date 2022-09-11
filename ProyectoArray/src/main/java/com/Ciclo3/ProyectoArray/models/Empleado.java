package com.Ciclo3.ProyectoArray.models;

import javax.persistence.*;

@Entity
@Table(name="Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String correo;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    private String rol;

    public Empleado() {  ///only JPA
    }

    public Empleado(String nombre, String correo, Empresa empresa, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

