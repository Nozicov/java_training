package kz.nee.sandbox;

/* Задание 2, пункт 1 */
public class Point {

  public double x;
  public double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double distance(Point p){
    double lenX = p.x - this.x;
    double lenY = p.y - this.y;
    return Math.sqrt(lenX*lenX + lenY*lenY);
  }

}
