import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Procesos {
    private ArrayList<String> personas;
    
    public Procesos() {
        personas = new ArrayList<>();
        iniciar();
        mostrarDatos();
    }
    
    public void iniciar() {
        boolean continuar = true;
        
        while (continuar) {
          
            String nombre = JOptionPane.showInputDialog("Ingrese nombre:");
            String telefono = JOptionPane.showInputDialog("Ingrese teléfono:");
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese peso en kilogramos:"));
            double talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese talla en metros:"));

            double imc = calcularIMC(peso, talla);
            
            String categoria = evaluarCategoria(imc);
            
            personas.add("Nombre: " + nombre + ", Teléfono: " + telefono + ", Categoría del IMC: " + categoria);

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar información de otra persona?", "Confirmar", JOptionPane.YES_NO_OPTION);
            continuar = (opcion == JOptionPane.YES_OPTION);
        }
    }
    
    public double calcularIMC(double peso, double talla) {
        return peso / (talla * talla);
    }
    
    public String evaluarCategoria(double imc) {
        if (imc >= 40) {
            return "Obesidad Mórbida";
        } else if (imc >= 35) {
            return "Obesidad Nivel 3";
        } else if (imc >= 30) {
            return "Obesidad Nivel 2";
        } else if (imc >= 27) {
            return "Obesidad Nivel 1";
        } else if (imc >= 20) {
            return "Normalidad";
        } else if (imc >= 18) {
            return "Delgadez";
        } else {
            return "Anorexia";
        }
    }
    
    public void mostrarDatos() {
        for (String persona : personas) {
            JOptionPane.showMessageDialog(null, persona);
        }
    }
    
}
