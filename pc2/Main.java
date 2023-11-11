package pc2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hospital hospital=new Hospital("La solidaridad", new ArrayList<Medico>(), new ArrayList<Paciente>());
		Paciente pacientePrueba1=new Paciente("234367", "Cesar", "Santa Anita", 78, 37);
		Paciente pacientePrueba2=new Paciente("345378", "Milagros", "Ate", 50, 37);
		Paciente pacientePrueba3=new Paciente("547865", "Diego", "Agustino", 67, 36);
		Paciente pacientePrueba4=new Paciente("456789", "Bryan", "CentrodeLima", 89, 38);
		
		Medico medico1=new Medico(1993, "Dr.Perez", "Urologo");
		Medico medico2=new Medico(2901, "Dr. Lopez", "Neurologo");
		Medico medico3=new Medico(2602, "Dr. Huachua", "Traumatologo");
		Medico medico4=new Medico(2801, "Dr. Julca", "Ginecologo");
		
		hospital.añadirMedicos(medico1);
		hospital.añadirMedicos(medico2);
		hospital.añadirMedicos(medico3);
		hospital.añadirMedicos(medico4);
		
		pacientePrueba1.setMedico(medico1);
		pacientePrueba2.setMedico(medico1);
		pacientePrueba3.setMedico(medico3);
		pacientePrueba4.setMedico(medico4);
		
		hospital.añadirPacientes(pacientePrueba1);
		hospital.añadirPacientes(pacientePrueba2);
		hospital.añadirPacientes(pacientePrueba3);
		hospital.añadirPacientes(pacientePrueba4);
		
		Scanner sc=new Scanner(System.in);		
		boolean puedeIngresar=true;
		String dni, nombre, direccion;
		int peso, temperatura;
		double[] pesos;
		
		imprimirInstrucciones();
		
		try {
			while (puedeIngresar && sc.hasNext()) {
				int opcion=sc.nextInt();
				sc.nextLine();
				
				switch (opcion) {
				case 1:
					System.out.println("Ingrese dni del paciente");
					dni=sc.nextLine();
					System.out.println("Ingrese nombre del paciente");
					nombre=sc.nextLine();
					nombre=nombre.substring(0,1).toUpperCase()+nombre.substring(1);
					System.out.println("Ingrese dirección del paciente");
					direccion=sc.nextLine();
					System.out.println("Ingrese peso del paciente");
					peso=sc.nextInt();
					System.out.println("Ingrese temperatura del paciente");
					temperatura=sc.nextInt();
					
					Paciente paciente=new Paciente(dni, nombre, direccion, peso, temperatura);
					hospital.añadirPacientes(paciente);
					System.out.println("Paciente añadido");				
					hospital.imprimirPacientes();				
					break;
					
				case 2:
					hospital.imprimirPacientes();
					System.out.println("Ingrese posición del paciente a eliminar");
					int pacienteAEliminar=sc.nextInt();
					
					if(pacienteAEliminar>hospital.getPacientes().size()) {
						System.out.println("La posición ingresada no existe");
					}else {
						hospital.eliminarPacientes(pacienteAEliminar-1);
						System.out.println("Paciente eliminado");
						hospital.imprimirPacientes();
					}
					break;
					
				case 3:
					hospital.imprimirPacientes();
					System.out.println("Ingrese posición del paciente a modificar");
					int pacienteAModificar=sc.nextInt();
					sc.nextLine();
					
					if(pacienteAModificar>hospital.getPacientes().size()) {
						System.out.println("La posición ingresada no existe");
					}else {
						System.out.println("Ingrese dni del paciente");
						dni=sc.nextLine();
						System.out.println("Ingrese nombre del paciente");
						nombre=sc.nextLine();
						nombre=nombre.substring(0,1).toUpperCase()+nombre.substring(1);
						System.out.println("Ingrese dirección del paciente");
						direccion=sc.nextLine();
						System.out.println("Ingrese peso del paciente");
						peso=sc.nextInt();
						System.out.println("Ingrese temperatura del paciente");
						temperatura=sc.nextInt();
						
						paciente=hospital.getPacientes().get(pacienteAModificar-1);
						paciente.setDni(dni);
						paciente.setNombre(nombre);
						paciente.setDireccion(direccion);
						paciente.setPeso(peso);
						paciente.setTemperatura(temperatura);
						
						System.out.println("Los datos del paciente fueron modificados");
						hospital.imprimirPacientes();
					}
					break;
				case 4:
					pesos=new double[hospital.getPacientes().size()];
					for (int i = 0; i < hospital.getPacientes().size(); i++) {
						pesos[i]=hospital.getPacientes().get(i).getPeso();
					}
					System.out.println("El peso más común es "+hospital.elementoMasComun(pesos));
					break;
				case 5:
					pesos=new double[hospital.getPacientes().size()];
					for (int i = 0; i < hospital.getPacientes().size(); i++) {
						pesos[i]=hospital.getPacientes().get(i).getPeso();
					}
					
					double pesoMasComun=hospital.elementoMasComun(pesos);
					int pacientesConPesoMasComun=0;
					for (Paciente p : hospital.getPacientes()) {
						if(p.getPeso()==pesoMasComun) {
							pacientesConPesoMasComun++;
						}
					}
					System.out.println("Las personas con "+pesoMasComun+" kilos son: "+pacientesConPesoMasComun);
					break;
				case 6:
					System.out.println("El peso menor es "+hospital.buscarPesoMenor());
					System.out.println("El peso mayor es "+hospital.buscarPesoMayor());
					break;
				case 7:
					double primerRango=hospital.buscarPesoMenor(),
						ultimoRango=hospital.buscarPesoMayor(),
						diferencia=(ultimoRango-primerRango)/4,
						segundoRango=primerRango+diferencia,
						tercerRango=primerRango+(diferencia*2),
						cuartoRango=ultimoRango-diferencia;
					
					int enPrimerRango=0, enSegundoRango=0, enTercerRango=0, enCuartoRango=0;
						
					for (Paciente p : hospital.getPacientes()) {
						if(p.getPeso()<segundoRango) {
							enPrimerRango++;
						}else if(p.getPeso()>=segundoRango&&p.getPeso()<tercerRango) {
							enSegundoRango++;
						}else if(p.getPeso()>=tercerRango&&p.getPeso()<cuartoRango) {
							enTercerRango++;						
						}else {
							enCuartoRango++;												
						}
					}
					System.out.println("Pacientes en el primer rango (desde "+primerRango+" hasta "+segundoRango+"): "+enPrimerRango);
					System.out.println("Pacientes en el segundo rango (desde "+segundoRango+" hasta "+tercerRango+"): "+enSegundoRango);
					System.out.println("Pacientes en el tercer rango (desde "+tercerRango+" hasta "+cuartoRango+"): "+enTercerRango);
					System.out.println("Pacientes en el último rango (desde "+cuartoRango+" hasta "+ultimoRango+"): "+enCuartoRango);
					break;
				case 8:
					hospital.ordenarPacientesPorNombre();
					break;
				case 9:
					hospital.imprimirPacientes();
					System.out.println("Ingrese posición del paciente");
					int pacienteABuscar=sc.nextInt();
					//sc.nextLine();
					
					if(pacienteABuscar>hospital.getPacientes().size()) {
						System.out.println("La posición ingresada no existe");
					}else {
						System.out.println("El paciente "+hospital.getPacientes().get(pacienteABuscar-1).getNombre()+
								" fue atendido por: "+hospital.getPacientes().get(pacienteABuscar-1).getMedico());
					}
					break;
				case 10:
					System.out.println("Ingrese especialidad del médico");
					String espABuscar=sc.nextLine();
					for (Medico m : hospital.getMedicos()) {
						if(m.getEspecialidad().equalsIgnoreCase(espABuscar)) {
							System.out.println(m.toString());
						}
					}
					break;
				default:
					System.out.println("Número no soportado, el programa finaliza");
					sc.close();
					puedeIngresar=false;
					break;
				}
				if(puedeIngresar) imprimirInstrucciones();	
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Valor no aceptado. Se finaliza el programa");
			sc.close();
			puedeIngresar=false;
		}	
	}
	
	public static void imprimirInstrucciones() {
		System.out.println("Seleccione una opción");		
		System.out.println("1: Registrar los datos de los pacientes");		
		System.out.println("2: Eliminar los datos de un paciente");		
		System.out.println("3: Modificar los datos de un paciente");		
		System.out.println("4: Mostrar el peso que más se repite");		
		System.out.println("5: Mostrar la cantidad de pacientes que tienen el peso que más se repite");		
		System.out.println("6: Mostrar el peso mayor y menor");		
		System.out.println("7: Dividir el rango de pesos por 4");		
		System.out.println("8: Mostrar la lista de pacientes ordenados por nombres");		
		System.out.println("9: Dado un paciente indicar qué doctor lo atendió");		
		System.out.println("10: Buscar a los doctores por especialidad.");				
	}
}
