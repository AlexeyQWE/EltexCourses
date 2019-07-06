package eltex_tasks;

public class MainManager extends Manager {	

	private Sales arr;

	MainManager () {};

	MainManager (String fio, String phone, String email) {

		super(fio, phone, email);
	}

	@Override
	public void speak () {

		System.out.print("Hello! Im a MainManager! ");
	}

	public void sort () {

		for (int j = 0; j < 3; ++j) {
			for (int i = 0; i < 2; ++i) {
				if (this.sales[i].getPrice() > this.sales[i + 1].getPrice()) {
					arr = this.sales[i];
					this.sales[i] = this.sales[i + 1];
					this.sales[i + 1] = arr;
				}
			}
		}
	}

	@Override
	public String getTitle () {

		return this.sales[this.id - 1].getTitle();
	}

	@Override
	public int getPrice () {

		return this.sales[this.id - 1].getPrice();
	}
}