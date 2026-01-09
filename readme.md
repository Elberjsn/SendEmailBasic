
# SendEmail

Aplicação Java Spring Boot para envio de e-mails usando templates Freemarker.

## Descrição
Projeto simples que monta e envia e-mails a partir de templates em `src/main/resources/templates`. Serve como o uso de templates Freemarker.

## Tecnologias
- Java
- Spring Boot
- Maven
- Freemarker
- 
## Estrutura principal
- `src/main/java/dev/elberjsn/sendemail`  
  - `core` - classes do domínio (`Email.java`)  
  - `services` - lógica de envio (`EmailServices.java`)  
  - `templates` - classes helper para templates (ex: `BemVindo.java`)  
  - `utils` - utilitários (`FreemarkerUtils.java`, `GetQueue.java`)  
  - `SendEmailApplication.java` - classe principal
- `src/main/resources`  
  - `application.yml` - configurações da aplicação  
  - `templates/*.ftl` - templates Freemarker

## Variáveis de ambiente / Configurações
A aplicação usa placeholders para configurar o mail. As principais variáveis esperadas:
- `HOST_MAIL` — servidor SMTP (`smtp.gmail.com`)  
- `MAIL_PORT` — porta SMTP  
- `MAIL_USERNAME` — usuário SMTP  
- `MAIL_PASSWORD` — senha SMTP

Exemplo mínimo em `src/main/resources/application.yml` (já suportando fallback):

```yaml
spring:
  mail:
    host: ${HOST_MAIL:smtp.example.com}
    port: ${MAIL_PORT:587}
    username: ${MAIL_USERNAME:}
    password: ${MAIL_PASSWORD:}
```

## Como executar

1. Com variáveis na mesma linha:
   ```
   HOST_MAIL=smtp.gmail.com MAIL_PORT=587 MAIL_USERNAME=meu@ex.com MAIL_PASSWORD=minhaSenha ./mvnw spring-boot:run
   ```

2. Exportando para a sessão (Linux):
   ```
   export HOST_MAIL=smtp.gmail.com
   export MAIL_PORT=587
   export MAIL_USERNAME=meu@ex.com
   export MAIL_PASSWORD=minhaSenha
   ./mvnw spring-boot:run
   ```

3. Usando IntelliJ: abra `Run > Edit Configurations`, adicione as variáveis em *Environment variables*.

4. Gerar jar e executar:
   ```
   ./mvnw clean package
   java -jar target/sendemail-*.jar
   ```

## Testes
Executar:
```
./mvnw test
```

## Observações
- Caso veja erro `Could not resolve placeholder 'HOST_MAIL'`, defina a variável ou coloque um valor padrão em `application.yml` como mostrado acima.
- Logs de debug: iniciar a aplicação com `--debug` para relatório de avaliação de condições do Spring.

## Licença
Projeto com finalidade didática.
```
