package jdbcdemo.dao.uow;

import jdbcdemo.domain.IHaveId;

public class Entity {
	private IHaveId entity;
	private UnitOfWorkRepository repository;
	private EntityState state;

	public IHaveId getEntity() {
		return entity;
	}

	public UnitOfWorkRepository getRepository() {
		return repository;
	}

	public void setRepository(UnitOfWorkRepository repository) {
		this.repository = repository;
	}

	public EntityState getState() {
		return state;
	}

	public void setState(EntityState state) {
		this.state = state;
	}

	public void setEntity(IHaveId entity) {
		this.entity = entity;
	}

	public void persistChange() {
		switch (state) {
		case Changed:
			repository.persistUpdate(this);
			break;
		case Deleted:
			repository.persistDelete(this);
			break;
		case New:
			repository.persistAdd(this);
			break;
		default:
			break;
		}
	}

}
