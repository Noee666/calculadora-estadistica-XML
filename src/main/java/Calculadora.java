import java.util.Collections;
import java.util.List;

public class Calculadora {



    public static double calcularMedia(List<Double> datos) {
        double suma = 0;
        for (double num : datos) {
            suma += num;
        }
        return suma / datos.size();
    }



    public static double calcularVarianza(List<Double> datos, double media) {
        double sumaDiferenciasCuadradas = 0;
        for (double num : datos) {
            sumaDiferenciasCuadradas += Math.pow(num - media, 2);
        }
        // Usamos datos.size() para varianza poblacional. 
        // Si fuera muestral sería datos.size() - 1
        return sumaDiferenciasCuadradas / datos.size();
    }



    public static double calcularDesviacionEstandar(double varianza) {
        return Math.sqrt(varianza);
    }



    public static double calcularMaximo(List<Double> datos) {
        return Collections.max(datos); // Uso del Java Collections API
    }



    public static double calcularMinimo(List<Double> datos) {
        return Collections.min(datos); // Uso del Java Collections API
    }



    public static double calcularCorrelacion(List<Double> x, List<Double> y) {
        if (x.size() != y.size()) {
            throw new IllegalArgumentException("Para calcular la correlación, ambas variables deben tener la misma cantidad de datos.");
        }

        double mediaX = calcularMedia(x);
        double mediaY = calcularMedia(y);

        double covarianza = 0;
        double varianzaX = 0;
        double varianzaY = 0;

        for (int i = 0; i < x.size(); i++) {
            double difX = x.get(i) - mediaX;
            double difY = y.get(i) - mediaY;

            covarianza += difX * difY;
            varianzaX += Math.pow(difX, 2);
            varianzaY += Math.pow(difY, 2);
        }

        return covarianza / Math.sqrt(varianzaX * varianzaY);
    }
}