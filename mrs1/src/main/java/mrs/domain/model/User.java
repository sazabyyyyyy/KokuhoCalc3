package mrs.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Tableアノテーションを付与してマッピング先のテーブル名を指定する
@Table(name="usr")
public class User {

	@Id

	private String userId;

	private String password;

	private String firstName;

	private String lastName;

	//Enumratedアノテーションを付与してユーザー権限をENnumにマッピングする。カラムの間にEnumの文字列表現が格納されるようにEnum/STRINGを指定している
	@Enumerated(EnumType.STRING)
	private RollName roleName;


	//Getter/Setter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RollName getRoleName() {
		return roleName;
	}

	public void setRoleName(RollName roleName) {
		this.roleName = roleName;
	}




}
