package sdg.demo.java;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SDGDemoController {
	@Autowired
    private EmployeeRepository empRepository;
	
	
	public SDGDemoController() {
		
	}
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	@GetMapping("/v1/api/sdg/demo/person/title")
	public String getEmployeeTitle(@RequestParam(name = "name") String name) {
		
		Employee emp = empRepository.findByEmployeename(name);
        if(emp != null) {
        	return emp.getEmployeetitle();
        } else {
        	return "No Name find";
        }
	}
	
	@GetMapping("/v1/api/sdg/demo/person/all")
	public List<Employee> getAllEmployee() {
		
		List<Employee> emp = empRepository.findAll();
        return emp;
	}
	
	@PostMapping(path = "/v1/api/sdg/demo/person")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String title) {

		Employee user = new Employee();
        
        user.setEmployeename(name);
        user.setEmployeetitle(title);
        empRepository.save(user);
        return "User Created";
    }
	
		
}
