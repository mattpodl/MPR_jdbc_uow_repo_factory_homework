package jdbcdemo.dao.uow;

public interface UnitOfWorkRepository {

	public void persistAdd(Entity entity);

	public void persistUpdate(Entity entity);

	public void persistDelete(Entity entity);

}
