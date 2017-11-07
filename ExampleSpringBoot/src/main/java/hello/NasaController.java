package hello;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NasaController {

	@RequestMapping("/nasa")
    public Image nasa() {
		try {
			URL url = new URL("https://api.nasa.gov/planetary/apod?concept_tags=True&api_key=DEMO_KEY");
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            sb.append(line);
	        }
	        bufferedReader.close();
	        String s = sb.toString();
	        return new Image(new Date(), new JSONObject(s).getString("url"));
		} catch (Exception e) {return new Image(new Date(), e.getMessage());}
		
    }
	
	@RequestMapping(value="/register", method=RequestMethod.PUT)
	public User register(@RequestParam(value="name", defaultValue="World") String name, @RequestParam(value="password", defaultValue="password") String password) {
		User u = new User(name, password);
		return u;
	}
}
