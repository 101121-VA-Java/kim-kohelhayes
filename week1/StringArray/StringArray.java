import java.util.*; 

public class StringArray{
  public static void main(String[] args){
    String[] macGroup = {"Albert", "Alex", "Andre", "Brayden", "Gerardo", "Kim"};

    String[] reversedMacGroup = reversal(macGroup);

    for( int a = 0; a < macGroup.length; a++){
      System.out.print(macGroup[a] + ", ");
    }
      System.out.println("");
    for( int b = 0; b < macGroup.length; b++){
      System.out.print(reversedMacGroup[b] + ", ");
    }

  }
    public static String[] reversal(String[] macGroup) {
      String[] reversedMacGroup = new String[6];
      reversedMacGroup = new String[macGroup.length];
      int i = macGroup.length;
      int j = 0;
      while( i > 0)
      {
        reversedMacGroup[j] = macGroup[i-1];
        i--;
        j++;
      }
      return reversedMacGroup;
    }
}