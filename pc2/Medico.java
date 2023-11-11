package pc2;

public class Medico {
	private int nroDeColegiatura;
	private String nombre, especialidad;
	
	public Medico(int nroDeColegiatura, String nombre, String especialidad) {
		super();
		this.nroDeColegiatura = nroDeColegiatura;
		this.nombre = nombre;
		this.especialidad = especialidad;
	}
	
	@Override
	public String toString() {
		return "Medico [nroDeColegiatura=" + nroDeColegiatura + ", nombre=" + nombre + ", especialidad=" + especialidad
				+ "]\n";
	}

	public int getNroDeColegiatura() {
		return nroDeColegiatura;
	}
	public void setNroDeColegiatura(int nroDeColegiatura) {
		this.nroDeColegiatura = nroDeColegiatura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}	
}
