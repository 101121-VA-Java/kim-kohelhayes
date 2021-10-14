public class calculater {
  public static void main(String[] args) {
    int a = 1;
    int b = 2;
    double c = 3;
    double d = 1;
    int e = add(a, b);
    System.out.println(e);
    int f = subtract(a,b);
    System.out.println(f);
    double g = multiply(a,b);
    System.out.println(g);
    int h = remainder(a,b);
    System.out.println(h);
    String dayOfTheWeek1 = "Tuesday";
    String day = weekday(dayOfTheWeek1);
    countdown(5);
    greeting("Kevuda");
  
  }
  public static int add(int a, int b) {
    return a+b;
  }
  public static int subtract(int a, int b) {
    return a-b;
  }
  public static double multiply(double a, double b) {
    return a*b;
  }
  public static int remainder(int a, int b) {
    return a%b;
  }
  public static String weekday(String weekday) {
    String day = "";
    switch(weekday) {
      case "Monday": 
        day = "Monday, Oh No!"; 
      break;
      case "Tuesday": 
        day = "Tuesday, Oh Well"; 
      break;
      case "Wednesday": 
        day = "Wednesday, Hump Day!"; 
      break;
      case "Thursday": 
        day = "Thursday, Almost There!"; 
      break;
      case "Friday": 
        day = "Friday, TGIF!!!"; 
      break;
      default: day = "Today is a WEEKEND day!!!!"; 
      break;
    }
    System.out.println(day);
    return day;
  }
  public static void countdown(int i) { 
    while(i>0){
      System.out.println("Learning Java is fun!");
      i--;
    }
  }

  public static void greeting(String name) { 
    System.out.println("Hello " + name);
  }

}