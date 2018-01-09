package jdbcdemo.dao;

import jdbcdemo.domain.Accident;
import jdbcdemo.domain.Car;
import jdbcdemo.domain.Owner;

public interface RepositoryCatalog {

	Repository<Owner> owners();

	Repository<Accident> accidents();

	Repository<Car> cars();

	void saveChanges();

}