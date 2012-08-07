package org.bitducks.gamenav.ejb.session.entityutil;

import java.util.List;

import javax.ejb.Remote;

import org.bitducks.gamenav.ejb.entity.Univers;

@Remote
public interface UniversService {
	List<Univers> getAllUnivers();
}
