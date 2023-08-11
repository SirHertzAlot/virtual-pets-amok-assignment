package pets_amok;
import java.util.Scanner;

public class VirtualPetApp {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        int choices = 0;

        do {
            VirtualPet.tick();
            System.out.println("Pero the puppy is your new pet!");
            System.out.println("Hunger Lvl: " + VirtualPet.getHungerLvl());
            System.out.println("Thirst Lvl: " + VirtualPet.getThirstLvl());
            System.out.println("Boredom Lvl: " + VirtualPet.getBoredLvl());
            System.out.println("Potty Lvl: " + VirtualPet.getPottyLvl());
            System.out.println("Happiness Lvl: " + VirtualPet.getHealthLvl());
            System.out.println("Pet Type: " + VirtualPet.getPetType());

            System.out.println("What do you want to do?");
            System.out.println("1. See if Pero is hungry");
            System.out.println("2. See if Pero is thirsty");
            System.out.println("3. See if Pero is bored");
            System.out.println("4. Take Pero to the potty");
            System.out.println("5. Take Pero for a walk");
            System.out.println("0. To return to the main menu");

            choices = input.nextInt();

            switch (choices) {
                case 0: {
                    System.out.println("Pero the puppy is your new pet!");
                    System.out.println("Hunger: " + VirtualPet.getHungerLvl());
                    System.out.println("Thirst: " + VirtualPet.getThirstLvl());
                    System.out.println("Boredom: " + VirtualPet.getBoredLvl());

                    System.out.println("What do you want to do?");
                    System.out.println("1. See if Pero is hungry");
                    System.out.println("2. See if Pero is thirsty");
                    System.out.println("3. See if Pero is bored");
                    System.out.println("4. Take Pero to the potty");
                }
                case 1: {
                    VirtualPet.timeToEat(VirtualPet.getHungerLvl());
                    if (VirtualPet.isHungry == true) {
                        VirtualPet.eat();
                        choices = 0;
                    }
                    System.out.println("Press 0 to return to the main menu.");
                    choices = input.nextInt();
                    if(choices > 0){
                        System.out.println("You entered the an option that isn't listed. Will be redirecting you back to main menu.");
                        choices = 0;
                    }
                    break;
                }
                case 2: {
                    VirtualPet.timeToDrink(VirtualPet.getThirstLvl());
                    if (VirtualPet.isThirsty) {
                        VirtualPet.drink();
                        choices = 0;
                    }
                    System.out.println("Press 0 to return to the main menu.");
                    choices = input.nextInt();
                    if(choices > 0){
                        System.out.println("You entered the an option that isn't listed. Will be redirecting you back to main menu.");
                        choices = 0;
                    }
                    break;
                }
                case 3: {
                    VirtualPet.timeToPlay(VirtualPet.getBoredLvl());
                    if (VirtualPet.isBored) {
                        VirtualPet.play();
                        choices = 0;
                    }
                    System.out.println("Press 0 to return to the main menu.");
                    choices = input.nextInt();
                    if(choices > 0){
                        System.out.println("You entered the an option that isn't listed. Will be redirecting you back to main menu.");
                        choices = 0;
                    }
                    break;
                }
                case 4: {
                    VirtualPet.timeToPotty(VirtualPet.getPottyLvl());
                    if (VirtualPet.waste) {
                        VirtualPet.potty();
                        choices = 0;
                    }
                    System.out.println("Press 0 to return to the main menu.");
                    choices = input.nextInt();
                    if(choices > 0){
                        System.out.println("You entered the an option that isn't listed. Will be redirecting you back to main menu.");
                        choices = 0;
                    }
                    break;
                }

                case 5: {
                    VirtualPet.timeForAWalk(VirtualPet.getBoredLvl());
                    if (VirtualPet.isBored) {
                        VirtualPet.walk();
                        choices = 0;
                    }
                    System.out.println("Press 0 to return to the main menu.");
                    choices = input.nextInt();
                    if(choices > 0){
                        System.out.println("You entered the an option that isn't listed. Will be redirecting you back to main menu.");
                        choices = 0;
                    }
                    break;
                }
                default: {
                    System.out.println("Please make sure you enter a menu item number.");
                    choices = 0;
                }
            }
        } while(choices == 0);
    }
}

