import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainDisplay extends JFrame {

    Game currentGame;
    File defaultPath = new File("C:/");

    private boolean checkActive(){
        if(currentGame == null) {
            JOptionPane.showMessageDialog(this, "No active project!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private void makeNewGame(){
        String name = (String)JOptionPane.showInputDialog(this,
                "Give your game a title:\n",
                "New Game - Title",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "The Greatest Game");
        currentGame = new Game(name);
        setTitle("Finale 242 - RPG Builder - " + currentGame.getName());
    }

    private void makeNewTile(){
        if(checkActive()) {
            JFileChooser imageOpen = new JFileChooser();
            imageOpen.setCurrentDirectory(defaultPath);
            imageOpen.addChoosableFileFilter(new FileNameExtensionFilter("PNG files", "PNG"));
            imageOpen.addChoosableFileFilter(new FileNameExtensionFilter("GIF files", "GIF"));
            imageOpen.addChoosableFileFilter(new FileNameExtensionFilter("Bitmap files", "BMP"));
            int ret = imageOpen.showDialog(this, "Open Tile Graphic");
            File file = imageOpen.getSelectedFile();
            defaultPath = imageOpen.getCurrentDirectory();
            BufferedImage tileImage = null;
            try {
                tileImage = ImageIO.read(file);
                if(tileImage.getWidth() == 32 && tileImage.getHeight() == 32) {
                    currentGame.addTile(new Tile(tileImage));
                    TileEditor edit = new TileEditor(currentGame, currentGame.getTiles().size() - 1, defaultPath);
                    edit.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a 32x32 image.",
                            "Size error.", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                System.out.println("Cannot read file.");
            }
        }
    }

    private void openEditor(){
        if(checkActive()) {
            if (currentGame.getTiles().size() > 1) {
                TileEditor editor = new TileEditor(currentGame, 1, defaultPath);
                editor.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No tiles added!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public MainDisplay() {
        currentGame = null;
        //set the behavior/appearance of main pane
        setTitle("Finale 242 - RPG Builder");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //manage menubar
        JMenuItem newGame = new JMenuItem("New");
        newGame.setToolTipText("Creates a new RPG Project.");
        newGame.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent event){
                makeNewGame();
            }
        });

        JMenuItem loadGame = new JMenuItem("Load");
        loadGame.setToolTipText("Loads an existing RPG Project.");

        JMenuItem exportGame = new JMenuItem("Export");
        exportGame.setToolTipText("Export a standalone, playable version of your game!");

        JMenuItem saveGame = new JMenuItem("Save");
        saveGame.setToolTipText("Save the current RPG Project.");

        JMenuItem exit = new JMenuItem("Exit");
        exit.setToolTipText("Exits Finale 242.");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });

        JMenuItem newRoom = new JMenuItem("New");
        newRoom.setToolTipText("Create a new room.");

        JMenuItem editRoom = new JMenuItem("Edit");
        editRoom.setToolTipText("Edit a previously made room.");

        JMenuItem newTile = new JMenuItem("New");
        newTile.setToolTipText("Create a new tile.");
        newTile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                makeNewTile();
            }
        });

        JMenuItem editTile = new JMenuItem("Edit");
        editTile.setToolTipText("Edit a previously made tile.");
        editTile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                openEditor();
            }
        });

        JMenu file = new JMenu("File");
        file.add(newGame);
        file.add(loadGame);
        file.add(exportGame);
        file.add(saveGame);
        file.add(exit);

        JMenu room = new JMenu("Room");
        room.add(newRoom);
        room.add(editRoom);

        JMenu tile = new JMenu("Tile");
        tile.add(newTile);
        tile.add(editTile);

        JMenuBar menubar = new JMenuBar();
        menubar.add(file);
        menubar.add(room);
        menubar.add(tile);

        setJMenuBar(menubar);
    }
}
