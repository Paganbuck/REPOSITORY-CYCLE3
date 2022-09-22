package com.Ciclo3.ProyectoArray.controller;

///a partri de este momento modificacmos el fullcontrller por el RESTcontroller Y RAMA controller_typeREST
//agregamos otro cambio antes de iniciar con el RESTcontroller

import com.Ciclo3.ProyectoArray.models.Empleado;
import com.Ciclo3.ProyectoArray.models.Empresa;
import com.Ciclo3.ProyectoArray.models.MovimientoDinero;
import com.Ciclo3.ProyectoArray.services.EmpleadoService;
import com.Ciclo3.ProyectoArray.services.EmpresaService;
import com.Ciclo3.ProyectoArray.services.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controlador {

    //conectamos cada controlador a su respectivo servicio
    @Autowired
    EmpresaService empresaService;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    MovimientosService movimientosService;
    //conectamos cada controlador a su respectivo servicio


    /*INICIO EMPRESAS***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */
    @GetMapping("/enterprises") //Ver json de todas las empresas
    public List<Empresa> verEmpresas() {
        return empresaService.listarAllEmpresas();
    }

    @PostMapping("/enterprises") //Guardar el json del body como una nueva empresa o registro en nuestra bd
    public Empresa guardarEmpresa(@RequestBody Empresa emp) {
        return this.empresaService.crearOactualizarEmpresa(emp);
    }

    @GetMapping(path = "enterprises/{id}")
    public Empresa empresaPorID(@PathVariable("id") Integer id) {
        return this.empresaService.consultarEmpresaXId(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa) {
        Empresa emp = empresaService.consultarEmpresaXId(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(empresa.getNIT());
        return empresaService.crearOactualizarEmpresa(emp);
    }


    @DeleteMapping(path = "enterprises/{id}") //Eliminar registro de la bd
    public String DeleteEmpresa(@PathVariable("id") Integer id) {
        boolean respuesta = this.empresaService.deleteEmpresa(id);
        if (respuesta) {  //Si respuesta es true?
            return "Se elimino la empresa con id" + id;
        } else {
            return "No se pudo eliminar la empresa con id" + id;
        }
    }
    /*FINAL EMPRESAS***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */


    /*INICIO EMPLEADO***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */
    @GetMapping("/empleados") //Ver json de todas los empleados
    public List<Empleado> verEmpleados() {
        return empleadoService.getAllEmpleado();
    }

    @PostMapping("/empleados") //Guardar un empleado nuevo
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empl) {
        return Optional.ofNullable(this.empleadoService.saveOrUpdateEmpleado(empl));
    }

    @GetMapping(path = "empleados/{id}")//Consultar empleado por ID
    public Optional<Empleado> empleadoPorID(@PathVariable("id") Integer id) {
        return this.empleadoService.getEmpleadoById(id);
    }

    @GetMapping("/enterprises/{id}/empleados")// Consultar empleados por empresa
    public ArrayList<Empleado> EmpleadoPorEmpresa(@PathVariable("id") Integer id) {
        return this.empleadoService.obtenerPorEmpresa(id);
    }

    @PatchMapping("/empleados/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {
        Empleado empl = empleadoService.getEmpleadoById(id).get();
        empl.setNombre(empleado.getNombre());
        empl.setCorreo(empleado.getCorreo());
        empl.setEmpresa(empleado.getEmpresa());
        empl.setRol(empleado.getRol());
        return empleadoService.saveOrUpdateEmpleado(empl);
    }

    @DeleteMapping("/empleados/{id}") //Metodo para eliminar empleados por id
    public String DeleteEmpleado(@PathVariable("id") Integer id) {
        boolean respuesta = empleadoService.deleteEmpleado(id); //eliminamos usando el servicio de nuestro service
        if (respuesta) { //si la respuesta booleana es true, si se eliminò
            return "Se pudo eliminar correctamente el empleado con id " + id;
        }//Si la respuesta booleana es false, no se eliminó
        return "No se puedo eliminar correctamente el empleado con id " + id;
    }
    /*FINAL EMPLEADO***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */


    /*INICIO MOVIMIENTO DINERO***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */
    @GetMapping("/movimientos") //Consultar todos los movimientos
    public List<MovimientoDinero> verMovimientos() {
        return movimientosService.getAllMovimientos();
    }

    @PostMapping("/movimientos")///crear o guardar un nuevo movimiento
    public boolean guardarMovimiento(@RequestBody MovimientoDinero movimiento) {
        return movimientosService.saveOrUpdateMovimiento(movimiento);
    }

    @GetMapping("/movimientos/{id}") //Consultar movimiento por id
    public MovimientoDinero movimientoPorId(@PathVariable("id") Integer id) {
        return movimientosService.getMovimientoById(id);
    }

    @PatchMapping("/movimientos/{id}")//Editar o actualizar un movimiento
    public boolean actualizarMovimiento(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movimiento) {
        MovimientoDinero mov = movimientosService.getMovimientoById(id);
        mov.setConcepto(movimiento.getConcepto());
        mov.setMonto(movimiento.getMonto());
        mov.setUsuario(movimiento.getUsuario());
        return movimientosService.saveOrUpdateMovimiento(mov);
    }

    @DeleteMapping("/movimientos/{id}")
    public String deleteMovimiento(@PathVariable("id") Integer id) {
        boolean respuesta = movimientosService.deleteMovimiento(id);
        if (respuesta) {
            return "Se elimino correctamente el movimiento con id " + id;
        }
        return "No se pudo eliminar el movimiento con id " + id;
    }

    @GetMapping("/empleados/{id}/movimientos") //Consultar movimientos por id del empleado
    public ArrayList<MovimientoDinero> movimientosPorEmpleado(@PathVariable("id") Integer id) {
        return movimientosService.obtenerPorEmpleado(id);
    }

    @GetMapping("/enterprises/{id}/movimientos")
    //Consultar movimientos que pertenecen a una empresa por el id de la empresa
    public ArrayList<MovimientoDinero> movimientosPorEmpresa(@PathVariable("id") Integer id) {
        return movimientosService.obtenerPorEmpresa(id);
    }
    /*FINAL MOVIMIENTO DINERO***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */


    //Actualizando Controlador
    @PostMapping("/GuardarMovimientos")///crear o guardar un nuevo movimiento
    public String guardarMovimiento(MovimientoDinero mov, RedirectAttributes redirectAttributes) {
        if (movimientosService.saveOrUpdateMovimiento(mov)) {
            redirectAttributes.addFlashAttribute("mensaje", "saveOk");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/agregarMovimientos";
    }

     redirectAttributes.addFlashAttribute("mensaje","saveError");
        return"redirect:/AgregarMovimiento";
     }

    @GetMapping("/EditarMovimiento/{id}")
    public String editarMovimento(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero mov=movimientosService.getMovimientoById(id);
        //Creamos un atributo para el modelo, que se llame igualmente empl y es el que ira al html para llenar o alimentar campos
        model.addAttribute("mov",mov);
        model.addAttribute("mensaje", mensaje);
        List<Empleado> listaEmpleados= empleadoService.getAllEmpleado();
        model.addAttribute("emplelist",listaEmpleados);
        return "editarMovimiento";
    }

    @PostMapping("/ActualizarMovimiento")
    public String updateMovimiento(@ModelAttribute("mov") MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(movimientosService.saveOrUpdateMovimiento(mov)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarMovimiemto/"+mov.getId();

    }

    @GetMapping("/EliminarMovimiento/{id}")
    public String eliminarMovimiento(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (movimientosService.deleteMovimiento(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerMovimientos";
    }

    @GetMapping("/Empleado/{id}/Movimientos") //Filtro de movimientos por empleados
    public String movimientosPorEmpleado(@PathVariable("id")Integer id, Model model){
        List<MovimientoDinero> movlist = movimientosService.obtenerPorEmpleado(id);
        model.addAttribute("movlist",movlist);
        Long sumaMonto=movimientosService.MontosPorEmpleado(id);
        model.addAttribute("SumaMontos",sumaMonto);
        return "verMovimientos"; //Llamamos al HTML
    }

    @GetMapping("/Empresa/{id}/Movimientos") //Filtro de movimientos por empresa
    public String movimientosPorEmpresa(@PathVariable("id")Integer id, Model model){
        List<MovimientoDinero> movlist = movimientosService.obtenerPorEmpresa(id);
        model.addAttribute("movlist",movlist);
        Long sumaMonto=movimientosService.MontosPorEmpresa(id);
        model.addAttribute("SumaMontos",sumaMonto);
        return "verMovimientos"; //Llamamos al HTML
    }

    //Controlador que me lleva al template de No autorizado
    @RequestMapping(value="/Denegado")
    public String accesoDenegado(){
        return "accessDenied";
    }


    //Metodo para encriptar contraseñas
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
