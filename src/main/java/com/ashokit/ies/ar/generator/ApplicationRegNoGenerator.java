package com.ashokit.ies.ar.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ApplicationRegNoGenerator implements IdentifierGenerator {

	Integer suffix = null;
	private static final String prefix="AR";
	private static final String GET_AR_SEQUENCE="select ar_seq.nextval from dual";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
       
		try {
			Connection con = session.connection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(GET_AR_SEQUENCE);

			if (rs.next()) {
				suffix = rs.getInt(1);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		

		return prefix+suffix;
	}

}
