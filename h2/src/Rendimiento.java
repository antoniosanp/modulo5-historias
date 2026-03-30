public class Rendimiento {

    public int cantidadCoders;
    public double[][] matrizRendimiento;

    public Rendimiento(int cantidadCoders){
        this.cantidadCoders = cantidadCoders;
        this.matrizRendimiento = new double[cantidadCoders][3];
        
    }

    public void agregarNotas(int indice, double nota1, double nota2, double nota3){
        if (indice >= this.cantidadCoders){return;}

        this.matrizRendimiento[indice] = new double[]{nota1,nota2,nota3};
        return;
    }

    public double calcularPromedio(int indice){
        double promedio = 0;
        if (indice >= this.cantidadCoders){return -1;}

        for (double nota : this.matrizRendimiento[indice]){
            promedio += nota;
        }
        promedio /= 3;

        return promedio;
    }

    public int promedioSimple(int indice){
        int promedio = 0;
        if (indice >= this.cantidadCoders) {return -1;}

        promedio = (int) this.calcularPromedio(indice);

        return promedio;
    }

    public void imprimirNotas(){
        
    }
}
