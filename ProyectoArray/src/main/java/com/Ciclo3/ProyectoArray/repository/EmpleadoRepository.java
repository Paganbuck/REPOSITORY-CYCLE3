package com.Ciclo3.ProyectoArray.repository;

import com.Ciclo3.ProyectoArray.models.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,Integer>{
}


