package entities;

public class CompanyPayer extends Payer {
	private Integer numberEmployees;

	public CompanyPayer() {
		super();
	}

	public CompanyPayer(String name, Double anualIncome, Integer numberEmployees) {
		super(name, anualIncome);
		this.numberEmployees = numberEmployees;
	}

	public Integer getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public Double totalTax() {
		if (numberEmployees <= 10) {
			return getAnualIncome() * 0.16;
		} else {
			return getAnualIncome() * 0.14;
		}
	}
}
