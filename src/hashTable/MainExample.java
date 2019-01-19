package hashTable;

public class MainExample {

	public static void main(String[] args) {
		//creacion
		HashTable<Integer> h = new HashTable<Integer>();
		//impresion lista vacia
		h.print();
		
		//buscar elemento en lista vacia
		Object res = h.get("lunes");
		System.out.println(res);
		
		//tamaño
		res = h.getSize();
		System.out.println(res);
		
		//factor de redispersion
		res = h.getLoadFactor();
		System.out.println(res);
		
		//contains key
		res = h.containsKey("lunes");
		System.out.println(res);
		
		//contains value
		res = h.containsValue(100);
		System.out.println(res);
		
		
		
		//insercion
		res = h.put("lunes", 12);
		h.print();
		
		//buscar elemento en lista vacia
		res = h.get("lunes");
		System.out.println(res);
		
		//tamaño
		res = h.getSize();
		System.out.println(res);
		
		//factor de redispersion
		res = h.getLoadFactor();
		System.out.println(res);
		
		//contains key
		res = h.containsKey("lunes");
		System.out.println(res);
		
		//contains value
		res = h.containsValue(100);
		System.out.println(res);
		
		
		
		//reinsercion
		res = h.put("lunes", 12);
		h.print();
		
		//buscar elemento en lista vacia
		res = h.get("lunes");
		System.out.println(res);
		
		//tamaño
		res = h.getSize();
		System.out.println(res);
		
		//factor de redispersion
		res = h.getLoadFactor();
		System.out.println(res);
		
		//contains key
		res = h.containsKey("lunes");
		System.out.println(res);
		
		//contains value
		res = h.containsValue(12);
		System.out.println(res);
		
		
		// nuevo elem
		res = h.put("martes", 12);
		h.print();
		
		//buscar elemento en lista vacia
		res = h.get("martes");
		System.out.println(res);
		
		//tamaño
		res = h.getSize();
		System.out.println(res);
		
		//factor de redispersion
		res = h.getLoadFactor();
		System.out.println(res);
		
		//contains key
		res = h.containsKey("martes");
		System.out.println(res);
		
		//contains value
		res = h.containsValue(12);
		System.out.println(res);
		
		// nuevo elem
				res = h.put("miercoles", 12);
				h.print();
				
				//buscar elemento en lista vacia
				res = h.get("martes");
				System.out.println(res);
				
				//tamaño
				res = h.getSize();
				System.out.println(res);
				
				//factor de redispersion
				res = h.getLoadFactor();
				System.out.println(res);
				
				//contains key
				res = h.containsKey("martes");
				System.out.println(res);
				
				//contains value
				res = h.containsValue(12);
				System.out.println(res);
				
				
				// nuevo elem
				res = h.put("jueves", 12);
				h.print();
				
				//buscar elemento en lista vacia
				res = h.get("martes");
				System.out.println(res);
				
				//tamaño
				res = h.getSize();
				System.out.println(res);
				
				//factor de redispersion
				res = h.getLoadFactor();
				System.out.println(res);
				
				//contains key
				res = h.containsKey("martes");
				System.out.println(res);
				
				//contains value
				res = h.containsValue(12);
				System.out.println(res);
				
				
				
				
				
				
				
				//replace
				res = h.replace("lunes", 11);
				System.out.println(res);
				res = h.replace("asd", 11);
				System.out.println(res);
				h.print();
				
				//replace
				res = h.remove("lunes");
				System.out.println(res);
				res = h.remove("asd");
				System.out.println(res);
				res = h.remove("jueves");
				System.out.println(res);
				h.print();
				
				res = h.remove("miercoles");
				System.out.println(res);
				h.print();
				res = h.remove("martes");
				System.out.println(res);
				h.print();
				
				
	}

}
