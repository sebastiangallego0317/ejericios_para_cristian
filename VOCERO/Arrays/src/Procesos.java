import javax.swing.JOptionPane;

public class Procesos {
    private String[] nombres;
    private double[] imc;
    private double peso, talla;

    public Procesos() {
        int cantidadPersonas = obtenerCantidadPersonas();
        nombres = new String[cantidadPersonas];
        imc = new double[cantidadPersonas];
        iniciar();
    }

    private int obtenerCantidadPersonas() {
        String input = JOptionPane.showInputDialog("Ingrese la cantidad de personas que desea evaluar");
        return Integer.parseInt(input);
    }

    private void iniciar() {
        llenarDatos();
        calcularIMC();
        mostrarResultados();
    }

    private void llenarDatos() {
        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = JOptionPane.showInputDialog("Ingrese el nombre de la persona " + i);
            peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de " + nombres[i]));
            talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla de " + nombres[i]));
        }
    }

    private void calcularIMC() {
        for (int i = 0; i < nombres.length; i++) {
            imc[i] = peso / Math.pow(talla, 2);
        }
    }

    private void mostrarResultados() {
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("El índice de masa corporal de " + nombres[i] + " es " + imc[i] + " y se encuentra en la categoría de " + evaluar(imc[i]));
        }
    }

    private String evaluar(double imc) {
        if (imc >= 40) {
            return "Obesidad Mórbida";
        } else if (imc >= 35) {
            return "Obesidad grado 3";
        } else if (imc >= 30) {
            return "Obesidad grado 2";
        } else if (imc >= 27) {
            return "Obesidad grado 1";
        } else if (imc >= 20) {
            return "Normalidad";
        } else if (imc >= 18) {
            return "Delgadez";
        } else {
            return "Anorexia";
        }
    }
}
