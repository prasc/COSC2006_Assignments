public class TestSortingMethods {
    public static void main(String[] args) {
        int[] numbers = new int[5000];

        for (int i = 0; i < 5000; i++) {
            numbers[i] = (int) (Math.random() * (250000 - (-250000) + 1) + -250000);
        }

        mergeSort(numbers, 0, numbers.length);

        int[] copyOne = numbers.clone();
        int[] copyTwo = numbers.clone();
        int[] copyThree = numbers.clone();
        int[] copyFour = numbers.clone();

        System.out.println("Merge Sort before and after");
        printArray(copyOne);
        double start = System.nanoTime();
        mergeSort(copyOne, 0, copyOne.length);
        printArray(copyOne);
        System.out.println((System.nanoTime() - start) + " = total time in nanoseconds");

        System.out.println();
        System.out.println("Quick Sort first item pivot before and after");
        printArray(copyTwo);
        start = System.nanoTime();
        quickSortChooseFirst(copyTwo, 0, copyTwo.length);
        printArray(copyTwo);
        System.out.println(System.nanoTime() - start + " = total time in nanoseconds");


        System.out.println();
        System.out.println("Quick Sort middle item pivot before and after");
        printArray(copyThree);
        start = System.nanoTime();
        quickSortMiddleValue(copyThree, 0, copyThree.length);
        printArray(copyThree);
        System.out.println(System.nanoTime() - start + " = total time in nanoseconds");

        System.out.println();
        start = System.nanoTime();
        System.out.println("Quick Sort middle item pivot before and after");
        printArray(copyFour);
        start = System.nanoTime();
        quickSortRandomPivot(copyFour, 0, copyFour.length);
        printArray(copyFour);
        System.out.println(System.nanoTime() - start + " = total time in nanoseconds");
    }

    public static void mergeSort(int[] items, int start, int end) {
        if (end - start <= 1) return;

        int midPoint = (start + end) / 2;

        mergeSort(items, start, midPoint);
        mergeSort(items, midPoint, end);

        int left = start;
        int right = midPoint;
        int[] temp = new int[end - start];
        int i =0;

        while (left < midPoint && right < end) {
            if (items[left] < items[right]) {
                temp[i++] = items[left++];
            } else {
                temp[i++] = items[right++];
            }
        }

        while (left < midPoint) {
            temp[i++] = items[left++];
        }

        while (right < end) {
            temp[i++] = items[right++];
        }

        for (i = 0;i < temp.length; i++) {
            items[start + i] = temp[i];
        }
    }

    public static void quickSortChooseFirst(int[] items, int start, int end) {
        if (end - start <= 1) return;

        // get pivot point
        int pivot = partitionFirst(items, start, end);

        // left half
        quickSortChooseFirst(items, start, pivot);
        // right half
        quickSortChooseFirst(items, pivot + 1, end);
    }

    public static void quickSortMiddleValue(int[] items, int start, int end) {
        if (end - start <= 1) return;

        // get pivot point
        int pivot = partitionMiddle(items, start, end);

        // left half
        quickSortChooseFirst(items, start, pivot);
        // right half
        quickSortChooseFirst(items, pivot + 1, end);

    }

    public static void quickSortRandomPivot(int[] items, int start, int end) {
        if (end - start <= 1) return;

        // get pivot point
        int pivot = partitionRandom(items, start, end);

        // left half
        quickSortChooseFirst(items, start, pivot);
        // right half
        quickSortChooseFirst(items, pivot + 1, end);
    }

    public static int partitionFirst(int[] items, int start, int end) {
        int p = start;
        int lastSmall = p;
        int afterPivot = p+1;

        while ( afterPivot < end) {
            if (items[afterPivot] < items[p]) {
                lastSmall++;
                swap(items, afterPivot, lastSmall);
            }
            afterPivot++;
        }
        swap (items, p, lastSmall);
        return lastSmall;
    }

    public static int partitionMiddle(int[] items, int start, int end) {
        start = (end - start) / 2;
        int p = start;
        int lastSmall = p;
        int afterPivot = p+1;

        while ( afterPivot < end) {
            if (items[afterPivot] < items[p]) {
                lastSmall++;
                swap(items, afterPivot, lastSmall);
            }
            afterPivot++;
        }
        swap (items, p, lastSmall);
        return lastSmall;
    }

    public static int partitionRandom(int[] items, int start, int end) {
        start =(int) Math.random() * (end-start + 1);
        int p = start;
        int lastSmall = p;
        int afterPivot = p+1;

        while ( afterPivot < end) {
            if (items[afterPivot] < items[p]) {
                lastSmall++;
                swap(items, afterPivot, lastSmall);
            }
            afterPivot++;
        }
        swap (items, p, lastSmall);
        return lastSmall;
    }

    public static void swap(int[] items, int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.print("[ ");
        System.out.print(arr[0] + ", ");
        System.out.print(arr[1] + ", ");
        System.out.print(arr[2] + ", ");
        System.out.print("..." + arr[4997] + ", ");
        System.out.print(arr[4998] + ", ");
        System.out.print(arr[4999] + "]");
        System.out.println();

    }
}
