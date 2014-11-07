import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by the1banana on 11/7/2014.
 */
public class TileEditor extends JFrame implements KeyListener {

    int index = -1;
    final JCheckBoxMenuItem north = new JCheckBoxMenuItem("North");
    final JCheckBoxMenuItem south = new JCheckBoxMenuItem("South");
    final JCheckBoxMenuItem east = new JCheckBoxMenuItem("East");
    final JCheckBoxMenuItem west = new JCheckBoxMenuItem("West");
    JLabel tileGraphic;
    Game source;

    private void saveTile(){
        source.getTiles()[index].setWalls(north.getState(), south.getState(), east.getState(), west.getState());
    }

    private void makeNewTile(){
        saveTile();
        JFileChooser imageOpen = new JFileChooser();
        imageOpen.addChoosableFileFilter(new FileNameExtensionFilter("PNG files", "PNG"));
        imageOpen.addChoosableFileFilter(new FileNameExtensionFilter("GIF files", "GIF"));
        imageOpen.addChoosableFileFilter(new FileNameExtensionFilter("Bitmap files", "BMP"));
        int ret = imageOpen.showDialog(this, "Open Tile Graphic");
        File file = imageOpen.getSelectedFile();
        BufferedImage tileImage = null;
        try {
            tileImage = ImageIO.read(file);
            source.addTile(new Tile(tileImage));
            index = source.getTiles().length - 1;
            Tile currTile = source.getTiles()[index];
            tileGraphic.setIcon(new ImageIcon(currTile.getGraphics()));
            updateWalls();
        } catch (IOException e){
            System.out.println("Cannot read file.");
        }
    }

    private void updateWalls(){
        Tile currTile = source.getTiles()[index];
        north.setState(currTile.getNorth());
        south.setState(currTile.getSouth());
        east.setState(currTile.getEast());
        west.setState(currTile.getWest());
    }

    private void updateEditor(boolean forward){
        saveTile();
        if(forward) {
            index++;
            if (index == source.getTiles().length) {
                index = 1;
            }
        } else {
            index--;
            if (index < 1){
                index = source.getTiles().length-1;
            }
        }
        Tile currTile = source.getTiles()[index];
        tileGraphic.setIcon(new ImageIcon(currTile.getGraphics()));
        updateWalls();
    }

    public TileEditor(Game source, int index) {
        this.source = source;
        setTitle("Tile Editor");
        setSize(250, 250);

        Tile currTile = source.getTiles()[index];
        tileGraphic = new JLabel(new ImageIcon(currTile.getGraphics()));
        add(tileGraphic);
        this.index = index;
        updateWalls();

        JMenuItem addTile = new JMenuItem("Add Tile");
        addTile.setToolTipText("Add another tile.");
        addTile.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event){
                makeNewTile();
            }
        });

        JMenuItem saveExit = new JMenuItem("Save and Exit");
        saveExit.setToolTipText("Exit the tile editor.");
        saveExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                saveTile();
                dispose();
            }
        });

        JMenu file = new JMenu("File");
        file.add(addTile);
        file.add(saveExit);

        JMenu walls = new JMenu("Walls");
        walls.add(north);
        walls.add(south);
        walls.add(east);
        walls.add(west);
        JMenuBar menubar = new JMenuBar();
        menubar.add(file);
        menubar.add(walls);

        setJMenuBar(menubar);

        addKeyListener(this);
    }

    public void keyPressed(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                updateEditor(false);
                break;
            case KeyEvent.VK_RIGHT:
                updateEditor(true);
                break;
        }
    }
}
