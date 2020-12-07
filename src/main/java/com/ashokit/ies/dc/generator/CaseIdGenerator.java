package com.ashokit.ies.dc.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CaseIdGenerator implements IdentifierGenerator {

	private static final String GET_AR_SEQUENCE = "select caseId_seq.nextval from dual";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Integer caseId = 0;
		try {
			Connection con = session.connection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(GET_AR_SEQUENCE);

			if (rs.next()) {
				caseId = rs.getInt(1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return caseId;
	}

}
