import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by the1banana on 11/7/2014.
 */
public class MainDisplay extends JFrame {

    Game currentGame;

    private void makeNewGame(){

    }

    public MainDisplay() {
        currentGame = null;
        //set the behavior/appearance of main pane
        setTitle("Finale 242 - RPG Builder");
        setSize(400, 200);
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

        JMenu file = new JMenu("File");
        file.add(newGame);
        file.add(loadGame);
        file.add(exportGame);
        file.add(saveGame);
        file.add(exit);

        JMenu room = new JMenu("Room");
        room.add(newRoom);
        room.add(editRoom);

        JMenuBar menubar = new JMenuBar();
        menubar.add(file);
        menubar.add(room);

        setJMenuBar(menubar);
    }
}
