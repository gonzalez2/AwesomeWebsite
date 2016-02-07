import com.jaunt.*;     // A Java library for web scraping. http://jaunt-api.com/

/* This class visits CPP's public class schedule site ("http://schedule.cpp.edu/index.aspx")
   and fills the form to retrieve the results and store them for roadmap suggestion purposes.
   The Jaunt library is a great and easy-to-use library (entirely in Java, yaay) that makes 
   use of an UserAgent object to contain a website data and retrieve and modify data.
*/
public class Extractor {
    public static void main(String[] args) throws JauntException {    
        try {
            UserAgent userAgent = new UserAgent();
            userAgent.visit("http://schedule.cpp.edu/index.aspx");
 
            // WORKING ON AN EASY WAY TO INPUT DATA VS. HARD CODE THE INPUT DATA
            userAgent.doc.getForm(1).apply(     // work with the 2nd form available (there are a total of 2 forms in schedule.cpp.edu)
                "(Winter Quarter 2016)",        // bracketed string (regular expression) selects a dropdown menu item
                "CS",                           // string input is applied to textarea
                "365"                           // string input is applied to textarea                    
            ); 
            userAgent.doc.submit("Search");     // press the submit button labeled 'Search'
            
            Element elements;
            elements = userAgent.doc.findFirst("<div id=\"class_list\">");  // from doc, find first element with given html tag
            
            // WORKING ON A WAY TO TOKENIZE RESULT AND STORE DATA
            System.out.println(elements.innerText());     // print all text within given div elem
            
            System.out.println(userAgent.getLocation());  // print the current location (url)
        }
        catch(JauntException e){
            System.out.println(e);
        }
    }
}