package towerofterror5;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TowerTest {
     
    boolean playerAlive; //add player states for each outcome
    boolean atticKey; // keeps track of the attic key
    int numFloor; // assigns each floor with a designated number
    String[] backPack = new String[20]; // holds 20 possible items for the player's bookbag
    String userName; 
    
    TowerTest(String name) {
        userName = name; 
        playerAlive = true;
    }
    /* Each room will be a method. Arrays will be used to give the user many 
    options to click from in the JOptionPane window.*/
    
    public void elevator() {
        while (playerAlive) {
            JOptionPane.showMessageDialog(null, "In the front door, you see the elevator...");
            numFloor = Integer.parseInt( JOptionPane.showInputDialog(null, 
                    "Enter the floor you would like to go to (0 - 12). If you're"
                            + " too scared, enter 13 to exit"));
            switch (numFloor) {
                case 0:
                    playerAlive = enterBasement(); 
                    break;
                
                case 1:
                    playerAlive = enterAttic();
                    break;
                
                case 2:
                    playerAlive = enterLivingRoom();
                    break;
                
                case 3:
                    playerAlive = enterDiningRoom();
                    break;
                
                case 4:
                    playerAlive = enterKitchen();
                    break;
                
                case 5:
                    playerAlive = enterPantry();
                    break;
                
                case 6:
                    playerAlive = enterBathroom1();
                    break;
                
                case 7:
                    playerAlive = enterBedroom1();
                    break;
                    
                case 8:
                    playerAlive = enterBathroom2();
                    break;
                    
                case 9:
                    playerAlive = enterBedroom2();
                    break;
                
                case 10:
                    playerAlive = enterMasterBedroom();
                    break;
                
                case 11:
                    playerAlive = enterMasterBathroom();
                    break;
                
                case 12:
                    playerAlive = enterAttic();
                    break;
                    
                case 13:
                    JOptionPane.showMessageDialog(null, "Farewell, " + userName + "!");
                    gameOver();
                    playerAlive = false;
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Please enter another "
                            + "number.");
                    playerAlive = true;
                    break;
            }
        }       
    }
    /*
    Each room is assigned a number from 0-12 and depending on what number the user types in
    he/she enters that room.
    */
    
    public boolean enterBasement() {
        Object[] options = {"Go to Storage room", "Search Boiler"};
        int userOption = JOptionPane.showOptionDialog(null, userName + ", Would"
                + " you like enter the Storage room," + "\n" + "or search the "
                + "Boiler room?","Basement", + JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "Let's go to the Storage room, "
                    + userName + ".");
            enterStorageRoom();
        }
        else if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "Let's go to the Boiler room, "
                    + userName + ".");
            enterBoilerRoom();
        }  
        return playerAlive;
    }
    /*
    If the user chooses array element zero which is the storage room, he 
    ends us in the storage room. 
    If the user chooses aray element one which is the boiler room, 
    he ends up in the boiler room.
    */
    
    public void enterBoilerRoom() {

        Object[] options = {"Go to Elevator", "Search Boiler"}; //Shows the availble options for the user in the JOption Pane
        int userOption = JOptionPane.showOptionDialog(null, userName + ", What would you like to do next?" //Prompts user of there available options
                ,
                 "Boiler Room", +JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (userOption == 0) { //Will take the user to the Living Room
            elevator();
        } //End of == 0 if statment
        else if (userOption == 1) { //Will take the user to the Stairs
            JOptionPane.showMessageDialog(null, "You approach the Boiler. Suddenly, hot flames emit escape from it, " + "\n" + ""
                    + "burning you alive! GAME OVER!");
            backPack[17] = "Boiler";
            //updateInventory();
            gameOver();
        } //End of == 1 if statement

    } //End of enterBoilerRoom method
    /*
    If the player chooses array element zero which is to go to the elevator, he
    ends up in the elevator where he originally started. This is a way of backtracking 
    besides when the game starts over. 
    If the player chooses array element one, he dies 
    from the boiler's fumes and has to start again.
    */
    
    public void enterStorageRoom() {

        Object[] options = {"Go to Elevator", "Search Chest"}; //Shows the availble options for the user in the JOption Pane
        int userOption = JOptionPane.showOptionDialog(null, userName + ", What would you like to do next?" //Prompts user of there available options
                ,
                 "Storage Room", +JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (userOption == 0) { //Will take the user to the Living Room
            elevator();
        } //End of == 0 if statment
        else if (userOption == 1){
            if (backPack[18] == "Attic Key") {
                JOptionPane.showMessageDialog(null, "You already found the Attic Key.");
                enterStorageRoom();
            } else {
                JOptionPane.showMessageDialog(null, "You find the Attic Key! You can enter the attic now.");
                backPack[18] = "Attic Key";
                //updateInventory();
                enterStorageRoom();
            }
        } //End of else statement

    } //End of enterStorageRoom method
    /*
    If the player chooses array element zero, he to goes the elevator. This is a way of backtracking
    If the player chooses array element one to search the chest, he either is given the 
    attic key or is told he already has it.
    */
    
    public boolean enterDiningRoom() {
        ImageIcon DinRoom = new ImageIcon("DiningRoom.jpg");
        JOptionPane.showMessageDialog(null, "This is the dining room, "
                + userName + ".");
        Object[] options = {"Exit room", "Explore Candelabra"};
        int userOption = JOptionPane.showOptionDialog(null, userName + ", Would"
                + " you like to go to the kitchen," + "\n" + "or explore the "
                + "candelabra?","DiningRoom", + JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "You've lighted yourself on "
                    + "fire," + "\n" + "and you see a death shadow. GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, DinRoom);
            backPack[0] = "Candelabra";
            gameOver();
            playerAlive = false;
            return playerAlive;
        } else if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "Very well, " + userName + ". "
                    + "Let's leave this room.");
            //enterKitchen(); removed
            playerAlive = true;
            return playerAlive;
        } else { //In case player chooses to exit the window 
            JOptionPane.showMessageDialog(null, "Don't leave now, " + userName);
            playerAlive = false;
            return playerAlive;
        }
       
    }
    /*
    If the player chooses array element one to explore the candelabra, he ends up dead and starts back 
    at the elevator through the gameOver method. 
    If the player chooses array element zero, he exits the room back to the elevator
    and goes back to the elevator. 
    In the case the player closes the window, the game ends immediately after a pop
    up message saying "Don't leave now" is displayed.
    */

    public boolean enterLivingRoom() {
        ImageIcon LivRoom = new ImageIcon("Living_Room.jpeg");
        JOptionPane.showMessageDialog(null, "This is the living room, " + 
                userName + ".");
        Object[] options = {"Exit room", "Explore chest"};
        int userOption = JOptionPane.showOptionDialog(null, userName + ", Would"
                + " you like to go to the bathroom,"+ "\n" + "or open the chest?", 
                "Livingroom", + JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "A ghost escapes when you open"
                    + " it and scares you to death." + "\n" + "GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, LivRoom);
            backPack[1] = "Chest";
            playerAlive = false;
            gameOver();
            return playerAlive;
        } else if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "Very well, " + userName + ". "
                    + "Let's exit this room.");
            //enterBathroom1();
            return playerAlive;
        } else {
            JOptionPane.showMessageDialog(null, "Don't leave now, " + userName);
            playerAlive = false;
            return playerAlive;
        }
    }
    
    /*
    If the player chooses array element one, the chest is explored and the player
    ends up dead so the gameOver method is enacted to start the game over again.
    If the player chooses array element zero, he exits the room back to the elevator.
    In the case the player closes the window, the game ends immediately after a pop
    up message saying "Don't leave now" is displayed.
    */

    public boolean enterKitchen() {
        ImageIcon Kitchen = new ImageIcon("Kitchen.jpg");
        JOptionPane.showMessageDialog(null, "This is the kitchen, " + userName 
                + ".");
        Object[] options = {"Open Refrigerator", "Open Cabinet", "Exit room"};
        int userOption = JOptionPane.showOptionDialog(null, userName + ", Would"
                + " you like to open the refrigerator or cabinet?" + "\n" + "Or"
                + " perhaps visit the pantry?", "Kitchen", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, options, options[1]);

        if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "You open it and find some "
                    + "delicious soul food. Get it?" + "\n" + "GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, Kitchen);
            backPack[2] = "Refrigerator";
            //gameOver();
            playerAlive = true;
            return playerAlive;
        } else if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "The dishes and glasses start "
                    + "flying at you as soon as you open the door." + "\n" + 
                    "You get hit in the head and feel yourself start moving "
                    + "towards a light. GAME OVER!");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, Kitchen);
            backPack[3] = "Cabinet";
            gameOver();
            playerAlive = false;
            return playerAlive;
        } else if (userOption == 2) {
            JOptionPane.showMessageDialog(null, "Very well, " + userName + ". "
                    + "Let's exit this room.");
            //enterPantry();
            playerAlive = true;
            return playerAlive;
        } else {
            JOptionPane.showMessageDialog(null, "Don't leave now, " + userName);
            playerAlive = false;
            return playerAlive;
        }
        
    }
    
    /*
    If the player chooses array elements zero or one, the player is killed immediately and is
    brought back to the elevator with the gameOver method which also counts the items collected so far.
    If the player chooses element two, the player is brought back to the elevator.
    In the case the player closes the window, the game ends immediately after a pop
    up message saying "Don't leave now" is displayed.
    */

    public boolean enterPantry() {
        ImageIcon Pantry = new ImageIcon("Pantry.jpg");
        JOptionPane.showMessageDialog(null, "This is the pantry, " + userName
                + ".");
        Object[] options = {"Dusty Recipe", "Broom"};
        int userOption = JOptionPane.showOptionDialog(null, "Alright " + 
                userName + ", Which item do you wish to explore?", "Pantry",
                +JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);

        if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "You open it up and a recipe "
                    + "for chocolate devils"+ "\n" + "food cake appears out of "
                    + "no where. GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, Pantry);
            backPack[4] = "Dusty recipe";
            //gameOver();
            playerAlive = true;
            return playerAlive;
        } else if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "The broom flies up in the air "
                    + "as soon as you touch it." + "\n" + "GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, Pantry);
            backPack[5] = "Broom";
            //gameOver();
            playerAlive = true;
            return playerAlive;
        } else {
            JOptionPane.showMessageDialog(null, "Don't leave now " + userName);
            playerAlive = false;
            return playerAlive;
        }    
    }
    /*
    If the player chooses array element zero or one, he dies and is brought back to the elevator 
    though the gameOver method which also counts the items the player collected.
    In the case the player closes the window, the game ends immediately after a pop
    up message saying "Don't leave now" is displayed.
    */

    public boolean enterBathroom1() {
        ImageIcon BathRoom = new ImageIcon("Bathroom1.jpg");
        JOptionPane.showMessageDialog(null, "This is the bathroom, " + userName
                + ".");
        Object[] options = {"Mirror", "Shower"};
        int userOption = JOptionPane.showOptionDialog(null, "Alright " + userName
                + ", Which item do you wish to explore?", "Bathroom1",
                +JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);

        if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "You see a bloody face looking "
                    + "back at you. GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, BathRoom);
            backPack[6] = "Mirror";
            //gameOver();
            playerAlive = true;
            return playerAlive;
        } else if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "The room suddenly steams up, "
                    + "and you feel" + "\n" + "fingers touching the back of your"
                    + " neck. GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, BathRoom);
            backPack[7] = "Shower";
            gameOver();
            playerAlive = false;
            return playerAlive;
        } else {
            JOptionPane.showMessageDialog(null, "Don't leave now, " + userName);
            playerAlive = false;
            return playerAlive;
        }
    }
    /*
    If the player chooses array element zero or one, he dies and is brought back to the elevator 
    though the gameOver method which also counts the items the player collected.
    In the case the player closes the window, the game ends immediately after a pop
    up message saying "Don't leave now" is displayed.
    */
    
    
    //This method allows the player to backtrack
    public boolean enterBedroom1() {
        ImageIcon BedRoom = new ImageIcon("Bedroom1.jpeg");
        Object[] options = {"Sit on Rocking Chair", "Look outside the window",
            "Exit bedroom"};
        JOptionPane.showMessageDialog(null, "This is the first Bedroom, " + 
                userName + ".");
        int userOption = JOptionPane.showOptionDialog(null, "What would you like"
                + " to do here?", "Bedroom 1", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

        if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "The chairs starts rocking back"
                    + " and forth" + "\n" + "by itself with no one in it. GAME "
                    + "OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, BedRoom);
            backPack[8] = "Rocking Chair";
            //gameOver();
            playerAlive = true;
            return playerAlive;
        } else if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "You see a child outside on a "
                    + "swing" + "\n" + "..who suddenly disappears! GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, BedRoom);
            backPack[9] = "Window";
            //gameOver();
            playerAlive = true;
            return playerAlive;
        } else if (userOption == 2) {
            JOptionPane.showMessageDialog(null, "Don't like this room, " 
                    + userName + "? Let's leave then.");
           playerAlive = true;
            return playerAlive;
        } else {
            JOptionPane.showMessageDialog(null, "What's wrong, " + userName + 
                    "? Too chicken to continue?");
            playerAlive = false;
            return playerAlive;
        }
    }
    /*
     If the player chooses array elements zero or one, the player is killed immediately and is
    brought back to the elevator with the gameOver method which also counts the items collected so far.
    If the player chooses element two, the player is brought back to the elevator.
    In the case the player closes the window, the game ends immediately after a pop
    up message saying "What's wrong, [name]? Too chicken to continue?" is displayed.   
    */
    
    
    //This method allows the player to backtrack
    public boolean enterBedroom2() {
        ImageIcon BedRoom = new ImageIcon("Bedroom2.jpg");
        Object[] options = {"Explore Doll House", "Explore Dresser", "Exit Room"};
        JOptionPane.showMessageDialog(null, "This is the second Bedroom, " + 
                userName + ".");
        int userOption = JOptionPane.showOptionDialog(null, "What would you like"
                + " to do here?", "Bedroom 2", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

        if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "The Dolls start dancing on "
                    + "their own. GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, BedRoom);
            backPack[10] = "Doll House";
            //gameOver();
            playerAlive = true;
            return playerAlive;
        } else if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "A ghost flies out of the dresser"
                    + " as soon as you open it" + "\n" + "and goes right though"
                    + " your body. GAME OVER!");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, BedRoom);
            backPack[11] = "Dresser";
            gameOver();
            playerAlive = false;
            return playerAlive;
        } else if (userOption == 2) {
            JOptionPane.showMessageDialog(null, "Don't like this room, " + 
                    userName + "? Let's leave then.");
            playerAlive = true;
            return playerAlive;
        } else {
            JOptionPane.showMessageDialog(null, "What's wrong, " + userName + 
                    "? Too chicken to continue?");
            playerAlive = false;
            return playerAlive;
        }
        
    }
    /*
     If the player chooses array elements zero or one, the player is killed immediately and is
    brought back to the elevator with the gameOver method which also counts the items collected so far.
    If the player chooses element two, the player is brought back to the elevator.
    In the case the player closes the window, the game ends immediately after a pop
    up message saying "What's wrong, [name]? Too chicken to continue?" is displayed.    
    */
    
    //This method allows the player to backtrack
    public boolean enterBathroom2() {
        ImageIcon BathRoom = new ImageIcon("Bathroom2.jpg");
        JOptionPane.showMessageDialog(null, "This is the bathroom, " + userName
                + "." + "\n" + "It is in between the 1st and 2nd bedrooms");
        Object[] options = {"Mirror", "Shower", "Exit room"};
        int userOption = JOptionPane.showOptionDialog(null, "Alright " + 
                userName + ", What is your next move?", "Bathroom 2",
                + JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[2]);

        if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "You see a bloody face looking "
                    + "back at you. GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, BathRoom);
            backPack[12] = "Mirror";
            //gameOver();
            playerAlive = true;
            return playerAlive;
        } else if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "The room suddenly steams up "
                    + "\n" + "and you feel fingers touching the back of your "
                    + "neck. GAME OVER");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, BathRoom);
            backPack[13] = "Shower";
            gameOver();
            playerAlive = false;
            return playerAlive;
        } else if (userOption == 2) {
            JOptionPane.showMessageDialog(null, "Ok, " + userName + ", Let's "
                    + "leave this room.");
            //enterBedroom1();
            playerAlive = true;
            return playerAlive;
        } else {
            JOptionPane.showMessageDialog(null, "Don't leave now, " + userName);
            playerAlive = false;
            return playerAlive;
        }        
    }
    
    /*
     If the player chooses array elements zero or one, the player is killed immediately and is
    brought back to the elevator with the gameOver method which also counts the items collected so far.
    If the player chooses element two, the player is brought back to the elevator.
    In the case the player closes the window, the game ends immediately after a pop
    up message saying "Don't leave now" is displayed.
    */

    public boolean enterMasterBedroom() {
        ImageIcon MRoom = new ImageIcon("MasterBedroom.jpeg");
        Object[] options = {"Explore Jewelry Box", "Exit room"};
        JOptionPane.showMessageDialog(null, "This is the Master Bedroom, " + 
                userName + ".");
        int userOption = JOptionPane.showOptionDialog(null, "What would you like"
                + " to do here?", "MasterBedroom", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);

        if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "You find the cursed Hope "
                    + "Diamond and feel your doom" + "\n" + "GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, MRoom);
            backPack[14] = "Jewelry Box";
            gameOver();
            playerAlive = false;
            return playerAlive;
        } else if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "Wise decision, " + userName + 
                    ". Let's exit the Master Bedroom.");
            //enterMasterBathroom();
            playerAlive = true;
            return playerAlive;
        } else {
            JOptionPane.showMessageDialog(null, "What's wrong, " + userName + 
                    "? Too chicken to continue?");
            playerAlive = false;
            return playerAlive;
        }
    }
    
    /*
     If the player chooses array element zero, the player is killed immediately and is
    brought back to the elevator with the gameOver method which also counts the items collected so far.
    If the player chooses element one, the player is brought back to the elevator.
    In the case the player closes the window, the game ends immediately after a pop
    up message saying "What's wrong, [name]? Too chicken to continue?" is displayed.    
    */

    public boolean enterMasterBathroom() {
        ImageIcon BathRoom = new ImageIcon("MasterBathroom.jpg");
        JOptionPane.showMessageDialog(null, "This is the Master Bathroom, "
                + userName + "." + "\n" + "There is no escape from this room.");
        Object[] options = {"Intricate Oil Lamp", "Shower"};
        int userOption = JOptionPane.showOptionDialog(null, "Alright " + userName
                + ", Which item do you wish to explore?", "MasterBathroom",
                +JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);

        if (userOption == 0) {
            JOptionPane.showMessageDialog(null, "You rub the lamp and a genie "
                    + "pops out," + "\n" + "who says he’ll grant you 3 wishes. "
                    + "GAME OVER.");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, BathRoom);
            backPack[15] = "Intricate Oil Lamp";
            //gameOver();
            playerAlive = true;
            return playerAlive;
        } else if (userOption == 1) {
            JOptionPane.showMessageDialog(null, "You suddenly hear singing in "
                    + "the shower,"+ "\n" + "but no one is there. GAME OVER!");
            JOptionPane.showMessageDialog(null, "It ends here.", "Game Over",
            JOptionPane.INFORMATION_MESSAGE, BathRoom);
            backPack[16] = "Shower";
            //gameOver();
            playerAlive = true;
            return playerAlive;
        } else {
            JOptionPane.showMessageDialog(null, "Don't leave now, " + userName);
            playerAlive = false;
            return playerAlive;
        }
    } 
    
    /*
     If the player chooses array element zero or one, the player is killed immediately and is
    brought back to the elevator with the gameOver method which also counts the items collected so far.
    In the case the player closes the window, the game ends immediately after a pop
    up message saying "Don't leave me now" is displayed.     
    */
    
     public boolean enterAttic() {
         if (backPack[18] == "Attic Key") {
            JOptionPane.showMessageDialog(null, "The Attic is now open.");

            Object[] options = {"Go to Elevator", "Search Chest"}; //Shows the availble options for the user in the JOption Pane
            int userOption = JOptionPane.showOptionDialog(null, userName + ", What would you like to do next?" //Prompts user of there available options
                    ,
                     "Attic", +JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

            if (userOption == 0) { //Will take the user to the Living Room
                playerAlive = true;
                return playerAlive;
            } //End of == 0 if statment
            else if (userOption == 1) {
                if (backPack[19] == "Exit Key") {
                    JOptionPane.showMessageDialog(null, "You already have the exit key, escape while you have the chance!");
                    enterAttic();
                } else {
                    JOptionPane.showMessageDialog(null, "You find the Exit Key, now is your chance to escape!");
                    backPack[19] = "Exit Key";
                    //updateInventory();
                    enterAttic();
                }

            } //End of else statement
        }//End of initial if statement if you have attic key
        else {
            JOptionPane.showMessageDialog(null, "Sorry, you can't enter the attic " + userName + ". The door is locked.");
            playerAlive = true;
            return playerAlive;
        }//End of else statment if you don't have attic key
        return playerAlive;
    }
     
     /*
     If the player's 19th element in the backpack is the attic key, he is given
     access there. If not, he is denied access and brought back to the elevator.
     If the player chooses array element zero, he goes back to the elevator.
     If the player chooses array element one to search the chest, depeneding whether he already collected
     the Exit key from there, he is either given it or told to escape while he can. In both cases,
     he's brought back to the attic.
     */
     
    //Displays what is in the backpack. Ends the program.
    public boolean gameOver() {
        for (int i = 0; i < backPack.length; i++) {
            if (backPack[i] == null) {
                continue;
            }
            JOptionPane.showMessageDialog(null, userName + ", Your backpack "
                + "contains the following item(s): \n" + backPack[i], "Game Over",
                JOptionPane.INFORMATION_MESSAGE);
        } 
        playerAlive = false;
        return playerAlive;
    }  
    
}

/*
This counts the amount of items in the player's backpack and labels him as dead, leading him back to
the elevator to start over.
*/
