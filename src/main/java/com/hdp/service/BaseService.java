package com.hdp.service;

import java.util.List;

public interface BaseService<E> {
	int insert(E obj);
	int delete(int id);
	int update(E obj);
	E queryObject(int id);
	int queryCount();
	List<E> queryALL();
	List<E> queryPage(int offset,int size);
	int querySearchCount(String search);
	List<E> querySearchPage(String search,int offset,int size);
}
