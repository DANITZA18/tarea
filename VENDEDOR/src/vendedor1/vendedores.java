package vendedor1;




public class vendedores {
	
	    private  Long id;
	    private String name_consultas;
	    private  String name_sinrespuesta;

	    vendedores() {}

	    public vendedores(String name_consultas) {
	        this.name_consultas = name_consultas;
	    }

	    public vendedores(String name_consultas, String name_sinrespuesta) {
	        this.name_consultas = name_consultas;
	        this.name_sinrespuesta = name_sinrespuesta;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName_consultas() {
	        return this.name_consultas + " " + this.name_sinrespuesta;
	    }

	    public void setName_consultas(String name) {
	        String[] parts =name.split(" ");
	        this.name_consultas = parts[0];
	        this.name_sinrespuesta = parts[1];
	    }

	}

