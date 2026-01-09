<#import "base.ftl" as ui>
<@ui.mainLayout title="Bem-vindo!">
    <h3>Olá, ${name}!</h3>
    <p>Estamos muito felizes em ter você conosco. Sua conta foi criada com sucesso usando o e-mail <strong>${email}</strong>.</p>
    <p>Para começar a explorar nossa plataforma, clique no botão abaixo:</p>
    <p style="text-align: center; margin-top: 30px;">
        <a href="${activationLink}" class="button">Confirmar Cadastro</a>
    </p>
</@ui.mainLayout>