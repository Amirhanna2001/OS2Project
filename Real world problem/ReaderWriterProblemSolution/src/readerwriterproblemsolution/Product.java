package readerwriterproblemsolution;

public class Product {
	private String name;
	private int counter;

	public Product() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Product(String name, int counter) {
		super();
		this.name = name;
		this.counter = counter;
	}
}