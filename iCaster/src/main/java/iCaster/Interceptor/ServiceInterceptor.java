package iCaster.Interceptor;

import iCaster.Annotation.Interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Interceptor
@javax.interceptor.Interceptor
public class ServiceInterceptor implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private static Logger logger =
	// org.slf4j.LoggerFactory.getLogger(ServiceInterceptor.class.getSimpleName());

	@AroundInvoke
	public Object ServiceIntercept(InvocationContext invocationContext) throws Exception
	{
		try
		{
			System.out.println("################ serviceIntercept Begin");

			// MDC.put("Exception", "Exception");
			// MDC.put("Action", "Action");
			//
			// MDC.put("Method", invocationContext.getMethod().getName());
			// MDC.put("ClientIp", "ClientIp");
			// MDC.put("RequestUrl", Resources.getRequest().getServletPath());
			// MDC.put("AppUid", "AppUid");
			// MDC.put("AppName", "AppName");
			// MDC.put("UserUid", "UserUid");
			// MDC.put("UserName", "UserName");
			// MDC.put("EmpUid", "EmpUid");
			// MDC.put("EmpName", "EmpName");
			// JSONObject jsonObject = new JSONObject();
			// MDC.put("Params", jsonObject.accumulate("params",
			// invocationContext.getParameters()).toString());
			//

			// logger.info("message");

			// MDC.clear();

			// logger.info("########################### message ##################################");

			Object resultObject = invocationContext.proceed();
			System.out.println("################ serviceIntercept End");

			return resultObject;
		}

		catch (Exception e)
		{
			throw e;
		}
	}

}
