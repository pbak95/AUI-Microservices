package pl.aui.DateAndTime;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.aui.DateAndTime.rest.DateResource;
import pl.aui.DateAndTime.rest.DateResourceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateAndTimeApplicationTests {

	private static final String SERVICE_NAME = "DateAndTime";

	private static DateResource dateResource;

	@BeforeClass
	public static void initializeService() {
		dateResource = new DateResourceImpl();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldDateFormatBeTheSame() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");
		String resultFromService = dateResource.getDate().getDate();
		LocalDateTime ldt = LocalDateTime.parse(resultFromService, dateFormat);
		Assert.assertTrue("Date result from service and after format it should be the same.",
				ldt.format(dateFormat).equals(resultFromService));
	}

	@Test
	public void shouldReturnServiceName() {
		Assert.assertTrue("Service name should be " + SERVICE_NAME,
				dateResource.getDate().getServiceName().equals(SERVICE_NAME));
	}

}
