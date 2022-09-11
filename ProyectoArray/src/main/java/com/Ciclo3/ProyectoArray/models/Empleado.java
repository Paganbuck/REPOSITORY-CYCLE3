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

