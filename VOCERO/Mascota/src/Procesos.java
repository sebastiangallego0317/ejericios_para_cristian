
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Procesos {
	HashMap<Integer, Mascota> mascotas;
	Mascota mascota;
	String name;

	public Procesos() {
		mascotas = new HashMap<Integer, Mascota>();
		start();
	}

	private void start() {
		int opc = 0;
		String menu = "¡Bienvenido!\n" +
                "Selecciona una opción:\n" +
                "1. Registrar una nueva mascota\n" +
                "2. Ver lista de mascotas registradas\n" +
                "3. Consultar mascota\n" +
                "4. Modificar mascotas\n" +
                "5. Salir";
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
					
			elegirOpcion(opc);
		} while (opc != 5);
	}

	private void registrarMascota() {
		do {
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota");
			String especie = JOptionPane.showInputDialog("Ingrese la raza de la mascota");
			int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota"));
			int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la identificación de la mascota"));

			mascota = new Mascota(nombre, especie, edad, id);
			if (mascotas.containsKey(mascota.id)) {
				JOptionPane.showMessageDialog(null, "La mascota no fue registrada, la identificación ya existe");
			} else {
				mascotas.put(mascota.id, mascota);
				JOptionPane.showMessageDialog(null, "Registro exitoso");
			}
		} while (mascota == null);
	}

	public void elegirOpcion(int a) {
		switch (a) {
		case 1:
			registrarMascota();
			break;
		case 2:
			if (tieneMascotas()) {
				mostrarLista();
			} else {
				JOptionPane.showMessageDialog(null, "Aún no hay ninguna mascota registrada");
			}
			break;
		case 3:
			if (tieneMascotas()) {
				buscarPorNombre();
			} else {
				JOptionPane.showMessageDialog(null, "Aún no hay ninguna mascota registrada");
			}
			break;
		case 4:
			if (tieneMascotas()) {
				modificar();
			} else {
				JOptionPane.showMessageDialog(null, "Aún no hay ninguna mascota registrada");
			}
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Hasta la próxima");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
		}
	}

	public boolean tieneMascotas() {
		return !mascotas.isEmpty();
	}

	public void mostrarLista() {
		for (Mascota mascota : mascotas.values()) {
			mascota.mostrarInformacion();
			System.out.println();
		}
	}

	public void buscarPorNombre() {
		name = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a buscar");
		boolean noExiste = true;
		for (Mascota mascota : mascotas.values()) {
			if (mascota.nombre.equalsIgnoreCase(name)) {
				mascota.mostrarInformacion();
				noExiste = false;
			}
		}
		if (noExiste) {
			JOptionPane.showMessageDialog(null, "No hay mascotas con ese nombre");
		}
	}

	public void modificar() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la mascota que desea modificar"));
		int opc = Integer.parseInt(
				JOptionPane.showInputDialog("¿Qué desea modificar?\n1. Nombre\n2. Edad\n3. Especie"));
		cambiar(id, opc);
	}

	public void cambiar(int id, int opc) {
		switch (opc) {
		case 1:
			String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de " + mascotas.get(id).nombre);
			mascotas.get(id).nombre = nuevoNombre;
			break;
		case 2:
			int nuevaEdad = Integer.parseInt(
					JOptionPane.showInputDialog("Ingrese la nueva edad de " + mascotas.get(id).nombre));
			mascotas.get(id).edad = nuevaEdad;
			break;
		case 3:
			String nuevaEspecie = JOptionPane.showInputDialog("Ingrese la nueva especie de " + mascotas.get(id).nombre);
			mascotas.get(id).especie = nuevaEspecie;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
			break;
		}
	}
}
