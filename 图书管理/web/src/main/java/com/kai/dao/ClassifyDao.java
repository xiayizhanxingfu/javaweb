package com.kai.dao;

import java.util.List;

import com.kai.bean.Classify;

public interface ClassifyDao {

	/**
	 * 	根据classify_id获取图书分类信息
	 * @param classify_id
	 * @return
	 */
	Classify getClassify(int classify_id);
	/**
	 * 	获取所有图书分类信息
	 * @return
	 */
	List<Classify> getAll();
	/**
	 * 	判断是否存在classify_id
	 * @param classify_id
	 * @return true:存在,false:不存在
	 */
	boolean exist(int classify_id);
	/**
	 * 	删除分类classify_id
	 * @param classify_id
	 * @return
	 */
	boolean delete(int classify_id);
	/**
	 * 	更新图书分类信息
	 * @param classify
	 * @return
	 */
	boolean update(Classify classify);
	/**
	 * 	添加图书分类信息
	 * @param classify
	 * @return
	 */
	boolean addClassify(Classify classify);

}
