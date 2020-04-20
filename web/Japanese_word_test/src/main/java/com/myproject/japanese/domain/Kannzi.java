package com.myproject.japanese.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Kannzi extends Word{
	private String kannzi;
	private String hurigana;
	
	public Kannzi() {};
	public Kannzi(String kannzi, String hurigana, String meaning) {
		super.meaning = meaning;
		this.kannzi = kannzi;
		this.hurigana = hurigana;
	}
	
}
