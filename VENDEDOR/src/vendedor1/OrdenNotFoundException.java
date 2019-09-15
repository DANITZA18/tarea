package vendedor1;

public class OrdenNotFoundException extends RuntimeException {

	    OrdenNotFoundException(Long id) {
	        super("Could not find bus " + id);
	    }
	}

