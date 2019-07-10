package eltex.tasks;

public class MainManager extends Manager {	

	private Sales arr;

	MainManager () {};

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
}