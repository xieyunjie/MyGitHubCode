package iCaster.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the membership_authority database table.
 * 
 */
@Entity
@Table(name="membership_authority")
@NamedQuery(name="MembershipAuthority.findAll", query="SELECT m FROM MembershipAuthority m")
public class MembershipAuthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String authName;

	private byte enable;

	public MembershipAuthority() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

}