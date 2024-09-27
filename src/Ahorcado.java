import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        //scanner es una entrada
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        Boolean palabraAdivinada = false;

        //arreglos;
        char[] letrasAdivinadas = new char[palabraSecreta.length()];


        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }
        
        while (!palabraAdivinada && intentos < intentosMaximos) {
            
            System.out.println("Palabra a adivinar:" + String.valueOf(letrasAdivinadas) + "("+ letrasAdivinadas.length +"letras)");

            System.out.println("introduce una letra, por favor.");

            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }
            if(!letraCorrecta){
                intentos++;
                System.out.println("letra incorrecta pierde un intento! "+  (intentosMaximos-intentos) + "Intentos");
            }
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                System.out.println("Palabra Descubierta!");
            }

        }

        if(!palabraAdivinada){
            System.out.println("No tienes mas intentos, Game Over!");
        }

        scanner.close();

    }
}
