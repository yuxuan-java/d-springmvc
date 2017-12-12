package org.yuxuan.springmvc.domain;

import java.io.Serializable;

public class DemoObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4757724568190591740L;
	
	@Override
	public String toString() {
		return "DemoObj [id=" + id + ", name=" + name + "]";
	}

	private Long id;
	
	private String name;

	public DemoObj() {
		super();
	}

	public DemoObj(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
