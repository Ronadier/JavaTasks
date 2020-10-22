package Helpers;

public class GoHelper {
  public static Integer[][] goHuman(Integer[] gameFieldHorizont, Integer[][] gameFieldAll, int move){
    for (int i = 0;i<gameFieldHorizont.length;i++){
      for (int j = 0;j<gameFieldAll.length;j++) {
        if (gameFieldAll[i][j] == move) {
          gameFieldAll[i][j] = 99;
        }
        if (gameFieldAll[i][j] == 99) System.out.print("X ");
        else System.out.print(gameFieldAll[i][j] + " ");
      }
      System.out.println();
    }
    return gameFieldAll;
  }

  public static Integer[][] goCompLight(Integer[] gameFieldHorizont, Integer[][] gameFieldAll){
    int min = gameFieldAll[2][2];
    for (int i = 0;i<gameFieldHorizont.length;i++){
      for (int j = 0;j<gameFieldAll.length;j++) {
        if (min > gameFieldAll[i][j] && gameFieldAll[i][j]!=0) min = gameFieldAll[i][j];
      }
    }
    for (int i = 0;i<gameFieldHorizont.length;i++){
      for (int j = 0;j<gameFieldAll.length;j++) {
        if (min == gameFieldAll[i][j]) gameFieldAll[i][j] = 0;
      }
    }
    for (int i = 0;i<gameFieldHorizont.length;i++){
      for (int j = 0;j<gameFieldAll.length;j++) {
        if (gameFieldAll[i][j] == 99) System.out.print("X ");
        else System.out.print(gameFieldAll[i][j] + " ");
      }
      System.out.println();
    }
    return gameFieldAll;
  }
}
