package converterserviceimpl;


import java.util.List;
import java.util.Arrays;
import converterservice.ConverterService;
import java.lang.String;
import java.lang.Math; 



public class ConverterServiceImpl implements ConverterService  {
	@Override
	
	
	public String locale() {return "England";} // seçenekler :"England", "Turkey"
	
	public String NumberToWords(  long n ) {
		
		
		String units[] = { "", "one", "two", "three", "four",
				"five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
				"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };

		String tens[] = { 
				"", 		// 0
				"",		// 1
				"twenty", 	// 2
				"thirty", 	// 3
				"forty", 	// 4
				"fifty", 	// 5
				"sixty", 	// 6
				"seventy",	// 7
				"eighty", 	// 8
				"ninety" 	// 9		
				};
		String[] birlik = { "", "bir", "iki", "üç", "dört",
				"beþ", "altý", "yedi", "sekiz", "dokuz"};
		
		String[] onluk = { 
				"", 		// 0
				"on",		// 1
				"yirmi", 	// 2
				"otuz", 	// 3
				"kýrk", 	// 4
				"elli", 	// 5
				"altmýþ", 	// 6
				"yetmiþ",	// 7
				"seksen", 	// 8
				"doksan" 	// 9		
				};
		
		
		int i;
		long m ;
		
		if(locale()=="England") {
			if (n < 0) {
				return "minus " + NumberToWords(-n);
			}

			if (n < 20) {
				i = (int) n;
				return units[i];
			}

			if (n < 100) {
				i = (int) n;
				return tens[i / 10] + ((n % 10 != 0) ? " " : "") + units[i % 10];
			}

			if (n < 1000) {
				i = (int) n;
				return units[i / 100] + " hundred" + ((n % 100 != 0) ? " " : "") + NumberToWords(n % 100);
			}

			if (n < Math.pow(10,6)) {
				return NumberToWords(n / 1000) + " thousand" + ((n % 1000 != 0) ? " " : "") + NumberToWords(n % 1000);
			}

			if (n < Math.pow(10,9)) {
				return NumberToWords(n / 1000000) + " million" + ((n % 1000000 != 0) ? " " : "") + NumberToWords(n % 1000000);
			}
			
			if (n < Math.pow(10,12)) {

			return NumberToWords((long) (n / Math.pow(10,9))) + " billion" + ((n % Math.pow(10,9) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,9)));
			}
			
			if (n < Math.pow(10,15)) {

				return NumberToWords((long) (n / Math.pow(10,12))) + " trillion" + ((n % Math.pow(10,12) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,12)));
				}
			
			if (n < Math.pow(10,18)) {

				return NumberToWords((long) (n / Math.pow(10,15))) + " quadrillion" + ((n % Math.pow(10,15) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,15)));
				}
			if (n < Math.pow(10,21)) {

				return NumberToWords((long) (n / Math.pow(10,18))) + " quintillion" + ((n % Math.pow(10,18) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,18)));
				}
			if (n < Math.pow(10,24)) {

				return NumberToWords((long) (n / Math.pow(10,21))) + " sextillion" + ((n % Math.pow(10,21) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,21)));
				}
			if (n < Math.pow(10,27)) {

				return NumberToWords((long) (n / Math.pow(10,24))) + " septillion" + ((n % Math.pow(10,24) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,24)));
				}
			if (n < Math.pow(10,30)) {

				return NumberToWords((long) (n / Math.pow(10,27))) + " octillion" + ((n % Math.pow(10,27) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,27)));
				}
			
			
			
			
		}
		
		else if(locale()=="Turkey") {
			if (n < 0) {
				return "eksi " + NumberToWords(-n);
			}

			if (n < 9) {
				i = (int) n;
				return birlik[i];
			}

			if (n < 100) {
				i = (int) n;
				return onluk[i / 10] + ((n % 10 != 0) ? " " : "") + birlik[i % 10];
			}

			if (n < 1000) {
				i = (int) n;
				if (i/100 == 1)
					i=0;
				return birlik[i / 100] + " yüz" + ((n % 100 != 0) ? " " : "") + NumberToWords(n % 100);
			}

			if (n < Math.pow(10,6)) {
				m=n;
				if (n/1000 == 1)
					m=0;
				
				return NumberToWords(m / 1000) + " bin" + ((n % 1000 != 0) ? " " : "") + NumberToWords(n % 1000);
			}

			if (n < Math.pow(10,9)) {
				return NumberToWords(n / 1000000) + " milyon" + ((n % 1000000 != 0) ? " " : "") + NumberToWords(n % 1000000);
			}
			
			if (n < Math.pow(10,12)) {

			return NumberToWords((long) (n / Math.pow(10,9))) + " milyar" + ((n % Math.pow(10,9) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,9)));
			}	
			if (n < Math.pow(10,15)) {
				System.out.println((n / Math.pow(10,12)));

				return NumberToWords((long) (n / Math.pow(10,12))) + " trilyon" + ((n % Math.pow(10,12) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,12)));
				
			}
			
			if (n < Math.pow(10,18)) {

				return NumberToWords((long) (n / Math.pow(10,15))) + " katrilyon" + ((n % Math.pow(10,15) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,15)));
				}
			if (n < Math.pow(10,21)) {

				return NumberToWords((long) (n / Math.pow(10,18))) + " kentrilyon" + ((n % Math.pow(10,18) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,18)));
				}
			if (n < Math.pow(10,24)) {

				return NumberToWords((long) (n / Math.pow(10,21))) + " seksilyon" + ((n % Math.pow(10,21) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,21)));
				}
			if (n < Math.pow(10,27)) {

				return NumberToWords((long) (n / Math.pow(10,24))) + " septilyon" + ((n % Math.pow(10,24) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,24)));
				}
			if (n < Math.pow(10,30)) {

				return NumberToWords((long) (n / Math.pow(10,27))) + " oktilyon" + ((n % Math.pow(10,27) != 0) ? " " : "") + NumberToWords((long) (n % Math.pow(10,27)));
				}
			
		}
		return "";
	}
	
	
	public  String isValidInput (String input) {
		
	    List<String> allowedStrings_England = Arrays.asList
	    	    (
	    	    "minus","zero","one","two","three","four","five","six","seven",
	    	    "eight","nine","ten","eleven","twelve","thirteen","fourteen",
	    	    "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
	    	    "thirty","forty","fifty","sixty","seventy","eighty","ninety",
	    	    "hundred","thousand","million","billion","trillion ",
	    	    "quadrillion","quintillion","sextillion","septillion",
	    	    "octillion","nonillion"
	    	    );
	    	    
	    List<String> allowedStrings_Turkey = Arrays.asList
	    	    (
	    	    "eksi","sýfýr","bir","iki","üç","dört","beþ","altý","yedi",
	    	    "sekiz","dokuz","on","yirmi","otuz","kýrk",
	    	    "elli","altmýþ","yetmiþ","seksen","doksan","yüz",
	    	    "bin","milyon","milyar","trilyon","katrilyon","kentilyon",
	    	    "seksilyon", "septilyon", "oktilyon","nonilyon"
	    	    );
		
		
		if (locale()=="Turkey") {
			if(input.equals("") || input.equals("Lütfen bir sayý giriniz!") ) 
				return "Lütfen bir sayý giriniz!";	
			else if(input != null && input.length()> 0 ){
			    String[] splittedParts = input.trim().split("\\s+");

		        for(String str : splittedParts)
		        {
		            if(!allowedStrings_Turkey.contains(str))
		            	return "Hatalý giriþ!";
		        }
		
		    }
			return "Geçerli";
		}
		
		else if (locale()=="England") {
			
			if(input.equals("") || input.equals("Please enter a number!"))
				return "Please enter a number!";
			
			else if(input != null && input.length()> 0)
		    {
		        input = input.replaceAll("-", " ");
		        input = input.toLowerCase().replaceAll(" and", " ");
		        String[] splittedParts = input.trim().split("\\s+");

		        for(String str : splittedParts)
		        {
		            if(!allowedStrings_England.contains(str))
		            {
		                return "Incorrect entry!";
		            }
		        }		
		    }
			return "Geçerli";
		}
		return "";
	}
		
	public long WordsToNumber( String input ) {
	    long result = 0;
	    long finalResult = 0;
	    boolean negative=false;
		
		if (locale()=="England") {
	        input = input.replaceAll("-", " ");
	        input = input.toLowerCase().replaceAll(" and", " ");
	        String[] splittedParts = input.trim().split("\\s+");
	        for(String str : splittedParts)
            {
	        	if(str.equalsIgnoreCase("minus")) {
	        		negative=true;
	        	}
	        	else if(str.equalsIgnoreCase("zero")) {
                    result += 0;
                }
                else if(str.equalsIgnoreCase("one")) {
                    result += 1;
                }
                else if(str.equalsIgnoreCase("two")) {
                    result += 2;
                }
                else if(str.equalsIgnoreCase("three")) {
                    result += 3;
                }
                else if(str.equalsIgnoreCase("four")) {
                    result += 4;
                }
                else if(str.equalsIgnoreCase("five")) {
                    result += 5;
                }
                else if(str.equalsIgnoreCase("six")) {
                    result += 6;
                }
                else if(str.equalsIgnoreCase("seven")) {
                    result += 7;
                }
                else if(str.equalsIgnoreCase("eight")) {
                    result += 8;
                }
                else if(str.equalsIgnoreCase("nine")) {
                    result += 9;
                }
                else if(str.equalsIgnoreCase("ten")) {
                    result += 10;
                }
                else if(str.equalsIgnoreCase("eleven")) {
                    result += 11;
                }
                else if(str.equalsIgnoreCase("twelve")) {
                    result += 12;
                }
                else if(str.equalsIgnoreCase("thirteen")) {
                    result += 13;
                }
                else if(str.equalsIgnoreCase("fourteen")) {
                    result += 14;
                }
                else if(str.equalsIgnoreCase("fifteen")) {
                    result += 15;
                }
                else if(str.equalsIgnoreCase("sixteen")) {
                    result += 16;
                }
                else if(str.equalsIgnoreCase("seventeen")) {
                    result += 17;
                }
                else if(str.equalsIgnoreCase("eighteen")) {
                    result += 18;
                }
                else if(str.equalsIgnoreCase("nineteen")) {
                    result += 19;
                }
                else if(str.equalsIgnoreCase("twenty")) {
                    result += 20;
                }
                else if(str.equalsIgnoreCase("thirty")) {
                    result += 30;
                }
                else if(str.equalsIgnoreCase("forty")) {
                    result += 40;
                }
                else if(str.equalsIgnoreCase("fifty")) {
                    result += 50;
                }
                else if(str.equalsIgnoreCase("sixty")) {
                    result += 60;
                }
                else if(str.equalsIgnoreCase("seventy")) {
                    result += 70;
                }
                else if(str.equalsIgnoreCase("eighty")) {
                    result += 80;
                }
                else if(str.equalsIgnoreCase("ninety")) {
                    result += 90;
                }
                else if(str.equalsIgnoreCase("hundred")) {
                    result *= 100;
                }
                else if(str.equalsIgnoreCase("thousand")) {
                    result *= 1000;
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("million")) {
                    result *= 1000000;
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("billion")) {
                    result *= (long) Math.pow(10, 9);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("trillion")) {
                    result *= (long) Math.pow(10, 12);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("quadrillion")) {
                    result *= (long) Math.pow(10, 15);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("quintillion")) {
                    result *= (long) Math.pow(10, 18);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("sextillion")) {
                    result *= (long) Math.pow(10, 21);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("septillion")) {
                    result *= (long) Math.pow(10, 24);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("octillion")) {
                    result *= (long) Math.pow(10, 27);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("nonillion")) {
                    result *= (long) Math.pow(10, 30);
                    finalResult += result;
                    result=0;
                }
            }

            finalResult += result;
            if(negative)
            	finalResult = 0 - finalResult;
            result=0;
            return finalResult;
        }
		else if (locale()=="Turkey") {
	        String[] splittedParts = input.trim().split("\\s+");
	        for(String str : splittedParts)
            {
	        	if(str.equalsIgnoreCase("eksi")) {
	        		negative=true;
	        	}
	        	else if(str.equalsIgnoreCase("sýfýr")) {
                    result += 0;
                }
                else if(str.equalsIgnoreCase("bir")) {
                    result += 1;
                }
                else if(str.equalsIgnoreCase("iki")) {
                    result += 2;
                }
                else if(str.equalsIgnoreCase("üç")) {
                    result += 3;
                }
                else if(str.equalsIgnoreCase("dört")) {
                    result += 4;
                }
                else if(str.equalsIgnoreCase("beþ")) {
                    result += 5;
                }
                else if(str.equalsIgnoreCase("altý")) {
                    result += 6;
                }
                else if(str.equalsIgnoreCase("yedi")) {
                    result += 7;
                }
                else if(str.equalsIgnoreCase("sekiz")) {
                    result += 8;
                }
                else if(str.equalsIgnoreCase("dokuz")) {
                    result += 9;
                }
                else if(str.equalsIgnoreCase("on")) {
                    result += 10;
                }
                else if(str.equalsIgnoreCase("yirmi")) {
                    result += 20;
                }
                else if(str.equalsIgnoreCase("otuz")) {
                    result += 30;
                }
                else if(str.equalsIgnoreCase("kýrk")) {
                    result += 40;
                }
                else if(str.equalsIgnoreCase("elli")) {
                    result += 50;
                }
                else if(str.equalsIgnoreCase("altmýþ")) {
                    result += 60;
                }
                else if(str.equalsIgnoreCase("yetmiþ")) {
                    result += 70;
                }
                else if(str.equalsIgnoreCase("seksen")) {
                    result += 80;
                }
                else if(str.equalsIgnoreCase("doksan")) {
                    result += 90;
                }
                else if(str.equalsIgnoreCase("yüz")) {
                	if(result==0)
                		result=1;
                    result *= 100;
                }
                else if(str.equalsIgnoreCase("bin")) {
                	if(result==0)
                		result=1;
                    result *= 1000;
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("milyon")) {
                    result *= 1000000;
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("milyar")) {
                    result *= (long) Math.pow(10, 9);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("trilyon")) {
                    result *= (long) Math.pow(10, 12);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("katrilyon")) {
                    result *= (long) Math.pow(10, 15);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("kentilyon")) {
                    result *= (long) Math.pow(10, 18);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("seksilyon")) {
                    result *= (long) Math.pow(10, 21);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("septilyon")) {
                    result *= (long) Math.pow(10, 24);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("oktilyon")) {
                    result *= (long) Math.pow(10, 27);
                    finalResult += result;
                    result=0;
                }
                else if(str.equalsIgnoreCase("nonilyon")) {
                    result *= (long) Math.pow(10, 30);
                    finalResult += result;
                    result=0;
                }
            }

            finalResult += result;
            if(negative)
            	finalResult = 0 - finalResult;
            result=0;
            result=0;
            return finalResult;
        }     
		
		return 0;
	}


}


