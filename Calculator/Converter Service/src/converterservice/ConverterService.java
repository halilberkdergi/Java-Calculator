package converterservice;

public interface ConverterService {

	
	public String locale();	 
	
	public String NumberToWords(  long n );
	
	public  String isValidInput (String input);
	
	public long WordsToNumber( String input );
	

}
