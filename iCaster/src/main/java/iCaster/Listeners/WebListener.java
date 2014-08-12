package iCaster.Listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebListener implements ServletContextListener
{
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent)
	{
		System.out.println("Application Startup!");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent)
	{
		System.out.println("Application Shutdown!");
		
	} 

}
