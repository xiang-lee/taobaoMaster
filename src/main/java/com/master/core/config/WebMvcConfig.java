package com.master.core.config;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.master.core.dao.BuyingDao;
import com.master.core.dao.SellingDao;
import com.master.core.dao.StatisticDao;
import com.master.core.dao.UserDao;
import com.master.core.dao.impl.BuyingDaoImpl;
import com.master.core.dao.impl.SellingDaoImpl;
import com.master.core.dao.impl.StatisticDaoImpl;
import com.master.core.dao.impl.UserDaoImpl;
import com.master.core.service.BuyingService;
import com.master.core.service.SellingService;
import com.master.core.service.StatisticService;
import com.master.core.service.UserService;
import com.master.core.service.impl.BuyingServiceImpl;
import com.master.core.service.impl.SellingServiceImpl;
import com.master.core.service.impl.StatisticServiceImpl;
import com.master.core.service.impl.UserServiceImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	

	@Bean
	public UserService createUserService(UserDao userDao) {
		return new UserServiceImpl();
	}
	
    @Bean
    public UserDao createUserDao() {
    	return new UserDaoImpl();
    }
    
    
    @Bean
	public BuyingService createBuyingService(BuyingDao buyingDao) {
		return new BuyingServiceImpl();
	}
	
    @Bean
    public BuyingDao createBuyingDao() {
    	return new BuyingDaoImpl();
    }
    
    @Bean
   	public SellingService createSellingService(SellingDao sellingDao) {
   		return new SellingServiceImpl();
   	}
   	
   @Bean
   public SellingDao createSellingDao() {
   	return new SellingDaoImpl();
   }
   
   @Bean
  	public StatisticService createStatisticService(StatisticDao statisticDao) {
  		return new StatisticServiceImpl();
  	}
  	
  @Bean
  public StatisticDao createStatisticDao() {
  	return new StatisticDaoImpl();
  }
    
    /*
     * multipartResolver
     */
    @Bean
    public MultipartResolver multipartResolver() {
      CommonsMultipartResolver resolver = new CommonsMultipartResolver();
      resolver.setMaxUploadSize(10000000); //10MB
      return resolver;
    }
  /*  @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultiPartConfigFactory factory = new MultiPartConfigFactory();
        factory.setMaxFileSize("128KB");
        factory.setMaxRequestSize("128KB");
        return factory.createMultipartConfig();
    }*/
	
	/*
	 *   Spring MVC 3.1.x request mapping to URLs with a trailing .xxx (in a path vari able)
	 */
	@Bean
	public static BeanPostProcessor beanPostProcessor() {
		return new DoNotTruncateMyUrls();
	}  
	
	  
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
    public SessionFactory sessionFactory() throws PropertyVetoException, SQLException {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder
        	.scanPackages("com.master.core.demain")
            .addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }

	private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "false");
        prop.put("hibernate.show_sql", "false");
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return prop;
    }
	
	
	@Bean(name = "dataSource")
	public ComboPooledDataSource dataSource() throws PropertyVetoException, SQLException {
		
		ComboPooledDataSource cpd = new ComboPooledDataSource();
		cpd.setDriverClass("com.mysql.jdbc.Driver");
	    
	    //local host
		cpd.setJdbcUrl("jdbc:mysql://localhost:3306/taobaomaster");
		cpd.setUser("root");
		cpd.setPassword("xiang55");
		
		
		
		//configure c3p0
		cpd.setMinPoolSize(5);
		cpd.setMaxPoolSize(20);
		cpd.setLoginTimeout(600);
		cpd.setMaxStatements(0);
		cpd.setIdleConnectionTestPeriod(300);
		cpd.setAcquireIncrement(1);
		return cpd;
	}
	
	
	
	@Bean
    public HibernateTransactionManager txManager() throws PropertyVetoException, SQLException {
        return new HibernateTransactionManager(sessionFactory());
    }

	
	
	
   @Bean
    public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
        ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
        contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        MappingJackson2JsonView defaultView = new MappingJackson2JsonView();
        defaultView.setExtractValueFromSingleKeyModel(true);

        ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
        contentViewResolver.setContentNegotiationManager(contentNegotiationManager.getObject());
        contentViewResolver.setViewResolvers(Arrays.<ViewResolver>asList(viewResolver));
        contentViewResolver.setDefaultViews(Arrays.<View>asList(defaultView));
        return contentViewResolver;
    }


    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
