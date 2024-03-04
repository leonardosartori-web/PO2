package tinyjdk;

public class ArrayList<T> implements List<T> {

    private Object[] a;
    private int sz;

    public ArrayList() {
        this.a = new Object[10];
    }

    @Override
    public void add(T x) {
        if (sz >= a.length) {
            Object[] old = a;
            a = new Object[a.length * 2];
            for (int i = 0; i < old.length; ++i) {
                a[i] = old[i];
            }
        }
        a[sz++] = x;
    }

    @Override
    public void clear() {
        sz = 0;
    }

    @Override
    public boolean contains(T x) {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T o = it.next();
            if (x.equals(o)) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return sz == 0;
    }

    @Override
    public void remove(T x) {
        Iterator<T> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            T o = it.next();
            i++;
            if (x.equals(o)) {
                while (i < size() - 1) {
                    set(i, get(i + 1));
                }
                sz--;
            }
        }
    }

    @Override
    public int size() {
        return sz;
    }


    /*
    private class MyIterator implements Iterator<T> {

        private int pos = 0;

        @Override
        public boolean hasNext() {
            return (pos < size());
        }

        @Override
        public T next() {
            return get(pos++);
        }

    }  */


    /*


    private static class MyIterator<T> implements Iterator<T> {

        private int pos = 0;
        private ArrayList<T> enclosing;

        public MyIterator(ArrayList<T> a) {
            this.enclosing = a;
        }

        @Override
        public boolean hasNext() {
            return pos < enclosing.size();
        }

        @Override
        public T next() {
            return enclosing.get(pos++);
        }
    }

     */


    @Override
    public Iterator<T> iterator() {
        // return new ArrayListIterator<T>(this);
        // return new MyIterator<>(this);

        //int pos = 0; // L'anonymous class vede questa variabile

        return new Iterator<T>() {

            private int pos = 0;

            @Override
            public boolean hasNext() {
                return (pos < size());
            }

            @Override
            public T next() {
                return get(pos++);
            }

        };
    }

    @Override
    public T get(int i) {
        if (i < sz) return (T) a[i];
        throw new RuntimeException(String.format("ArrayList.get(): index out of bound"));
    }

    @Override
    public T set(int i, T x) {
        if (i < sz) {
            T old = get(i);
            a[i] = x;
            return old;
        }
        throw new RuntimeException(String.format("ArrayList.set(): index out of bound"));
    }

    @Override
    public void add(int i, T x) {

    }

    @Override
    public void remove(int i) {

    }
}
