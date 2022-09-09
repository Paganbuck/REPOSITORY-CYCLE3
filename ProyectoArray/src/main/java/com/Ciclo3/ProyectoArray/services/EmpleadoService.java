package com.Ciclo3.ProyectoArray.services;

import com.Ciclo3.ProyectoArray.models.Empleado;
import com.Ciclo3.ProyectoArray.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

  @Autowired
  EmpleadoRepository empleadoRepository;

  //Metodo para ver todos los empleados registrados
  public List<Empleado>getAllEmpleado(){
    List<Empleado>empleadoList= new ArrayList<>();
    empleadoRepository.findAll().forEach(empleado -> empleadoList.add(empleado);
     return  empleadoList;
  }
  //Metodo para buscar empleados por ID
  public Optional<Empleado> getEmpleadoById(Integer id){  //Existe Optionaly asi se podria usar
    return empleadoRepository.findById(id);
  }

  //Metodo para guardar o actualizar Empleados
 public Empleado saveOrUpdateEmpleado(Empleado empleado){
  return empleadoRepository.save(empleado);
  }

  //Metodo para eliminar un Registro de Empleado por Id
  public boolean deleteEmpleado(Integer id){
    empleadoRepository.deleteById(id);
    if (empleadoRepository.findById(id)!=null) {
      return false;
    }
    return  true;
   }
}
