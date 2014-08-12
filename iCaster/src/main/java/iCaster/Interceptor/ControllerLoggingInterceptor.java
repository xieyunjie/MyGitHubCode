package iCaster.Interceptor;

import iCaster.Annotation.ControllerLogging;
import iCaster.Util.CurrentFacesContext;
import iCaster.Util.WebSecurityUtil;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import net.sf.json.JSONObject;

import org.slf4j.MDC;

@ControllerLogging
@Interceptor
public class ControllerLoggingInterceptor implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ControllerLoggingInterceptor.class.getSimpleName());

	@AroundInvoke
	public Object ControllerIntercept(InvocationContext invocationContext) throws Exception
	{
		try
		{
			String methodStr = invocationContext.getMethod().getDeclaringClass().getSimpleName() + "." + invocationContext.getMethod().getName();

			Boolean canProceed = true;

			MDC.put("Exception", canProceed == false ? "你没有该操作权限，请与管理员联系。" : "");
			MDC.put("Action", invocationContext.getMethod().getName());
			MDC.put("Method", methodStr);
			MDC.put("ClientIp", CurrentFacesContext.getRequest().getRemoteAddr());
			MDC.put("RequestUrl", CurrentFacesContext.getRequest().getServletPath());
			MDC.put("AppUid", "AppUid");
			MDC.put("AppName", "iCaster");
			MDC.put("UserUid", WebSecurityUtil.getUserDetails().getUserUID());
			MDC.put("UserName", WebSecurityUtil.getUserDetails().getUsername());
			MDC.put("EmpUid", WebSecurityUtil.getUserDetails().getEmployeeUID());
			MDC.put("EmpName", WebSecurityUtil.getUserDetails().getEmployeeName());
			if (invocationContext.getParameters().length > 0)
			{
				JSONObject jsonObject = new JSONObject();
				MDC.put("Params", jsonObject.accumulate("params", invocationContext.getParameters()).toString());
			}
			else
			{
				MDC.put("Params", "");
			}

			logger.info("controller Intercept");

			Object resultObject = invocationContext.proceed();

			return resultObject;

		}

		catch (Exception e)
		{
			throw e;
		}
	}

}
