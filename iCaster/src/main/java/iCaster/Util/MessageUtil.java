package iCaster.Util;

import java.text.MessageFormat;

import javax.faces.application.FacesMessage;

public class MessageUtil
{
	public static void addInfoMessage(String localeKey)
	{
		String message = LocaleUtil.getLocaleMessage(localeKey);
		CurrentFacesContext.getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "系统提示", message));
	}

	public static void addInfoMessage(String summaryKey, String detailKey)
	{
		String summary = LocaleUtil.getLocaleMessage(summaryKey);
		String message = LocaleUtil.getLocaleMessage(detailKey);

		CurrentFacesContext.getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, message));
	}

	public static void addInfoMessage(String localeKey, Object... args)
	{
		String message = LocaleUtil.getLocaleMessage(localeKey);
		if (args != null)
		{
			message = MessageFormat.format(message, args);
		}
		CurrentFacesContext.getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "系统提示", message));
	}

	public static void addInfoMessageWithoutKey(String summary, String detail)
	{
		CurrentFacesContext.getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}
}
