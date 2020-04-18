package com.myproject.japanese.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JapanesWordLists {
	
	private List<Word> list;
	
	private List<Kannzi> nounWords1;	//음독명사 리스트
	private List<Kannzi> nounWords2;	//훈독명사 리스트
	private List<Kannzi> verbWords;	//동사 리스트
	private List<Kannzi> iAdjectiveWords;	//い형용사 리스트
	private List<Kannzi> naAdjectiveWords;	//な형용사 리스트
	private List<Kannzi> adverbWrods;		//부사 리스트
	private List<Katakana> katakanaWords;	//카타카나 리스트
	
	public JapanesWordLists() {
		nounWords1 = new ArrayList<Kannzi>();
		nounWords2 = new ArrayList<Kannzi>();
		verbWords = new ArrayList<Kannzi>();
		iAdjectiveWords = new ArrayList<Kannzi>();
		naAdjectiveWords = new ArrayList<Kannzi>();
		adverbWrods = new ArrayList<Kannzi>();
		katakanaWords = new ArrayList<Katakana>();
	}
	
}
