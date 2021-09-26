package com.demo.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BackgroundJobManager implements ServletContextListener {

    private ScheduledExecutorService scheduler;

    @Override
    public void contextInitialized(ServletContextEvent event) {
    	System.out.println("Background processes started successfully.");
    	DateFormat yymmddhhmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	SimpleDateFormat yymmdd = new SimpleDateFormat("yyyy-MM-dd");  
        Date currentDate = new Date();
        String cDate = yymmdd.format(currentDate);
        String Date19 = cDate + " 19:00:00";
        String Date00 = cDate + " 00:00:00";
        //System.out.println(cDate);
        try {
		Date scheduledDate = yymmddhhmmss.parse(Date19);
		Date auctionStartDate = yymmddhhmmss.parse(Date00);
		long initialDelay = scheduledDate.getTime() - currentDate.getTime();
		if(initialDelay<0)
		{
			initialDelay = initialDelay + 86400000;
		}
		long auctionStarterDelay = auctionStartDate.getTime() + 86400000;
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new AuctionCloser(),initialDelay,86400000,TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(new AuctionStarter(),auctionStarterDelay,100,TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdownNow();
    }

}