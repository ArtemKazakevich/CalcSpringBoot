package by.tms.boot.controller;

import by.tms.boot.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/calc")
public class CalcController {
     
     @Autowired
     private CalcService calcService;
     
     @Autowired
     private List<String> history;
     
     @PostMapping
     public double calc(@RequestParam("operation") String operation,
                        @RequestParam("num1") Integer num1,
                        @RequestParam("num2") Integer num2,
                        HttpSession httpSession) {
          
          double result = calcService.action(operation, num1, num2);
          history.add(LocalDateTime.now() + " - result = " + result);
          
          httpSession.setAttribute("history", history);
          
          return result;
     }
}
