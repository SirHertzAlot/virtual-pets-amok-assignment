package pets_amok;

import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
    static Map<String, VirtualPet> shelter = new HashMap<String, VirtualPet>();

    public static void timeToEat(int hungerLvl) {
        shelter.forEach((key, value) -> {
            VirtualPet obj = shelter.get(key);
            obj.walk();
        });
    }

    public static VirtualPet getPetByName(String name) {
        return shelter.get(name);
    }

    public static void addPet(VirtualPet virtualPetToAdd) {
        shelter.put(VirtualPet.getName(), virtualPetToAdd);
    }

    public static void adoptAPet(VirtualPet virtualPetToAdopt) {
        shelter.remove(VirtualPet.getName(), virtualPetToAdopt);
    }

    public static void addDog(VirtualPet virtualDogToAdd) {
        shelter.put(VirtualPet.getName(), virtualDogToAdd);
    }

    public void addCat(VirtualPet virtualCatToAdd) {
        shelter.put(VirtualPet.getName(), virtualCatToAdd);
    }

    public void mainAllRobots() {
        if (VirtualPet.needsOil) {
            VirtualPet.oil();
            System.out.println("Looks like your pet really appreciates the oil.");
        } else {
            System.out.println("Looks like your pet doesn't need any oil or maintenance.");
        }
    }

    public static void walkAllDogs() {
        shelter.forEach((key, value) -> {
            VirtualPet obj = shelter.get(key);
            obj.walk();
        });
    }

    public static void waterAllDogs() {
        shelter.forEach((key, value) -> {
            VirtualPet obj = shelter.get(key);
            obj.drink();
        });
    }

    public static void playWithAllPets() {
        shelter.forEach((key, value) -> {
            VirtualPet obj = shelter.get(key);
            obj.play();
        });
    }

    public static void feedAllPets() {
            shelter.forEach((key, value) -> {
                VirtualPet obj = shelter.get(key);
                obj.eat();
            });
    }

    public static void returnAllPets() {
        shelter.forEach((key, value) -> {
            System.out.println("Pet name: " + key + " Hunger: " + VirtualPet.getHungerLvl() + " Thirst: " + VirtualPet.getThirstLvl() + " Boredom: " + VirtualPet.getBoredLvl());
        });
    }
}
