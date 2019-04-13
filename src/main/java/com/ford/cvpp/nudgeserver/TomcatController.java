package com.ford.cvpp.nudgeserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TomcatController {

  @GetMapping("/nudge")
  public String getNudge() {
    return "You've been nudged!";
  }

  @PostMapping(path = "/nudge", consumes = MimeTypes.Application.JSON)
  public String postNudge(@RequestBody NudgeCommand nudgeCommand) {
    NudgeCommand sampleNudge = new NudgeCommand("sampleNudge","sampleVehID","2 feet","forward");
    ObjectMapper mapper = new ObjectMapper();
    String result = "Fail\n";
    try {
      String sampleJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sampleNudge);
      System.out.println("SampleJSON: \n"+sampleJSON);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    try {
      String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nudgeCommand);
      System.out.println("Actual JSON = " + json);
      result = "Success: Vehicle " + nudgeCommand.getVehicleID() + " has been nudged " + nudgeCommand.getDistance() + " " + nudgeCommand.getDirection() + "\n"+json;
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return result;
  }
}
