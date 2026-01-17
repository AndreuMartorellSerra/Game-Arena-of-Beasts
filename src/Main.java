import java.util.Scanner;

public class Main {
    static final int ATAC = 1;
    static final int DEFENSA = 2;
    static final int MANIOBRA = 3;
    static final int ENGANY = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el teu nom: ");
        String nomJugador = sc.nextLine();

        // Inicialització de les stats
        Stats[] stats = new Stats[5];
        stats[Lluitador.DEMON - 1] = new Stats(34, 12, 6);
        stats[Lluitador.WIZARD - 1] = new Stats(30, 13, 9);
        stats[Lluitador.OGRE - 1] = new Stats(41, 11, 1);
        stats[Lluitador.DRAGON - 1] = new Stats(25, 14, 13);
        stats[Lluitador.HIDRA - 1] = new Stats(32, 11, 10);

        int victoriesJugador = 0;
        int victoriesBot = 0;
        int combat = 1;

        while (victoriesJugador < 2 && victoriesBot < 2) {
            System.out.println("========== COMBAT " + combat + " ==========");

            int classeJugador = triaClasseJugador();
            int classeBot = triaClasseBot();

            // Crear lluitadors amb el nom del personatge
            Lluitador jugador = newLluitador(nomJugador + " (" + nomClasse(classeJugador) + ")", stats, classeJugador);
            Lluitador bot = newLluitador("Bot (" + nomClasse(classeBot) + ")", stats, classeBot);

            int guanyador = lluita(jugador, bot);

            if (guanyador == 1) {
                victoriesJugador++;
                System.out.println("🏆 Guanya " + jugador.getNom() + " el combat!");
            } else {
                victoriesBot++;
                System.out.println("💀 Guanya " + bot.getNom() + " el combat!");
            }

            combat++;
        }

        System.out.println("=================================");
        if (victoriesJugador > victoriesBot) {
            System.out.println("🏆 GUANYADOR FINAL: " + nomJugador);
        } else {
            System.out.println("💀 GUANYADOR FINAL: BOT" );
        }
    }

    // Crea un nou lluitador amb el nom real
    static Lluitador newLluitador(String nom, Stats[] stats, int clase) {
        Stats s = stats[clase - 1];
        return new Lluitador(nom, clase, 0, s.vida, s.vida, s.atac, s.defensa);
    }

    // Funció per obtenir el nom segons la classe
    static String nomClasse(int clase) {
        switch (clase) {
            case Lluitador.WIZARD: return "Wizard";
            case Lluitador.OGRE: return "Ogre";
            case Lluitador.HIDRA: return "Hidra";
            case Lluitador.DEMON: return "Demon";
            case Lluitador.DRAGON: return "Dragon";
            default: return "Desconegut";
        }
    }

    // Tria classe jugador
    static int triaClasseJugador() {
        Scanner sc = new Scanner(System.in);
        int opcio = 0;

        do {
            System.out.println("Tria el teu lluitador:");
            System.out.println("1 - Wizard");
            System.out.println("2 - Ogre");
            System.out.println("3 - Hidra");
            System.out.println("4 - Demon");
            System.out.println("5 - Dragon");
            System.out.print("> ");

            try {
                opcio = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                opcio = 0;
            }
        } while (opcio < 1 || opcio > 5);

        return opcio;
    }

    // Tria classe bot aleatòria
    static int triaClasseBot() {
        return (int)(Math.random() * 5) + 1;
    }

    // Lluita completa entre dos lluitadors
    static int lluita(Lluitador l1, Lluitador l2) {
        while (l1.getPuntsDevida() > 0 && l2.getPuntsDevida() > 0) {
            System.out.println("\n--- TORN " + l1.torn + " ---");

            imprimeixPantalla(l1, l2);

            int estrategia1 = triaEstrategiaHuma();
            int estrategia2 = triaEstrategiaBot();

            int cares1 = tiraModenes(l1, estrategia1);
            int cares2 = tiraModenes(l2, estrategia2);

            imprimeixEstrategiaICares(l1.getNom(), estrategia1, cares1);
            imprimeixEstrategiaICares(l2.getNom(), estrategia2, cares2);

            l1.incTorn();
            l2.incTorn();

            boolean resolt = resolCombat(l1, l2, estrategia1, estrategia2, cares1, cares2);
            if (!resolt) {
                resolCombat(l2, l1, estrategia2, estrategia1, cares2, cares1);
            }

            System.out.println("---------------------------------------");
        }

        return (l1.getPuntsDevida() <= 0) ? 2 : 1;
    }

    // Mostrar pantalla amb gràfics i stats
    static void imprimeixPantalla(Lluitador l1, Lluitador l2) {
        Screen.clearScreen();
        Screen.liniaVertical(0,70,15);

        int colJugador1 = 40;
        Screen.printGraphics(Graphics.getGraphics(l1.getClase()), 0, 5);
        Screen.print("Nom: " + l1.getNom(), 5, colJugador1);
        Screen.print("Vida: " + l1.getPuntsDevida() + " / " + l1.getPuntsDeVidaMaxima(), 6, colJugador1);
        Screen.print("Atac: " + l1.getAtac(), 7, colJugador1);
        Screen.print("Defensa: " + l1.getDefensa(), 8, colJugador1);

        int colJugador2 = 110;
        Screen.printGraphics(Graphics.getGraphics(l2.getClase()), 0, 80);
        Screen.print("Nom: " + l2.getNom(), 5, colJugador2);
        Screen.print("Vida: " + l2.getPuntsDevida() + " / " + l2.getPuntsDeVidaMaxima(), 6, colJugador2);
        Screen.print("Atac: " + l2.getAtac(), 7, colJugador2);
        Screen.print("Defensa: " + l2.getDefensa(), 8, colJugador2);

        Screen.show();
    }

    // Estratègia jugador
    static int triaEstrategiaHuma() {
        Scanner scanner = new Scanner(System.in);
        String resposta;
        int estrategia = 0;

        do {
            System.out.println("Tria la estrategia: (A/D/E/M)");
            resposta = scanner.nextLine().toUpperCase();

            switch (resposta.charAt(0)) {
                case 'A': estrategia = ATAC; break;
                case 'D': estrategia = DEFENSA; break;
                case 'E': estrategia = ENGANY; break;
                case 'M': estrategia = MANIOBRA; break;
                default:
                    System.out.println("La lletra no es correcta, torna a intentar-ho");
                    continue;
            }
            break;
        } while (true);

        return estrategia;
    }

    // Estratègia bot
    static int triaEstrategiaBot() {
        int[] estrategies = {ATAC, DEFENSA, ENGANY, MANIOBRA};
        int n = (int) (Math.random() * estrategies.length);
        return estrategies[n];
    }

    // Tirada de monedes segons atac o defensa
    static int tiraModenes(Lluitador lluitador, int estrategia) {
        int quantes = (estrategia == ATAC || estrategia == ENGANY) ? lluitador.getAtac() : lluitador.getDefensa();

        int ncares = 0;
        for (int i = 0; i < quantes; i++) {
            if (Math.random() < 0.5) ncares++;
        }
        return ncares;
    }

    // Resolució del combat
    static boolean resolCombat(Lluitador l1, Lluitador l2, int estrategia1, int estrategia2, int cares1, int cares2) {
        if (estrategia1 == ATAC && estrategia2 == ATAC) {
            l1.restaPuntsDeVida(cares2);
            l2.restaPuntsDeVida(cares1);
        } else if (estrategia1 == ATAC && estrategia2 == DEFENSA) {
            int dany = Math.max(cares1 - l2.getDefensa(), 0);
            l2.restaPuntsDeVida(dany);
        } else if (estrategia1 == ATAC && estrategia2 == ENGANY) {
            l2.restaPuntsDeVida(cares1);
        } else if (estrategia1 == ATAC && estrategia2 == MANIOBRA) {
            l2.restaPuntsDeVida(cares1);
        } else if (estrategia1 == DEFENSA && estrategia2 == ATAC) {
            int dany = Math.max(cares2 - l1.getDefensa(), 0);
            l1.restaPuntsDeVida(dany);
        } else if (estrategia1 == DEFENSA && estrategia2 == DEFENSA) {
            l1.recuperaVida(cares1 / 2);
            l2.recuperaVida(cares2 / 2);
        } else if (estrategia1 == DEFENSA && estrategia2 == ENGANY) {
            l1.restaPuntsDeVida(cares2 * 2);
        } else if (estrategia1 == DEFENSA && estrategia2 == MANIOBRA) {
            l1.penalitza();
        } else if (estrategia1 == ENGANY && estrategia2 == ATAC) {
            l1.restaPuntsDeVida(cares2);
            l2.restaPuntsDeVida(cares1 * 2);
        } else if (estrategia1 == ENGANY && estrategia2 == DEFENSA) {
            l2.restaPuntsDeVida(cares1 * 2);
        } else if (estrategia1 == ENGANY && estrategia2 == ENGANY) {
            l1.restaPuntsDeVida(cares2);
            l2.restaPuntsDeVida(cares1);
        } else if (estrategia1 == ENGANY && estrategia2 == MANIOBRA) {
            l2.penalitza();
        } else if (estrategia1 == MANIOBRA && estrategia2 == ATAC) {
            l1.restaPuntsDeVida(cares2);
        } else if (estrategia1 == MANIOBRA && estrategia2 == DEFENSA) {
            l2.penalitza();
        } else if (estrategia1 == MANIOBRA && estrategia2 == ENGANY) {
            l2.penalitza();
        } else if (estrategia1 == MANIOBRA && estrategia2 == MANIOBRA) {
            // no passa res
        } else {
            return false;
        }
        return true;
    }

    // Mostra estratègia i cares
    static void imprimeixEstrategiaICares(String nom, int estrategia, int cares) {
        String[] ar = {"ATAC", "DEFENSA", "MANIOBRA", "ENGANY"};
        System.out.printf("Estrategia (%s): %s, cares: %d%n", nom, ar[estrategia - 1], cares);
    }
}