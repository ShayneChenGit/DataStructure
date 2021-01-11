package mymap;

public class EntryDefault implements IEntry{
    protected Object key;
    protected Object value;

    public EntryDefault(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Object getKey() {
        return key;
    }

    @Override
    public Object setKey(Object key) {
        Object oldKey = this.key;
        this.key = key;
        return oldKey;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public Object setValue(Object value) {
        Object oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
