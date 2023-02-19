package org.obc.util;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.obc.entity.Period;

public class PeriodIdGenerator implements IdentifierGenerator {
	public static final String ID_GENERATOR = "org.obc.util.PeriodIdGenerator";

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
		final var period = (Period) o;
		final var startTime = period.getStartTime().format(DateTimeFormatter.ISO_TIME);
		final var date = period.getDate().format(DateTimeFormatter.ISO_DATE);
		return String.format("%s %s/%d",date,startTime,((Period) o).getOffice()) ;
	}
}
