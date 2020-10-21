package Task7;

public class GoHelper {
  static Integer[][] goHuman(Integer[] a, Integer[][] b, int c){
    for (int i = 0;i<a.length;i++){
      for (int j = 0;j<b.length;j++) {
        if (b[i][j] == c) {
          b[i][j] = 99;
        }
        if (b[i][j] == 99) System.out.print("X ");
        else System.out.print(b[i][j] + " ");
      }
      System.out.println();
    }
    return b;
  }

  static Integer[][] goComp(Integer[] a, Integer[][] b){
    int min = b[2][2];
    for (int i = 0;i<a.length;i++){
      for (int j = 0;j<b.length;j++) {
        if (min > b[i][j] && b[i][j]!=0) min = b[i][j];
      }
    }
    for (int i = 0;i<a.length;i++){
      for (int j = 0;j<b.length;j++) {
        if (min == b[i][j]) b[i][j] = 0;
      }
    }
    for (int i = 0;i<a.length;i++){
      for (int j = 0;j<b.length;j++) {
        if (b[i][j] == 99) System.out.print("X ");
        else System.out.print(b[i][j] + " ");
      }
      System.out.println();
    }
    return b;
  }
}
