package prob01;

public class ServiceImp implements Service {
	private MemDaoImp memDao;

	public ServiceImp() {

	}

	public void setMemDao(MemDaoImp memDao) {
		this.memDao = memDao;
	}

	@Override
	public void prn() {
		memDao.selectMethod();

	}
}
