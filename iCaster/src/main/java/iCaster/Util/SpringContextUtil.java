package iCaster.Util;

import javax.enterprise.inject.Produces;

import org.jboss.seam.spring.context.SpringContext;
import org.jboss.seam.spring.context.Web;
import org.jboss.seam.spring.inject.SpringBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;

@SuppressWarnings("deprecation")
public class SpringContextUtil
{

	@Produces
	@SpringContext
	@Web 
	public ApplicationContext context;
	
	
	@Produces
	@SpringBean
	private PasswordEncoder passwordEncoder;
	
	@Produces
	@SpringBean
	private SaltSource saltSource;
}
