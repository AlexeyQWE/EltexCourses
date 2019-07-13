package eltex.tasks;

class Task <T extends User, V extends User > {

	private T owner;
	private V qa;
	private String title;
	private String description;

	public T getOwner () {

		return this.owner;
	}

	public V getQa () {

		return this.qa;
	}

	public String getTitle() {

		return this.title;
	} 

	public String getDescription() {

		return this.description;
	} 

	public void setOwner (T owner) {

		this.owner = owner;
	}

	public void setQa (V qa) {

		this.qa = qa;
	}

	public void setTitle (String title) {

		this.title = title; 
	}

	public void setDescription (String description) {

		this.description = description;
	}
}