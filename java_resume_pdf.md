# Java Özgeçmiş (CV) PDF Oluşturucu

Bu proje, Java dili kullanılarak PDF formatında özgeçmiş (CV) oluşturan basit bir konsol uygulamasıdır. 
Uygulama, Apache PDFBox kütüphanesi ile PDF dosyasını oluşturur ve içine kullanıcı bilgilerini, deneyimleri ve bir profil fotoğrafını ekler.

## Özellikler
- Kişisel bilgiler ve 3 adet örnek iş deneyimi içerir.
- Fotoğraf ekleme özelliği bulunur.
- Arayüz (GUI) içermez; yalnızca komut satırı üzerinden çalışır.
- Apache PDFBox kütüphanesi kullanılmıştır.

## Kullanılan Teknolojiler
- Java 17+
- Apache PDFBox 2.0.27  

## Çalıştırma
1. `pdfbox-app-2.0.27.jar` dosyasını projenin kök dizinine ekleyin.  
2. Komut satırında aşağıdaki adımları uygulayın:

```bash
javac -cp ".;pdfbox-app-2.0.27.jar" ResumeGenerator.java
java -cp ".;pdfbox-app-2.0.27.jar" ResumeGenerator
```

3. Uygulama çalıştırıldığında `resume.pdf` dosyası otomatik olarak oluşturulur.

## Ekran Çıktısı
```
PDF oluşturuldu: resume.pdf
```

## Not
Bu proje eğitim amaçlıdır ve örnek veriler içerir.