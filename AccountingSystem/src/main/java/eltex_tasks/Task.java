package eltex_tasks;

class Task <T extends User, V extends User > {

	private T owner;
	private V qa;

	Task (T owner, V qa) { 

		this.owner = owner;
		this.qa = qa;
	}

	public String T_getTitle() {

		return this.owner.getTaskTitle();
	} 

	public String T_getDescription() {

		return this.owner.getTaskDescription();
	} 

	public String V_getTitle() {

		return this.qa.getTaskTitle();
	} 

	public String V_getDescription() {

		return this.qa.getTaskDescription();
	} 

	public void T_SetTitle (String title) {

		this.owner.setTaskTitle(title); 
	}

	public void T_SetDescription (String description) {

		this.owner.setTaskDescription(description);
	}

	public void V_SetTitle (String title) {

		this.qa.setTaskTitle(title);
	}

	public void V_SetDescription (String description) {

		this.qa.setTaskDescription(description);
	}
}