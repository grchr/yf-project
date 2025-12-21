package org.opensource.model.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyOfficersItem{

	@JsonProperty("unexercisedValue")
	private UnexercisedValue unexercisedValue;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("name")
	private String name;

	@JsonProperty("exercisedValue")
	private ExercisedValue exercisedValue;

	@JsonProperty("title")
	private String title;

	@JsonProperty("fiscalYear")
	private Integer fiscalYear;

	@JsonProperty("yearBorn")
	private Integer yearBorn;

	@JsonProperty("age")
	private Integer age;

	@JsonProperty("totalPay")
	private TotalPay totalPay;

	public UnexercisedValue getUnexercisedValue(){
		return unexercisedValue;
	}

	public Integer getMaxAge(){
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

	public Integer getFiscalYear(){
		return fiscalYear;
	}

	public Integer getYearBorn(){
		return yearBorn;
	}

	public Integer getAge(){
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