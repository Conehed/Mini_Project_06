public class Main {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();

        // Test isEmpty and getSize on empty heap
        System.out.println("Empty? " + heap.isEmpty()); // true
        System.out.println("Size: " + heap.getSize());  // 0

        // Test add
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(3);

        System.out.println("\nAfter adding 10, 5, 20, 3:");
        heap.print_array();

        System.out.println("Empty? " + heap.isEmpty()); // false
        System.out.println("Size: " + heap.getSize());  // 4

        // Test removeMin
        System.out.println("\nRemoving values:");
        System.out.println(heap.removeMin()); // 3
        System.out.println(heap.removeMin()); // 5
        System.out.println(heap.removeMin()); // 10
        System.out.println(heap.removeMin()); // 20

        // Test removeMin on empty heap
        System.out.println("\nRemove from empty:");
        System.out.println(heap.removeMin()); // null

        // Test duplicates
        heap.add(2);
        heap.add(2);
        heap.add(1);

        System.out.println("\nDuplicates:");
        System.out.println(heap.removeMin()); // 1
        System.out.println(heap.removeMin()); // 2
        System.out.println(heap.removeMin()); // 2

        // Test clear
        heap.add(100);
        heap.add(50);

        System.out.println("\nBefore clear size: " + heap.getSize()); // 2
        heap.clear();
        System.out.println("After clear size: " + heap.getSize());    // 0
        System.out.println("Empty after clear? " + heap.isEmpty());    // true
    }
}