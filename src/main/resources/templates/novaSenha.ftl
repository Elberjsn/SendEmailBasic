<#import "base.ftl" as ui>
<@ui.mainLayout title="Recuperação de Senha">
    <h3>Ola! ${name}, Solicitação de nova senha</h3>
    <p>Recebemos uma solicitação para redefinir a senha da sua conta.</p>
    <p>Clique no link abaixo para escolher uma nova senha. <strong>Este link expira em ${expiryLink} horas.</strong></p>
    <div style="background: #f9f9f9; padding: 15px; border-radius: 5px; text-align: center;">
        <a href="${resetLink}" style="color: #007bff; font-weight: bold;">Clique aqui para redefinir sua senha</a>
    </div>
    <p>Se você não fez essa solicitação, nenhuma ação é necessária.</p>
</@ui.mainLayout>