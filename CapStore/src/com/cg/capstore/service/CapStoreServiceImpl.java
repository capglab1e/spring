package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capstore.dao.CapStoreDao;
import com.cg.capstore.dto.Store;


@Service("service")
@Transactional
public class CapStoreServiceImpl implements CapStoreService
{
	@Autowired
	CapStoreDao dao;

	@Override
	public List<Store> getAllProducts(Integer cat) 
	{
		// TODO Auto-generated method stub
		return dao.getAllProducts(cat);
	}

}
