package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class HotelTests {
	@Setter(onMethod_ = @Autowired)
	private SampleHotel hotel;
	
	@Test
	public void testExist() {
		assertNotNull(hotel);
		
		log.info(hotel.toString());
		log.info("-------------------");
		log.info(hotel.getChef().toString());
	}
}
