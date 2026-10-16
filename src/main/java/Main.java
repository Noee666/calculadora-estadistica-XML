import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Error: No se proporcionaron argumentos validos\n"
                             + "Ej Uso: java Estadísticas archivo.xml variable1 [variable2]");
            System.exit(1);
        }

        Path ruta = Path.of(args[0]);
        String xmlTagName1 = args[1];
        String xmlTagName2 = (args.length == 3) ? args[2] : null;

        try {
            List<Double> elementosTagName1 = LectorXML.extraerElemento(ruta, xmlTagName1);
            System.out.println("\n------- Estadísticas de elementos en " + xmlTagName1 + " ------");
            imprimirEstadisticas(elementosTagName1);


            if (xmlTagName2 != null) {
                List<Double> elementosTagName2 = LectorXML.extraerElemento(ruta, xmlTagName2);
                System.out.println("\n------- Estadísticas de elementos en " + xmlTagName2 + " ------");
                imprimirEstadisticas(elementosTagName2);


                System.out.println("--- Análisis ---");
                double correlacion = Calculadora.calcularCorrelacion(elementosTagName1, elementosTagName2);
                System.out.printf("Coeficiente de Correlación: %.4f\n", correlacion);
            }

        } catch (Exception e) {
            System.err.println("\n[ERROR] " + e.getMessage());
        }
    }


    private static void imprimirEstadisticas(List<Double> datos) {
        double media = Calculadora.calcularMedia(datos);
        double varianza = Calculadora.calcularVarianza(datos, media);
        double devEstandar = Calculadora.calcularDesviacionEstandar(varianza);
        double max = Calculadora.calcularMaximo(datos);
        double min = Calculadora.calcularMinimo(datos);

        System.out.println("Muestra de datos (n): " + datos.size());
        System.out.printf("Media: %.4f\n", media);
        System.out.printf("Varianza: %.4f\n", varianza);
        System.out.printf("Desviación Estándar: %.4f\n", devEstandar);
        System.out.printf("Valor Máximo: %.4f\n", max);
        System.out.printf("Valor Mínimo: %.4f\n\n", min);
    }
}
