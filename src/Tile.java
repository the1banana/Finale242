import java.awt.image.BufferedImage;

/**
 * Created by the1banana on 11/7/2014.
 */
public class Tile {
    private boolean left, right, up, down; //if false, it obstructs entry from that direction
    private BufferedImage image;
    public Tile (boolean left, boolean right, boolean up, boolean down, BufferedImage image) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.image = image;
    }
}
