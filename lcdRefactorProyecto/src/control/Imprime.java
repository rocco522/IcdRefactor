package control;

public class Imprime {
	
	public static final String HORIZONTAL = "-";
	public static final String VERTICAL = "|";
	
	private String entrada;
	private int espacioEntreDigitos;
	
	/**
	 * La clase Imprime se encarga esencialmente de crear los n�meros e imprimirlos.
	 * @param textoImprimir
	 * @param espacioEntreDigitos
	 */
	public Imprime(String textoImprimir, int espacioEntreDigitos) {
		this.entrada = textoImprimir;
		this.espacioEntreDigitos = espacioEntreDigitos;

		procesarDatos();
	}

	/**
	 * Recibe los datos de entrada.
	 */
	public void procesarDatos(){
		String[] caso1 = entrada.split(" ");

		for(int i=0; i<caso1.length; i++){
			String[] caso2 = caso1[i].split(",");

			crearMatrizValores( Integer.parseInt(caso2[0]), caso2[1]);
		}

	}

	/**
	 * Crea una matriz de valores para guardar los datos que se imprimen en consola
	 * @param tamanioImpresion
	 * @param numerosImprimir
	 */
	private void crearMatrizValores(int tamanioImpresion, String numerosImprimir) {

		int columnas = tamanioImpresion+2;
		int filas = (tamanioImpresion*2) + 3;
		int cantidadValoresImprimir = numerosImprimir.length();
		int columnasTotal = ( columnas * cantidadValoresImprimir ) + ( columnas * espacioEntreDigitos );

		String matrizValores[][] = new String[filas][columnasTotal];

		//Llena la matriz de espacios en cada posici�n
		for(int i=0; i<filas; i++ ){
			for(int j=0; j<columnasTotal; j++){
				matrizValores[i][j] = " ";
			}
		}
		
		// Ingresa los datos de cada n�mero para imprimirlos en consola
		//2,12345 3,67890 5,23 10,2 0,0
		for(int i = 0; i < cantidadValoresImprimir ; i++ ){
			int valor = Integer.parseInt(numerosImprimir.charAt(i)+"");
			int posInicialY = ( i*columnas ) + ( i*espacioEntreDigitos );
			
			//invoca el m�todo dibujar n�mero que se encarga de insertar en la matriz los datos a imprimir 
			dibujarNumero(valor, matrizValores, filas, columnas, posInicialY);
		}

		// Imprime la matriz en la consola
		for(int i=0; i<filas; i++ ){
			for(int j=0; j<columnasTotal; j++){
				System.out.print(matrizValores[i][j]);
			}
			System.out.println();
		}

	}
	
	/**
	 * Invoca el m�todo necesario para dibujar un n�mero espec�fico.
	 * @param numero 
	 * @param matrizValores
	 * @param filas
	 * @param columnas
	 * @param posInicialY
	 */
	private void dibujarNumero(int numero, String[][] matrizValores, int filas, int columnas, int posInicialY){
		
		switch (numero) {
		case 0:
			//Dibujar el n�mero 0
			formatoCero(matrizValores, filas, columnas, posInicialY);
			break;
		case 1:
			//Dibujar el n�mero 1
			formatoUno(matrizValores, filas, columnas, posInicialY);
			break;
		case 2:
			//Dibujar el n�mero 2
			formatoDos(matrizValores, filas, columnas, posInicialY);
			break;
		case 3: 
			//Dibujar el n�mero 3
			formatoTres(matrizValores, filas, columnas, posInicialY);
			break;
		case 4:
			//Dibujar el n�mero 4
			formatoCuatro(matrizValores, filas, columnas, posInicialY);
			break;
		case 5: 
			//Dibujar el n�mero 5
			formatoCinco(matrizValores, filas, columnas, posInicialY);
			break;
		case 6:
			//Dibujar el n�mero 6
			formatoSeis(matrizValores, filas, columnas, posInicialY);
			break;
		case 7: 
			//Dibujar el n�mero 7
			formatoSiete(matrizValores, filas, columnas, posInicialY);
			break;
		case 8: 
			//Dibujar el n�mero 8
			formatoOcho(matrizValores, filas, columnas, posInicialY);
			break;
		case 9:
			//Dibujar el n�mero 9
			formatoNueve(matrizValores, filas, columnas, posInicialY);
			break;
			
		default:
			break;
		}
		
	}
	
	/**
	 * Inserta los s�mbolos para imprimir el n�mero 0 en la matriz de valores
	 * @param matrizValores Matriz de m*n que ser� impresa en consola
	 * @param filas n�mero de filas de la matriz
	 * @param columnas n�mero de columnas
	 * @param posInicialY Posici�n Y donde deba iniciar un n�mero.
	 */
	public void formatoCero(String[][] matrizValores, int filas, int columnas, int posInicialY ) {
		
		int mitadX = filas/2;
		
		int i = 0;
		int j = posInicialY+1;
		
		//Dibuja las l�neas horizontales de arriba
		while( j < posInicialY + ( columnas-1 ) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i = filas-1;
		j = posInicialY+1;
		
		//Dibuja las l�neas horizontales de abajo
		while( j < posInicialY + ( columnas-1 ) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=1;
		j = posInicialY;
		
		//Dibuja las l�neas verticales de la izquierda
		while( i < filas-1 ){
			if(i != mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}

		i=1;
		j = posInicialY + ( columnas-1 );
		
		//Dibuja las l�neas verticales de la derecha
		while( i < filas-1 ){
			if(i != mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}
	}
	
	/**
	 * Inserta los s�mbolos para imprimir el n�mero 1 en la matriz de valores
	 * @param matrizValores Matriz de m*n que ser� impresa en consola
	 * @param filas n�mero de filas de la matriz
	 * @param columnas n�mero de columnas
	 * @param posInicialY Posici�n Y donde deba iniciar un n�mero.
	 * */
	public void formatoUno(String[][] matrizValores, int filas, int columnas, int posInicialY ) {

		int mitadX = filas/2;

		int i=1;
		int j = posInicialY + ( columnas-1 );
		while( i < filas-1 ){
			if(i != mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}
	}
	
	/**
	 * Inserta los s�mbolos para imprimir el n�mero 2 en la matriz de valores
	 * @param matrizValores Matriz de m*n que ser� impresa en consola
	 * @param filas n�mero de filas de la matriz
	 * @param columnas n�mero de columnas
	 * @param posInicialY Posici�n Y donde deba iniciar un n�mero.
	 */
	public void formatoDos(String[][] matrizValores, int filas, int columnas, int posInicialY ) {

		int mitadX = filas/2;

		int i = 0;
		int j = posInicialY + 1;
		while( j < posInicialY + ( columnas-1 ) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=mitadX;
		j = posInicialY + 1;
		while( j < posInicialY + ( columnas-1 ) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=filas-1;
		j = posInicialY + 1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=1;
		j = posInicialY;
		while( i < filas-1 ){
			if(i > mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}

		i=1;
		j = posInicialY + (columnas - 1);
		while( i < filas-1 ){
			if(i < mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}
	}

	/**
	 * Inserta los s�mbolos para imprimir el n�mero 3 en la matriz de valores
	 * @param matrizValores Matriz de m*n que ser� impresa en consola
	 * @param filas n�mero de filas de la matriz
	 * @param columnas n�mero de columnas
	 * @param posInicialY Posici�n Y donde deba iniciar un n�mero.
	 */
	public void formatoTres(String[][] matrizValores, int filas, int columnas, int posInicialY ) {

		int mitadX = filas/2;

		int i = 0;
		int j = posInicialY + 1;

		while( j < posInicialY + (columnas - 1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;

		}

		i=mitadX;
		j = posInicialY+1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=filas-1;
		j = posInicialY+1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=1;
		j = posInicialY + (columnas - 1);
		while( i < filas-1 ){
			if(i != mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}
	}

	/**
	 * Inserta los s�mbolos para imprimir el n�mero 4 en la matriz de valores
	 * @param matrizValores Matriz de m*n que ser� impresa en consola
	 * @param filas n�mero de filas de la matriz
	 * @param columnas n�mero de columnas
	 * @param posInicialY Posici�n Y donde deba iniciar un n�mero.
	 */
	public void formatoCuatro(String[][] matrizValores, int filas, int columnas, int posInicialY ) {

		int mitadX = filas/2;
		
		int i = mitadX;
		int j = posInicialY + 1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=1;
		j = posInicialY;
		while( i < filas-1 ){
			if(i < mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}

		i=1;
		j = posInicialY + (columnas - 1);
		while( i < filas-1 ){
			if(i != mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}
	}
	
	/**
	 * Inserta los s�mbolos para imprimir el n�mero 5 en la matriz de valores
	 * @param matrizValores Matriz de m*n que ser� impresa en consola
	 * @param filas n�mero de filas de la matriz
	 * @param columnas n�mero de columnas
	 * @param posInicialY Posici�n Y donde deba iniciar un n�mero.
	 */
	public void formatoCinco(String[][] matrizValores, int filas, int columnas, int posInicialY ) {

		int mitadX = filas/2;

		int i = 0;
		int j = posInicialY+1;
		while( j < posInicialY + (columnas - 1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=mitadX;
		j = posInicialY+1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=filas-1;
		j = posInicialY+1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=1;
		j = posInicialY;
		while( i < filas-1 ){
			if(i < mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}

		i=1;
		j = posInicialY + (columnas-1);
		while( i < filas-1 ){
			if(i > mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}
	}

	/**
	 * Inserta los s�mbolos para imprimir el n�mero 6 en la matriz de valores
	 * @param matrizValores Matriz de m*n que ser� impresa en consola
	 * @param filas n�mero de filas de la matriz
	 * @param columnas n�mero de columnas
	 * @param posInicialY Posici�n Y donde deba iniciar un n�mero.
	 */
	public void formatoSeis(String[][] matrizValores, int filas, int columnas, int posInicialY ) {

		int mitadX = filas/2;

		int i = 0;
		int j = posInicialY + 1;

		while( j < posInicialY + (columnas - 1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=mitadX;
		j = posInicialY+1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=filas-1;
		j = posInicialY+1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=1;
		j = posInicialY;
		while( i < filas-1 ){
			if(i != mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}

		i=1;
		j = posInicialY + (columnas - 1);
		while( i < filas-1 ){
			if(i > mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}
	}

	/**
	 * Inserta los s�mbolos para imprimir el n�mero 7 en la matriz de valores
	 * @param matrizValores Matriz de m*n que ser� impresa en consola
	 * @param filas n�mero de filas de la matriz
	 * @param columnas n�mero de columnas
	 * @param posInicialY Posici�n Y donde deba iniciar un n�mero.
	 */
	public void formatoSiete(String[][] matrizValores, int filas, int columnas, int posInicialY ) {

		int mitadX = filas/2;

		int i = 0;
		int j = posInicialY + 1;
		while( j < posInicialY + (columnas - 1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=1;
		j = posInicialY + (columnas - 1);
		while( i < filas-1 ){
			if(i != mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}
	}
	
	/**
	 * Inserta los s�mbolos para imprimir el n�mero 8 en la matriz de valores
	 * @param matrizValores Matriz de m*n que ser� impresa en consola
	 * @param filas n�mero de filas de la matriz
	 * @param columnas n�mero de columnas
	 * @param posInicialY Posici�n Y donde deba iniciar un n�mero.
	 */
	public void formatoOcho(String[][] matrizValores, int filas, int columnas, int posInicialY ) {

		int mitadX = filas/2;

		int i = 0;
		int j = posInicialY + 1;

		while( j < posInicialY + (columnas - 1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=mitadX;
		j = posInicialY+1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=filas-1;
		j = posInicialY+1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=1;
		j = posInicialY;
		while( i < filas-1 ){
			if(i != mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}

		i=1;
		j = posInicialY + (columnas - 1);
		while( i < filas-1 ){
			if(i != mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}
	}

	/**
	 * Inserta los s�mbolos para imprimir el n�mero 9 en la matriz de valores
	 * @param matrizValores Matriz de m*n que ser� impresa en consola
	 * @param filas n�mero de filas de la matriz
	 * @param columnas n�mero de columnas
	 * @param posInicialY Posici�n Y donde deba iniciar un n�mero.
	 */
	public void formatoNueve(String[][] matrizValores, int filas, int columnas, int posInicialY ) {

		int mitadX = filas/2;

		int i = 0;
		int j = posInicialY + 1;

		while( j < posInicialY + (columnas - 1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;

		}

		i=mitadX;
		j = posInicialY+1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=filas-1;
		j = posInicialY+1;
		while( j < posInicialY + ( columnas-1) ){
			matrizValores[i][j] = HORIZONTAL;
			j++;
		}

		i=1;
		j = posInicialY;
		while( i < filas-1 ){
			if(i < mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}

		i=1;
		j = posInicialY + (columnas - 1);
		while( i < filas-1 ){
			if(i != mitadX)
				matrizValores[i][j] = VERTICAL;
			i++;
		}
	}
}
