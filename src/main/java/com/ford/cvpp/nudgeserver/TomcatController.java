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
        String returnString =
                new StringBuilder()
                        .append("{")
                        .append("\"")
                        .append("message")
                        .append("\"")
                        .append(":")
                        .append("\"")
                        .append("You've been nudged!")
                        .append("\"")
                        .append("}")
                        .toString();
        System.out.println(returnString);
        return returnString;
    }

    @PostMapping(path = "/nudge", consumes = MimeTypes.Application.JSON)
    public String postNudge(@RequestBody NudgeCommand nudgeCommand) throws JsonProcessingException {
        NudgeCommand sampleNudge = new NudgeCommand("sampleNudge", "sampleVehID", "2 feet", "forward");
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sampleNudge);
        try {
            String sampleJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sampleNudge);
            System.out.println("SampleJSON: \n" + sampleJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nudgeCommand);
            System.out.println("Actual JSON = " + json);

//      result = new StringBuilder()
//              .append("{\"message\":\"Success: Vehicle ")
//              .append(nudgeCommand.getVehicleID())
//              .append(" has been nudged ")
//              .append(nudgeCommand.getDistance())
//              .append(" ")
//              .append(nudgeCommand.getDirection())
//              .append("\n").append(json)
//              .append("\"}")
//              .toString();
            result = json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
