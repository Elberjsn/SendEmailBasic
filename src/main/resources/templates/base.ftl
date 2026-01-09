<#macro mainLayout title>
    <html>
    <head>
        <style>
            body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; }
            .container { width: 80%; margin: 20px auto; border: 1px solid #eee; padding: 20px; }
            .header { text-align: center; border-bottom: 2px solid #007bff; padding-bottom: 10px; }
            .footer { font-size: 12px; color: #888; text-align: center; margin-top: 20px; }
            .button { background-color: #007bff; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px; }
        </style>
    </head>
    <body>
    <div class="container">
        <div class="header">
            <h2>Ola!</h2>
        </div>

        <#nested/>

        <div class="footer">
            <p>&copy; ${.now?string('yyyy')}. Todos os direitos reservados.</p>
            <p>Se você não solicitou este e-mail, por favor ignore-o.</p>
        </div>
    </div>
    </body>
    </html>
</#macro>