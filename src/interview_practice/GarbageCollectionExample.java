package interview_practice;

public class GarbageCollectionExample {
    public static void main(String[] args) {
        GarbageCollectionExample obj1 = new GarbageCollectionExample();
        GarbageCollectionExample obj2 = new GarbageCollectionExample();

        obj1 = null;  // obj1 is no longer reachable
        System.gc();  // Suggest the JVM to run the garbage collector

        // The garbage collector may or may not immediately reclaim memory
        // depending on various factors, including its internal algorithms.

        obj2 = null;  // obj2 is no longer reachable
        Runtime.getRuntime().gc();  // Another way to suggest garbage collection
    }
}
