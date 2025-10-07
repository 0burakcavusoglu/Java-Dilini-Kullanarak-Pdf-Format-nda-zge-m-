import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class ResumeGenerator {

    public static void main(String[] args) {
        String photoPath = "photo.jpg";
        String outputPdf = "resume.pdf";

        String fullName = "Burak Çavuşoğlu";
        String title = "Yazılım Mühendisi";
        String email = "burak.cavusoglu@example.com";
        String phone = "+90 555 123 4567";
        String location = "İstanbul, Türkiye";

        String summary = "Problem çözen, temiz ve test edilebilir kod yazmaya önem veren yazılım mühendisi. "
                + "Java, Spring ve bulut teknolojileriyle deneyim sahibi.";

        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            doc.addPage(page);

            PDPageContentStream cs = new PDPageContentStream(doc, page);

            // Fotoğraf (sağ üstte)
            File photoFile = new File(photoPath);
            if (photoFile.exists()) {
                PDImageXObject img = PDImageXObject.createFromFile(photoPath, doc);
                cs.drawImage(img, 420, 650, 120, 140);
            } else {
                System.out.println("Uyarı: Fotoğraf bulunamadı.");
            }

            // Başlık
            cs.beginText();
            cs.setFont(PDType1Font.HELVETICA_BOLD, 20);
            cs.newLineAtOffset(50, 770);
            cs.showText(fullName);
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
            cs.newLineAtOffset(50, 745);
            cs.showText(title);
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.HELVETICA, 10);
            cs.newLineAtOffset(50, 725);
            cs.showText(email + " | " + phone + " | " + location);
            cs.endText();

            // Özet
            cs.beginText();
            cs.setFont(PDType1Font.HELVETICA, 11);
            cs.newLineAtOffset(50, 690);
            cs.showText(summary);
            cs.endText();

            // İş Deneyimi
            cs.beginText();
            cs.setFont(PDType1Font.HELVETICA_BOLD, 13);
            cs.newLineAtOffset(50, 650);
            cs.showText("İş Deneyimi");
            cs.endText();

            String[][] jobs = {
                {"Senior Backend Developer", "VegaTech Yazılım A.Ş.", "Ocak 2022 - Günümüz", "Mikroservis mimarisi ile ölçeklenebilir servisler geliştirdim."},
                {"Backend Developer", "Nebula Çözümleri", "Haziran 2019 - Aralık 2021", "RESTful API tasarımı ve veri tabanı modellemesi yaptım."},
                {"Junior Software Engineer", "SoftNova", "Temmuz 2017 - Mayıs 2019", "Müşteri uygulamaları için modüller geliştirdim."}
            };

            float y = 630;
            for (String[] job : jobs) {
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 11);
                cs.newLineAtOffset(50, y);
                cs.showText(job[0] + " - " + job[1]);
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_OBLIQUE, 9);
                cs.newLineAtOffset(400, y);
                cs.showText(job[2]);
                cs.endText();

                y -= 15;

                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 10);
                cs.newLineAtOffset(60, y);
                cs.showText("• " + job[3]);
                cs.endText();

                y -= 25;
            }

            // Eğitim
            cs.beginText();
            cs.setFont(PDType1Font.HELVETICA_BOLD, 13);
            cs.newLineAtOffset(50, y);
            cs.showText("Eğitim");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.HELVETICA, 11);
            cs.newLineAtOffset(50, y - 20);
            cs.showText("B.Sc. Bilgisayar Mühendisliği — Örnek Üniversitesi (2013 - 2017)");
            cs.endText();

            cs.close();
            doc.save(outputPdf);
            System.out.println("PDF oluşturuldu: " + outputPdf);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}