package beans;

public class Car {
	private String[] carNames;
	private Engine[] engine;

	public String[] getCarNames() {
		return carNames;
	}

	public void setCarNames(String[] carNames) {
		this.carNames = carNames;
	}

	public Engine[] getEngine() {
		return engine;
	}

	public void setEngine(Engine[] engine) {
		this.engine = engine;
	}

	public void printCarData() {
		for (String car : carNames) {
			System.out.println(car);
		}
		for (Engine e : engine) {
			System.out.println(e.getModelYear());
		}
	}
}
