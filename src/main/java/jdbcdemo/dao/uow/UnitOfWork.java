package jdbcdemo.dao.uow;

public interface UnitOfWork {

	public void markAsNew(Entity entity);

	public void markAsDeleted(Entity entity);

	public void markAsChanged(Entity entity);

	public void printEntityList(); // for test

	public void saveChanges();

	public void rollback();

}
