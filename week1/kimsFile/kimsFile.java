class kimsFile {

  public static void main(String[] args) {
    System.out.println("This is Kim's Wednesday File.");


    int alpha = 20;
    int gamma = 20;
    int j = 0;

    if(gamma==alpha){
      System.out.println("Gamma is: " + alpha);
    }
    for(int i = 30; i > gamma; i--){
      System.out.println("i is: " + i);
    }
    
    do{
      System.out.println("Kim is learning Java");
      j++;
    }while(j<5);
  }
}
