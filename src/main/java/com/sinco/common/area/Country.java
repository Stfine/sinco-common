package com.sinco.common.area;

import java.util.Currency;

public class Country {
	
	public Country(Continent continent,String zhName, String code) {
		super();
		this.zhName = zhName;
		this.code = code;
		this.continent = continent;
	}
	
	public Country(Continent continent,String zhName,String enName,String code,Currency currency) {
		super();
		this.zhName = zhName;
		this.enName = enName;
		this.code = code;
		this.continent = continent;
		this.currency=currency;
		this.currencyCode = currency.getCurrencyCode();
	}
	
	public Country(Continent continent,String zhName,String enName,String code,Currency currency, String language) {
		super();
		this.zhName = zhName;
		this.enName = enName;
		this.code = code;
		this.continent = continent;
		this.currency=currency;
		this.currencyCode = currency.getCurrencyCode();
		this.language = language;
	}
	
	private String zhName;
	
	private String enName;
	
	private String code;
	
	private Continent continent;
	
	private Currency currency;
	
	private String currencyCode;
	
	private String language;
	
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getZhName() {
		return zhName;
	}

	public void setZhName(String zhName) {
		this.zhName = zhName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Continent getContinent() {
		return continent;
	}
	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
