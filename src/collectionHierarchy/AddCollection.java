package collectionHierarchy;

import collectionHierarchy.interfaces.Addable;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AddCollection<T> implements Addable<T>{

    private static final int DEFAULT_CAPACITY = 10;

    private static final int DEFAULT_INDEX = 0;

    private Class<T> classType;

    private T[] internalArray;

    private int currentIndex;

    @SuppressWarnings("unchecked")
    public AddCollection(Class<T> classType) {
        this.setClassType(classType);
        this.setInternalArray((T[]) Array.newInstance(classType, DEFAULT_CAPACITY));
        this.setCurrentIndex(DEFAULT_INDEX);
    }

    public Class<T> getClassType() {
        return classType;
    }

    public void setClassType(Class<T> classType) {
        this.classType = classType;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    protected void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public T[] getInternalArray() {
        return internalArray;
    }

    public void setInternalArray(T[] internalArray) {
        this.internalArray = internalArray;
    }

    @Override
    public int add(T element) {
        this.resize();
        internalArray[this.currentIndex++] = element;
        return this.currentIndex - 1;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        if (currentIndex == internalArray.length){
            internalArray = Arrays.copyOf(internalArray, internalArray.length * 2);
        }
    }
}
