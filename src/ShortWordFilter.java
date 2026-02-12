// ShortWordFilter.java
public class ShortWordFilter implements Filter {

    @Override
    public boolean accept(Object x) {
        if (x == null) return false;
        if (!(x instanceof String)) return false;
        String s = (String) x;
        return s.length() < 5;
    }
}
