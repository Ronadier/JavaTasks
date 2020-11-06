public class Task1Day23 {
  public static void main(String[] args) {

  }

  static class pistol{
    private int bullets = 15;
    private int magazins = 10; //и не важно, что magazin - журнал. И так понятно :)

    public int getBulletsAmount() {
      return bullets;
    }

    public int getMagazinsAmount() {
      return magazins;
    }

    public void reload(int magazins) {
      this.magazins = magazins-1;
      this.bullets = 15;
    }

    public void takeAShot(int bullets, int magazins) throws OutOfMagazins{
      if (bullets!=0){
        this.bullets = bullets-1;
      } else if (magazins != 0){
        reload(magazins);
        this.bullets = bullets -1;
      }
    }
  }

  static class OutOfMagazins extends Exception{
    void print(){
      System.out.println("Ну тут уже наши полномочия всё. Магазины кончились.");
    }
  }
}

/*
Сегодня пишем класс-пистолет :)

У объекта этого класса есть следующие публичные методы:

getMagazinsAmount() - возвращает количество магазинов. Изначально к пистолету дается 10 магазинов. Каждый магазин имеет 15 патронов.
getBulletsAmount() - возвращает количество патронов к пистолету. Изначально у пистолета 10 * 15 = 150 патронов.

takeAShot() - делаем выстрел. Если в магазине есть пули, становится на одну меньше. Если нет, сначала автоматически дергается функция reload(), затем происходит выстрел.
reload() - вставляем новый магазин в пистолет. Старый магазин выбрасывается вместе с пулями, если они в нем остались. Если у нас больше нет магазинов, кидается исключения OutOfMagazins()

 */