package net.Ganesh.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "net.Ganesh.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateClass {

	// h2 database connection
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PSWD = "H2c0nn3ct@!56";

	//mysql connection
	/*
	 * private final static String DATABASE_URL =
	 * "jdbc:mysql://127.0.0.1:3306/trashbox"; private final static String
	 * DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver"; private final static String
	 * DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect"; private final static
	 * String DATABASE_USERNAME = "Pravin"; private final static String
	 * DATABASE_PSWD = "Sql(0nn3)t!*78";
	 */

	// DataSource bean
	@Bean
	public DataSource getDataSource() {
		// providing Database connection information
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PSWD);
		return dataSource;
	}

	// Session factory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.Ganesh.shoppingbackend.dto");
		return builder.buildSessionFactory();

	}

	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	// Transaction Manager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
