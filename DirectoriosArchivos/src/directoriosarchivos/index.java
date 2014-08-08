package directoriosarchivos;
public class index {
    public static String indexLista(String musica){
        String html="";
        html+=  "<html><title>El Callejon.COM</title>\n"+
                "<head>\n<div align=\"center\"><center><script type=\"text/javascript\" src=\"swfobject.js\">\n</script>\n</div></head>\n"+
                "<body bgcolor=\"#000000\">\n"+
                "<center><td valign=\"top\" width=\"1\"><img src=\"http://elcallejon.com/web/logo.png\" WIDTH=350 HEIGHT=70></td>\n"+
                "\t<FONT FACE=\"IMPACT\"><MARQUEE BGCOLOR=\"000000\" SCROLLAMOUNT=3><span style=\"color: white;\">\n"+
                "\tEstas escuchando musica de:\""+musica+"\"\n"+
                "\t</MARQUEE></span></FONT><br>\n"+	
                "<TABLE CELLPADDING=5 CELLSPACING=5 BORDER=5 BORDER bgcolor=\"#000000\">\n"+
                "\t<td>"+
                "<div id=\"player3\">Reproductor de MP3 By Gavo</div><script type=\"text/javascript\">\n"+
                "var so = new SWFObject('mediaplayer.swf','mp3','320','480','7');\n"+
                "\tso.addParam('allowfullscreen','true');\n"+
                "\tso.addVariable('autostart','true');\n"+
                "\tso.addVariable('displayheight','110');\n"+
                "\tso.addVariable('file','lista.xml');\n"+
                "\tso.addVariable('height','480');\n"+
                "\tso.addVariable('width','320');\n"+
                "\tso.addVariable('backcolor','0x000000');\n"+
                "\tso.addVariable('frontcolor','0xFFFFFF');\n"+
                "\tso.addVariable('shuffle','true');\n"+
                "\tso.addVariable('lightcolor','0x0000FF');\n"+
                "\tso.addVariable('repeat','true');\n"+
                "\tso.addVariable('showeq','true');\n"+
                "so.write('player3');\n"+
                "</script>\n"+
                "</td>\n"+
                "</TABLE>\n"+
                "\t  <input type=\"button\" value=\"< ATRAS >\" name=\"Back2\" onclick=\"history.back()\" /></div>\n"+
                "\t  <input type=\"button\" value=\"< DESCARGAR >\" onClick=\" window.location.href='descargar.php' \"></form>\n"+
                "</body></html>";
        return html;
    }
    public static String listaXML(String directorio, String []x){
        String s ="<playlist version=\"1\" xmlns=\"http://xspf.org/ns/0/\">\n<trackList>\n";
        for(int i = 0; i<= x.length-1;i++){
            if(Directorio.mp3(x[i])){
                s+="<track><title>"+Directorio.quitarExtension(x[i])+"</title>"+"\n"; 
                s+="<creator>"+i+".- "+directorio+"</creator>\n";
                s+="<location>"+x[i]+"</location>\n";
                s+="<image>imagen.jpg</image></track>\n";
            }
        }
        return s+="</trackList>\n</playlist>";
    }
    public static String listaDescarga(String directorio, String []x){
        String s ="";
        for(int i = 0; i<= x.length-1;i++){
            if(Directorio.mp3(x[i])){
                s+="<a href=\"ftp://elcallejon.com/"+directorio+"/"+x[i]+"\">"+Directorio.quitarExtension(x[i])+"</a><br>\n";             
            }
        }
        return s+="</trackList>\n</playlist>";
    }
    public static String index(int n,String [] directorio){
        String s = "";
        s+="<html><header><title>Musia del Callejon</title></header>\n"+
        "<body bgcolor=\"#000000\">\n"+
        "<center><td valign=\"top\" width=\"1\"><img src=\"http://elcallejon.com/web/logo.png\" WIDTH=350 HEIGHT=50></td>\n"+
        "<TABLE CELLSPACING=5 BORDER=5 BORDER bgcolor=\"#000000\" WIDTH=350 HEIGHT=520 >\n"+
        "<td><center><TABLE CELLSPACING=5 BORDER=1 BORDER bgcolor=\"#000000\" WIDTH=330 HEIGHT=60 ><td  bgcolor=\"white\"><center>\n";  
        String[]pag = paginas(directorio);
        for(int i = 0; i<=pag.length-1;i++){
            if (i==0){
                s+="<A HREF=\"http://elcallejon.com/musica\">";
                s+="<IMG SRC=\"http://elcallejon.com/web/letras/"+pag[i]+"\" WIDTH=26 HEIGHT=16></A>\n";
            }
            else{
                s+="<A HREF=\"http://elcallejon.com/musica/"+i+".php\">";
                s+="<IMG SRC=\"http://elcallejon.com/web/letras/"+pag[i]+"\" WIDTH=26 HEIGHT=16></A>\n";
            }
        }
        s+="</center></td></table>\n"+
        "<TABLE CELLSPACING=5 BORDER=1 BORDER bgcolor=\"#000000\" WIDTH=330 HEIGHT=450 ><td>\n";
        for(int i = 0; i< directorio.length-1;i++){
            if((i>=n*23)&&(i<(n*23+23)))
                s+="<a href=\"http://elcallejon.com/musica/"+(directorio[i])+"\">"+(i+1)+".-"+(directorio[i])+"</a><br>\n";
        }
        s+="</td></table></center></td></TABLE></center>\n</body></html>";
        
        return s;
    }
    public static String indexListaDescarga(String musica, String []x){
        String html="";
        html+=  "<html><title>El Callejon.COM</title>\n"+
                "<head>\n<div align=\"center\"><center><script type=\"text/javascript\" src=\"swfobject.js\">\n</script>\n</div></head>\n"+
                "<body bgcolor=\"#000000\">\n"+
                "<center><td valign=\"top\" width=\"1\"><img src=\"http://elcallejon.com/web/logo.png\" WIDTH=350 HEIGHT=70></td>\n"+
                "\t<FONT FACE=\"IMPACT\"><MARQUEE BGCOLOR=\"000000\" SCROLLAMOUNT=3><span style=\"color: white;\">\n"+
                "\tEstas escuchando musica de:\""+musica+"\"\n"+
                "\t</MARQUEE></span></FONT><br>\n"+	
                "<TABLE CELLPADDING=5 CELLSPACING=5 BORDER=5 BORDER bgcolor=\"#000000\">\n"+
                "\t<td><div style=\"overflow-y:auto; WIDTH:330; height:450px; \">"+listaDescarga(musica,x)+                
                "</div></td>\n"+
                "</TABLE>\n"+
                "\t  <input type=\"button\" value=\"< ATRAS >\" name=\"Back2\" onclick=\"history.back()\" /></div> </form>\n"+
                "\t  <input type=\"button\" value=\"< DESCARGAR >\" onClick=\" window.location.href='descargar.php' \"></form>\n"+
                "</body></html>";
        return html;
    }
    
    private static String[]paginas(String[]directorio){
        int n = (directorio.length/23)+1;
        int j = 0;
        String r[]= new String[n];
        for(int i =0; i< directorio.length-1; i+=23){
            if(i<directorio.length-24)
                r[j]=""+Directorio.primeraLetra(directorio[i])+Directorio.primeraLetra(directorio[i+20])+".gif";
            else
                r[j]=""+Directorio.primeraLetra(directorio[i])+Directorio.primeraLetra(directorio[directorio.length-1])+".gif";
            j++;
        }
        return r;
    }
    
    
}
