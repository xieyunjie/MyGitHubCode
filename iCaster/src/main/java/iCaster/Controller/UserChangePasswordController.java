package iCaster.Controller;

import iCaster.Model.UserChangePassword;
import iCaster.Util.MessageUtil;
import iCaster.Util.WebSecurityUtil;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;

@Named
@ViewScoped
public class UserChangePasswordController extends BaseController
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void initResource()
	{
		this.userChangePassword = new UserChangePassword();
		this.userChangePassword.setUserName(WebSecurityUtil.getUserDetails().getUsername());
		this.userChangePassword.setUserUID(WebSecurityUtil.getUserDetails().getUserUID());
	}

	private UserChangePassword userChangePassword;

	public UserChangePassword getUserChangePassword()
	{
		return userChangePassword;
	}

	public void setUserChangePassword(UserChangePassword userChangePassword)
	{
		this.userChangePassword = userChangePassword;
	}

	@SuppressWarnings("deprecation")
	@Inject
	private PasswordEncoder passwordEncoder;

	@Inject
	private SaltSource saltSource;

	public void changePassword()
	{
		Object salt = saltSource.getSalt(WebSecurityUtil.getUserDetails());
		@SuppressWarnings("deprecation")
		String password = passwordEncoder.encodePassword(this.userChangePassword.getNewPassword(), salt);

		// CurrentFacesContext.getFacesContext().addMessage(null, new
		// FacesMessage(FacesMessage.SEVERITY_INFO, "新密码加密后：", password));

		MessageUtil.addInfoMessageWithoutKey("", password);
	}

	public void test(AjaxBehaviorEvent event)
	{
		System.out.println("@@@@@##@$!@");
	}

}
