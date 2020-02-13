package by.tms.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/history")
public class HistoryController {
     
     private List<String> listResult = new ArrayList<>();
     
     @GetMapping
     public List<String> outputResult(HttpSession httpSession) {
          listResult = (List<String>) httpSession.getAttribute("history");
          return listResult;
     }
}
