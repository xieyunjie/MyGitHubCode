package iCaster.Controller;

import iCaster.Annotation.Controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
 
@Controller
public class MasterLayourController  extends BaseController
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String employeeName;
	private String postName;
	private String orgenizationName;

	@PostConstruct
	public void initResource()
	{
		this.employeeName = "yunjie.xie";
		this.postName = "程序员";
		this.orgenizationName = "分享网讯";
	}

	public MasterLayourController()
	{

	}

	public String getEmployeeName()
	{
		return employeeName;
	}

	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}

	public String getPostName()
	{
		return postName;
	}

	public void setPostName(String postName)
	{
		this.postName = postName;
	}

	public String getOrgenizationName()
	{
		return orgenizationName;
	}

	public void setOrgenizationName(String orgenizationName)
	{
		this.orgenizationName = orgenizationName;
	}

}
