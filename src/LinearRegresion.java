public class LinearRegresion {
	
	//Data Set
	static double[] anio = new double[] {1,2,3,4,5,6,7,8,9};
    static double[] sales = new double[] {651,762,856,1063,1190,1298,1421,1440,1518};
    
    public double beta1;
	public double beta2;
	
	//Contructor con parametros
	public LinearRegresion(double _val1, double _val2){
		this.beta1 = _val1;
		this.beta2 = _val2;
	}
	//Constructor
	public LinearRegresion(){

	}
	//Getters & Setters
	public double getBeta2() {
		return beta2;
	}
	public void setBeta2(double _val2) {
		this.beta2 = _val2;
	}
	public double getBeta1() {
		return beta1;
	}
	public void setBeta1(double _val1) {
		this.beta1 = _val1;
	}
	
	//Metodo que obtiene las sumatorias de beta 0 y beta 1
	public void operacion(double sum_X,double sum_Y,double sum_XY,double sum_X2, int n, double x) {
		
		double prediccion = 0;
		//operaciones para obeter
		beta1= ( n * sum_XY - sum_X * sum_Y) / ( n * sum_X2 - sum_X * sum_X );
		beta2= ( sum_Y * sum_X2 - sum_X * sum_XY ) / ( n * sum_X2 - sum_X * sum_X );
		//Imprime y de hat
		System.out.println("y= "+beta2+" + "+beta1+"x");
		//Imprimer predicción
		prediccion= beta2 + beta1 * x;
		System.out.println("\nPrediccion en ventas: " + prediccion);
	}

	public static void main(String[] args) {
		
		//Obtenes entrada del cmd y parseamos a double
		double x2 = Double.parseDouble(args[0]);
		int tamano;
		
		//declaración de variables
		double sumatoria_x=0,sumatoria_y=0,sumatoria_xy=0,sumatoria_x2=0;
		
		tamano=anio.length;
		
		//Sumamos los valores de cada elemento de la tabla de valores
		for(int i=0; i < tamano; i++) {
			sumatoria_x  = sumatoria_x + anio[i];
			sumatoria_y  = sumatoria_y + sales[i];
			sumatoria_xy = sumatoria_xy + anio[i]* sales[i];
			sumatoria_x2 = sumatoria_x2 + anio[i]* anio[i];
		}

		LinearRegresion lr = new LinearRegresion();
		//hacemos la operaión
		lr.operacion(sumatoria_x, sumatoria_y, sumatoria_xy, sumatoria_x2, tamano, x2);	
	}
}
