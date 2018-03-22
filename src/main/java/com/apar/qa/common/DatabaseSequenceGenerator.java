package com.apar.qa.common;

import java.math.BigInteger;
import java.text.DecimalFormat;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

@Service
public class DatabaseSequenceGenerator {
	
	@PersistenceContext
	private EntityManager entityManager;

	public String generateUniqueId(String p_prefix, String p_suffix) throws Exception {
		if (p_prefix == null) {
			p_prefix = "";
		}

		if (p_suffix == null) {
			p_suffix = "";
		}

		return p_prefix + generateId() + p_suffix;
	}

	private synchronized String generateId() throws Exception {
		try {
			StoredProcedureQuery proc_stmt = entityManager.createStoredProcedureQuery("Prod_session_sequence");
			proc_stmt.registerStoredProcedureParameter(0, Integer.class, ParameterMode.OUT);
			proc_stmt.execute();
			String identifier = proc_stmt.getOutputParameterValue(0).toString();
			BigInteger bi = new BigInteger(identifier);
			DecimalFormat db = new DecimalFormat("000000");
			String generated_id = db.format(bi);
			return generated_id;
		} catch (Exception e) {
			// ignore
		} finally {
			entityManager.close();
		}
		return null;
	}

}
