package towerofterror5;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class TowerofTerror5 {


    public static void main(String[] args) {
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("MV"
                + " boli", Font.PLAIN, 20))); //New bold font is created.
        ImageIcon AmityvilleHouse = new ImageIcon("AmityvilleHouse.jpg");
        String name = JOptionPane.showInputDialog("Introduce yourself, brave "
                + "soul."); //Stores the user's name.
        TowerTest PlayerExploration = new TowerTest(name);
        JOptionPane.showMessageDialog(null, name + ", Welcome to AMITYVILLE!",
                "House", JOptionPane.INFORMATION_MESSAGE, AmityvilleHouse);
        PlayerExploration.elevator();
   
    }
    
}

