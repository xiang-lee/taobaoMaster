package com.master.service;
import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.master.core.dao.BuyingDao;
import com.master.core.demain.Buying;
import com.master.core.service.BuyingService;
import com.master.core.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,classes = AppMvcConfig.class)
@WebAppConfiguration
@EnableWebMvc
public class TestBuyingService    
{  
	
	
	@Autowired
    UserService userService;
	
	@Autowired
    BuyingService buyingService;


	@Autowired
	private BuyingDao buyingDao;
	
    @Test
    public void testAddBuying()  {
    	Buying buying = new Buying();
    	buying.setName("LUSH88888");
    	buying.setArriveDate(Date.valueOf( "2015-05-15" ));
    	buying.setExchangeRate(7.5);
    	buying.setOrderNumber("abca123123");
    	buying.setPayer("test");
    	buying.setQuantity(2);
    	buying.setRecordDate(Date.valueOf( "2015-03-07" ));
    	buying.setUnitPrice(50.5);
    	buying.setStockpile(true);
    	
    	buyingService.addBuying(buying);
    }
    
    @Test
    public void testFindBuyingById()  {
    	Buying buying = buyingService.findById(4);
    	Assert.assertNotNull(buying);
    	System.out.println(buying);
    }
    
    @Test
    public void testUpdateBuying()  {
    	Buying buying = new Buying();
    	buying.setId(4);
    	buying.setName("UGG898989");
    	buying.setArriveDate(Date.valueOf( "2015-05-15" ));
    	buying.setExchangeRate(7.5);
    	buying.setOrderNumber("abca123123");
    	buying.setPayer("tester");
    	buying.setQuantity(6);
    	buying.setRecordDate(Date.valueOf( "2015-03-07" ));
    	buying.setUnitPrice(66.56);
    	buying.setStockpile(true);
    	buyingService.updateBuying(buying);
    }
    
    @Test
    public void testDeleteBuyingById()  {
    	buyingService.deleteBuying(59);
    	Assert.assertNull(buyingService.findById(59));
    }
    
    @Test
    public void testFindAllBuying()  {
    	List<Buying> buyings = buyingService.findAll();
    	for (Buying buying : buyings) {
			System.out.println(buying);
		}
    }
    
    /*
     * stockpile
     */
    @Test
    public void testFindAllStockpiles()  {
    	List<Buying> stockpiles = buyingService.findAllStockpilesWithRemain();
    	for (Buying stockpile : stockpiles) {
			System.out.println(stockpile);
		}
    }
    
}  