
public class Candidate {
	private double social,algorithm,gpa,age,distance;
	private int hired;
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Candidate(double social, double algorithm, double gpa, double age,int hired) {
		super();
		this.social = social;
		this.algorithm = algorithm;
		this.gpa = gpa;
		this.age = age;
		this.hired=hired;
	}
	
	public Candidate(double social, double algorithm, double gpa, double age) {
		super();
		this.social = social;
		this.algorithm = algorithm;
		this.gpa = gpa;
		this.age = age;
	}

	public double getSocial() {
		return social;
	}

	public double getAlgorithm() {
		return algorithm;
	}

	public double getGpa() {
		return gpa;
	}

	public double getAge() {
		return age;
	}

	
	public int isHired() {
		return hired;
	}

	public void setHired(int hired) {
		this.hired = hired;
	}
	@Override
	public String toString() {
		return "Social:" + social + ", Algorithm:" + algorithm + ", Gpa:" + gpa + ", Age:" + age + ", Hired:"
				+ hired+"--->Distance: "+distance;
	}
}
