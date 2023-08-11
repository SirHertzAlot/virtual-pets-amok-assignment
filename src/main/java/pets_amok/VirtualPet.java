package pets_amok;

import java.util.*;

public class VirtualPet {
    String description = " ";
    private static int oilLvl = 0;
    private static int maintenanceLvl = 0;
    static String name = "";
    static String petType = "";
    private static boolean petRobot = false;
    public static TimerTask task;
    static Timer timer = new Timer();
    private static int hungerLvl = 0; //0 is starting point, not hungry. 5 is end point, and very hungry!!
    private static int thirstLvl = 0;
    private static int wasteLvl = 0;
    private static int boredomLvl = 0; //0 is not thirsty. 5 is very thirsty!!
    static boolean isHungry = false;
    static boolean isThirsty = false;
    static boolean isBored = false;
    static boolean needsOil = false;
    private static int feedMe = 2;
    private static int waterMe = 1;
    private static int playWithMe = 2;
    static boolean waste = false;
    private static int healthLvl;
    private static int happiness;

    public VirtualPet(String petName, String petDescription, String petType) {
        this.name = petName;
        this.petType = petType;
        this.petRobot = petRobot;
        this.isHungry = false;
        this.isThirsty = false;
        this.isBored = false;
        this.waste = false;
        this.healthLvl = 10;
        this.happiness = 0;
        this.oilLvl = 0;
        this.maintenanceLvl = 0;
        this.description = petDescription;
    }

    public static int getHungerLvl() {
        return hungerLvl;
    }

    public static int getOilLvl() {
        return oilLvl;
    }

    public static int getMaintenanceLvl() {
        return maintenanceLvl;
    }

    public static int getThirstLvl() {
        return thirstLvl;
    }

    public static int getBoredLvl() {
        return boredomLvl;
    }

    public static int getPottyLvl() {
        return wasteLvl;
    }

    public static int getHealthLvl() {
        return healthLvl;
    }

    public static String getPetType() {
        return petType;
    }

    public static String getName() {
        return VirtualPet.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setPetType(String petType){
        this.petType = petType;
    }

    public static boolean timeToEat(int hungerLvl) {
        if (petRobot) {
            System.out.println("Sorry your pet is a robot and doesn't eat!");
        } else {
            if (getHungerLvl() == 1) {
                System.out.println("looks like your pet is hungry! Hunger level is: " + hungerLvl);
                return isHungry = true;
            } else if (getHungerLvl() > 1 && getHungerLvl() <= 4) {
                System.out.println("Your pet is starving!! Hunger level is: " + hungerLvl);
                return isHungry = true;
            } else if (getHungerLvl() == 5) {
                System.out.println("Your pet is dead. You didn't feed it in time, sorry.. Hunger level is: " + hungerLvl);
                return isHungry = false;
            } else {
                System.out.println("Looks like your pet isn't hungry");
            }
        }

        return isHungry;
    }

    public static boolean timeForOil(int oilLvl) {
        if (!petRobot) {
            System.out.println("This pet doesn't use oil");
        } else {

            if (getOilLvl() == 1) {
                System.out.println("looks like your pet needs oil! Hunger level is: " + oilLvl);
                return needsOil = true;
            } else if (getOilLvl() > 1 && getOilLvl() <= 4) {
                System.out.println("Your pet is rusting!! Hunger level is: " + oilLvl);
                return needsOil = true;
            } else {
                System.out.println("Looks like your pet doesn't need oil.");
            }
        }

        return needsOil;
    }

    public static boolean timeForMaintenance(int maintenanceLvl) {
        if (!petRobot) {
            System.out.println("This pet doesn't use oil");
        } else {

            if (getMaintenanceLvl() == 1) {
                System.out.println("looks like your pet needs maintenance! Maintenance level is: " + maintenanceLvl);
                return needsOil = true;
            } else if (getMaintenanceLvl() > 1 && getMaintenanceLvl() <= 4) {
                System.out.println("Your pet is malfunctioning!! Maintenance level is: " + maintenanceLvl);
                return needsOil = true;
            } else {
                System.out.println("Looks like your pet doesn't need maintenance.");
            }
        }

        return needsOil;
    }

    public static boolean timeToDrink(int thirstLvl) {
        if (petRobot) {
            System.out.println("Sorry your pet is a robot and doesn't need water!");
        } else {
            if (getThirstLvl() == 1) {
                isThirsty = true;
                System.out.println("looks like your pet is thirsty! Thirst level is: " + thirstLvl);
            } else if (getThirstLvl() > 1 && getThirstLvl() <= 4) {
                isThirsty = true;
                System.out.println("Your pet is very thirsty!! Thirst level is: " + thirstLvl);
            } else if (getThirstLvl() == 5) {
                isThirsty = false;
                System.out.println("Your pet is dead. It died of dehydration.. Thirst level is: " + thirstLvl);
            } else {
                System.out.println("Looks like your pet isn't thirsty.");
            }
        }
        return isThirsty;
    }

    public static boolean timeToPlay(int boredomLvl) {
        if (getBoredLvl() == 1) {
            isBored = true;
            System.out.println("Looks like your pet is bored! Boredom level is: " + boredomLvl);
        } else if (getBoredLvl() > 1 && getBoredLvl() <= 4) {
            isBored = true;
            System.out.println("Your pet is so bored it's reading!! Boredom level is: " + boredomLvl);
        } else if (getBoredLvl() == 5) {
            isBored = false;
            System.out.println("Your pet is dead. It died of boredom, sorry.. Boredom level is: " + boredomLvl);
        } else {
            System.out.println("Looks like your pet isn't bored");
        }
        return isBored;
    }

    public static boolean timeForAWalk(int boredomLvl) {
        if (getBoredLvl() == 1) {
            isBored = true;
            System.out.println("Looks like your pet is ready for a walk! Boredom level is: " + boredomLvl);
        } else if (getBoredLvl() > 1 && getBoredLvl() <= 4) {
            isBored = true;
            System.out.println("Your pet is so bored it's reading!! Boredom level is: " + boredomLvl);
        } else if (getBoredLvl() == 5) {
            isBored = false;
            System.out.println("Your pet is dead. It died of boredom, sorry.. Boredom level is: " + boredomLvl);
        } else {
            System.out.println("Looks like your pet isn't bored");
        }
        return isBored;
    }

    public static boolean timeToPotty(int wasteLvl) {
        if (petRobot) {
            System.out.println("Sorry your pet is a robot and doesn't need to potty!");
        } else {
            if (getPottyLvl() >= 1) {
                waste = true;
                System.out.println("Oh, it looks like your pet is ready to use the bathroom! Potty level is: " + wasteLvl);
            } else if (getPottyLvl() == 5) {
                System.out.println("Your pet has died. It needed to use the bathroom very bad and you ignored it. Sorry.");
            } else {
                waste = false;
                System.out.println("Your pet isn't ready to use the potty yet. Potty level is: " + wasteLvl);
            }
        }
        return waste;
    }

    public static int eat() {
        if (isHungry) {
            hungerLvl -= feedMe;
            wasteLvl += hungerLvl;
            happiness += feedMe;
            healthLvl += feedMe;
            System.out.println("Pero is very thankful for the food!");
        } else {
            hungerLvl = hungerLvl;
        }
        return hungerLvl;
    }

    public static int drink() {
        if (isThirsty) {
            thirstLvl -= waterMe;
            wasteLvl += thirstLvl;
            happiness += waterMe;
            healthLvl += waterMe;
            System.out.println("Pero is very thankful for the water!");
        } else {
            thirstLvl = thirstLvl;
        }
        return thirstLvl;
    }

    public static int play() {
        if (isBored) {
            boredomLvl -= playWithMe;
            playWithMe += thirstLvl;
            playWithMe += happiness;
            healthLvl += playWithMe;
            System.out.println("Pero loves to play! He asks to be petted after playing");
        } else {
            boredomLvl = boredomLvl;
        }
        return boredomLvl;
    }

    public static int walk() {
        if (isBored) {
            boredomLvl -= playWithMe;
            playWithMe += thirstLvl;
            playWithMe += happiness;
            wasteLvl -= playWithMe;
            System.out.println(VirtualPet.getName() + " really enjoyed his walk! He also used the potty!");
        } else {
            System.out.println(VirtualPet.getName() + " doesn't need a walk right now.");
            boredomLvl = boredomLvl;
        }
        return boredomLvl;
    }

    public static int potty() {
        if (timeToPotty(wasteLvl)) {
            wasteLvl -= wasteLvl;
            happiness += wasteLvl;
            healthLvl += wasteLvl;
            System.out.println("Pero looks very relieved after using the potty!");
        } else {
            wasteLvl = wasteLvl;
        }
        return wasteLvl;
    }

    public static int oil() {
        if (timeForOil(oilLvl)) {
            oilLvl++;
            happiness += wasteLvl;
            healthLvl += wasteLvl;
            System.out.println("Pero looks very relieved after using the potty!");
        } else {
            oilLvl = oilLvl;
        }
        return oilLvl;
    }

    public static int maintenance() {
        if (timeForMaintenance(maintenanceLvl)) {
            maintenanceLvl++;
            happiness += wasteLvl;
            healthLvl += wasteLvl;
            System.out.println("Pero looks very relieved after using the potty!");
        } else {
            maintenanceLvl = maintenanceLvl;
        }
        return maintenanceLvl;
    }

    public static void tick() {
        task = new TimerTask() {
            public void run() {
                for (int i = 0; i < 1; i++) {
                    hungerLvl++;
                    thirstLvl++;
                    boredomLvl++;

                    if (hungerLvl < 1 || thirstLvl < 1 || boredomLvl < 1 || wasteLvl < 1) {
                        happiness -= hungerLvl;
                        healthLvl--;
                    }

                    if (getThirstLvl() == 5 || getHungerLvl() == 5 || getBoredLvl() == 5 || getPottyLvl() == 5) {
                        this.cancel();
                        System.out.println("Game over! See you next time!");
                        System.exit(0);
                    }
                }
            }

            ;
        };

        timer.scheduleAtFixedRate(task, 120000, (1000 * 60) * 4);
    }


}
