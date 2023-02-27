package exc1;
import java.util.*;
public class Tester2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Map<String, Integer> sales1 = new HashMap<>();
	        sales1.put("Mathew", 50);
	        sales1.put("Lisa", 76);
	        sales1.put("Courtney", 45);
	        sales1.put("David", 49);
	        sales1.put("Paul", 49);
	        List<String> result1 = SalesDepartment.sortSales(sales1);
	        System.out.println(result1);
	        
	        Map<String, Integer> sales2 = new HashMap<>();
	        sales2.put("Mathew", 40);
	        sales2.put("Lisa", 60);
	        sales2.put("Courtney", 35);
	        sales2.put("David", 52);
	        sales2.put("Paul", 58);
	        List<String> result2 = SalesDepartment.sortSales(sales2);
	        System.out.println(result2); 

	}

}
