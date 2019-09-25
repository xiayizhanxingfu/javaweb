package com.kai.bean;

/**
 * Classify entity. @author MyEclipse Persistence Tools
 */

public class Classify implements java.io.Serializable {

	// Fields

	private Integer classifyId;
	private String classifyName;

	// Constructors

	/** default constructor */
	public Classify() {
	}

	/** minimal constructor */
	public Classify(Integer classifyId) {
		this.classifyId = classifyId;
	}

	/** full constructor */
	public Classify(Integer classifyId, String classifyName) {
		this.classifyId = classifyId;
		this.classifyName = classifyName;
	}

	// Property accessors

	public Integer getClassifyId() {
		return this.classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public String getClassifyName() {
		return this.classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

}