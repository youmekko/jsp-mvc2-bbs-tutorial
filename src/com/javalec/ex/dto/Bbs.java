package com.javalec.ex.dto;

import java.sql.Timestamp;

public class Bbs {

	int bbsId, bbsHit, bbsGroup, bbsStep, bbsIndent;
	String bbsName, bbsContent;
	Timestamp bbsDate;

	public Bbs(int bbsId, String bbsName, String bbsTitle, String bbsContent, Timestamp bbsDate, int bbsHit,
			int bbsGroup, int bbsStep, int bbsIndent) {
		super();
		this.bbsId = bbsId;
		this.bbsHit = bbsHit;
		this.bbsGroup = bbsGroup;
		this.bbsStep = bbsStep;
		this.bbsIndent = bbsIndent;
		this.bbsName = bbsName;
		this.bbsDate = bbsDate;
		this.bbsContent = bbsContent;
	}

	public int getBbsId() {
		return bbsId;
	}

	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}

	public int getBbsHit() {
		return bbsHit;
	}

	public void setBbsHit(int bbsHit) {
		this.bbsHit = bbsHit;
	}

	public int getBbsGroup() {
		return bbsGroup;
	}

	public void setBbsGroup(int bbsGroup) {
		this.bbsGroup = bbsGroup;
	}

	public int getBbsStep() {
		return bbsStep;
	}

	public void setBbsStep(int bbsStep) {
		this.bbsStep = bbsStep;
	}

	public int getBbsIndent() {
		return bbsIndent;
	}

	public void setBbsIndent(int bbsIndent) {
		this.bbsIndent = bbsIndent;
	}

	public String getBbsName() {
		return bbsName;
	}

	public void setBbsName(String bbsName) {
		this.bbsName = bbsName;
	}

	public Timestamp getBbsDate() {
		return bbsDate;
	}

	public void setBbsDate(Timestamp bbsDate) {
		this.bbsDate = bbsDate;
	}

	public String getBbsContent() {
		return bbsContent;
	}

	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}

}
