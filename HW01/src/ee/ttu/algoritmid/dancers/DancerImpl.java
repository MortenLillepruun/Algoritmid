package ee.ttu.algoritmid.dancers;

public class DancerImpl implements Dancer {
	
	private int id;
	private boolean sex;
	private int height;

	public DancerImpl(int id, boolean isMale, int height) {
		this.id = id;
		this.sex = isMale;
		this.height = height;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public boolean isMale() {
		return sex;
	}

	@Override
	public int getHeight() {
		return height;
	}

}
