import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CoffeeMachine user = new CoffeeMachine();
        while (true){
            try {
                System.out.println("Welcome to Kingsley Coffee maker!");
                System.out.println("Choose what coffee you want:(cappuccino, latte, espresso)");
                String coffee = input.nextLine().toLowerCase();
                if (coffee == "admin") {
                    admin(user);
                } else if (coffee == "cappuccino") {

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
                        "\n2).money made, 3).restock");
                String choice = input.nextLine().toLowerCase();
                if (choice.equals("1")) {
                    user.remIngredients();
                } else if (choice.equals("2")) {
                    System.out.println("Total money made is $" + user.getMoney());
                } else if (choice.equals("3")) {
                    System.out.println("Still in working progress");
                } else {
                    System.out.println("Invalid choice " + choice);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
    public static void cappuccino(CoffeeMachine user) {
        if ((user.getCoffee() >= 8) && (user.getWater() >= 30)) {
            user.setWater(user.getCoffee() - 8);
            user.setMoney(user.getWater() - 30);
            user.setMoney(user.getMoney() + 30.0);
        } else {
            System.out.println("Insufficient resources");
        }
    }

    public static void latte(CoffeeMachine user) {

    }

    public static void espresso(CoffeeMachine user) {

    }

    public static void calMoney(CoffeeMachine user) {

    }
}
