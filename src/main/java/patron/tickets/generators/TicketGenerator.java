package patron.tickets.generators;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import patron.auth.globals.UserGlobal;
import patron.events.models.Event;
import patron.tickets.models.Ticket;
import patron.users.enums.RoleName;
import patron.users.services.UserService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.NumberFormat;

/**
 * The type Ticket generator.
 */
public class TicketGenerator {

    /**
     * Generate.
     *
     * @param toFile the to file
     * @param ticket the ticket
     * @throws DocumentException     the document exception
     * @throws FileNotFoundException the file not found exception
     */
    public static void generate(File toFile, Ticket ticket) throws DocumentException, FileNotFoundException {
        Event event = ticket.getEvent();
        Double price = ticket.getPrice();
        if (!UserService.hasRole(UserGlobal.getUser(), RoleName.ADMIN) && UserService.hasRole(UserGlobal.getUser(), RoleName.AGENT)) {
            price = ticket.getPrice() - (ticket.getPrice() * ( event.getAgentReduction() / 100));
        }
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(toFile));
        document.open();
        Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font bold16 = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
        document.add(new Paragraph("=============================================", normal));
        document.add(new Paragraph(getTitle(ticket), bold16));
        document.add(new Paragraph("", normal));
        document.add(new Paragraph(ticket.getTitle(), bold));
        document.add(new Paragraph("", normal));
        document.add(new Paragraph(ticket.getDescription(), normal));
        document.add(new Paragraph("", normal));
        document.add(new Paragraph("Cena: " + NumberFormat.getCurrencyInstance().format(price).replace("zł", "PLN"), bold));
        document.add(new Paragraph("", normal));
        document.add(new Paragraph("Organizator: " + ticket.getCreatedBy().getLogin(), normal));
        document.add(new Paragraph("Zarezerwowany dla: " + ticket.getReservedBy().getLogin(), normal));
        document.add(new Paragraph("=============================================", normal));
        document.close();
    }

    private static String getTitle(Ticket ticket){
        switch (ticket.getType()){
            case FLIGHT:
                return "Bilet na lot";
            case TOUR:
                return "Bilet na wycieczkę";
            case TURNUS:
                return "Bilet na turnus";
            default:
                return "Bilet";
        }
    }
}
