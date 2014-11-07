import java.awt.image.BufferedImage;

/**
 * Created by the1banana on 11/7/2014.
 */
public class Tile {
    private boolean north, south, east, west; //if true, a wall exists on that side of the tile
    private BufferedImage image;
    public Tile (BufferedImage image) {
        this.west = false;
        this.east = false;
        this.north = false;
        this.south = false;
        this.image = image;
    }

    public void setWalls(boolean north, boolean south, boolean east, boolean west){
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

    public BufferedImage getGraphics(){ return image; }
    public boolean getNorth(){ return north; }
    public boolean getSouth(){ return south; }
    public boolean getEast(){ return east; }
    public boolean getWest(){ return west; }
}
