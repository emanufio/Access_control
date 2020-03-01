package Second_site.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import Second_site.Entity.Session;
import Second_site.Entity.User;
import Second_site.service.SessionService;
import Second_site.service.UserService;

@Controller
public class ApiController {
	
	@Autowired
	private SessionService sessionService;
	@Autowired
	private UserService userService;
	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "public\\images\\";
    
    @PostMapping("/api/activity/entry")
	@ResponseBody
    public String Entry(@RequestParam("file")MultipartFile file, @RequestParam String password) {
    	
    	String result = "-1";
		long timestamp = System.currentTimeMillis();
    	User u = userService.findByPsw(password);
    	//System.out.println(type+password);
		if (u != null) {
			// Check file
			if (file != null) {
				try {
					// Create session in DB
					System.out.println("nel metodo");
					System.out.println(timestamp + u.getName() + u.getSurname() + u.getPassword());
					Session s = sessionService.create(timestamp, u.getName(), u.getSurname(), u.getPassword());
					if (s != null)
						System.out.println("s != null");
					else
						System.out.println("s == null");
					// Get the file and save it somewhere
					byte[] bytes = file.getBytes();
					Path path = Paths.get(UPLOADED_FOLDER + timestamp + ".jpg");
					Files.write(path, bytes);
					result = "1";
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else
				System.out.println("male male");
		}
		/*
		 * else if (type == "EXIT") {
		 * 
		 * //Calculate ts today midnight LocalTime midnight = LocalTime.MIDNIGHT;
		 * LocalDate today = LocalDate.now(ZoneId.of("Europe/Rome")); LocalDateTime
		 * todayMidnight = LocalDateTime.of(today, midnight); long ts_midnight =
		 * todayMidnight.atZone(ZoneId.of("Europe/Rome")).toInstant().toEpochMilli();
		 * 
		 * //Update DB Session s = sessionService.update(password , ts_midnight,
		 * timestamp); if (s != null) result = 1; } }
		 */
		else {
			result = "-2";
			System.out.println("oh shit");
		}
		System.out.println("il risultato:  "+result);
		return result;
    }
    
    
	@PostMapping("/api/activity/exit")
	@ResponseBody
	public int Exit(@RequestParam String password) {
		int result = -1;
		long timestamp = System.currentTimeMillis();
		User u = userService.findByPsw(password);
		// System.out.println(type+password);
		if (u != null) {
			// Calculate ts today midnight
			LocalTime midnight = LocalTime.MIDNIGHT;
			LocalDate today = LocalDate.now(ZoneId.of("Europe/Rome"));
			LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
			long ts_midnight = todayMidnight.atZone(ZoneId.of("Europe/Rome")).toInstant().toEpochMilli();
			// Update DB
			Session s = sessionService.update(password, ts_midnight, timestamp);
			if (s != null)
				result = 1;
		} else {
			result = -2;
			System.out.println("oh shit+++");
		}
		return result;
	}

//	@PostMapping("/api/send_info_entry")
//	@ResponseBody
//    public String api_send_info_entry(@RequestParam String password, @RequestParam String immagine)
//    {
//		String i="-1";
//    	if (immagine != null)
//    	{
//    		User u = userService.findByPsw(password);
//    		if (u!=null)
//    		{
//    			//System.out.println("nell if");
//				long data = new Timestamp(System.currentTimeMillis()).getTime();
//				Session d = sessionService.create(data, u.getNome(), u.getCognome(), u.getPsw());
//				byte[] imgBytes = Base64.decodeBase64(immagine.getBytes());
//				try {
//					FileOutputStream fos = new FileOutputStream("image/" + data + ".jpg");
//					fos.write(imgBytes);
//					FileDescriptor fd = fos.getFD();
//					fos.flush();
//					fd.sync();
//					fos.close();
//					System.out.println("tutto apposto");
//					i = "1";
//				} catch (Exception e) {
//					System.out.println(e.toString());
//				}
//
//    		}
//    		else
//    			i="-2";
//    	}
//		return i;
//    }
	
//	@PostMapping("/api/send_info_exit")
//	@ResponseBody
//    public String api_send_info_exit(@RequestParam String password)
//    {
//		String i = "-1";
//		User u = userService.findByPsw(password);
//		if (u != null) {
//			long data = new Timestamp(System.currentTimeMillis()).getTime();
//			Date date= new Date();
//	    	date.setHours(0);
//	    	date.setMinutes(0);
//	    	date.setSeconds(0);
//	    	long data1 = date.getTime();
//			Session s = sessionService.update(password , data, data1 );
//			if (s!=null)
//				i="1";
//		} else
//			i = "-2";
//		return i;
//    }

//	@RequestMapping(value = "/api/ajax/get_image", method = RequestMethod.POST)
//    @ResponseBody
//    public String getImage() {
//    	 //prendo tutte le date dal database
//    	//long data = new Timestamp(System.currentTimeMillis()).getTime();
//		//File image = new File("C:\\Users\\Emanuele\\Desktop\\Ingegneria\\Spring\\Second_site\\src\\main\\resources\\images\\1581950795906.jpg");
//		//System.out.println(image.getPath()+"  "+image.getName());
//		//byte[] base64EncodedData = null;
//		String encoded="";
//		try {
//			encoded=encodeFileToBase64Binary("C:\\Users\\Emanuele\\Desktop\\Ingegneria\\Spring\\Second_site\\src\\main\\resources\\images\\1581950795906.jpg");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		/*
//		//byte[] encoded = Base64.decodeBase64(image);
//		 String encodedfile = null;
//         try {
//             FileInputStream fileInputStreamReader = new FileInputStream(image);
//             byte[] bytes = new byte[(int)image.length()];
//             fileInputStreamReader.read(bytes);
//             encodedfile = Base64.encodeBase64(bytes).toString();
//         } catch (FileNotFoundException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         } catch (IOException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
//
//		//ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		//image.compre(Bitmap.CompressFormat.JPEG, 100, baos);
//		//byte[] data = Base64.encodeBase64(image);
//		 * 
//		 */
//		if(encoded!=null)
//			System.out.println("codifica riuscita");
//    	return encoded;
//	}
//	
//	private static String encodeFileToBase64Binary(String fileName)
//	        throws IOException {
//
//	    File file = new File(fileName);
//	    byte[] bytes = loadFile(file);
//	    byte[] encoded = Base64.encodeBase64(bytes);
//	    String encodedString = new String(encoded,StandardCharsets.US_ASCII);
//
//	    return encodedString;
//	}
//	
//	private static byte[] loadFile(File file) throws IOException {
//	    InputStream is = new FileInputStream(file);
//
//	    long length = file.length();
//	    if (length > Integer.MAX_VALUE) {
//	        // File is too large
//	    }
//	    byte[] bytes = new byte[(int)length];
//
//	    int offset = 0;
//	    int numRead = 0;
//	    while (offset < bytes.length
//	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
//	        offset += numRead;
//	    }
//
//	    if (offset < bytes.length) {
//	        throw new IOException("Could not completely read file "+file.getName());
//	    }
//
//	    is.close();
//	    return bytes;
//	}
    	    
}
