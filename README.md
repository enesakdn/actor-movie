# actor-movie Movie Rest Api
Başlangıç
Spring Boot Projesi Oluşturma:

Spring Initializr kullanılarak yeni bir Spring Boot projesi oluşturulmalıdır. Bu projede Spring Web, Spring Data JPA, Lombok ve Postgresql driver dependency'leri eklenmelidir.

Maven dependency management sistemi kullanılarak tüm dependency'ler yüklenmelidir.

Uygulama 9000 portundan ayağa kaldırılmalıdır.

Rest API Tasarımı:

Filmler için bir Rest API tasarlanmalıdır.

API tasarımında error handling ve validation kurallarına uyulmalıdır.

Dependency Injection kurallarına uyulmalıdır.

Movie ve Actor sınıfları arasında many-to-many ilişkisi tanımlanmalıdır. Bu ilişki Lombok ve JPA annotation'ları ile uygulanmalıdır.

application.properties dosyası kullanılarak veritabanı bağlantısı kurulmalıdır.

SQL sorgularını görmek için logging.level.org.hibernate.SQL ve logging.level.org.hibernate.orm.jdbc.bind opsiyonları kullanılmalıdır.

Bu aşamalarda kullanılan ana yazılım araçları:

IntelliJ IDEA: Java tabanlı projenin geliştirilmesi için kullanılan entegre geliştirme ortamı.
Spring Initializr: Spring Boot projesi oluşturmak için kullanılan çevrimiçi bir araç.
Maven: Bağımlılık yönetimi için kullanılan araç.
PostgreSQL: Projede kullanılan veritabanı yönetim sistemi.
