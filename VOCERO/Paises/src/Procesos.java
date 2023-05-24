import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;

public class Procesos {
    private HashMap<String, ArrayList<String>> ciudadesPorPais;

    public Procesos() {
        ciudadesPorPais = new HashMap<>();
        iniciar();
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            int opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    registrarPais();
                    break;
                case 2:
                    registrarCiudad();
                    break;
                case 3:
                    consultarCiudadesPorPais();
                    break;
                case 4:
                    consultarCiudad();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, elija una opción válida.");
            }
        }
    }

    public int mostrarMenu() {
        String menu = "Seleccione una opción:\n" +
                "1. Registrar país\n" +
                "2. Registrar ciudad\n" +
                "3. Consultar ciudades por país\n" +
                "4. Consultar ciudad\n" +
                "5. Salir";

        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    public void registrarPais() {
        String pais = JOptionPane.showInputDialog("Ingrese el nombre del país:");

        if (!ciudadesPorPais.containsKey(pais)) {
            ciudadesPorPais.put(pais, new ArrayList<>());
            JOptionPane.showMessageDialog(null, "País registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El país ya está registrado.");
        }
    }

    public void registrarCiudad() {
        if (ciudadesPorPais.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha registrado ningún país. Registre un país primero.");
            return;
        }

        String pais = JOptionPane.showInputDialog("Ingrese el nombre del país:");
        String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad:");

        if (ciudadesPorPais.containsKey(pais)) {
            ArrayList<String> ciudades = ciudadesPorPais.get(pais);
            ciudades.add(ciudad);
            JOptionPane.showMessageDialog(null, "Ciudad registrada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El país no está registrado. Registre el país primero.");
        }
    }

    public void consultarCiudadesPorPais() {
        if (ciudadesPorPais.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha registrado ningún país. Registre un país primero.");
            return;
        }

        String pais = JOptionPane.showInputDialog("Ingrese el nombre del país:");

        if (ciudadesPorPais.containsKey(pais)) {
            ArrayList<String> ciudades = ciudadesPorPais.get(pais);
            String resultado = "Ciudades de " + pais + ":\n";

            for (String ciudad : ciudades) {
                resultado += "- " + ciudad + "\n";
            }

            JOptionPane.showMessageDialog(null, resultado);
        } else {
            JOptionPane.showMessageDialog(null, "El país no está registrado.");
        }
    }

    public void consultarCiudad() {
        if (ciudadesPorPais.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha registrado ningún país. Registre un país primero.");
            return;
        }

        String ciudadBuscada = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad que desea consultar:");

        String resultado = "Información de la ciudad:\n";

        for (String pais : ciudadesPorPais.keySet()) {
            ArrayList<String> ciudades = ciudadesPorPais.get(pais);
            if (ciudades.contains(ciudadBuscada)) {
                resultado += "- Ciudad: " + ciudadBuscada + "\n";
                resultado += "- País: " + pais + "\n";
                JOptionPane.showMessageDialog(null, resultado);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "La ciudad no está registrada.");
    }
}