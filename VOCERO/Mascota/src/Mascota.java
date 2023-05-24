import javax.swing.JOptionPane;

public class Mascota {

	String nombre;
	String especie;
	int edad;
	int id;

	public Mascota() {
		id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la identificación de la mascota"));
	}

	public Mascota(String nombre, String especie, int edad, int id) {
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
		this.id = id;
	}

	public void mostrarInformacion() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Especie: " + especie);
		System.out.println("Edad: " + edad + " años");
	}


	public void hacerSonido() {
		if (especie.equalsIgnoreCase("perro")) {
			System.out.println("Guau guau!");
		} else if (especie.equalsIgnoreCase("gato")) {
			System.out.println("Miau miau!");
		} else {
			System.out.println("La mascota no hace sonidos conocidos.");
		}
	}


	public void comer() {
		System.out.println("La mascota está comiendo...");
	}


	public void jugar() {
		System.out.println("La mascota está jugando...");
	}
}
