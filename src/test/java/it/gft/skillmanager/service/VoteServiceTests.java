package it.gft.skillmanager.service;

import it.gft.skillmanager.entity.EmployeeEntity;
import it.gft.skillmanager.entity.ProjectEntity;
import it.gft.skillmanager.entity.SkillEntity;
import it.gft.skillmanager.entity.VoteEntity;
import it.gft.skillmanager.model.VoteOutBean;
import it.gft.skillmanager.repository.EmployeeRepository;
import it.gft.skillmanager.repository.ProjectRepository;
import it.gft.skillmanager.repository.SkillRepository;
import it.gft.skillmanager.repository.VoteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
public class VoteServiceTests {


    @Mock
    private SkillRepository skillRepository;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private VoteRepository voteRepository;

    @InjectMocks // auto inject helloRepository
    private VoteService voteService;

    @Test()
    public void  postVoteTest (){
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName("test");
        when(projectRepository.getById(BigInteger.ONE)).thenReturn(projectEntity);

       /* VoteEntity voteEntity = new VoteEntity();
        voteEntity.setProject(projectEntity);
        */

        SkillEntity skillEntity = new SkillEntity();
        skillEntity.setName("skill");
        when(skillRepository.getById(BigInteger.ONE)).thenReturn(skillEntity);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("employ");
        employeeEntity.setCode("em");
        employeeEntity.setSurmane("cognome");
        when(employeeRepository.getEmployeeByCode("em")).thenReturn(employeeEntity);

        VoteOutBean voteOutBean=voteService.postVote(BigInteger.ONE,BigInteger.ONE,"em","vote");

        assertNotNull("Nullo", voteOutBean.getSkill());
       // assertEquals("project name","test", voteOutBean.getVote().getProject().getName());
        assertEquals("skill name","skill", voteOutBean.getSkill().getName());
        assertEquals("employee name","employ", voteOutBean.getEmp().getName());

    }


}
