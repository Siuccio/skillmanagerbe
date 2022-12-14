package it.gft.skillmanager.service;

import it.gft.skillmanager.entity.EmployeeEntity;
import it.gft.skillmanager.entity.ProjectEntity;
import it.gft.skillmanager.entity.SkillEntity;
import it.gft.skillmanager.model.EmployeeInBean;
import it.gft.skillmanager.model.EmployeeOutBean;
import it.gft.skillmanager.model.VoteOutBean;
import it.gft.skillmanager.repository.EmployeeRepository;
import it.gft.skillmanager.repository.ProjectRepository;
import it.gft.skillmanager.repository.SkillRepository;
import it.gft.skillmanager.repository.VoteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import java.math.BigInteger;

import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class EmployeeServiceTests {

    @Mock
    private SkillRepository skillRepository;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks // auto inject helloRepository
    private EmployeeService employeeService;

    @Test()
    public void putEmployeeTest (){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("name");
        employeeEntity.setCode("xx");
        employeeEntity.setSurmane("surname");

        EmployeeInBean employeeInBean = new EmployeeInBean();
        employeeInBean.setSurname("surname");
        employeeInBean.setName("name");
        employeeInBean.setCode("xx");

        EmployeeOutBean employeeOutBean = new EmployeeOutBean();

        when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);

         employeeOutBean= employeeService.putEmployee(employeeInBean);
        //verify(employeeRepository).save(employeeEntity);
        assertEquals("employee name","name", employeeOutBean.getName());
        assertEquals("employee surname","surname", employeeOutBean.getSurname());
        assertEquals("employee code","xx", employeeOutBean.getCode());

    }

    @Test()
    public void putEmployeeNullTest (){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        EmployeeInBean employeeInBean = new EmployeeInBean();
        EmployeeOutBean employeeOutBean = new EmployeeOutBean();

        when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);

        employeeOutBean= employeeService.putEmployee(employeeInBean);

        AssertionErrors.assertNull("può essere nullo",employeeOutBean.getCode());
        AssertionErrors.assertNull("può essere nullo",employeeOutBean.getSurname());
        AssertionErrors.assertNull("può essere nullo",employeeOutBean.getName());

    }


}
