import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        

        // Clase scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al juego del ahorcado, Adivina la palabra secreta!!");

        //Declaraciones de asignaciones
        String palabraSecreta = "murcielago";
        int intentosMax = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;
        
        //arreglos
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        //estructura de control iterativa (bucle)
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_'; 
        }

        while (!palabraAdivinada && intentos < intentosMax) {
            
            //esto se usa cuando tenemos una palabra de chart
            System.out.println("Palabra a adivinar: "+String.valueOf(letrasAdivinadas)+" "+palabraSecreta.length()+" letras");
            System.out.println("Ingresa Letra: ");

            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {

                //estructura de control condicional
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }
            if (!letraCorrecta) {
                intentos++;
                System.out.println("!Incorrecto¡ te quedan: "+ (intentosMax - intentos) + " intentos.");
            }

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades has adivinado la palabra secreta "+palabraSecreta.toUpperCase());
            }
        }

        if (!palabraAdivinada) {
            System.out.println("Que pena te quedaste sin intentos, GAME OVER");
        }

        scanner.close();

    }
}
