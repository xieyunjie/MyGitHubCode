package iCaster.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the membership_user database table.
 * 
 */
@Entity
@Table(name="membership_user")
@NamedQuery(name="MembershipUser.findAll", query="SELECT m FROM MembershipUser m")
public class MembershipUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private byte enable;

	private String password;

	private String userName;

	public MembershipUser() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}