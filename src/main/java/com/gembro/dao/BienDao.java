/**
 * 
 */
package com.gembro.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.gembro.model.Bien;

/**
 * @author quocanh
 *
 */
@Transactional
public interface BienDao extends CrudRepository<Bien, Long>{
	public Bien findById(int Id);
}
