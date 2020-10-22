package Helpers;

public class InitHelper {
  public static Integer[] initArr1(){
    Integer[] a = new Integer[3];
    return a;
  }

  public static Integer[][] initArr2(Integer[] a){
    int u=1;
    Integer[][] b = new Integer[a.length][3];
    for (int i = 0;i<a.length;i++){
      for (int j = 0;j<b.length;j++) {
        b[i][j] = u;
        u++;
        System.out.print(b[i][j] + " ");
      }
      System.out.println();
    }
    return b;
  }
}
