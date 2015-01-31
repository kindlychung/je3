package com.company;

/**
 * Created by IDEA on 27/01/15.
 */
public class IntList implements Comparable {

    protected int[] data;
    protected int size;
    private static final int DEFAULT_CAPACITY = 8;

    public IntList() { this(DEFAULT_CAPACITY); }

    public IntList(int initialCapacity) {
        data = new int[initialCapacity];
    }

    public IntList(IntList original) {
        this.data = (int[]) original.data.clone();
        this.size = original.size;
    }

    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        return data[index];
    }

    public void set(int index, int value) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
    }

    public void trim() { setCapacity(size); }

    public void clear() { size = 0; }

    // Return a copy, because this.data should not be exposed.
    public int[] toArray() {
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }

    public void add(int value) {
        if(size == data.length) setCapacity(size * 2);
        data[size++] = value;
    }


    public int getSize() {
        return size;
    }

    protected void setCapacity(int n) {
        assert (n >= size) : (n + "<" + size);
        if(n == data.length) return;
        // Just set capacity to n, everything else is the same
        int[] newData = new int[n];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public int compareTo(Object o) {
        IntList that = (IntList) o;
        int n = Math.min(this.size, that.size);
        for(int i = 0; i < n; i++) {
            if(this.data[i] < that.data[i]) return -1;
            if(this.data[i] > that.data[i]) return 1;
        }
        return this.size - that.size;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("[");
        for(int i = 0; i < size; i++) {
            // Don't put a comma before the first element
            if(i > 0) {
                b.append(", ");
            }
            // New line after 8 elements
            if(i % 8 == 0) {
                b.append('\n');
            }
            b.append(data[i]);
        }
        b.append(']');
        return b.toString();
    }


    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof IntList)) return false;
        IntList that = (IntList) o;
        if(this.size != that.size) return false;
        for(int i = 0; i < this.size; i++) {
            if(this.data[i] != that.data[i]) return false;
        }
        return true;
    }

    public int hashCode() {
        int code = 1;
        for(int i = 0; i < size; i++) {
            code = code * 997 + data[i];
        }
        return code;
    }

    public static int[] concatArrays(int[] a1, int[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        if(n1 == 0) return a2;
        if(n2 == 0) return a1;

        int n = n1 + n2;
        int counter = 0;
        int[] result = new int[n];
        for(; counter < n1; counter++) {
            result[counter] = a1[counter];
        }
        for(; counter < n; counter++) {
            result[counter] = a2[counter - n1];
        }
        return result;
    }

    public static int[] concatArrays(int[] a1, int a2) {
        int[] a2New = new int[] {a2};
        return concatArrays(a1, a2New);
    }



    public static int[] sort(int[] data) {
        if(data.length == 0) return new int[0];
        int nBefore = 0;
        int nAfter = 0;
        int[] beforeArray = new int[data.length];
        int[] afterArray  = new int[data.length];
        for(int i = 1; i < data.length; i++) {
            if(data[i] < data[0]) {
                beforeArray[nBefore++] = data[i];
            }
            else {
                afterArray[nAfter++] = data[i];
            }
        }
        int[] beforeArrayTrimmed = new int[nBefore];
        int[] afterArrayTrimmed = new int[nAfter];
        System.arraycopy(beforeArray, 0, beforeArrayTrimmed, 0, nBefore);
        System.arraycopy(afterArray, 0, afterArrayTrimmed, 0, nAfter);
        return concatArrays(
                concatArrays(sort(beforeArrayTrimmed), data[0]),
                sort(afterArrayTrimmed)
        );
    }

    public void sortInPlace() {
        int[] sorted = IntList.sort(this.toArray());
        System.arraycopy(sorted, 0, data, 0, size);
    }

    public static class Test {
        public static void main(String[] args) {
            int[] a1 = new int[] {4, 1, 2, 5};
//            int[] a2 = new int[] {5};
            int[] a2 = new int[] {};
            int[] a = concatArrays(a1,  a2);
            int[] a1Sorted = sort(a1);
            for(int i : a1Sorted) {
                System.out.println(i);
            }

            IntList x = new IntList();
            x.add(5);
            x.add(99);
            x.add(72);
            x.add(1);
            System.out.println(x);
            x.sortInPlace();
            System.out.println(x);
        }
    }

}


