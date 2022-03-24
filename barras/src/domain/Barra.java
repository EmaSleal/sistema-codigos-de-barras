
package domain;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Barra {
    public void creacion(String number, String nombre){
        
        try {
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream(nombre+".pdf"));
            
            doc.open();
            
            BarcodeEAN code =new BarcodeEAN();
            code.setCode(number);
            Image img =code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            doc.add(img);
            doc.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Barra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Barra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
