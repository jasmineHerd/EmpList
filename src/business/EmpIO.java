package business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;


/**
 * @author 
 */
public class EmpIO {
    public static Map<Long,Employee> getEmps(String path){
        Map<Long,Employee> emplist= new HashMap<>();
        try{
            BufferedReader in = new BufferedReader(new FileReader(path));
            String hdr = in.readLine();
            
            String empstr = in.readLine();
            while(empstr != null){
                Employee emp= buildByString(empstr);
                if(emp != null)
                {
                    emplist.put(emp.getEmpno(), emp);
                }empstr = in.readLine();
            }
            in.close();
        }catch(IOException e){
            
        }
        return emplist;
    }
    private static Employee buildByString(String empstr) {
        Employee e = new Employee();
        String[] edata = empstr.split(","); 
            try {
                Long empno = Long.parseLong(edata[0]);
                e.setEmpno(empno);
            } catch (NumberFormatException ex) {
                return null;
            }
                if (!edata[1].isEmpty()) {
                    e.setFirstnm(edata[1]);
                }
                if (!edata[2].isEmpty()) {
                    e.setLastnm(edata[2]);
                }
                if (!edata[3].isEmpty()) {
                    e.setMiddlenm(edata[3]);
                }
                if (!edata[4].isEmpty()) {
                    e.setSuffix(edata[4]);
                }
                if (!edata[5].isEmpty()) {
                    e.setAddress1(edata[5]);
                }
                if (!edata[6].isEmpty()) {
                    e.setAddress2(edata[6]);
                }
                if (!edata[7].isEmpty()) {
                    e.setCity(edata[7]);
                }
                if (!edata[8].isEmpty()) {
                    e.setState(edata[8]);
                }
                if (!edata[9].isEmpty()) {
                    e.setZip(edata[9]);
                }
                if (!edata[10].isEmpty()) {
                    e.setPhone(Long.parseLong(edata[10]));
                }
                if (!edata[11].isEmpty()) {
                    e.setGender(edata[11]);
                }
                if (!edata[12].isEmpty()) {
                    e.setStatus(edata[12]);
                }
                if (!edata[13].isEmpty()) {
                    e.setHiredt(edata[13]);
                }
                if (!edata[14].isEmpty()) {
                    e.setTerminatedt(edata[14]);
                }
                if (!edata[15].isEmpty()) {
                    e.setPaycd(Integer.parseInt(edata[15]));
                }
                return e;
    }
    public static String setEmpsXML(String path,Map<Long,Employee> emps ){
        int countXML = 0;
        String msg = "";
        int v1 = 0;
        long v2 = 0;
        String val = "";
        
        try{
            Iterator<Map.Entry<Long,Employee>> it = 
                    emps.entrySet().iterator();
            XMLOutputFactory xout = XMLOutputFactory.newFactory();
            FileWriter filewriter = new FileWriter(path);
            XMLStreamWriter xw = xout.createXMLStreamWriter(filewriter);
            xw.writeStartDocument("1.0");
            xw.writeStartElement("Employees");
            while(it.hasNext()){
                Map.Entry<Long,Employee> empentry = it.next();
                Employee emp = empentry.getValue();
                
                
                xw.writeStartElement("Employee");
                xw.writeAttribute("Empno", String.valueOf(emp.getEmpno()));
                
                xw.writeStartElement("Lastnm");
                    xw.writeCharacters(emp.getLastnm());
                    xw.writeEndElement();

                xw.writeStartElement("Firstnm");
                    xw.writeCharacters(emp.getFirstnm());
                    xw.writeEndElement();                    

                 xw.writeStartElement("Middlenm");
                    xw.writeCharacters(emp.getMiddlenm());
                    xw.writeEndElement();    

                xw.writeStartElement("Suffix");
                    xw.writeCharacters(emp.getSuffix());
                    xw.writeEndElement();   
                    
                xw.writeStartElement("Address1");
                    xw.writeCharacters(emp.getAddress1());
                    xw.writeEndElement();   
                    
                xw.writeStartElement("Address2");
                    xw.writeCharacters(emp.getAddress2());
                    xw.writeEndElement();  
                    
                xw.writeStartElement("City");
                    xw.writeCharacters(emp.getCity());
                    xw.writeEndElement();     
                    
                 xw.writeStartElement("State");
                    xw.writeCharacters(emp.getState());
                    xw.writeEndElement();   
                    
                xw.writeStartElement("Zip");
                    xw.writeCharacters(emp.getZip());
                    xw.writeEndElement();
                    
                 xw.writeStartElement("Phone");
                    xw.writeCharacters(String.valueOf(emp.getPhone()));
                    xw.writeEndElement(); 
                    
                 xw.writeStartElement("Gender");
                    xw.writeCharacters(emp.getGender());
                    xw.writeEndElement();  
                    
                 xw.writeStartElement("Paycd");
                    xw.writeCharacters(String.valueOf(emp.getPaycd()));
                    xw.writeEndElement(); 
                    
                 xw.writeStartElement("Status");
                    xw.writeCharacters(emp.getStatus());
                    xw.writeEndElement();
                
                xw.writeStartElement("Hiredt");
                    xw.writeCharacters(emp.getHiredt());
                    xw.writeEndElement();
                
                xw.writeStartElement("Terminatedt");
                    xw.writeCharacters(emp.getTerminatedt());
                    xw.writeEndElement();
            xw.writeEndElement();
            countXML++;
            }
            xw.writeEndElement();
            xw.flush();
            xw.close();
            msg = countXML + " employees saved to file.";
        }catch(Exception e){
            msg = "XML Write error "+ e.getMessage();
        }
        return msg;
    }
    public static Map<Long,Employee> getEmpsXML(String path){
        Map<Long,Employee> emps = new HashMap<>();
        Employee emp = null;
         String eNm;
         long empno;
        
        try{
            FileReader flr = new FileReader(path);
            XMLInputFactory inFactory = XMLInputFactory.newFactory();
            XMLStreamReader xin = inFactory.createXMLStreamReader(flr);
            
           
            
            while(xin.hasNext()){
                int evType = xin.getEventType();
                switch(evType){
                    case XMLStreamConstants.START_ELEMENT:
                        eNm = xin.getLocalName();
                        switch(eNm){
                            case "Employee":
                                emp = new Employee();
                                empno = Long.parseLong(
                                        xin.getAttributeValue(0));
                                emp.setEmpno(empno);
                                break;
                            case "Lastnm":
                                emp.setLastnm(xin.getElementText());
                                break;
                                
                            case "Firstnm":
                                emp.setFirstnm(xin.getElementText());
                                break; 
                                
                             case "Middlenm":
                                emp.setMiddlenm(xin.getElementText());
                                break;
                            case "Suffix":
                                emp.setSuffix(xin.getElementText());
                                break;
                            case "Address1":
                                emp.setAddress1(xin.getElementText());
                                break;
                        
                            case "Address2":
                                emp.setAddress2(xin.getElementText());
                                break;
                            
                            case "City":
                                emp.setCity(xin.getElementText());
                                break;
                                
                                
                            case "State":
                                emp.setState(xin.getElementText());
                                break;
                            
                            case "Zip":
                                emp.setZip(xin.getElementText());
                                break;
                            
                            case "Phone":
                                try{
                                    emp.setPhone(Long.parseLong(xin.getElementText()));
                                }catch(NumberFormatException e){
                                    //skip phone -missing
                                   
                                }
                                break;
                                
                            case "Gender":
                                emp.setGender(xin.getElementText());
                                break;
                            
                            case "Paycd":
                                try{
                                    emp.setPaycd(Integer.parseInt(xin.getElementText()));
                                }catch(NumberFormatException e){
                                    //skip paycd -missing
                                }
                                break;
                            case "Status":
                                emp.setStatus(xin.getElementText());
                                break;
                            case "Hiredt":
                                emp.setHiredt((xin.getElementText()));
                                break;
                            case "Terminatedt":
                                emp.setTerminatedt(xin.getElementText());
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        eNm = xin.getLocalName();
                        if(eNm.equals("Employee")){
                            //just finished employee
                            if(emp != null){
                                emps.put(emp.getEmpno(), emp);
                                
                            }
                        }
                        break;
                        
                }//switch
                xin.next();
            }//while
        }catch(Exception e){
            emps= null;
        }
        return emps;
    }
}
