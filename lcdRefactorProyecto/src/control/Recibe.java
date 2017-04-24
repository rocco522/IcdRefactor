package control;

import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.ranges.RangeException;

import excepciones.FormatoInvalidoException;
import excepciones.RangoInvalidoException;

public class Recibe {

	private static final String FIN = "0,0";
	private static ImpresorLCD impresorLCD;
	private static Imprime imprimir;

	public static void main(String[] args) {

		String entrada = "";
		String textoImprimir = "";
		int espacioEntreDigitos;

		Scanner lector = new Scanner(System.in);

		System.out.print("Espacio entre Digitos (0 a 5): "); 
		entrada = lector.nextLine();

		try {
			if( isNumeric(entrada) ){
				espacioEntreDigitos = Integer.parseInt(entrada);

				// se valida que el espaciado este entre 0 y 5
				validarRango(espacioEntreDigitos);
				
				// Variable booleana para salir del while
				boolean salir = false;

				// Ciclo que guarda las entradas digitadas en consola
				while( !salir ){
					
					System.out.print("Entrada: ");
					entrada = lector.nextLine();

					//Finaliza el ciclo, si se escribe la cadena de fin.
					if( entrada.equals(FIN) ){
						salir = true;
					}
				
					else if( entrada.contains(" ") ){
						
						String[] temp = entrada.split(" ");
						
						for(int i=0; i<temp.length-1; i++){
							validarFormato(temp[i]);
							textoImprimir += temp[i]+" ";
							salir = true;
						}
						
						textoImprimir = textoImprimir.substring(0, textoImprimir.length()-1);
						temp = null;
					}
					else{
						validarFormato(entrada);
						textoImprimir += entrada + " ";
					}
				}

				imprimir = new Imprime(textoImprimir, espacioEntreDigitos);
				System.out.println(textoImprimir);
			}
			else{
				throw new IllegalArgumentException("Cadena " + "\""+entrada + "\""
						+ " no es un entero");
			}
		} catch (RangoInvalidoException | FormatoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que valida que la cadena ingresada en consola tenga el formato adecuado.
	 * @param entrada cadena escrita en consola
	 * @throws FormatoInvalidoException
	 */
	private static void validarFormato(String entrada) throws FormatoInvalidoException {
		
		String[] textoValidar = entrada.split(",");
		
		boolean comaEncontrada = false;

		if( entrada.contains(",") && entrada.contains(" ")){
			
			for( int i=0; i<textoValidar.length; i++ ){
				
				if( !isNumeric(textoValidar[i]) ){
					
					if(!textoValidar[i].equals(",") && !comaEncontrada){
						throw new FormatoInvalidoException("La entrada no es válida");
					}
					comaEncontrada = true;
				}
			}
		}

		else if( entrada.contains(",") && !entrada.contains(" ")){
			
			for( int i=0; i<textoValidar.length; i++ ){
				
				if( !isNumeric(textoValidar[i]) ){
					
					if(!textoValidar[i].equals(",") && !comaEncontrada){
						throw new FormatoInvalidoException("La entrada no es válida");
					}
					comaEncontrada = true;
				}
			}
		}

		else{
			throw new FormatoInvalidoException("La entrada no es válida");
		}

	}

	/**
	 * Método que valida que un número se encuentre en el rango requerido
	 * @param valor
	 * @throws RangoInvalidoException
	 */
	private static void validarRango(int valor) throws RangoInvalidoException {

		if( (valor < 0) || (valor > 5) ){
			throw new RangoInvalidoException("El número debe estar entre 0 y 5. ");
		}

	}

	/**
	 *
	 * Metodo encargado de validar si una cadena es numerica
	 *
	 * @param cadena Cadena
	 */  
	static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}
