package iCaster.Interceptor;

import java.lang.reflect.Method;

public class DecideGetterSetter
{
	public static boolean decide(Method method)
	{
 
		if (isSetter(method) == true)
		{
			return true;
		}
		else if (isGetter(method) == true)
		{
			return true;
		}
		
		return false;
	}
	
	private static boolean isSetter(Method method)
	{
		if (method.getName().startsWith("set")
				&& method.getParameterTypes().length == 1 
				&& void.class.equals(method.getReturnType()) == true)
		{
			return true;
		}
		
		return false;
		
	}
	private static boolean isGetter(Method method)
	{
		// ��set��ͷ ��һ������ ����ֵΪvoid
		if (method.getName().startsWith("get")
				&& method.getParameterTypes().length == 0
				&& void.class.equals(method.getReturnType()) == false)
		{
			return  true;
		}
		
		return false;
	}
}
