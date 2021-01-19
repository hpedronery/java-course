package entities;

public class IndividualPayer extends Payer {
	private Double healthExpenditures;

	public IndividualPayer() {
		super();
	}

	public IndividualPayer(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double totalTax() {
		if (getAnualIncome() < 20000.00) {
			return getAnualIncome() * 0.15 - getHealthExpenditures() * 0.5;
		} else {
			return getAnualIncome() * 0.25 - getHealthExpenditures() * 0.5;
		}
	}
}
