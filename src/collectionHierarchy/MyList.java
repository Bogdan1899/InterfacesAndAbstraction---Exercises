package collectionHierarchy;

import collectionHierarchy.interfaces.Usable;

import java.util.Arrays;

public class MyList<T> extends AddRemoveCollection<T> implements Usable {


    public MyList(Class<T> classType) {
        super(classType);
    }

    @Override
    public T remove() {
        T elementToRemove = super.getInternalArray()[0];
        super.setInternalArray(Arrays.copyOfRange(super.getInternalArray(), 1, super.getInternalArray().length - 1));
        return elementToRemove;
    }

    @Override
    public int used() {
        return super.getCurrentIndex() - 1;
    }
}
