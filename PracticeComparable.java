package JavaLearn;

public class PracticeComparable {
	public static void main (String[]args) {
		explainComparables();
	}
	
	/**
	 * We will write a generic merge sort for sorting any kinds of object (as long as they implements comparable)
	 * Note: Implementing comparable ensures these objects can be compared (as they will have the compareTo method).
	 * We don't need to know any other information about the object for sorting them as long as we are sure we can compare these objects (which is
	 * guaranteed as the objects implement comparable).
	 * 
	 *   You will see that the same MergeSortUtil can sort cars based on their mrp and books based on their names. If we want to sort any other
	 *   object, we can again use this same MergeSortUtil without changing a line of code in it for sorting the new type of objects (as long as the new type
	 *   of objects are comparable i.e. implements comparable)
	 */
	public static void explainComparables () {
		MergeSortUtil sorter = new MergeSortUtil();
		/**
		 * Creating an array of Car objects and storing in the array allCars
		 */
		Car[] allCars = new Car[] {
				new Car("Honda Amaze", 15),//prices of cars are in lacs
				new Car("Hyundai i20", 10),
				new Car("Ford Ecosport", 8),
				new Car("Honda Accord", 18),
				new Car("Skoda Rapid",8),
				new Car("Toyota Innova",25)
		};
		System.out.println();
		System.out.println("Sorting Cars based on MRP");
		sorter.mergeSort(allCars);
		for(Car car: allCars) {
			System.out.println(car);
		}
		System.out.println();
		/**
		 * Creating an array of Book objects and storing in the array allBooks
		 */
		Book[] allBooks = new Book[] {
				new Book("The Power"),
				new Book("Autumn"),
				new Book("Sing, Unburied, Sing"),
				new Book("Exit West"),
				new Book("Prairie Fires"),	
				new Book("Priestdaddy"),
				new Book("Pachinko"),
		};
		System.out.println();
		System.out.println("Sorting books based on their names");
		sorter.mergeSort(allBooks);
		for(Book book: allBooks) {
			System.out.println(book);
		}	
	}
}

/**
 * 
 *Since we want to compare Car with another Car object, we mention <Car> as the type of the Comparable
 */
class Car implements Comparable<Car> {

	int mrp;
	String model;
	Car(String model, int mrp) {
		this.mrp = mrp;
		this.model = model;
		System.out.println("Created car "+model+" mrp "+mrp);
	}
	
	@Override
	public int compareTo(Car compareWithCar) {
		/**
		 * Compares this object with the specified object for order. 
		 * Returns a negative integer, zero, or a positive integer as this object is less than,
		 *  equal to, or greater than the specified object.
		 */
		if(this.mrp<compareWithCar.mrp) {
			return -1;
		} else if(compareWithCar.mrp==this.mrp) {
			return 0;
		} else {
			return 1;
		}
	}
	
	/**
	 * The result returned by the toString() method is fetched when the object is converted to a string
	 * System.out.println(car_object) -> will print -> Car: car_object.model MRP: car_object.mrp 
	 */
	@Override
	public String toString() {
		return "Car: "+model+" MRP: "+mrp;
	}
}

class Book implements Comparable<Book> {

	String name;
	Book(String name) {
		this.name = name;
		System.out.println("Creating Book:"+name);
	}
	
	@Override
	public int compareTo(Book compareWithBook ) {
		if(this.name.compareTo(compareWithBook.name)<0) {
			return -1;
		} else if(this.name.compareTo(compareWithBook.name)==0) {
			return 0;
		} else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
		return "Book: "+name;
	}
}

/**
 * Merge sort is taken from the other class. Its just converted to a generic.
 * Car[] allCars
 * mergeSort(allCars) -> will work if Car implements Comparable. In other words the cars can be compared which is what merge sort only needs to
 * care about.
 * 
 * Notice in this implementation of merge sort I have not called any method of Car or Book apart from the compareTo method. 
 */
class MergeSortUtil {
	public void mergeSort(Comparable[] arr) {
		Comparable[] aux = new Comparable[arr.length];
		mergeSortInternal(arr,aux,0,arr.length-1);
	}
	
	private void mergeSortInternal(Comparable[] arr, Comparable[] aux, int l, int r) {
		if (r <= l) {
			return;
		}
		int mid = l + (r - l) / 2;
		mergeSortInternal(arr, aux, l, mid);
		mergeSortInternal(arr, aux, mid + 1, r);
		merge(arr, aux, l, mid, r);
	}
	
	private void merge(Comparable[] arr, Comparable[] aux, int l, int mid, int r) {
		int i = l;
		int j = mid + 1;
		int k = 0;
		if (arr[mid].compareTo(arr[mid + 1])<=0) {
			return;
		}
		while (i <= mid && j <= r) {
			if (arr[i].compareTo(arr[j])<=0) {
				aux[k++] = arr[i++];
			} else {
				aux[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			aux[k++] = arr[i++];
		}
		while (j <= r) {
			aux[k++] = arr[j++];
		}

		// copy the aux array into original array
		for (i = l, k = 0; i <= r; i++) {
			arr[i] = aux[k++];
		}
	}
}
