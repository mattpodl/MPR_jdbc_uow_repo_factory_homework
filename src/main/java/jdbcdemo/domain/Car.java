package jdbcdemo.domain;

public class Car implements IHaveId {

	private int id;
	private String brand;
	private String registration;
	private int ownersId;

	public Car() {
		brand = null;
		registration = null;
		ownersId = 0;
	}

	public Car(int id, String brand, String registration, int ownersId) {
		super();
		this.id = id;
		this.brand = brand;
		this.registration = registration;
		this.ownersId = ownersId;
	}

	public Car(String brand, String registration, int ownersId) {
		super();
		this.brand = brand;
		this.registration = registration;
		this.ownersId = ownersId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public int getOwnersId() {
		return ownersId;
	}

	public void setOwnersId(int ownersId) {
		this.ownersId = ownersId;
	}

	@Override
	public String toString() {
		return "Car: ID: " + getId() + ", brand: " + getBrand() + ", registration: " + getRegistration()
				+ ", owner ID: " + getOwnersId() + ".";
	}

}
