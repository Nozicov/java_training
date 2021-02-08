package kz.nee.sandbox;

public class MyOneProgram {


  public static void main(String[] args) {
    /*  Координаты первой точки */
    double x0 = -7;
    double y0 = 8.5;
    Point p0 = new Point(x0, y0);

    /*  Координаты второй точки */
    double x1 = 5.5;
    double y1 = 10;
    Point p1 = new Point(x1, y1);

    /*Вывод результата длины линии*/
    System.out.println("Вычисление расстояния между двумя точками равно: " + distance(p0, p1) + ". Задание 2, пункт 3");

    System.out.println("Вычисление расстояния между двумя точками равно: " + p0.distance(p1) + ". Задание 2, пункт 4");

  }

  /* Задание 2, пункт 2 */
  public static double distance(Point p0, Point p1){
    double lenX = p1.x - p0.x;
    double lenY = p1.y - p0.y;
    return Math.sqrt(lenX*lenX + lenY*lenY);
  }

}