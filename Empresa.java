package codigoEmpresa;

public class Empresa {

	//Atributos 
	private String nombre;
	private String direccion;
	private long telefono;
	private String nit;

	//Method Constructor

public Empresa(String nombre, String direccion, long telefono, String nit) {
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	this.nit = nit;

	

//Getters y Setters

public String getNombre() { 
	return nombre; 
}

public void setNombre(String nombre) { 
	this.nombre = nombre; 
}
public String getDireccion() { 
	return direccion; 
}
public void setDireccion(String direccion) { 
	this.direccion = direccion; 
}
public long getTelefono() { 
	return telefono; 
}
public void setTelefono(long telefono) { 
	this.telefono = telefono; 
}
public String getNit() { 
	return nit; 
}
public void setNit(String nit) { 
	this.nit = nit;
}
