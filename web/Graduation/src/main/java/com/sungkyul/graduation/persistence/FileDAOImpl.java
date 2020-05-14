package com.sungkyul.graduation.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAOImpl implements FileDAO{

	@Inject
	private SqlSession session;
	
	private static final String NS = "com.sungkyul.graduation.persistence.UserFileMapper";
	
}
