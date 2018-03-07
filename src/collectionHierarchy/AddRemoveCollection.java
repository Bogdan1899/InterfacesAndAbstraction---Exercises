package collectionHierarchy;

import collectionHierarchy.interfaces.Removable;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AddRemoveCollection<T> extends AddCollection<T> implements Removable{

    public AddRemoveCollection(Class<T> classType) {
        super(classType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public int add(T element) {
        T[] newArr = (T[]) Array.newInstance(super.getClassType(), super.getInternalArray().length + 1);
        newArr[0] = element;
        System.arraycopy(super.getInternalArray(), 0, newArr, 1, newArr.length - 1);
        super.setInternalArray(newArr);
        super.setCurrentIndex(super.getCurrentIndex() + 1);
        return 0;
    }

    @Override
    public T remove() {
        T elementToRemove = super.getInternalArray()[super.getCurrentIndex() - 1];
        super.setInternalArray(Arrays.copyOf(super.getInternalArray(), super.getInternalArray().length - 1));
        super.setCurrentIndex(super.getCurrentIndex() - 1);
        return elementToRemove;
    }
}
