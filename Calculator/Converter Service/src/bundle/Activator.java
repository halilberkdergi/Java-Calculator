package bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import converterserviceimpl.ConverterServiceImpl;
import converterservice.ConverterService;

public class Activator implements BundleActivator {
	  private static BundleContext context;
	  
	   static BundleContext getContext() {
	       return context;
	   }
	 
	   public void start(BundleContext bundleContext) throws Exception {
	       Activator.context = bundleContext;
	        
	       System.out.println("Registry Service ConverterService...");
	        
	       this.registryMathService();
	        
	       System.out.println("OSGi ConverterService Started");
	   }
	 
	   private void registryMathService() {
		   ConverterService service = new ConverterServiceImpl();
	       context.registerService(ConverterService.class.getName(), service, null);
	   }
	 
	   public void stop(BundleContext bundleContext) throws Exception {
	       Activator.context = null;
	       System.out.println("OSGi ConverterService Stopped!");
	   }
	 
	}