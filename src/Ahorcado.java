import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        //scanner es una entrada
        Scanner scanner = new Scanner(System.in);
        int intentosMaximos = 10;
        int intentos = 0;
        Boolean palabraAdivinada = false;
        int opcion_menu = 0;
        //arreglos;

        final String RESET = "\033[0m"; // Restablece el color
        final String RED = "\033[0;31m";
        final String GREEN = "\033[0;32m";
        final String YELLOW = "\033[0;33m";
        final String BLUE = "\033[0;34m";

        System.out.println(RED + "********************************" + RESET);
        System.out.println(GREEN + "*     EL AHORCADO THE GAME    *" + RESET);
        System.out.println(BLUE + "********************************" + RESET);

        System.out.print("Cargando");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);  // Pausa de medio segundo
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("");
        while (opcion_menu == 0) {
            System.out.println(YELLOW+"**********************"+ RESET);
            System.out.println("* 1. Nueva partida    *");
            System.out.println("* 2. Cargar partida   *");
            System.out.println("* 3. Salir            *");
            System.out.println(YELLOW+"**********************"+ RESET);
            System.out.print("Elige una opción: ");
            opcion_menu = scanner.nextInt();  
        }

        if(opcion_menu > 0){
            System.out.println("Escribe una palabra secreta: ");
            String palabraSecreta = scanner.next().toLowerCase();
            char[] letrasAdivinadas = new char[palabraSecreta.length()];
    
            for (int i = 0; i < letrasAdivinadas.length; i++) {
                letrasAdivinadas[i] = '_';
            }
            
            while (!palabraAdivinada && intentos < intentosMaximos) {
                
                if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                    System.out.println(YELLOW+"**********************"+ RESET);
                    System.out.println(GREEN+"   "+String.valueOf(letrasAdivinadas)+RESET);
                    System.out.println(" ");
                    System.out.println(GREEN+"Palabra Descubierta!");
                    System.out.println(YELLOW+"**********************"+ RESET);
                    palabraAdivinada = true;
                }else{
                    System.out.println(YELLOW+"**********************"+ RESET);
                    System.out.println(YELLOW+"Palabra a adivinar:");
                    System.out.println("   "+String.valueOf(letrasAdivinadas)+RESET);
                    System.out.println("("+ letrasAdivinadas.length +" letras)");
                    System.out.println(intentos+" / "+intentosMaximos);
                    System.out.println(" ");
                    System.out.println(YELLOW+"**********************"+ RESET);
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
                        System.out.println( RED+"letra incorrecta pierde un intento! "+  (intentosMaximos-intentos) + " Intentos"+ RESET);
                    }
                }
            }
    
            if(!palabraAdivinada){
                System.out.println("No tienes mas intentos, Game Over!");
            }
        }
        scanner.close();

    }
}
