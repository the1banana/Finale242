import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by the1banana on 11/7/2014.
 */
public class Game {
    private Tile[] tiles;
    private Room[] rooms;
    private Character[] party;
    private String name;

    public Game (String name){
        this.name = name;
        party = new Character[4];
        party[0] = new Character();
        rooms = null;
        tiles = new Tile[1];
        BufferedImage nullTile = null;
        try {
            nullTile = ImageIO.read(new File("src/nullTile.png"));
        } catch (IOException e){
            System.out.println("Cannot read file.");
        }
        tiles[0] = new Tile(nullTile);
        tiles[0].setWalls(true, true, true, true);
    }

    public void addTile(Tile tile){
        Tile[] newArray = new Tile[tiles.length+1];
        for(int i = 0; i < tiles.length; i++){
            newArray[i] = tiles[i];
        }
        tiles = newArray;
        tiles[tiles.length-1] = tile;
    }

    public Tile[] getTiles(){
        return tiles;
    }

    String getName (){
        return name;
    }
}
