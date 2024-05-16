import java.util.Random;
import java.util.Scanner;

public class practicasJava {

    static Scanner teclado = new Scanner(System.in); //Sirve para recoger texto por consola
    static int seleccionUsuario = -1; //opción elegida del usuario
	static boolean retornar; //Variable para regresar al menu principal
	//Variables de convertidorDeTemperaturas();
	static int celcius;
	static float farenheit;
	//variables de numeroSecreto();
	static int numeroRandom = 0;
	static int intentos = 0;
	static String respuesta = "";
    public static void main(String[] args) {
       
        //Mientras la opción elegida sea 0, preguntamos al usuario
		while(seleccionUsuario != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
                System.out.println("Bienvenido al repertorio de programas de prueba, seleccione el que quiera probar\n");
				System.out.println("Elige opción:\n" +
                        "1.- Conversor de Temperaturas Farenheit-Celcius\n" +
						"2.- Adivina el número secreto\n" +
						"3.- \n" +
						"4.- \n" +
						"0.- Salir");
				//Recoger una variable por consola
				seleccionUsuario = Integer.parseInt(teclado.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(seleccionUsuario){
				case 1: 
					convertidorDeTemperaturas();
				case 2: 
					numeroSecreto();
				case 3: 
					break;
				case 4: 
					break;
				case 0: 
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
				
				System.out.println("\n"); //Mostrar un salto de línea en Java
				
			}catch(Exception e){
				System.out.println("Uoop! Error!");
			}
		}
    }//Aquí termina el main
	//Funciones de la primera opción
	static void convertidorDeTemperaturas(){
		while(!retornar){
		System.out.println("Haz elegido el convertidor de temperaturas.\n" +
		"¿Que realizara?\n" +
		"1.- Convertir de Farenheit a Celcius\n" +
		"2.- Convertir de Celcius a Farenheit\n" +
		"3.- Salir");

		//Recoger una variable por consola
		seleccionUsuario = Integer.parseInt(teclado.nextLine());
		//Ejemplo de switch case en Java

		switch(seleccionUsuario){
			case 1: 
				farenheitACelcius();
				break;
			case 2: 
				celciusAFarenheit();
				break;
			case 3: 
				//regresa al menu principal
				System.out.println("\nDe regreso al menú!\n");
				retornar = true;
				break;
			default:
				System.out.println("Número no reconocido");break;
			}
		}
	}
	static void farenheitACelcius(){
		System.out.println("Ingrese la temperatura Farenheit que desee convertir a Celcius\n");
		//Recoger una variable por consola
		farenheit = teclado.nextFloat();
		//Uso de casting para imprimir entero
		celcius = (int)(farenheit - 32) * 5/9;
		System.out.printf("\nLa temperatura en grados Celcius es de: %d\n", celcius);
	}
	static void celciusAFarenheit(){
		System.out.println("Ingrese la temperatura Celcius que desee convertir a Farenheit\n");
		//Recoger una variable por consola
		celcius = teclado.nextInt();
		farenheit = (celcius * 9/5) + 32;
		System.out.printf("\nLa temperatura en grados Farenheit es de: %.2f\n", farenheit);
	}
	//Funciones número secreto
	static void numeroSecreto(){
			System.out.println("Estoy pensando en un número\n");	
			System.out.println("Ingrese un número del 0 al 100 para ver si lo adivinas\n");
			//Asigna el número secreto
			numeroRandom = new Random().nextInt(100);
			//System.out.println(numeroRandom);
		while (!retornar) {

			//Recoger una variable por consola
			seleccionUsuario = Integer.parseInt(teclado.nextLine()); 

			if (seleccionUsuario == numeroRandom) {
				System.out.printf("¡Exacto! ¡El número secreto que estaba pensando era %d y solo te llevo %d intentos!", seleccionUsuario, intentos);
				System.out.println("\n¿Quieres intentarlo otra vez?\n"+
				"S = Si N = No\n");
				respuesta = teclado.nextLine();
				//Si la respuesta es "s" o "S" empezara otra vez
				if (respuesta.equalsIgnoreCase("s")) {
					numeroSecreto();
				} else {
					//Si no regresa al menú principal
					break;
				}
			} else {
				if (seleccionUsuario > numeroRandom) {
					System.out.println("El número que estoy pensando es menor\n"+
										"Intentalo otra vez\n");
				} else {
					System.out.println("El número que estoy pensando es mayor\n"+
										"Intentalo otra vez\n");
				}
				intentos++; //Conteo de los intentos
			}

		}
	}
}

