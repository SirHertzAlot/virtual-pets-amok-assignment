package pets_amok;

import java.sql.SQLOutput;
import java.util.Scanner;


public class VirtualPetShelterApp {
    public static void main(String[] args) throws Exception {

        VirtualPetShelter vps = new VirtualPetShelter();

        VirtualPet pet1 = new VirtualPet("Perro", "This is the puppy named Perro.", "Dog");
        vps.addDog(pet1);

        VirtualPet pet2 = new VirtualPet("PawPaw", "PawPaw is a robo-puppy!", "Dog");
        vps.addDog(pet2);

        VirtualPet pet3 = new VirtualPet("Barksdale", "Mr. Barksdale, the biggest bark in the room.", "Dog");
        vps.addDog(pet3);

        Scanner input = new Scanner(System.in);
        int choices = 0;

        do {
            VirtualPet.tick();
            System.out.println("Thank you for volunteering at the puppy palace!");
            System.out.println("This is the status of all our pets!");

            VirtualPetShelter.returnAllPets();

            System.out.println("What would you like to do?");
            System.out.println("1. Feed the pets");
            System.out.println("2. Water the pets");
            System.out.println("3. Play with the pets");
            System.out.println("4. Adopt a pet");
            System.out.println("5. Admit a pet (Put pet in shelter)");
            System.out.println("0. To return to the main menu");

            choices = input.nextInt();

            switch (choices) {
                case 0: {
                    System.out.println("Thank you for volunteering at the puppy palace!");
                    System.out.println("This is the status of all our pets!");

                    System.out.println("What would you like to do?");
                    System.out.println("1. Feed the pets");
                    System.out.println("2. Water the pets");
                    System.out.println("3. Play with the pets");
                    System.out.println("4. Adopt a pet");
                    System.out.println("5. Admit a pet (Put pet in shelter)");
                    System.out.println("0. To return to the main menu");
                }
                case 1: {

                    if (VirtualPet.isHungry == true) {
                        VirtualPetShelter.feedAllPets();
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
                        VirtualPetShelter.waterAllDogs();
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
                        VirtualPetShelter.playWithAllPets();
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
                    System.out.println("Please enter the name of the pet you would like to adopt.");
                    VirtualPetShelter.returnAllPets();
                    String name = input.nextLine();

                    VirtualPetShelter.adoptAPet(VirtualPetShelter.getPetByName(name));

                    System.out.println("Press 0 to return to the main menu.");
                    choices = input.nextInt();
                    if(choices > 0){
                        System.out.println("You entered the an option that isn't listed. Will be redirecting you back to main menu.");
                        choices = 0;
                    }
                    break;
                }

                case 5: {
                    System.out.println("Would like to leave your pet with us?");
                    System.out.println("Alright, let's go ahead get pet's name first.");

                    String petName = input.nextLine();

                    System.out.println("Our shelter only accepts doggies! Can you tell me a little about your pet?");
                    String petDescription = input.nextLine();

                    VirtualPet newlyAddedPet = new VirtualPet(petName, petDescription, "Dog");

                    VirtualPetShelter.addPet(newlyAddedPet);

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
