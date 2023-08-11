package pets_amok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class VirtualPetTest {

    @Test
    public void addPetToShelter() {
        VirtualPetShelter underTest = new VirtualPetShelter();
        Map shelter = VirtualPetShelter.shelter;

        VirtualPet pet1 = new VirtualPet("Perro", "This is the puppy named Perro.", "Dog");
        underTest.addPet(pet1);

        VirtualPet pet2 = new VirtualPet("PawPaw", "PawPaw is a robo-puppy!", "Dog");
        underTest.addPet(pet2);

        System.out.println(shelter.containsKey("Perro"));
    }

    @Test
    public void tryToOilOrganicPet() {
        VirtualPetShelter vps = new VirtualPetShelter();

        Map shelter = VirtualPetShelter.shelter;

        VirtualPet pet1 = new VirtualPet("Perro", "This is the puppy named Perro.", "Dog");
        vps.addDog(pet1);

        VirtualPet pet2 = new VirtualPet("PawPaw", "PawPaw is a robo-puppy!", "Dog");
        vps.addCat(pet2);

        pet2.oil();
    }

    @Test
    public void tryToFeedRobotPet() {
        VirtualPetShelter vps = new VirtualPetShelter();

        Map shelter = VirtualPetShelter.shelter;

        VirtualPet pet1 = new VirtualPet("Perro", "This is the puppy named Perro.", "Dog");
        vps.addDog(pet1);

        VirtualPet pet2 = new VirtualPet("PawPaw", "PawPaw is a robo-puppy!", "Dog");
        vps.addCat(pet2);

        pet2.timeToEat(pet2.getHungerLvl());
    }

    @Test
    public void walkAllDogs() {
        VirtualPetShelter vps = new VirtualPetShelter();

        Map shelter = VirtualPetShelter.shelter;

        VirtualPet pet1 = new VirtualPet("Perro", "This is the puppy named Perro.", "Dog");
        vps.addDog(pet1);

        VirtualPet pet2 = new VirtualPet("PawPaw", "PawPaw is a robo-puppy!", "Dog");
        vps.addCat(pet2);

        VirtualPet pet3 = new VirtualPet("Barksdale", "Mr. Barksdale, the biggest bark in the room.", "Dog");
        vps.addCat(pet3);

        vps.walkAllDogs();
    }

    @Test
    public void shouldReturnAllPets() {
        VirtualPetShelter vps = new VirtualPetShelter();

        Map shelter = VirtualPetShelter.shelter;

        VirtualPet pet1 = new VirtualPet("Perro", "This is the puppy named Perro.", "Dog");
        vps.addDog(pet1);

        VirtualPet pet2 = new VirtualPet("PawPaw", "PawPaw is a robo-puppy!", "Dog");
        vps.addCat(pet2);

        VirtualPet pet3 = new VirtualPet("Barksdale", "Mr. Barksdale, the biggest bark in the room.", "Dog");
        vps.addCat(pet3);

        vps.returnAllPets();
    }

}
