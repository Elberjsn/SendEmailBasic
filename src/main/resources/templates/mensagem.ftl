<#import "base.ftl" as ui>
<@ui.mainLayout title="Mensagem do Sistema">
    <h3 style="color: #007bff;">
        Ola!, ${name} Tudo Bem?
    </h3>
    <p>Temos uma Mensagem para Você:</p>
    <p>
        ${messagem}
    </p>
</@ui.mainLayout>