/**
 * 
 * @author Algorithms taken from the book of robert sedgewick and Kevin wayne
 *
 */

public class Quick {

    // This class should not be instantiated.
    protected Quick(Point[] array) { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param array the array to be sorted
     */
    public static void sort(Point[] array) {
        sort(array, 0, array.length - 1);
        assert isSorted(array);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Point[] array, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(array, lo, hi);
        sort(array, lo, j-1);
        sort(array, j+1, hi);
        assert isSorted(array, lo, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Point[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Point v = array[lo];
        while (true) { 

            // find item on lo to swap
            while (less(array[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, array[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(array, i, j);
        }

        // put partitioning item v at a[j]
        exch(array, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

 



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Point array, Point v) {
        return array.getPoint() < v.getPoint();
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Point[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Point[] array, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(array[i], array[i-1])) return false;
        return true;
    }


 

}
