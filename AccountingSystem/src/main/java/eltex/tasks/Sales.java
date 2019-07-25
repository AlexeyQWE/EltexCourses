package eltex.tasks;
	
public class Sales {

	private Integer id;
	private String title;
	private String price;

	public String getPrice() {

		return price;
	}

	public void setPrice(String price) {

		this.price = price;
	}

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public Integer getId () {

		return this.id;
	}

	public void setId(Integer id) {

		this.id = id;

	}
}
