package POO;

public class TestaGenerics {
	
	    public static void main(String[] args) {
	    	
	        Tipo<Sala> sala1 = new Tipo<Sala>(new Sala());// sem o uso de generics, o compilador não conseguiria saber qual a diferença entre aparelho1 e aparelho2, pois ele os trataria da mesma forma
	        Tipo<Laboratorio> sala2 = new Tipo<Laboratorio>(new Laboratorio());
	        System.out.println(sala1.getObjeto().getClass());
	        System.out.println(sala2.getObjeto().getClass());
	    }
	   
}