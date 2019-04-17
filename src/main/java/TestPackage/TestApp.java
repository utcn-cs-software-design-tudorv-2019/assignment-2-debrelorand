package TestPackage;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.csdepartment.mvc.model.entities.Student;
import com.csdepartment.mvc.model.servicies.AdministratorService;
import com.csdepartment.mvc.model.servicies.StudentService;

@RunWith (SpringRunner.class)
@DataJpaTest	
public class TestApp {
	@Inject
	AdministratorService administratorService;
	
	@Inject
	StudentService studentService;
	
	@Test
	public void checkById()
	{
		Student student1 = studentService.getByID(1);
		
		assertThat(student1.getIdStudent()).isEqualTo(1);
	}
	
}
