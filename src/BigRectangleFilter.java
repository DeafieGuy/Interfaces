// BigRectangleFilter.java
import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {

    @Override
    public boolean accept(Object x) {
        if (x == null) return false;
        if (!(x instanceof Rectangle)) return false;
        Rectangle r = (Rectangle) x;
        double perimeter = 2.0 * (r.getWidth() + r.getHeight());
        return perimeter > 10.0;
    }
}
