import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private Player player;

    private ArrayList<Wall> walls = new ArrayList<>();

    public GamePanel() {
        JPanel panel = new JPanel();
        panel.setLocation(0, 0);
        panel.setBackground(Color.black);
        panel.setVisible(true);
        panel.setDoubleBuffered(true); // lepsi render

        this.player = new Player(400, 300, this);
    }

    public void paint(Graphics g) {
        // super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);
        for (Wall wall : walls) {
            wall.draw(gtd);
        }

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                player.keyLeft = true;
                break;
            case 'd':
                player.keyRight = true;
                break;
            case 'w':
                player.keyUp = true;
                break;
            case 's':
                player.keyDown = true;
                break;
        }

    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                player.keyLeft = false;
                break;
            case 'd':
                player.keyRight = false;
                break;
            case 'w':
                player.keyUp = false;
                break;
            case 's':
                player.keyDown = false;
                break;
        }
    }

    public void makeWalls() {
        for (int i = 50; i < 650; i += 50) {
            walls.add(new Wall(i, 600, 50, 50));

        }
        walls.add(new Wall(50, 450, 50, 50));
        walls.add(new Wall(50, 500, 50, 50));
        walls.add(new Wall(50, 550, 50, 50));
        walls.add(new Wall(450, 550, 50, 50));
        walls.add(new Wall(600, 450, 50, 50));
        walls.add(new Wall(600, 500, 50, 50));
        walls.add(new Wall(600, 550, 50, 50));

    }

    public ArrayList<Wall> getWalls() {
        return this.walls;
    }
}
