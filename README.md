# Calculadora Estadística XML

Una aplicación de línea de comandos en Java diseñada para leer variables numéricas desde un archivo XML y calcular sus principales métricas estadísticas.

## Características

* **Análisis Univariado:** Calcula la media, varianza, desviación estándar, valor máximo y valor mínimo de una variable dada.

* **Análisis Bivariado:** Si se proporcionan dos variables, calcula todas las estadísticas anteriores para cada una y determina el **coeficiente de correlación** entre ambas.

* **Procesamiento de XML:** Utiliza el API DOM de Java para la extracción segura de datos estructurados.

* **Manejo de Excepciones:** Validación rigurosa de archivos, estructura del XML y tipos de datos numéricos.

## Estructura del Proyecto

El proyecto está dividido en tres componentes principales siguiendo principios de responsabilidad única:

* `Main.java`: Punto de entrada y manejo de argumentos.

* `LectorXML.java`: Lógica de validación, lectura y extracción de nodos XML.

* `Calculadora.java`: Lógica matemática para las operaciones estadísticas.

## Instalación y Uso

### Prerrequisitos

* Java Development Kit (JDK) instalado.

### Compilación

En la terminal

```
javac src/main/java/*.java
```

### Ejecución

La aplicación recibe como argumentos la ruta del archivo XML, el nombre de la primera variable, y opcionalmente, el nombre de la segunda variable.

**Sintaxis:**

```
java -cp src/main/java Main <ruta_del_archivo.xml> <variable1> [variable2]
```

**Ejemplo de uso con una variable:**

```
java -cp src/main/java Main src/main/resources/datos.xml peso
```

**Ejemplo de uso con dos variables (correlación):**

```
java -cp src/main/java Main src/main/resources/datos.xml peso altura
```