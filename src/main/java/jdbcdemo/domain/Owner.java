package jdbcdemo.domain;

public class Owner implements IHaveId {

	private int id;
	private String name;
	private String surname;
	private int age;

	public Owner() {
		name = null;
		surname = null;
		age = 0;
	}

	public Owner(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Owner: ID; " + getId() + ", name: " + getName() + ", surname: " + getSurname() + " age: " + getAge()
				+ ".";
	}

}
