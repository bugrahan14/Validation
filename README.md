## Spring Boot MVC Validation Demo

[![Java](https://img.shields.io/badge/Java-17+-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![Build](https://img.shields.io/badge/build-Maven-blue)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-lightgrey)](#license)

### Project Information

- **Project Name**: Spring Boot MVC Validation Demo  
- **Description**:  
  Basit bir müşteri formu üzerinden Spring MVC ile sunucu tarafı form validasyonunu gösteren örnek bir Spring Boot projesi.  
  Form alanları için zorunluluk, minimum/maximum uzunluk ve özel kural (ör. belirli bir harfle başlama) gibi kontroller içerir.
- **Technologies**:
  - **Java** 17+
  - **Spring Boot** (Spring MVC, Spring Validation / Bean Validation – `jakarta.validation`)
  - **Thymeleaf** (HTML templating)
  - **Maven**

### System Requirements

- **JDK**: 17 veya üzeri  
- **Maven**: 3.8+ (veya projeyle gelen `mvnw`/`mvnw.cmd`)  
- **RAM**: Minimum 1 GB önerilir  
- **OS**: Windows, macOS veya Linux

### Installation

1. **Depoyu klonla**

```bash
git clone <your-repo-url>.git
cd validationdemo
```

2. **(Opsiyonel) Maven wrapper kullanmadan derlemek için Maven kur**

```bash
mvn -v
```

3. **Bağımlılıkları indir ve projeyi derle**

```bash
./mvnw clean package    # macOS / Linux
.\mvnw.cmd clean package # Windows (PowerShell / CMD)
```

veya sistem Maven’i ile:

```bash
mvn clean package
```

### Running the Project

Uygulamayı çalıştırmak için aşağıdaki komutlardan birini kullanabilirsin:

```bash
./mvnw spring-boot:run          # macOS / Linux
.\mvnw.cmd spring-boot:run      # Windows
```

veya derlenmiş JAR üzerinden:

```bash
java -jar target/validationdemo-0.0.1-SNAPSHOT.jar
```

Varsayılan olarak uygulama `http://localhost:8080` adresinde çalışır.

### Usage Examples

Bu proje, `Customer` modeline bağlı bir müşteri formu üzerinden validasyon örneği sunar.

- **Formu Gösterme**
  - **HTTP Method**: `GET`
  - **URL**: `/showForm` (veya controller’da tanımlanan mapping)
  - **Açıklama**: Boş müşteri formunu kullanıcıya gösterir.

- **Formu Gönderme**
  - **HTTP Method**: `POST`
  - **URL**: `/processForm`
  - **Açıklama**:  
    Gönderilen form verilerini `@Valid` ve `BindingResult` kullanarak kontrol eder.  
    Hata varsa form sayfasına geri döner ve hata mesajlarını gösterir;  
    hata yoksa onay sayfasına yönlendirir.

#### Örnek Controller Parçası (Genel Yapı)

```java
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        return "customer-confirmation";
    }
}
```

#### Örnek Model Validasyon Annotasyonları (Genel Yapı)

```java
public class Customer {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    // Diğer alanlar ve getter/setter'lar
}
```

### API Examples

Her ne kadar bu proje bir REST API yerine klasik MVC yapısı kullansa da, istersen ileride REST endpoint’leri de ekleyebilirsin.  
Şu an için temel endpoint’ler şunlar (örnek URI yapısıyla):

- **GET** `/customer/showForm`  
  - Müşteri formunu döner (Thymeleaf template: `customer-form.html`).

- **POST** `/customer/processForm`  
  - Form verilerini alır, validasyon uygular ve:
    - Hata varsa tekrar `customer-form.html` sayfasını,  
    - Başarılıysa `customer-confirmation.html` sayfasını gösterir.

### Screenshots

Aşağıya proje ekran görüntülerini ekleyebilirsin:

- **Customer Form Page**  
  `![Customer Form](docs/images/customer-form.png)`

- **Validation Errors**  
  `![Validation Errors](docs/images/customer-form-errors.png)`

- **Confirmation Page**  
  `![Customer Confirmation](docs/images/customer-confirmation.png)`

> Not: `docs/images` klasörünü oluşturup ekran görüntülerini bu dizine kaydedebilirsin.

### Project Structure (Özet)

```text
validationdemo/
├─ pom.xml
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com
│  │  │     └─ bugrahan
│  │  │        └─ spring
│  │  │           └─ mvc
│  │  │              ├─ Customer.java
│  │  │              ├─ CustomerController.java
│  │  │              └─ ValidationdemoApplication.java
│  │  └─ resources
│  │     ├─ application.properties
│  │     └─ templates
│  │        ├─ customer-form.html
│  │        └─ customer-confirmation.html
└─ target
```

### License

Bu proje MIT Lisansı altında lisanslanmıştır.  
Kendi GitHub reponda aşağıdaki gibi bir `LICENSE` dosyası oluşturabilirsin:

```text
MIT License

Copyright (c) 2025 <Your Name>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```


