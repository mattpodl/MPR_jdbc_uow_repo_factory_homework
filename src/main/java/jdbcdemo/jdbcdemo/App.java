package jdbcdemo.jdbcdemo;

import java.sql.Date;
import java.util.ArrayList;

import jdbcdemo.dao.JdbcCatalogFactory;
import jdbcdemo.dao.RepositoryCatalog;
import jdbcdemo.domain.Accident;
import jdbcdemo.domain.Car;
import jdbcdemo.domain.Owner;

public class App {
	public static void main(String[] args) {

		ArrayList<Owner> ownerList = new ArrayList<Owner>();
		ownerList.add(new Owner("Tomasz", "Flak", 25));
		ownerList.add(new Owner("Jan", "Nowak", 42));
		ownerList.add(new Owner("Krystian", "Przytul", 18));
		ownerList.add(new Owner("Agata", "Zip", 54));
		ownerList.add(new Owner("Janusz", "Podlin", 89));

		ArrayList<Car> carList = new ArrayList<Car>();
		carList.add(new Car("Ford", "CG 78678", 1));
		carList.add(new Car("Fiat", "CG 34543", 2));
		carList.add(new Car("Ford", "CG 76543", 3));
		carList.add(new Car("Renault", "CG 12345", 4));
		carList.add(new Car("Dodge", "CG 54332", 4));

		ArrayList<Accident> accidentList = new ArrayList<Accident>();
		accidentList.add(new Accident(1, new Date(112, 0, 20), "kierujacy udezyl w drzewo"));
		accidentList.add(new Accident(2, new Date(115, 3, 30), "kierwoca nie zatrzymal sie na czerwonym swietle"));
		accidentList.add(new Accident(5, new Date(117, 11, 31), "kierowca staranowal 15 samochodow na parkingu"));
		accidentList.add(new Accident(5, new Date(112, 0, 20), "pekla opona co spowodowalo wypadniecie auta z trasy"));
		accidentList.add(new Accident(3, new Date(112, 0, 20), "podczas burzy drzewo przewrocilo sie na zaparkowane auto"));

		RepositoryCatalog workdb = new JdbcCatalogFactory().HsqlDbWorkBd();
		// Creating table
		workdb.owners().createTable();
		workdb.cars().createTable();
		workdb.accidents().createTable();

		// Adding entries to database
		for (Owner owner : ownerList) {
			workdb.owners().add(owner);
		}

		for (Car car : carList) {
			workdb.cars().add(car);
		}
		for (Accident accident : accidentList) {
			workdb.accidents().add(accident);
		}

		workdb.saveChanges();

		// printing results
		for (Accident accident : workdb.accidents().getAll()) {
			System.out.println(accident);
		}
		System.out.println("");

		for (Owner owner : workdb.owners().getAll()) {
			System.out.println(owner.toString());
		}
		System.out.println("");

		for (Car car : workdb.cars().getAll()) {
			System.out.println(car);
		}
		System.out.println("----------------------------\n\n");
		// deleting entries in owner table
		for (Owner p : workdb.owners().getAll()) {
			workdb.owners().delete(p);
		}

		// executing queue
		workdb.saveChanges();

		// printing results
		System.out.println("Entries after delete: ");
		for (Owner p : workdb.owners().getAll()) {
			System.out.println(p.toString());
		}
		System.out.println("----------------------------\n\n");

	}
}
