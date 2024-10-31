public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(Plot p) {
        this(p.x, p.y, p.width, p.depth);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public boolean overlaps(Plot plot) {
        int ax1 = x;
        int ax2 = x + width;
        int ay1 = y;
        int ay2 = y + depth;

        int bx1 = plot.x;
        int bx2 = plot.x + plot.width;
        int by1 = plot.y;
        int by2 = plot.y + plot.depth;

        return ax1 < bx2 && ax2 > bx1 && ay1 < by2 && ay2 > by1;
    }

    public boolean encompasses(Plot plot) {
        int ax1 = x;
        int ax2 = x + width;
        int ay1 = y;
        int ay2 = y + depth;

        int bx1 = plot.x;
        int bx2 = plot.x + plot.width;
        int by1 = plot.y;
        int by2 = plot.y + plot.depth;

        return bx1 >= ax1 && bx2 <= ax2 && by1 >= ay1 && by2 <= ay2;
    }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) { this.width = width; }
    public void setDepth(int depth) { this.depth = depth; }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getDepth() { return depth; }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth; // Matches expected format in PlotTestGFA
    }
}
