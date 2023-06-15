package com.cjc.carloan.model;

import lombok.Data;

@Data
public class Cibil {
	private Integer cibilId;
	private Integer cibilScore;
	private String cibilScoreDate;
	private String status;
	private String remark;

}
