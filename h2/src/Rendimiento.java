public class Rendimiento {

    public int cantidadCoders;
    public double[][] matrizRendimiento; // Matriz [coders][trimestres] calificaciones

    public Rendimiento(int numeroCoders){
        this.cantidadCoders = numeroCoders;
        this.matrizRendimiento = new double[numeroCoders][3];
    }

    public void agregarNotas(int indiceCoder, double notaTrimestre1, double notaTrimestre2, double notaTrimestre3){
        if (indiceCoder >= this.cantidadCoders){return;}
        this.matrizRendimiento[indiceCoder][0] = notaTrimestre1;
        this.matrizRendimiento[indiceCoder][1] = notaTrimestre2;
        this.matrizRendimiento[indiceCoder][2] = notaTrimestre3;
    }

    public double calcularPromedio(int indiceCoder){
        // TASK 3: For anidados para recorrer matriz 2D
        double sumaNotas = 0;
        if (indiceCoder >= this.cantidadCoders){return -1;}
        for (int trimestre = 0; trimestre < 3; trimestre++) {
            sumaNotas += matrizRendimiento[indiceCoder][trimestre];
        }
        return sumaNotas / 3;
    }

    public int promedioSimple(int indiceCoder){
        // TASK 3: Casting double->int trunca precisión decimal
        if (indiceCoder >= this.cantidadCoders) {return -1;}
        return (int) calcularPromedio(indiceCoder);
    }
}
