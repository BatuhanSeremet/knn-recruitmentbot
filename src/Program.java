import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	
	public static void distance(Candidate a,Candidate b) {
		double total=Math.pow(a.getSocial()-b.getSocial(),2)+Math.pow(a.getAlgorithm()-b.getAlgorithm(),2)
				+Math.pow(a.getGpa()-b.getGpa(),2)+Math.pow(a.getAge()-b.getAge(),2);
		b.setDistance(Math.pow(total, 0.5));		
	}
		
	public static ArrayList<Candidate> readsample(Candidate newcand){
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		try {
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
			Candidate datacand = new Candidate(social, algorithm, gpa, age, hired);
			candidates.add(datacand);
			distance(newcand, datacand);
		}
		
		scan.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return candidates;
	}
	
	
	public static void mergeSort(ArrayList<Candidate> data,int left,int right) {
		if(right>left) {
			int mid=(right+left)/2;
			mergeSort(data,left,mid);
			mergeSort(data,mid+1,right);
			merge(data,left,mid,right);
		}
	}
	public static void merge(ArrayList<Candidate> data,int left,int mid,int right) {
		int sizeleft=mid-left+1;
		int sizeright=right-mid;
		Candidate[] subL = new Candidate[sizeleft];
		Candidate[] subR = new Candidate[sizeright];
		for(int i=0;i<sizeleft;i++) {
			subL[i]=data.get(left+i);
		}
		for(int j=0;j<sizeright;j++) {
			subR[j]=data.get(mid+1+j);
		}
		int i=0,j=0;
		int k=left;
		while(i<sizeleft && j<sizeright) {
			if(subL[i].getDistance()<=subR[j].getDistance()) {
				data.set(k,subL[i]);
				i++;
			}
			else {
				data.set(k,subR[j]);
				j++;
			}
			k++;
		}
		while(i<sizeleft) {
			data.set(k, subL[i]);
			k++;
			i++;
		}
		while(j<sizeright) {
			data.set(k,subR[j]);
			k++;
			j++;
		}
	}
	
	public static void searchknn(ArrayList<Candidate> sorteddata,Candidate newcand,int k) {
		int count_hired=0;
		for(int i=0;i<k;i++) {
			if(sorteddata.get(i).isHired()==1) count_hired++;
		}
		if(count_hired>k/2) newcand.setHired(1);
		else newcand.setHired(0);
	}
	
	public static String hire(Candidate newcand,int knn) throws Exception {
		ArrayList<Candidate> candidates = readsample(newcand);
		mergeSort(candidates,0,candidates.size()-1);
		searchknn(candidates,newcand,knn);
		String info="";
		for (int i = 0; i < knn; i++) {
			info = info + "Candidate "+(i+1)+" "+candidates.get(i).toString()+"\n";	
		}
		if(newcand.isHired()==1) info+= "\nGive the job to the applicant.";
		else info+= "\nDo not give the job to the applicant";
		return info;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Provide candidate social score:");
			double social = scan.nextDouble();
			System.out.println("Provide candidate algorithm score:");
			double algorithm = scan.nextDouble();
			System.out.println("Provide candidate gpa score:");
			double gpa = scan.nextDouble();
			System.out.println("Provide candidate age score:");
			double age = scan.nextDouble();
			System.out.println("Provide k for k-nearest neighbors:");
			int knn = scan.nextInt();
			Candidate cand = new Candidate(social, algorithm, gpa, age);
			System.out.println("New Candidate: "+cand.toString()+"\n\n");
			System.out.println(hire(cand, knn));
		} catch (Exception e) {	// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.close();
	}
}
	