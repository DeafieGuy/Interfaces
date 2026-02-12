// BigRectLister.java
import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {

    public static void main(String[] args) {
        ArrayList<Rectangle> rects = new ArrayList<>();

        // 10 rectangles with a mix of small and large perimeters
        rects.add(new Rectangle(0, 0, 1, 1)); // perimeter 4
        rects.add(new Rectangle(0, 0, 2, 1)); // perimeter 6
        rects.add(new Rectangle(0, 0, 3, 1)); // perimeter 8
        rects.add(new Rectangle(0, 0, 3, 2)); // perimeter 10
        rects.add(new Rectangle(0, 0, 4, 2)); // perimeter 12
        rects.add(new Rectangle(0, 0, 5, 1)); // perimeter 12
        rects.add(new Rectangle(0, 0, 6, 0)); // perimeter 12
        rects.add(new Rectangle(0, 0, 2, 4)); // perimeter 12
        rects.add(new Rectangle(0, 0, 7, 3)); // perimeter 20
        rects.add(new Rectangle(0, 0, 0, 6)); // perimeter 12

        Filter filter = new BigRectangleFilter();

        System.out.println("Rectangles with perimeter > 10:");
        for (Rectangle r : rects) {
            if (filter.accept(r)) {
                double perimeter = 2.0 * (r.getWidth() + r.getHeight());
                System.out.printf("  %s  -> perimeter = %.1f%n", r.toString(), perimeter);
            }
        }
    }
}
