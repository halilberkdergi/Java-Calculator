package calculatorservice;
 
import converterservice.ConverterService;

import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

 
 

 
public class Activator implements BundleActivator {
 
   private static BundleContext context;

   private JFrame frame;
   private JTextField birincideger;
   private JTextField ikincideger;
   private JTextField cevap;
   String error1="Sýfýra bölünemez.";
   String error2="Tam bölünemez";
	
   boolean	hesapla = true;

 
   static BundleContext getContext() {
       return context;
   }

   public void start(BundleContext bundleContext) throws Exception {

       Activator.context = bundleContext;
       System.out.println("CalculatorService Starting...");
       
       ServiceReference<?> serviceReference = context
               .getServiceReference(ConverterService.class);
       ConverterService service2 = (ConverterService) context
               .getService(serviceReference);
       
       EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					if(service2.locale().equals("England")){
						error1="Cannot be divided by zero.";
						error2="It cannot be divided completely.";
					}

					frame = new JFrame();
					frame.setBounds(100, 100, 783, 247);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(null);
					frame.setVisible(true);
					
					birincideger = new JTextField();
					birincideger.setBounds(128, 21, 631, 37);
					frame.getContentPane().add(birincideger);
					birincideger.setColumns(10);
					
					
					JLabel sayý1 = new JLabel("Birinci Say\u0131");
					sayý1.setHorizontalAlignment(SwingConstants.RIGHT);
					sayý1.setBounds(22, 19, 96, 37);
					sayý1.setFont(new Font("Tahoma", Font.BOLD, 15));
					frame.getContentPane().add(sayý1);
						
					JLabel sayý2 = new JLabel("\u0130kinci Say\u0131");
					sayý2.setHorizontalAlignment(SwingConstants.RIGHT);
					sayý2.setBounds(22, 66, 96, 37);
					sayý2.setFont(new Font("Tahoma", Font.BOLD, 15));
					frame.getContentPane().add(sayý2);
						
					JLabel Sonuc = new JLabel("Sonu\u00E7");
					Sonuc.setHorizontalAlignment(SwingConstants.RIGHT);
					Sonuc.setBounds(61, 111, 57, 37);
					Sonuc.setFont(new Font("Tahoma", Font.BOLD, 15));
					frame.getContentPane().add(Sonuc);
						
						
					ikincideger = new JTextField();
					ikincideger.setBounds(128, 68, 631, 37);
					ikincideger.setColumns(10);
					frame.getContentPane().add(ikincideger);
					
					
					cevap = new JTextField();
					cevap.setBounds(128, 113, 631, 37);
					cevap.setColumns(10);
					frame.getContentPane().add(cevap);
					
					JButton Btoplama = new JButton("Topla");
					Btoplama.setBounds(128, 160, 117, 37);
					Btoplama.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
				
							if ( service2.isValidInput( birincideger.getText()) !="Geçerli")   {
								birincideger.setText (service2.isValidInput( birincideger.getText()));
							}
							if  (  service2.isValidInput( ikincideger.getText()) !="Geçerli" )  {
								ikincideger.setText (service2.isValidInput( ikincideger.getText()));
							}
							else {
								long sonuc = service2.WordsToNumber( birincideger.getText()) + service2.WordsToNumber( ikincideger.getText());
								cevap.setText(service2.NumberToWords( sonuc ));		
							}
						
						}
					});
					Btoplama.setFont(new Font("Tahoma", Font.BOLD, 14));
					frame.getContentPane().add(Btoplama);
					
					JButton Bcikarma = new JButton("\u00C7\u0131kar");
					Bcikarma.setBounds(255, 160, 117, 37);
					Bcikarma.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if ( service2.isValidInput( birincideger.getText()) !="Geçerli")   {
								birincideger.setText (service2.isValidInput( birincideger.getText()));
							}
							if  (  service2.isValidInput( ikincideger.getText()) !="Geçerli" )  {
								ikincideger.setText (service2.isValidInput( ikincideger.getText()));
							}
							else {
								long sonuc = service2.WordsToNumber( birincideger.getText()) - service2.WordsToNumber( ikincideger.getText());
								cevap.setText(service2.NumberToWords( sonuc ));		
							}
						}
					});
					Bcikarma.setFont(new Font("Tahoma", Font.BOLD, 14));
					frame.getContentPane().add(Bcikarma);
					
					JButton Bçarpma = new JButton("\u00C7arp");
					Bçarpma.setBounds(382, 160, 117, 37);
					Bçarpma.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if ( service2.isValidInput( birincideger.getText()) !="Geçerli")   {
								birincideger.setText (service2.isValidInput( birincideger.getText()));
							}
							if  (  service2.isValidInput( ikincideger.getText()) !="Geçerli" )  {
								ikincideger.setText (service2.isValidInput( ikincideger.getText()));
							}
							else {
								long sonuc = service2.WordsToNumber( birincideger.getText()) * service2.WordsToNumber( ikincideger.getText());
								cevap.setText(service2.NumberToWords( sonuc ));	
							}
						}
					});
					Bçarpma.setFont(new Font("Tahoma", Font.BOLD, 14));
					frame.getContentPane().add(Bçarpma);
					
					
					JButton Bbolme = new JButton("B\u00F6l");
					Bbolme.setBounds(509, 160, 117, 37);
					Bbolme.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if ( service2.isValidInput( birincideger.getText()) !="Geçerli")   {
								birincideger.setText (service2.isValidInput( birincideger.getText()));
							}
							if  (  service2.isValidInput( ikincideger.getText()) !="Geçerli" )  {
								ikincideger.setText (service2.isValidInput( ikincideger.getText()));
							}
							if((service2.WordsToNumber( birincideger.getText())) % (service2.WordsToNumber( ikincideger.getText())) != 0) {
								cevap.setText( error2 );
								hesapla=false;					
							}
									
							if (service2.WordsToNumber( ikincideger.getText())==0) {
								cevap.setText( error1 );
								hesapla =false;
							}
								
							if(hesapla) {
							
								long sonuc = service2.WordsToNumber( birincideger.getText()) / service2.WordsToNumber( ikincideger.getText());
								cevap.setText(service2.NumberToWords( sonuc ));		
							}
						}
					});
					Bbolme.setFont(new Font("Tahoma", Font.BOLD, 14));
					frame.getContentPane().add(Bbolme);
					
					if(service2.locale().equals("England")){
						sayý1.setText("First Number");
						sayý1.setHorizontalAlignment(SwingConstants.RIGHT);
						sayý1.setBounds(10, 20, 108, 37);
						sayý1.setFont(new Font("Tahoma", Font.BOLD, 13));
						
						
						sayý2.setText("Second Number");
						sayý2.setHorizontalAlignment(SwingConstants.RIGHT);
						sayý2.setBounds(10, 66, 108, 37);
						sayý2.setFont(new Font("Tahoma", Font.BOLD, 13));
						
						
						Sonuc.setText("Result");
						Sonuc.setHorizontalAlignment(SwingConstants.RIGHT);
						Sonuc.setBounds(49, 113, 69, 37);
						Sonuc.setFont(new Font("Tahoma", Font.BOLD, 13));
						
						Bbolme.setText("Divide");
						Bçarpma.setText("Multiply");
						Btoplama.setText("Sum");
						Bcikarma.setText("Subtract");
						
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
       });

     
           
       System.out.println("CalculatorService Started");
       
   }
 
  
   public void stop(BundleContext bundleContext) throws Exception {
       Activator.context = null;
       frame.setVisible(false);
       System.out.println("CalculatorService Stopped");
       
   }


}