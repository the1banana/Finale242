/**
 * Created by the1banana on 11/7/2014.
 */
public class Room {

    private String name;
    private Tile[][] map;

    public Room (int width, int height, String name) {
        this.name = name;
        map = new Tile[width][height];
    }

    public int getWidth(){
        if(map == null){
            return 0;
        }
        return map.length;
    }

    public int getHeight() {
        if(map == null){
            return 0;
        }
        return map[0].length;
    }

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
}
