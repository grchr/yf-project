package org.opensource.model.keystats;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SummaryProfile{

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("country")
	private String country;

	@JsonProperty("website")
	private String website;

	@JsonProperty("industryDisp")
	private String industryDisp;

	@JsonProperty("city")
	private String city;

	@JsonProperty("address1")
	private String address1;

	@JsonProperty("companyOfficers")
	private List<Object> companyOfficers;

	@JsonProperty("industry")
	private String industry;

	@JsonProperty("executiveTeam")
	private List<Object> executiveTeam;

	@JsonProperty("fullTimeEmployees")
	private Integer fullTimeEmployees;

	@JsonProperty("longBusinessSummary")
	private String longBusinessSummary;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("sectorKey")
	private String sectorKey;

	@JsonProperty("sector")
	private String sector;

	@JsonProperty("sectorDisp")
	private String sectorDisp;

	@JsonProperty("industryKey")
	private String industryKey;

	public String getZip(){
		return zip;
	}

	public String getCountry(){
		return country;
	}

	public String getWebsite(){
		return website;
	}

	public String getIndustryDisp(){
		return industryDisp;
	}

	public String getCity(){
		return city;
	}

	public String getAddress1(){
		return address1;
	}

	public List<Object> getCompanyOfficers(){
		return companyOfficers;
	}

	public String getIndustry(){
		return industry;
	}

	public List<Object> getExecutiveTeam(){
		return executiveTeam;
	}

	public Integer getFullTimeEmployees(){
		return fullTimeEmployees;
	}

	public String getLongBusinessSummary(){
		return longBusinessSummary;
	}

	public String getPhone(){
		return phone;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public String getSectorKey(){
		return sectorKey;
	}

	public String getSector(){
		return sector;
	}

	public String getSectorDisp(){
		return sectorDisp;
	}

	public String getIndustryKey(){
		return industryKey;
	}

	@Override
 	public String toString(){
		return 
			"SummaryProfile{" + 
			"zip = '" + zip + '\'' + 
			",country = '" + country + '\'' + 
			",website = '" + website + '\'' + 
			",industryDisp = '" + industryDisp + '\'' + 
			",city = '" + city + '\'' + 
			",address1 = '" + address1 + '\'' + 
			",companyOfficers = '" + companyOfficers + '\'' + 
			",industry = '" + industry + '\'' + 
			",executiveTeam = '" + executiveTeam + '\'' + 
			",fullTimeEmployees = '" + fullTimeEmployees + '\'' + 
			",longBusinessSummary = '" + longBusinessSummary + '\'' + 
			",phone = '" + phone + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",sectorKey = '" + sectorKey + '\'' + 
			",sector = '" + sector + '\'' + 
			",sectorDisp = '" + sectorDisp + '\'' + 
			",industryKey = '" + industryKey + '\'' + 
			"}";
		}
}