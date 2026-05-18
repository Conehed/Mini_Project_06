import java.util.Arrays;

public class MinHeap<T extends Comparable<? super T>> {

    private T[] heap;
    private int lastIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 5;
    private static final int MAX_CAPACITY = 1000;


    public MinHeap(){
        this(DEFAULT_CAPACITY);
    }

    public MinHeap(int initialCapacity) {
        if(initialCapacity < DEFAULT_CAPACITY){
            initialCapacity = DEFAULT_CAPACITY;
        }
        else if(initialCapacity > MAX_CAPACITY) {
            throw new IllegalStateException("array too large");
        }

        T[] tempHeap = (T[]) new Comparable[initialCapacity+1];
        heap = tempHeap;
        lastIndex = 0;
        integrityOK = true;

    }

    private void checkIntegrity(){
        if(integrityOK==false){
            throw new SecurityException("array was not made right!");
        }
    }

    public void add(T newEntry) {
        checkIntegrity();
        //add new entry to end of array
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        //swap parent if needed
        while(parentIndex > 0 && newEntry.compareTo(heap[parentIndex]) < 0){
            heap[newIndex] = heap[parentIndex];
            //move up tree
            newIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        heap[newIndex] = newEntry;
        lastIndex++;

    }

    public T removeMin() {
        checkIntegrity();
        //check if empty
        if(isEmpty()){
            return null;
        }

        T root = heap[1];
        T lastItem = heap[lastIndex];

        heap[lastIndex] = null;
        lastIndex--;

        if (!isEmpty()) {
            int rootIndex = 1;
            int childIndex = 2;

            while (childIndex <= lastIndex) {
                int rightChildIndex = childIndex + 1;

                if (rightChildIndex <= lastIndex &&
                        heap[rightChildIndex].compareTo(heap[childIndex]) < 0) {
                    childIndex = rightChildIndex;
                }

                if (lastItem.compareTo(heap[childIndex]) <= 0) {
                    break;
                }

                heap[rootIndex] = heap[childIndex];
                rootIndex = childIndex;
                childIndex = 2 * rootIndex;
            }

            heap[rootIndex] = lastItem;
        }

        return root;
    }


    public boolean isEmpty(){
        return lastIndex<1;
    }


    public int getSize(){
        return lastIndex;
    }

    public void clear(){
        checkIntegrity();
        while(lastIndex > -1){
            heap[lastIndex] = null;
            lastIndex--;
        }
        lastIndex = 0;
    }


    public void print_array(){
        System.out.println(Arrays.toString(heap));
    }
}
