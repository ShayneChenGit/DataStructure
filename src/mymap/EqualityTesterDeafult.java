package mymap;

public class EqualityTesterDeafult implements IEqualityTester {
    public EqualityTesterDeafult() {
    }

    @Override
    public boolean isEqualTo(Object a, Object b) {
        return a.equals(b);
    }
}
