package vendedor1;


	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.bind.annotation.ResponseStatus;

	    @ControllerAdvice
	    public class vendedorNoEncuentra {

	        @ResponseBody
	        @ExceptionHandler(vendedorNoEncuentraException.class)
	        @ResponseStatus(HttpStatus.NOT_FOUND)
	        String employeeNotFoundHandler(vendedorNoEncuentraException ex) {
	            return ex.getMessage();
	        }
	    }

