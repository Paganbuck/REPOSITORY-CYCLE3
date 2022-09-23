
package codigoEmpresa;

public class Main {
    public static void main(String[] args){
        
    Empresa empresa1 = new Empresa("nombredefault","direcciondefault",311000000,"nitdefault");
    
    empresa1.setNombre("Digital Country");
    empresa1.setDireccion("cra24 No 37-88, piso2");
    empresa1.setTelefono(311263328);
    empresa1.setNit("nit900-0000-2");
    
    System.out.println("INICIO DE LA APLICACION!!*******************");
    System.out.println("********************************************");
    System.out.println("DATOS DE LA EMPRESA*******************");
    // imprimo Nombre de la empresa
    System.out.println("Nombre de la empresa: "+empresa1.getNombre());
    // imprimo direccion de la empresa
    System.out.println("Direccion de la empresa: "+empresa1.getDireccion());
    // imprimo telefono de la empresa
    System.out.println("telefono de la empresa: "+empresa1.getTelefono());
    // imprimo NIT de la empresa
    System.out.println("Nit de la empresa: "+empresa1.getNit()); 
    System.out.println("");
    
       
    
    ////////////////////////Out Put clase empleado
    
        Empleado empleado1 = new Empleado("Nombre: WILSON RICARDO REVELO SARASTY","E-mail: econowil@hotmail.com","Empresa: ArraysTeamGroup","Rol: ADMINISTRADOR");

        System.out.println("DATOS DEL EMPLEADO*******************");
        System.out.println(empleado1.getNombreEmpleado());
        System.out.println(empleado1.getEmailEmpleado());
        System.out.println(empleado1.getNombreEmpresa());
        System.out.println(empleado1.getRolEmpleado());
        
        empleado1.setNombreEmpleado("Nombre:JUAN PEREZ");
        empleado1.setEmailEmpleado("E_mail: ArraysTeam@gmail.com");
        empleado1.setNombreEmpresa("Empresa: ArraysGroup");
        empleado1.setRolEmpleado("Rol: OPERATIVO");
        
        System.out.println(empleado1.getNombreEmpleado());
        System.out.println(empleado1.getEmailEmpleado());
        System.out.println(empleado1.getNombreEmpresa());
        System.out.println(empleado1.getRolEmpleado());
        System.out.println("FIN DE LA APLICACION!!*******************");
        System.out.println("********************************************");
    
    }
}
