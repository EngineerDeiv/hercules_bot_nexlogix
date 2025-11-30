package models;

public class CreateVehicule {

	private String placa;
	private String marca;
	private String tipo;
	private String capacidad;
	private String estado;
	private String ultimoMantenimiento;

	public CreateVehicule() {
	}

	public CreateVehicule(String placa, String marca, String tipo, String capacidad, String estado, String ultimoMantenimiento) {
		this.placa = placa;
		this.marca = marca;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.estado = estado;
		this.ultimoMantenimiento = ultimoMantenimiento;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUltimoMantenimiento() {
		return ultimoMantenimiento;
	}

	public void setUltimoMantenimiento(String ultimoMantenimiento) {
		this.ultimoMantenimiento = ultimoMantenimiento;
	}

	@Override
	public String toString() {
		return "CreateVehicule{" +
				"placa='" + placa + '\'' +
				", marca='" + marca + '\'' +
				", tipo='" + tipo + '\'' +
				", capacidad='" + capacidad + '\'' +
				", estado='" + estado + '\'' +
				", ultimoMantenimiento='" + ultimoMantenimiento + '\'' +
				'}';
	}
}
