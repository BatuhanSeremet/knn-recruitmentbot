import java.io.FileInputStream;
import java.util.Scanner;

public class AccuracyTest {

	public static void main(String[] args) {
		try {
			int acc=0,tot=0;
			FileInputStream fis = new FileInputStream("sample_data.txt");
			Scanner scan = new Scanner(fis);
			scan.nextLine();
			while(scan.hasNextLine()) {
				String[] line=scan.nextLine().split(",");
				double social= Double.parseDouble(line[0]);
				double algorithm= Double.parseDouble(line[1]);
				double gpa= Double.parseDouble(line[2]);
				double age= Double.parseDouble(line[3]);
				int hired=Integer.parseInt(line[4]);
				Candidate cand = new Candidate(social, algorithm, gpa, age);
				Program.hire(cand,5);
				if(cand.isHired() == hired) acc++;
				tot++;
			}
			double percent = 100.0 * acc/tot;
			System.out.println("Accuracy is "+percent+"%");
			System.out.println("Made "+tot+" tests\n"+acc+" of them were accurate.");
			scan.close();
			}catch(Exception e) {
				e.printStackTrace();
			}

	}

}
