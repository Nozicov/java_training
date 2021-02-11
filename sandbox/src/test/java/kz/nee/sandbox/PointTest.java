package kz.nee.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testPoint(){
    /*  Координаты первой точки */
    double x0 = 0;
    double y0 = 0;
    Point p0 = new Point(x0, y0);

    /*  Координаты второй точки */
    double x1 = 0;
    double y1 = 0;
    Point p1 = new Point(x1, y1);

    /*Известный результат*/
    double result = 0;

    /*Сравнение вычесленного результата классом с эталонным результатом*/
    Assert.assertEquals(p0.distance(p1), result);
  }

  @Test
  public void testPoint2(){
    /*  Координаты первой точки */
    double x0 = 5;
    double y0 = 7;
    Point p0 = new Point(x0, y0);

    /*  Координаты второй точки */
    double x1 = 5;
    double y1 = 7;
    Point p1 = new Point(x1, y1);

    /*Известный результат*/
    double result = 0;

    /*Сравнение вычесленного результата классом с эталонным результатом*/
    Assert.assertEquals(p0.distance(p1), result);
  }
  
}

