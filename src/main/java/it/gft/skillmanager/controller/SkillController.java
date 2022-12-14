package it.gft.skillmanager.controller;


import it.gft.skillmanager.model.*;
import it.gft.skillmanager.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class SkillController {


    @Autowired
    private SkillService skillService;

    @RequestMapping("/skill")
    public SkillResponse getSkill(@RequestParam(value = "name",required = false) String name) {
        System.out.println("/skill - getSkill - name" + name);
        SkillResponse p=new SkillResponse();
        p.setSkills(skillService.getSkillList(name));
       return p;
    }

    @RequestMapping(value = "/project/{id}/skill",method = RequestMethod.POST)
    public SkillOutBean postSkill(@PathVariable("id") BigInteger idProject,@RequestBody PostSkillRequest postSkill) {

        System.out.println("/project/{id}/skill - postSkill - id" + idProject.toString());
        // TODO: usare un oggetto InBean?
        return skillService.postSkill(idProject, postSkill.getSkill());
    }

    // MODIFICA
    @RequestMapping(value = "/project/{id}/skill/{idSkill}",method = RequestMethod.PUT)
    public ProjectSkillOutBean putProject(@PathVariable("id") BigInteger idProject, @PathVariable("idSkill") BigInteger idSkill, @RequestBody PostProjectSkill postProjectSkill) {
        System.out.println("/project/{id}/skill/{idSkill} - putProject - id" + idProject.toString() + "idSkill" + idSkill.toString());
        ProjectSkillInBean projectSkillInBean = new ProjectSkillInBean();
        projectSkillInBean.setSkill_Id(idSkill);
        projectSkillInBean.setProject_Id(idProject);
        return skillService.putProjectSkill(projectSkillInBean, postProjectSkill);
    }


    @RequestMapping(value = "/project/{id}/skill/{idSkill}",method = RequestMethod.DELETE)
    public ProjectSkillOutBean deleteSkill(@PathVariable("id") BigInteger idProject, @PathVariable("idSkill") BigInteger idSkill) {
        System.out.println("/project/{id}/skill/{idSkill} - deleteSkill - id" + idProject.toString() + "idSkill" + idSkill.toString());
        ProjectSkillInBean projectSkillInBean = new ProjectSkillInBean();
        projectSkillInBean.setSkill_Id(idSkill);
        projectSkillInBean.setProject_Id(idProject);
        return skillService.deleteProjectSkill(projectSkillInBean);

    }


}

