public interface Screen {
    int SCREEN_WIDTH = 200;
    int SCREEN_HEIGHT = 20;

    void clear();

    void drawGraphics(String graph, int row, int col);

    void drawVerticalLine(int row, int col, int length);

    void drawText(String text, int row, int col);

    void render();
}