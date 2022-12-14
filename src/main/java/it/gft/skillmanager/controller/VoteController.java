package it.gft.skillmanager.controller;

import it.gft.skillmanager.model.*;
import it.gft.skillmanager.service.SkillService;
import it.gft.skillmanager.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class VoteController {

    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "/project/{idProject}/skill/{idSkill}/employee/{employeeCode}/vote}",method = RequestMethod.POST)
    public VoteOutBean postVote(@PathVariable("idProject") BigInteger idProject, @PathVariable("idSkill") BigInteger idSkill, @PathVariable("employeeCode") String employeeCode,@RequestBody PostVote postVote) {
        System.out.println("/project/{idProject}/skill/{idSkill}/employee/{employeeCode}/vote - postVote - idProject" + idProject.toString() + "idSkill" + idSkill.toString() + "employeeCode" + employeeCode);
        // TODO: usare un oggetto InBean?
        return voteService.postVote(idProject, idSkill, employeeCode, postVote.getVote());
    }
}
