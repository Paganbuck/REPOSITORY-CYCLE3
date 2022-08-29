
public class MovimientoDinero {
	private double montoDelMovimiento;
	private double montos_positivos_y_negativos;
	private String conceptoDelMovimiento;
	private String UsuarioEncargadoDelMovimiento;

	public MovimientoDinero(double montoDelMpvimiento, double montosPositivosYNegativos, String conceptoDelMovimiento,
			String UsuarioEncargadoDelMovimiento, double montoDelMovimiento) {
		this.montoDelMovimiento = montoDelMovimiento;
		this.montos_positivos_y_negativos = montosPositivosYNegativos;
		this.conceptoDelMovimiento = conceptoDelMovimiento;
		this.UsuarioEncargadoDelMovimiento = UsuarioEncargadoDelMovimiento;
	}

	public double getMontoDelMovimiento() {
		return montoDelMovimiento;
	}

	public void setMontoDelMovimiento(double montoDelMovimiento) {
		this.montoDelMovimiento = montoDelMovimiento;
	}

	public double getMontos_positivos_y_negativos() {
		return montos_positivos_y_negativos;
	}

	public void setMontos_positivos_y_negativos(double montos_positivos_y_negativos) {
		this.montos_positivos_y_negativos = montos_positivos_y_negativos;
	}

	public String getConceptoDelMovimiento() {
		return conceptoDelMovimiento;
	}

	public void setConceptoDelMovimiento(String conceptoDelMovimiento) {
		this.conceptoDelMovimiento = conceptoDelMovimiento;
	}

	public String getUsuarioEncargadoDelMovimiento() {
		return UsuarioEncargadoDelMovimiento;
	}

	public void setUsuarioEncargadoDelMovimiento(String usuarioEncargadoDelMovimiento) {
		UsuarioEncargadoDelMovimiento = usuarioEncargadoDelMovimiento;
	}
	
	public static void main(String[] args) {
		System.out.println();
	}

}
