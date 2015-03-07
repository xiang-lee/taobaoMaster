package com.master.service;
import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.master.core.demain.Buying;
import com.master.core.demain.Selling;
import com.master.core.demain.enu.Currency;
import com.master.core.service.BuyingService;
import com.master.core.service.SellingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,classes = AppMvcConfig.class)
@WebAppConfiguration
@EnableWebMvc
public class TestSellingService    
{  
	
	@Autowired
    SellingService sellingService;
	@Autowired
    BuyingService buyingService;

    @Test
    public void testAddSelling()  {
    	Selling s = new Selling();
    	s.setBrush(true);
    	s.setBuyer("xiang test");
    	s.setCurrency(Currency.euro.getLabel());
    	s.setDeliverDate(Date.valueOf( "2015-12-07" ));
    	s.setExchangeRate(7.5);
    	s.setName("LUSH");
    	s.setOrderNumber("123123abc");
    	s.setPostage(30);
    	s.setQuantity(2);
    	s.setReceived(false);
    	s.setRecordDate(Date.valueOf( "2015-03-07" ));
    	s.setSellCurrency(Currency.cny.getLabel());
    	s.setSellUnitPrice(100);
    	s.setUnitPrice(50.5);
    	
    	
    	Buying stockpile = buyingService.findById(4);
    	s.setStockpile(stockpile);
    	sellingService.addSelling(s);
    }
    
    @Test
    public void testFindSellingById()  {
    	Selling s = sellingService.findById(2);
    	Assert.assertNotNull(s);
    	System.out.println(s);
    }
    
    @Test
    public void testUpdateSelling()  {
    	Selling s = new Selling();
    	s.setId(2);
    	s.setBrush(true);
    	s.setBuyer("xiang");
    	s.setCurrency(Currency.euro.getLabel());
    	s.setDeliverDate(Date.valueOf( "2015-12-07" ));
    	s.setExchangeRate(7.5);
    	s.setName("LUSH");
    	s.setOrderNumber("123123abc");
    	s.setPostage(20);
    	s.setQuantity(2);
    	s.setReceived(false);
    	s.setRecordDate(Date.valueOf( "2015-03-07" ));
    	s.setSellCurrency(Currency.cny.getLabel());
    	s.setSellUnitPrice(100);
//    	s.setStockpile(stockpile);
    	s.setUnitPrice(50.5);
    	sellingService.updateSelling(s);
    }
    
    @Test
    public void testDeleteSellingById()  {
    	sellingService.deleteSelling(3);
    	Assert.assertNull(sellingService.findById(3));
    }
    
}  