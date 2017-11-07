public class CSVFileReader extends EventAdder{

private  String filepath;
    private static List<Book> read() {
        List<Sms> events= new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(filepath,
                StandardCharsets.US_ASCII)) 

            String line = br.readLine();

            while (line != null) {

                String[] attributes = line.split(","); //FOR PSV, JUST CHANGE ',' TO '|'

                Sms event = createEvent(attributes);

                events.add(event);

                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return events;
    }

    private static Event createEvent(String[] event) {
        String dateSTR = event[0];
	DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
	Date date = (Date)formatter.parse(dateSTR);
	String eventName = event[1];
	String color = event[2];	


        new Sms();
	Sms.setDate(date);
	Sms.setEventName(eventName);
	Sms.setColor(color);
	return 
    }

}

class Event {
    private Date date;
    private String eventName;
    private String color;

    public Book(Date date, String eventName, String color) {
        this.date = date;
        this.eventName = eventName;
        this.color = color;
    }

    	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public String getEventName(){
		return eventName;
	}

	public void setEventName(String eventName){
		this.eventName = eventName;
	}
	
	public String getColor(){
		return color;
	}

	public void setColor(String color){
		this.color = color;
	}

}