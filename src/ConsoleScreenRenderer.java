public class ConsoleScreenRenderer implements Screen {
    private final String[][] pixels = new String[SCREEN_HEIGHT][SCREEN_WIDTH];

    public ConsoleScreenRenderer() {
        clear();
    }

    @Override
    public void clear() {
        for (int row = 0; row < SCREEN_HEIGHT; row++) {
            for (int col = 0; col < SCREEN_WIDTH; col++) {
                pixels[row][col] = " ";
            }
        }
    }

    @Override
    public void drawGraphics(String graph, int row, int col) {
        String[] lines = graph.split("\n");
        for (int i = 0; i < lines.length; i++) {
            drawText(lines[i], row + i, col);
        }
    }

    @Override
    public void drawVerticalLine(int row, int col, int length) {
        for (int i = 0; i < length; i++) {
            drawText("|", row + i, col);
        }
    }

    @Override
    public void drawText(String text, int row, int col) {
        for (int i = 0; i < text.length(); i++) {
            if (row < 0 || row >= SCREEN_HEIGHT || col + i < 0 || col + i >= SCREEN_WIDTH) {
                continue;
            }
            pixels[row][col + i] = String.valueOf(text.charAt(i));
        }
    }

    @Override
    public void render() {
        for (int row = 0; row < SCREEN_HEIGHT; row++) {
            for (int col = 0; col < SCREEN_WIDTH; col++) {
                System.out.print(pixels[row][col]);
            }
            System.out.println();
        }
    }
}