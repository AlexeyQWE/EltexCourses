package eltex.tasks;
	
public class Sales {

	private String title;
	private Integer price;


	Sales (String title, int price) {

		this.title = title;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
