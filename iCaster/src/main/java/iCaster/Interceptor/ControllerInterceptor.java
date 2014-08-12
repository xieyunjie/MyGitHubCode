package iCaster.Interceptor;

import iCaster.Annotation.Interceptor;
import iCaster.Entity.MembershipResourceAuthority;
import iCaster.Security.WebUserDetails;
import iCaster.Util.CurrentFacesContext;
import iCaster.Util.WebSecurityUtil;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.MDC;

@Interceptor
@javax.interceptor.Interceptor
public class ControllerInterceptor implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ControllerInterceptor.class.getSimpleName());

	@AroundInvoke
	public Object ControllerIntercept(InvocationContext invocationContext) throws Exception
	{
		try
		{
			String methodStr = invocationContext.getMethod().getDeclaringClass().getSimpleName() + "." + invocationContext.getMethod().getName();

			Boolean canProceed = false;
			// 判断是否只是Setter或者Getter
			if (DecideGetterSetter.decide(invocationContext.getMethod()) == true)
			{
				canProceed = true;
			}
			else
			{
				// 权限判断
				WebUserDetails user = WebSecurityUtil.getUserDetails();
				for (MembershipResourceAuthority resourceAuthority : user.getUserAuthorities())
				{
					if (resourceAuthority.getUrl().compareToIgnoreCase(methodStr) == 0)
					{
						canProceed = true;
						break;
					}
				}
			}

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

			if (canProceed == false)
			{
				CurrentFacesContext.getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "操作失败", "你没有该操作权限，请与管理员联系。"));
			}
			else
			{
				Object resultObject = invocationContext.proceed();

				return resultObject;
			}

			return null;

		}

		catch (Exception e)
		{
			throw e;
		}
	}

}
