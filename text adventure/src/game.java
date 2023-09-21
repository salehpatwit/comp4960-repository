
import java.util.*;

public class game {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Mysterious Awakening Start\n");
        System.out.print("You wake up in a bedroom with no memory of where you are. What do you do?\n");
        bedroom(input, true, false, 1);
        
        
        input.close();
    }
    public static void bedroom(Scanner in, boolean first, boolean bathKey, int panel) {
        if (!first) {
            System.out.print("\nYou find yourself in the bedroom. What do you do?\n");
        }
        System.out.print("1. Exit the bedroom\n2. Check the nightstand\n3. Check the bed\n");
        int x = in.nextInt();
        if (x == 1) {
            greatHall(in, bathKey, panel);
        } else if (x == 2) {
            System.out.println("You find a key under the nightstand.\n");
            bedroom(in, false, true, panel);
        } else if (x == 3) {
            System.out.print("You don't find anything.\n");
            bedroom(in, false, bathKey, panel);
        }
        
    }
    public static void greatHall(Scanner in, boolean bathKey, int panel) {
        if (panel == 1) {
            System.out.print("\nYou find yourself in the Great Hall. Where do you go from here?\n" +
            "1. Bedroom\n2. Garden\n3. Basement\n4. Bathroom\n");
            int x = in.nextInt();
            if (x == 1) {
                bedroom(in, false, bathKey, panel);
             } else if (x == 2) {
                 garden(in, bathKey, panel, false);
             } else if (x == 3) {
                 basement();
             } else if (x == 4) {
                 if(bathKey) {
                     bathroom(in);
                 } else {
                     System.out.print("The bathroom is locked\n");
                     greatHall(in, bathKey, 1);
                 }
             }
        } else if (panel == 2) {
        System.out.print("\nYou find yourself in the Great Hall. Where do you go from here?\n" +
        "1. Bedroom\n2. Garden\n3. Basement\n4. Bathroom\n5. Hidden Panel\n");
        int x = in.nextInt();
        if (x == 1) {
            bedroom(in, false, bathKey, panel);
         } else if (x == 2) {
             garden(in, bathKey, panel, false);
         } else if (x == 3) {
             basement();
         } else if (x == 4) {
             System.out.print("You have everything you need from the bathroom.\n");
             greatHall(in, true, 2);
         } else if (x == 5) {
             System.out.print("You find a gun and a key.\n");
             greatHall(in, bathKey, 3);
         }
        }
        else {
        System.out.print("\nYou find yourself in the Great Hall. Where do you go from here?\n" +
        "1. Bedroom\n2. Garden\n3. Basement\n4. Bathroom\n");
        int x = in.nextInt();
        if (x == 1) {
            bedroom(in, false, bathKey, panel);
         } else if (x == 2) {
             garden(in, bathKey, panel, true);
         } else if (x == 3) {
             basement();
         } else if (x == 4) {
             System.out.print("You have everything you need from the bathroom.\n");
             greatHall(in, true, 3);
         }
        }
    }
    public static void garden(Scanner in, boolean bathKey, int panel, boolean gun) {
        if (!gun) {
            System.out.print("\nAs you enter the garden, you find yourself attacked by a dog. You quickly rush back into the great hall.\n");
            greatHall(in, bathKey, panel);
        } else {
            System.out.print("\nAs you enter the garden, you find yourself attacked by a dog. You quickly shoot it and put it down.\n" +
            "Walking to the front gates, you warily eye your surroundings for further dangers. \nUpon reaching the gate, you find it locked.\n" +
            "You're able to unlock it using the key from the hidden panel in the Great Hall. \nYou exit the gate and move towards freedom.\n" +
            "GAME OVER! YOU WIN!\n");
        }
    }
    public static void basement() {
        System.out.print("\nAs you enter the basement, the door suddenly locks behind you.\n" +
        "Gas begins to fill the room and you find yourself very sleepy. You struggle and fail to stay awake, drifting off into an endless slumber...\n" +
        "GAME OVER! YOU LOSE!\n");
    }
    public static void bathroom(Scanner in) {
        System.out.print("\nYou find yourself in the bathroom. Where do you go from here?\n" +
        "1. Exit bathroom\n2. Check closet\n");
        int x = in.nextInt();
        if (x == 1) {
           greatHall(in, true, 1);
        } else if (x == 2) {
            System.out.print("You find a note detailing a panel in the wall of the Great Hall.\n" +
            "You find nothing else in the bathroom an decide to leave.\n");
            greatHall(in, true, 2);
        } 
    }
}