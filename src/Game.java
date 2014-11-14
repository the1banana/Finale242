import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by the1banana on 11/7/2014.
 */
public class Game {
    private ArrayList<Tile> tiles;
    private ArrayList<Room> rooms;
    //by not explicitly defining attributes, it permits better flexibility of combat design
    private Unit[] party;
    private String name;

    public Game (String name){
        this.name = name;
        party = new Unit[4];
        party[0] = new Unit();
        rooms = null;
        tiles = new ArrayList<Tile>();
        BufferedImage nullTile = null;
        try {
            nullTile = ImageIO.read(new File("src/nullTile.png"));
        } catch (IOException e){
            System.out.println("Cannot read file.");
        }
        tiles.add(new Tile(nullTile));
        tiles.get(0).setWalls(true, true, true, true);
    }

    public void addTile(Tile tile){
        tiles.add(tile);
    }

    public void removeTile(int index){
        tiles.remove(index);
    }

    public ArrayList<Tile> getTiles(){
        return tiles;
    }

    String getName (){
        return name;
    }
}
