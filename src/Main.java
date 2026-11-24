import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CoffeeMachine user = new CoffeeMachine();
        while (true){
            try {
                System.out.println("Welcome to Kingsley Coffee maker!");
                System.out.println("Choose what coffee you want:(cappuccino, latte, espresso)");
                String coffee = input.nextLine();
                if (Objects.equals(coffee, "admin")) {
                    admin(user);
                } else if (Objects.equals(coffee, "cappuccino")) {
                    cappuccino(user);
                } else if (Objects.equals(coffee, "latte")) {
                    latte(user);
                } else if (Objects.equals(coffee, "espresso")) {
                    espresso(user);
                } else {
                    System.out.println("wrong input");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
    public static void admin(CoffeeMachine user) {
        Scanner input = new Scanner(System.in);
        while (true){
            try {
                System.out.println("You are an administrative coffee maker!");
                System.out.println("What do you want to check out: 1).ingredients remaining" +
                        "\n2).money made, 3).restock, 4).EXIT");
                String choice = input.nextLine().toLowerCase();
                if (choice.equals("1")) {
                    user.remIngredients();
                    continue;
                } else if (choice.equals("2")) {
                    System.out.println("Total money made is $" + user.getMoney());
                    continue;
                } else if (choice.equals("3")) {
                    System.out.println("Still in working progress");
                    continue;
                } else if (choice.equals("4")) {
                    System.out.println("Exiting admin site...");
                } else {
                    System.out.println("Invalid choice " + choice);
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
    public static boolean checkCappuccino(CoffeeMachine user) {
        return ((user.getCoffee() >= 8) && (user.getWater() >= 30));
    }
    public static void cappuccino(CoffeeMachine user) {
        if (checkCappuccino(user)) {
            if (calcMoney(user.getMoney())) {
                user.setWater(user.getCoffee() - 8);
                user.setMoney(user.getWater() - 30);
                user.setMoney(user.getMoney() + 30.0);
                System.out.println("Here is your cappuccino");
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Insufficient resources to make the cappuccino");
        }
    }

    public static void latte(CoffeeMachine user) {
        if (checkCappuccino(user)) {
            if (calcMoney(user.getMoney())) {
                user.setMilk(user.getMilk() - 25);
                user.setSugar(user.getSugar() + 10);
                user.setMoney(user.getMoney() + 75.0);
                System.out.println("Here is your latte");
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("You dont have enough resources to make a latte");
        }

    }

    public static void espresso(CoffeeMachine user) {
        if (checkCappuccino(user)) {
            if (calcMoney(user.getMoney())) {
                user.setMilk(user.getMilk() - 10);
                user.setSugar(user.getSugar() - 10);
                user.setMoney(user.getMoney() + 50.0);
                System.out.println("here is your espresso");
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("You dont have enough resources to make an espresso");
        }

    }

    public static boolean calcMoney(double price) {
        Scanner input = new  Scanner(System.in);
        System.out.println("How many penny do you have: ");
        String SPenny = input.nextLine();
        float penny = Float.parseFloat(SPenny);
        System.out.println("How many Nickel do you have: ");
        String SNickel = input.nextLine();
        float nickel = Float.parseFloat(SNickel);
        System.out.println("How many Dime do you have: ");
        String SDime = input.nextLine();
        float dime = Float.parseFloat(SDime);
        System.out.println("How many Quarter do you have: ");
        String SQuarter = input.nextLine();
        float quarter = Float.parseFloat(SQuarter);
        float sum = (penny * 0.01f) + (nickel * 0.05f) + (dime * 0.10f) + (quarter * 0.25f);
        System.out.println("The total paid is : $" + sum);
        float change;
        if (sum > price) {
            change = (float) (sum - price);
            System.out.println("Your change is : $" + change);
            return true;
        } else return sum == price;

    }
}
