package com.Ciclo3.ProyectoArray.controller;

///a partri de este momento modificacmos el fullcontrller por el RESTcontroller Y RAMA controller_typeREST
//cambiamos RESTcontroller por Controller Full
import com.Ciclo3.ProyectoArray.models.Empleado;
import com.Ciclo3.ProyectoArray.models.Empresa;
import com.Ciclo3.ProyectoArray.models.MovimientoDinero;
import com.Ciclo3.ProyectoArray.repository.MovimientosRepository;
import com.Ciclo3.ProyectoArray.services.EmpleadoService;
import com.Ciclo3.ProyectoArray.services.EmpresaService;
import com.Ciclo3.ProyectoArray.services.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class Controlador {

    //conectamos cada controlador a su respectivo servicio
    @Autowired
    EmpresaService empresaService;

    //conectamos cada controlador a su respectivo servicio
    @Autowired
    EmpleadoService empleadoService;

    //conectamos cada controlador a su respectivo servicio
    @Autowired
    MovimientosService movimientosService;

    @Autowired
    MovimientosRepository movimientosReposito;



    /*INICIO EMPRESAS***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */
    @GetMapping({"/","/VerEmpresas"})
    public String viewEmpresas(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emplist", listaEmpresas);
        model.addAttribute("mensaje", mensaje);
        return "verEmpresas"; //Llamamos al HTML
    }

    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaService.saveOrUpdateEmpresa(emp)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpresa";
    }

    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        Empresa emp=empresaService.getEmpresaById(id);
        //Creamos un atributo para el modelo, que se llame igualmente emp y es el que ira al html para llenar o alimentar campos
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje", mensaje);
        return "editarEmpresa";
    }


    @PostMapping("/ActualizarEmpresa")
    public String updateEmpresa(@ModelAttribute("emp") Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaService.saveOrUpdateEmpresa(emp)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpresa/"+emp.getId();

    }

    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (empresaService.deleteEmpresa(id)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpresas";
    }
    /*FINAL EMPRESAS***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */



    /*INICIO EMPLEADO***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */

    /*FINAL EMPLEADO***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */


    /*INICIO MOVIMIENTO DINERO***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */

    /*FINAL MOVIMIENTO DINERO***************************************************************************************
     *************************************************************************************************
     * **********************************************************************************************
     */


}
