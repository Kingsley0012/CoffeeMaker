public class CoffeeMachine {
    private int coffee = 100;
    private int water = 1000;
    private int milk = 500;
    private int sugar = 100;
    private double money;

    public void remIngredients() {
        System.out.println("coffee :" + coffee + "g");
        System.out.println("water :" + water + "ml");
        System.out.println("milk :" + milk + "ml");
        System.out.println("sugar :" + sugar + "g");
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
}
