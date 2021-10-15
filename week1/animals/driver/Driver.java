package animals.driver;

import animals.models.Cat;
import animals.models.Dog;

public class Driver{
  public static void main(String[] args){

    Cat freckles = new Cat("Freckles", "American Shorthair", 5, false, "Tabby");

    Dog daFreise = new Dog("Da Freise", "Bichone Frise", 2, true, "White");

    System.out.println(freckles.name + "  is a " + freckles.age + " year old " + freckles.color + " " + freckles.breed + ".");
    System.out.println(daFreise.name + "  is a " + daFreise.age + " year old " + daFreise.color + " " + daFreise.breed + ".");
  }
}
