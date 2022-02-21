
public class Main {

    public static void main(String[] args) {
        int[] bookShelf = new int[] {14, 16, 19, 32, 32, 32, 56, 69, 72};
        int newBook = 32;
        System.out.println("На полке " + followingLargeBook(bookShelf, newBook) + " книги строго больше, чем "
                + newBook + " страницы.");
        newBook = 68;
        System.out.println("На полке " + followingLargeBook(bookShelf, newBook) + " книги строго больше, чем "
                + newBook + " страницы.");
    }

    public static int followingLargeBook(int[] arr, int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        if (arr[firstIndex] > elementToSearch) {
            return arr.length;
        } else if (arr[lastIndex] < elementToSearch) {
            return 0;
        }
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex - 1] <= elementToSearch && arr[middleIndex] > elementToSearch) {
                return arr.length - middleIndex;
            } else if (arr[middleIndex] <= elementToSearch) {
                firstIndex = middleIndex + 1;
            } else if (arr[middleIndex] > elementToSearch) {
                lastIndex = middleIndex - 1;
            }
        }
        return firstIndex;
    }
}