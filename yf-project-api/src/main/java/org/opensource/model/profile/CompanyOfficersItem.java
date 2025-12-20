package org.opensource.model.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyOfficersItem{

	@JsonProperty("unexercisedValue")
	private UnexercisedValue unexercisedValue;

	@JsonProperty("maxAge")
	private int maxAge;

	@JsonProperty("name")
	private String name;

	@JsonProperty("exercisedValue")
	private ExercisedValue exercisedValue;

	@JsonProperty("title")
	private String title;

	@JsonProperty("fiscalYear")
	private int fiscalYear;

	@JsonProperty("yearBorn")
	private int yearBorn;

	@JsonProperty("age")
	private int age;

	@JsonProperty("totalPay")
	private TotalPay totalPay;

	public UnexercisedValue getUnexercisedValue(){
		return unexercisedValue;
	}

	public int getMaxAge(){
		return maxAge;
	}

	public String getName(){
		return name;
	}

	public ExercisedValue getExercisedValue(){
		return exercisedValue;
	}

	public String getTitle(){
		return title;
	}

	public int getFiscalYear(){
		return fiscalYear;
	}

	public int getYearBorn(){
		return yearBorn;
	}

	public int getAge(){
		return age;
	}

	public TotalPay getTotalPay(){
		return totalPay;
	}
}