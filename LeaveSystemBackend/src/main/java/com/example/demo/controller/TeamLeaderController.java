package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LeaveService;
import com.example.demo.model.LeaveModel;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeamLeaderController {
    @Autowired
    private LeaveService leaveService;
    
    @GetMapping("/GetLeavesByTeamLeader")
    public List<LeaveModel> getLeavesByTeamLeader(@RequestParam String teamLeaderId) {
        return leaveService.getLeavesByTeamLeaderId(teamLeaderId);
    }
    
    @PostMapping("/Esclate")
    public boolean EsclateLeave(@RequestParam long leaveId)
    {
    	return leaveService.EsclateApplication(leaveId);
    }
    @PostMapping("/Reject")
    public boolean RejectLeave(@RequestParam long leaveId)
    {
    	return leaveService.RejectApplication(leaveId);
    }
}
