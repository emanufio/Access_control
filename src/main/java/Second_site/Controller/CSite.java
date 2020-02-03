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
import Second_site.service.DataService;

//controllore web del sito
@Controller
public class CSite {
	
	//indico al framework le dipendenze da iniettare
	@Autowired
	private DataService dataService;
	
	//mappa "/" al metodo index()
    @RequestMapping("/")
    //il metodo index mi ritorna una stringa
    //il sistema cerca il file stringa.html nel percorso resources/templates
    
    public String index(Model model){
    	//prendo tutte le date dal database
    	List<Data> time = dataService.getAll();
    	String datass = " [ " ;
    	for(Data x : time)
    	{
    		datass = datass+x.toString()+",";
    	}
    	datass=datass+"]";
    	//passo le date alla pagina index.html
    	model.addAttribute("datass", datass);
    	return "index";
    }
    
    @RequestMapping("/register")
    public String buttons() {
    	return "register";
    }
    
    @RequestMapping("/tables")
    public String tables(Model model) {
    	List<Data> time = dataService.getAll();
    	String datass = " [ " ;
    	for(Data x : time)
    	{
    		datass = datass+x.toString()+",";
    	}
    	datass=datass+"]";
    	//passo le date alla pagina index.html
    	model.addAttribute("datass", datass);
    	return "tables";
    }
    
    
    
    
    @PostMapping("/carica")
    //metodo usato per caricare un oggetto nel database
    //@RequestParam serve per fare il bind tra il parametro passato con post/get e il parametro del metodo
    public void carica(@RequestParam String testo) 
    {
    	String s = "andato tutto molto bene";
    	try 
    	{
    		String timeStamp = new SimpleDateFormat("dd.MM.yyyy  HH.mm.ss").format(new Date());
    		//carico l oggetto nel database
        	Data d = dataService.create(timeStamp,testo);
    	}
    	catch(Exception e)
    	{
    		s="andato tutto male";
    	}
    }
    
}
