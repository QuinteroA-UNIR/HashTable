package hashTable;

/**
 * Class that shows a real life exmaple of a hash table
 * being used as a telephone agenda.
 * @author Arnaldo Quintero Segura
 *
 */
public class MainExample {
	
	// Funcion ayudante para imprimir valores tecnicos como
	// la cantidad de elementos y el factor de carga de la
	// tabla de hash.
	public static void technicalStats(HashTable<Integer> h) {
		// Cantidad de elementos en la lista
		System.out.println("    -- Valores tecnicos:");
		System.out.println("       Elementos insertados: " + h.getSize());
		System.out.println("       Factor de carga: " + h.getLoadFactor());
	}

	public static void main(String[] args) {
		
		// Variable temporal utilizada para almacenar los resultados
		// de las distintas operaciones que se realizaran a lo largo
		// de este ejemplo.
		Object res = null;

		// Introduccion del ejemplo real
		System.out.println("Para este caso de ejemplo, se tomará como ejemplo real");
		System.out.println("el caso de una agenda telefonica. Donde el nombre de la");
		System.out.println("persona es la clave, y el numero su valor. Debe tomarse");
		System.out.println("en cuenta que dicha agenda no permite dos contactos con el");
		System.out.println("mismo nombre. Procedamos a demostrar el ejemplo:");
		
		// Creacion y muestra de la lista vacía
		HashTable<Integer> h = new HashTable<Integer>();
		System.out.println();
		System.out.println("-- Creacion de la agenda");
		System.out.println("    Agenda actual: " + h);
		
		
		// Buscar elemento en lista vacia
		res = h.get("Juan");
		System.out.println();
		System.out.println("-- Busqueda de persona inexistente: Juan");
		System.out.println("    Resultado: " + res);
		
		// Elementos tecnicos
		technicalStats(h);
		
		// Insercion de elementos en la tabla
		res = h.put("Juan", 681123456);
		System.out.println();
		System.out.println("-- Insercion de persona a la lista: (Juan, 681123456)");
		System.out.println("    Resultado: " + res);
		System.out.println("    Agenda actual: " + h);
		
		// Buscar elemento en lista
		res = h.containsKey("Juan");
		System.out.println();
		System.out.println("-- Busqueda de persona existente: Juan");
		System.out.println("    Resultado: " + res);
		
		// Elementos tecnicos
		technicalStats(h);
	
		// Insercion de 4 personas mas
		
		
		
		
		System.out.println();
		System.out.println("-- Insercion de 4 personas a la lista:");
		System.out.println("        (Andres, 682123456), (Pedro, 683123456)");
		System.out.println("        (Maria, 684123456), (Luis, 685123456)");

		res = h.put("Andres", 682123456);
		System.out.println("    Insercion Andres: " + res);
		technicalStats(h);

		res = h.put("Pedro", 683123456);
		System.out.println("    Insercion Pedro: " + res);
		technicalStats(h);

		res = h.put("Maria", 684123456);
		System.out.println("    Insercion Maria: " + res);
		technicalStats(h);

		res = h.put("Luis", 682523456);
		System.out.println("    Insercion Luis: " + res);
		technicalStats(h);

		System.out.println("    Agenda actual: " + h);
		
		// Busqueda por numero telefonico
		res = h.containsValue(683123456);
		System.out.println();
		System.out.println("-- Busqueda por numero telefonico: 683123456");
		System.out.println("    Resultado: " + res);
		
		// Busqueda por nombre, para obtener el numero
		res = h.get("Maria");
		System.out.println();
		System.out.println("-- Busqueda por nombre, para obterner el numero: Maria");
		System.out.println("    Resultado: (Maria, " + res + ")");
		
		// Elementos tecnicos
		technicalStats(h);
		
		// Reinsercion de un nombre existente
		res = h.put("Luis", 999999999);
		System.out.println();
		System.out.println("-- Reinsercion de un nombre existente: Luis, nuevo valor '999999999'");
		System.out.println("    Resultado: " + res);

		// Muestra de que el elemento no ha cambiado
		res = h.get("Luis");
		System.out.println("-- Muestra de que el elemento no fue cambiado:");
		System.out.println("    Resultado: (Luis, " + res + ")");
		System.out.println("    Agenda actual: " + h);
		
		technicalStats(h);
		
		// Reemplazar un valor en la agenda
		res = h.replace("Luis", 999999999);
		System.out.println();
		System.out.println("-- Reemplazar numero telefonico: Luis, nuevo valor 999999999");
		System.out.println("    Resultado: " + res);
		System.out.println("    Agenda actual: " + h);
		
		
		// Eliminar todos los elementos de la lista
		System.out.println();
		System.out.println("-- Remover uno a uno todos los elementos de la list:");
		res = h.remove("Juan");
		System.out.println("    Remover Juan: " + res);
		System.out.println("    Agenda actual: " + h);
		technicalStats(h);
		
		System.out.println();
		res = h.remove("Andres");
		System.out.println("    Remover Andres: " + res);
		System.out.println("    Agenda actual: " + h);
		technicalStats(h);

		System.out.println();
		res = h.remove("Pedro");
		System.out.println("    Remover Pedro: " + res);
		System.out.println("    Agenda actual: " + h);
		technicalStats(h);

		System.out.println();
		res = h.remove("Maria");
		System.out.println("    Remover Maria: " + res);
		System.out.println("    Agenda actual: " + h);
		technicalStats(h);

		System.out.println();
		res = h.remove("Luis");
		System.out.println("    Remover Luis: " + res);
		System.out.println("    Agenda actual: " + h);
		technicalStats(h);
				
	}

}
