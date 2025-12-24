package org.opensource.model.response.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyOfficersItem{

	@JsonProperty("unexercisedValue")
	private UnexercisedValue unexercisedValue;

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("name")
	private String name;

	@JsonProperty("exercisedValue")
	private ExercisedValue exercisedValue;

	@JsonProperty("title")
	private String title;

	@JsonProperty("fiscalYear")
	private Long fiscalYear;

	@JsonProperty("yearBorn")
	private Long yearBorn;

	@JsonProperty("age")
	private Long age;

	@JsonProperty("totalPay")
	private TotalPay totalPay;

	public UnexercisedValue getUnexercisedValue(){
		return unexercisedValue;
	}

	public Long getMaxAge(){
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

	public Long getFiscalYear(){
		return fiscalYear;
	}

	public Long getYearBorn(){
		return yearBorn;
	}

	public Long getAge(){
		return age;
	}

	public TotalPay getTotalPay(){
		return totalPay;
	}

	@Override
 	public String toString(){
		return
			"CompanyOfficersItem{" +
			"unexercisedValue = '" + unexercisedValue + '\'' +
			",maxAge = '" + maxAge + '\'' +
			",name = '" + name + '\'' +
			",exercisedValue = '" + exercisedValue + '\'' +
			",title = '" + title + '\'' +
			",fiscalYear = '" + fiscalYear + '\'' +
			",yearBorn = '" + yearBorn + '\'' +
			",age = '" + age + '\'' +
			",totalPay = '" + totalPay + '\'' +
			"}";
		}
}