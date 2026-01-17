public class Screen {
    static final int SCREEN_WIDTH = 200;
    static final int SCREEN_HEIGHT = 20;

    public static void main(String[] args) {
        clearScreen();
        liniaVertical(0,70,20);

        int colJugador1 = 40;

        //Juagador 1
        printGraphics(Graphics.ogre, 0, 5);
        print("Nom: Nom", 5, colJugador1);
        print("Vida: 50", 6, colJugador1);
        print("Atac: 20", 7, colJugador1);
        print("Defensa: 10", 8, colJugador1);

        int colJugador2 = 110;

        //Jugador 2
        printGraphics(Graphics.demon, 0, 80);
        print("Nom: Nom", 5, colJugador2);
        print("Vida: 50", 6, colJugador2);
        print("Atac: 20", 7, colJugador2);
        print("Defensa: 10", 8, colJugador2);

        show();
    }

    static String[][] pixels = new String[SCREEN_HEIGHT][SCREEN_WIDTH];

    static void printGraphics(String graph, int fila, int col){
        String[] lineas = graph.split("\n");
        for (int i = 0; i < lineas.length; i++) {
            print(lineas[i], fila, col);
            fila++;
        }
    }

    static void liniaVertical(int fila, int col, int longitut){
        for (int i = 0; i < longitut; i++) {
            print("|", fila, col);
            fila++;
        }
    }

    static void clearScreen(){
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
               pixels[i][j] = " ";
            }
        }
    }

    static void  print(String str, int fila, int col){
        for (int i = 0; i < str.length(); i++) {
            pixels[fila][col] = "" + str.charAt(i);
            col++;
        }
    }

    static void show(){
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                System.out.print(pixels[i][j]);
            }
            System.out.println();
        }
    }
}
