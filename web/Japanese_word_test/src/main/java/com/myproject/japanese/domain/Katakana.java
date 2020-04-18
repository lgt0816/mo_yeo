package com.myproject.japanese.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Katakana extends Word{
	private String katakana;
	
	public Katakana() {}
	public Katakana(String katakana, String meaning) {
		super.meaning = meaning;
		this.katakana = katakana;
	}
}
