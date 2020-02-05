package Second_site.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import java.text.SimpleDateFormat;
import java.util.*;
import Second_site.Entity.*;
import Second_site.service.*;

//controllore web del sito
@Controller
public class CSite {
	
	//indico al framework le dipendenze da iniettare
	@Autowired
	private SessionService sessionService;
	@Autowired
	private UserService userService;
	
	//mappa "/" al metodo index()
    @RequestMapping("/")
    //il metodo index mi ritorna una stringa
    //il sistema cerca il file stringa.html nel percorso resources/templates
    
    public String index(Model model){
    	//prendo tutte le date dal database
    	List<Session> time = sessionService.findByUscita(false);
    	String datass = " [ " ;
    	for(Session x : time)
    	{
    		datass = datass+x.toString()+",";
    	}
    	datass=datass+"]";
    	//passo le date alla pagina index.html
    	model.addAttribute("datass", datass);
    	return "index";
    }
    
    @RequestMapping("/UserList")
    public String UserList(Model model){
    	//prendo tutte le date dal database
    	List<User> users = userService.getAll();
    	String datass = " [ " ;
    	for(User x : users)
    	{
    		datass = datass+x.toString()+",";
    	}
    	datass=datass+"]";
    	//passo le date alla pagina index.html
    	model.addAttribute("datass", datass);
    	return "UserList";
    }
    
    @RequestMapping("/register")
    public String buttons() {
    	return "register";
    }
    
    @RequestMapping("/tables")
    public String tables(Model model) {
    	List<Session> time = sessionService.getAll();
    	String datass = " [ " ;
    	for(Session x : time)
    	{
    		datass = datass+x.toString()+",";
    	}
    	datass=datass+"]";
    	//passo le date alla pagina index.html
    	model.addAttribute("datass", datass);
    	return "tables";
    }
    
    
    
    
    @RequestMapping("/carica")
    //metodo usato per caricare un oggetto nel database
    //@RequestParam serve per fare il bind tra il parametro passato con post/get e il parametro del metodo
    public String carica() 
    {
    	String s = "andato tutto molto bene";
    	try 
    	{
    		String timeStamp = new SimpleDateFormat("dd.MM.yyyy  HH.mm.ss").format(new Date());
    		//carico l oggetto nel database
    		String nome="emanuele";
    		String cognome="fiore";
        	Session d = sessionService.create(timeStamp,nome,cognome);
    	}
    	catch(Exception e)
    	{
    		s="andato tutto male";
    	}
    	return "index2";
    }
    
    @PostMapping("/newUser")
    //metodo usato per caricare un oggetto nel database
    //@RequestParam serve per fare il bind tra il parametro passato con post/get e il parametro del metodo
    public String newUser(@RequestParam String nome,@RequestParam String cognome,@RequestParam String email) 
    {
    	String s = "andato tutto molto bene";
    	try 
    	{
    		//carico l oggetto nel database
        	User u = userService.create(nome,cognome,email);
        }
    	catch(Exception e)
    	{
    		s="andato tutto male";
    	}
    	return "index";
    }
    
    
    
}
