import java.util.Random;

public class heapPerformance 
{
    private int[] heap;
    private int size;

    public heapPerformance(int capacity) 
    {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int val) 
    {
        if (size == heap.length) throw new IllegalStateException("Heap is full");
        heap[size] = val;
        sift(size);
        size++;
    }

    private void sift(int ind) 
    {
        int parentInd = (ind - 1) / 2;
        if (ind > 0 && heap[ind] > heap[parentInd]) 
        {
            swap(ind, parentInd);
            sift(parentInd);
        }
    }

    public void buildHeap(int[] array) 
    {
        if (array.length > heap.length) throw new IllegalArgumentException("Array too large");
        System.arraycopy(array, 0, heap, 0, array.length);
        size = array.length;
        for (int i = (size - 1) / 2; i >= 0; i--) 
        {
            heapify(i);
        }
    }

    private void heapify(int ind) 
    {
        int largest = ind;
        int left = 2 * ind + 1;
        int right = 2 * ind + 2;

        if (left < size && heap[left] > heap[largest]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != ind) 
        {
            swap(ind, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) 
    {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) 
    {
        int n = 10000;
        int[] sorted = new int[n];
        int[] reverse = new int[n];
        int[] random = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) 
        {
            sorted[i] = i;
            reverse[i] = n - i;
            random[i] = rand.nextInt(n);
        }

        testHeapConstruction(sorted, "Sorted Input");
        testHeapConstruction(reverse, "Reverse-Ordered Input");
        testHeapConstruction(random, "Random Input");
    }

    private static void testHeapConstruction(int[] data, String description) 
    {
        heapPerformance heap = new heapPerformance(data.length);

        long start = System.nanoTime();
        for (int val : data) 
        {
            heap.insert(val);
        }
        long end = System.nanoTime();
        System.out.println(description + " - Insertion Time: " + (end - start) / 1e6 + " ms");

        heap = new heapPerformance(data.length);
        start = System.nanoTime();
        heap.buildHeap(data);
        end = System.nanoTime();
        System.out.println(description + " - Build Heap Time: " + (end - start) / 1e6 + " ms");
    }
}