package Second_site.Controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Second_site.Entity.Session;
import Second_site.Entity.User;
import Second_site.service.SessionService;
import Second_site.service.UserService;

//controllore web del sito
@Controller
public class SiteController {
	
	//indico al framework le dipendenze da iniettare
	@Autowired
	private SessionService sessionService;
	@Autowired
	private UserService userService;
	
	//mappa "/" al metodo index()
    @RequestMapping("/")
    //il metodo index mi ritorna una stringa
    //il sistema cerca il file stringa.html nel percorso resources/templates
    public String index(){
    	return "index";
    }
    
    @SuppressWarnings("deprecation")
	@RequestMapping(value = "/ajax/getsessionsasync", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String getSessionsAsync() {
    	//prendo tutte le date dal database
    	Date date= new Date();
    	date.setHours(0);
    	date.setMinutes(0);
    	date.setSeconds(0);
    	long ts_midnight = new Timestamp(date.getTime()).getTime();
    	//System.out.println(data);
    	List<Session> time = sessionService.findByUscitaAndData(ts_midnight);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		String json = mapper.writeValueAsString(time);
    		
    		System.out.println(json);

    		return json;
    		
    	} catch (JsonProcessingException e) {
    		e.printStackTrace();
    	}
    	
    	return "[]";
    }
    
    @SuppressWarnings("deprecation")
   	@RequestMapping(value = "/ajax/getsessionsasyncbydate", method = RequestMethod.POST, produces = "application/json")
       @ResponseBody
       public String getSessionsAsyncByDate(@RequestParam String d) throws ParseException {
    	//System.out.println(d);
       	//prendo tutte le date dal database
       	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       	Date date = df.parse(d);
       	//System.out.println(date.toString()+"     "+date.getTime());
       	date.setHours(0);
       	date.setMinutes(0);
       	date.setSeconds(0);
       	//System.out.println(date.toString());
       	long data = date.getTime();
       	//long d2 = data+86400000;
       	//System.out.println(data+"      "+d2);
       	List<Session> time = sessionService.findBetweenData(data, data+86400000);
       	
       	ObjectMapper mapper = new ObjectMapper();
       	try {
       		String json = mapper.writeValueAsString(time);
       		
       		System.out.println(json);

       		return json;
       		
       	} catch (JsonProcessingException e) {
       		e.printStackTrace();
       	}
       	
       	return "[]";
       }
    
    @RequestMapping("/UserList")
    public String UserList()
    {
    	return "UserList";
    }
    
    @RequestMapping("/searchByData")
    public String searchByData() {
    	return "search_for_data";
    }
    
    @RequestMapping(value = "/ajax/getusersasync", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String getUsersAsync() {
    	
    	//System.out.println("ciao");
    	 //prendo tutte le date dal database
    	List<User> users = userService.getAll();
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		String json = mapper.writeValueAsString(users);
    		
    		//System.out.println(json);
    		
    		return json;
    		
    	} catch (JsonProcessingException e) {
    		e.printStackTrace();
    	}
    	
    	return "[]";
    }
    
    /*
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
    */
    
    @RequestMapping("/register")
    public String register() {
    	return "registrazione";
    }
    
    /*
    @RequestMapping("/carica")
    //metodo usato per caricare un oggetto nel database
    //@RequestParam serve per fare il bind tra il parametro passato con post/get e il parametro del metodo
    public String carica() 
    {
    	String s = "andato tutto molto bene";
    	try 
    	{
    		//timpestamp al posto di stringa
    		//String data = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    		//String ora = new SimpleDateFormat("HH.mm.ss").format(new Date());
    		long data = new Timestamp(System.currentTimeMillis()).getTime();
    		//System.out.println(time);
    		
    		//carico l oggetto nel database
    		String nome="marco";
    		String cognome="cicchetti";
        	Session d = sessionService.create(data,nome,cognome);
    	}
    	catch(Exception e)
    	{
    		s="andato tutto male";
    	}
    	return "index2";
    }
    */
    
    /*
    @RequestMapping("/exit")
    public String exit()
    {
    	Session s = sessionService.update("marco" , new Timestamp(System.currentTimeMillis()).getTime() );
    	return "index2";
    }
    */
    
    @PostMapping("/newUser")
    //metodo usato per caricare un oggetto nel database
    //@RequestParam serve per fare il bind tra il parametro passato con post/get e il parametro del metodo
    public String newUser(@RequestParam String nome,@RequestParam String cognome,@RequestParam String email,@RequestParam String number) 
    {
    	String s = "andato tutto molto bene";
    	try 
    	{
        	User u = userService.create(nome,cognome,email,number);
        }
    	catch(Exception e)
    	{
    		s="andato tutto male";
    	}
    	return "UserList";
    }
    
    @PostMapping("/delete")
    public void delete(@RequestParam String psw)
    {
    	userService.delete(psw);
    }   
    
    /*
    @PostMapping("/prova")
    public void prova(@RequestParam String password, @RequestParam String richiesta,@RequestParam String immagine)
    {
    	System.out.println(password);
    	System.out.println(richiesta);
    	if (immagine != null)
    	{
    		System.out.println("immagine arrivata");
    		byte[] imgBytes = Base64.decodeBase64(immagine.getBytes());
    	    try{
    	    	FileOutputStream fos = new FileOutputStream(".\\src\\main\\resources\\images\\image.jpg");
    	        fos.write(imgBytes);
    	        FileDescriptor fd = fos.getFD();
    	        fos.flush();
    	        fd.sync();
    	        fos.close(); 
    	     }
    	    catch(Exception e){
    	    	System.out.println(e.toString());
    	    }
    	}
    	this.index();
    }
    */
    
}
