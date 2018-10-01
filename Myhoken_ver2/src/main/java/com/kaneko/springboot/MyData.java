package com.kaneko.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity //エンティティクラスであることを示すアノテーション

@Table(name="mydata")//このエンティティクラスに割り当てられるテーブルを指定する。nameでテーブル名を指定。省略化
public class MyData {

	@Id//プライマリキーを指定

	@GeneratedValue(strategy=GenerationType.AUTO)//プライマリキーに対して値を自動生成する。strategyに生成方法を指定。AUTOで自動的に値を割り振る。

	//フィールドに割り当てられるコラム名を指定、省略可。name(カラム名指定) length(文字の最大の長さ）,nullable(nullを許可するかどうかを指定）
	@Column
	private long id;

	@Column(length=50,nullable=false)
	private String name;

	@Column(length=200,nullable=true)
	private String mail;

	@Column(nullable=false)
	private Integer age;

	@Column(nullable=false)
	private String memo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}





}
