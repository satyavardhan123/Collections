package exc1;
import java.util.ArrayList;
import java.util.List;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Participant[] finalists1 = {new Participant("Hazel", "Singing", 91.2),
	                new Participant("Ben", "Instrumental", 95.7),
	                new Participant("John", "Singing", 94.5),
	                new Participant("Bravo", "Singing", 97.6)};

	        List<Participant> finalists1List = generateListOfFinalists(finalists1);

	        System.out.println("All Finalists:");
	        for (Participant finalist : finalists1List) {
	            System.out.println(finalist.toString());
	        }

	        List<Participant> singingFinalists = getFinalistsByTalent(finalists1List, "Singing");

	        System.out.println("\nSinging Finalists:");
	        for (Participant finalist : singingFinalists) {
	            System.out.println(finalist.toString());
	        }

	        Participant[] finalists2 = {new Participant("Mark", "Instrumental", 81.2),
	                new Participant("Ella", "Instrumental", 65.7),
	                new Participant("Lily", "Singing", 86.5)};

	        List<Participant> finalists2List = generateListOfFinalists(finalists2);

	        System.out.println("\nAll Finalists:");
	        for (Participant finalist : finalists2List) {
	            System.out.println(finalist.toString());
	        }

	        List<Participant> instrumentalFinalists = getFinalistsByTalent(finalists2List, "Instrumental");

	        System.out.println("\nInstrumental Finalists:");
	        for (Participant finalist : instrumentalFinalists) {
	            System.out.println(finalist.toString());
	        }
	    }

	    public static List<Participant> generateListOfFinalists(Participant[] finalists) {
	        List<Participant> finalistList = new ArrayList<>();
	        for (Participant finalist : finalists) {
	            finalistList.add(finalist);
	        }
	        return finalistList;
	    }

	    public static List<Participant> getFinalistsByTalent(List<Participant> finalists, String talent) {
	        List<Participant> filteredList = new ArrayList<>();
	        for (Participant finalist : finalists) {
	            if (finalist.getParticipantTalent().equals(talent)) {
	                filteredList.add(finalist);
	            }
	        }
	        return filteredList;
	    }

	}

