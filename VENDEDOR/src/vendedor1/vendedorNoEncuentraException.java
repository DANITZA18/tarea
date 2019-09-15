package vendedor1;

public class vendedorNoEncuentraException {
	  vendedorNoEncuentraException(Long id) {
	        super("Could not find bus " + id);
	    }
}
