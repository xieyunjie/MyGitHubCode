package iCaster.Util;

import java.util.ResourceBundle;

public class LocaleUtil
{

	public static String getLocaleMessage(String key)
	{
		// UIViewRoot viewRoot =
		// CurrentFacesContext.getFacesContext().getViewRoot();
		// Locale locale = viewRoot.getLocale();
		//
		// if (localeClassLoader == null)
		// {
		// localeClassLoader = Thread.currentThread().getContextClassLoader();
		// if (localeClassLoader == null)
		// {
		// localeClassLoader = ClassLoader.getSystemClassLoader();
		// }
		// }
		//
		// ResourceBundle bundle = ResourceBundle.getBundle("locale.messages",
		// locale, localeClassLoader);

		ResourceBundle bundle = CurrentFacesContext.getFacesContext().getApplication().getResourceBundle(CurrentFacesContext.getFacesContext(), "msgs");
		return bundle.getString(key);
	}
}
